package com.porto.portocom.portal.cliente.v1.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.porto.portocom.portal.cliente.entity.ProdutoPortalOrigem;
import com.porto.portocom.portal.cliente.entity.ProdutoSegmento;
import com.porto.portocom.portal.cliente.entity.ProdutosPortal;
import com.porto.portocom.portal.cliente.entity.SituacaoProduto;
import com.porto.portocom.portal.cliente.v1.repository.IProdutosPortalRepository;
import com.porto.portocom.portal.cliente.v1.utils.ObterDataUtils;
import com.porto.portocom.portal.cliente.v1.wsdl.bcp.ObterContratoType.FiltroContrato;

public final class FiltroContratoUtils {

	private static final Logger LOG = LoggerFactory.getLogger(FiltroContratoUtils.class);

	private FiltroContratoUtils() {

	}

	public static List<FiltroContrato> adicionaFiltroContrato(IProdutosPortalRepository produtosPortalRepository) {
		List<ProdutosPortal> produtos = produtosPortalRepository.findAllByStatus("S");
		List<FiltroContrato> produtosReturn = new ArrayList<>();

		for (ProdutosPortal prod : produtos) {

			if (prod.getCodigoOrigem() == null) {
				continue;
			}

			FiltroContrato criterioAdd = criarFiltroContrato(prod);

			produtosReturn.add(criterioAdd);
		}
		return produtosReturn;
	}

	public static FiltroContrato criarFiltroContrato(ProdutosPortal prod) {

		FiltroContrato criterioAdd = new FiltroContrato();

		FiltroContrato.Produto produto = new FiltroContrato.Produto();

		trataProduto(prod, criterioAdd, produto);

		obterData(prod, criterioAdd);

		for (SituacaoProduto sit : prod.getSitProduto()) {
			criterioAdd.getCodigoSituacaoDocumento().add(sit.getId().shortValue());
		}
		return criterioAdd;
	}

	private static void obterData(ProdutosPortal prod, FiltroContrato criterioAdd) {
		String qtdDias = prod.getQtdDiasVigInicial();
		if (StringUtils.isNotEmpty(qtdDias)) {
			try {
				Date dataIni = ObterDataUtils.obterDataComHorasMinutosSegundosMilisegundosZeradosAlterarDias(new Date(),
						Short.valueOf(qtdDias));
				if (dataIni != null) {
					criterioAdd.setDiaVigenciaInicial(ObterDataUtils.dateToXMLGregorianCalendar(dataIni));
				}
			} catch (Exception e) {
				LOG.info(e.getMessage(), e);
			}
		}

		qtdDias = prod.getQtdDiasVigFinal();
		if (StringUtils.isNotEmpty(qtdDias)) {
			try {
				Date dataFim = ObterDataUtils.obterDataComHorasMinutosSegundosMilisegundosMaximoAlterarDias(new Date(),
						Short.valueOf(qtdDias));
				if (dataFim != null) {
					criterioAdd.setDiaVigenciaFinal(ObterDataUtils.dateToXMLGregorianCalendar(dataFim));
				}
			} catch (Exception e) {
				LOG.info(e.getMessage(), e);
			}
		}
	}

	private static void trataProduto(ProdutosPortal prod, FiltroContrato criterioAdd, FiltroContrato.Produto produto) {
		produto.setCodigoProdutoOrigem(prod.getCodigoOrigem().shortValue());
		if (prod.getProdutosOrigem() != null && !prod.getProdutosOrigem().isEmpty()) {
			for (ProdutoPortalOrigem prodOrigem : prod.getProdutosOrigem()) {
				FiltroContrato.Produto.ListaProduto listaProduto = new FiltroContrato.Produto.ListaProduto();
				listaProduto.setCodigoProduto(prodOrigem.getId().getCodigoBcp().shortValue());
				if (prodOrigem.getProdutoSegmento() != null && !prodOrigem.getProdutoSegmento().isEmpty()) {
					for (ProdutoSegmento prodSegmento : prodOrigem.getProdutoSegmento()) {
						FiltroContrato.Produto.ListaProduto.ListaSegmento listaSegmento = new FiltroContrato.Produto.ListaProduto.ListaSegmento();
						listaSegmento.setCodigoSegmento(prodSegmento.getId().getCodigoSegmentoCliente().shortValue());
						listaProduto.getListaSegmento().add(listaSegmento);
					}
				}
				produto.getListaProduto().add(listaProduto);
			}
		}
		criterioAdd.setProduto(produto);
	}

}
