
package com.porto.portocom.portal.cliente.v1.wsdl.investimento;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Classe Java de CotistaCompletoServiceVO complex type.
 * 
 * <p>
 * O seguinte fragmento do esquema especifica o conte�do esperado contido dentro
 * desta classe.
 * 
 * <pre>
 * &lt;complexType name="CotistaCompletoServiceVO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://common.portopar.financeiro.porto.com}CotistaServiceVO">
 *       &lt;sequence>
 *         &lt;element name="bairro" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cep" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cidade" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="complemento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ddd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="logradouro" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numero" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="telefone" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipoPessoa" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CotistaCompletoServiceVO", namespace = "http://common.portopar.financeiro.porto.com", propOrder = {
		"bairro", "cep", "cidade", "complemento", "ddd", "email", "estado", "logradouro", "nome", "numero", "telefone",
		"tipoPessoa" })
public class CotistaCompletoServiceVO extends CotistaServiceVO implements Serializable {

	private static final long serialVersionUID = -6899074578239690263L;

	@XmlElement(required = true, nillable = true)
	protected String bairro;
	@XmlElement(required = true, nillable = true)
	protected String cep;
	@XmlElement(required = true, nillable = true)
	protected String cidade;
	@XmlElement(required = true, nillable = true)
	protected String complemento;
	@XmlElement(required = true, nillable = true)
	protected String ddd;
	@XmlElement(required = true, nillable = true)
	protected String email;
	@XmlElement(required = true, nillable = true)
	protected String estado;
	@XmlElement(required = true, nillable = true)
	protected String logradouro;
	@XmlElement(required = true, nillable = true)
	protected String nome;
	@XmlElement(required = true, nillable = true)
	protected String numero;
	@XmlElement(required = true, nillable = true)
	protected String telefone;
	@XmlElement(required = true, nillable = true)
	protected String tipoPessoa;

	/**
	 * Obt�m o valor da propriedade bairro.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * Define o valor da propriedade bairro.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setBairro(String value) {
		this.bairro = value;
	}

	/**
	 * Obt�m o valor da propriedade cep.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * Define o valor da propriedade cep.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setCep(String value) {
		this.cep = value;
	}

	/**
	 * Obt�m o valor da propriedade cidade.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * Define o valor da propriedade cidade.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setCidade(String value) {
		this.cidade = value;
	}

	/**
	 * Obt�m o valor da propriedade complemento.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * Define o valor da propriedade complemento.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setComplemento(String value) {
		this.complemento = value;
	}

	/**
	 * Obt�m o valor da propriedade ddd.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDdd() {
		return ddd;
	}

	/**
	 * Define o valor da propriedade ddd.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setDdd(String value) {
		this.ddd = value;
	}

	/**
	 * Obt�m o valor da propriedade email.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Define o valor da propriedade email.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setEmail(String value) {
		this.email = value;
	}

	/**
	 * Obt�m o valor da propriedade estado.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Define o valor da propriedade estado.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setEstado(String value) {
		this.estado = value;
	}

	/**
	 * Obt�m o valor da propriedade logradouro.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * Define o valor da propriedade logradouro.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setLogradouro(String value) {
		this.logradouro = value;
	}

	/**
	 * Obt�m o valor da propriedade nome.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Define o valor da propriedade nome.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setNome(String value) {
		this.nome = value;
	}

	/**
	 * Obt�m o valor da propriedade numero.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Define o valor da propriedade numero.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setNumero(String value) {
		this.numero = value;
	}

	/**
	 * Obt�m o valor da propriedade telefone.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Define o valor da propriedade telefone.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setTelefone(String value) {
		this.telefone = value;
	}

	/**
	 * Obt�m o valor da propriedade tipoPessoa.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTipoPessoa() {
		return tipoPessoa;
	}

	/**
	 * Define o valor da propriedade tipoPessoa.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setTipoPessoa(String value) {
		this.tipoPessoa = value;
	}

}
