
package com.porto.portocom.portal.cliente.v1.wsdl.conquista;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de cadastrarClienteArenaResponseType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="cadastrarClienteArenaResponseType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://impl.service.soap.arenaservicos.portopar.financeiro.porto.com/}baseVO">
 *       &lt;sequence>
 *         &lt;element name="Message">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://impl.service.soap.arenaservicos.portopar.financeiro.porto.com/}baseVO">
 *                 &lt;sequence>
 *                   &lt;element name="TipoCritica" type="{http://impl.service.soap.arenaservicos.portopar.financeiro.porto.com/}tipoCriticaEnum"/>
 *                   &lt;element name="Mensagem" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Validacoes" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Validacao" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="cliente_arena" type="{http://impl.service.soap.arenaservicos.portopar.financeiro.porto.com/}clienteArenaType" minOccurs="0"/>
 *         &lt;element name="status_cadastro" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="mesagem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cadastrarClienteArenaResponseType", propOrder = {
    "message",
    "clienteArena",
    "statusCadastro",
    "mesagem"
})
public class CadastrarClienteArenaResponseType
    extends BaseVO
{

    @XmlElement(name = "Message", required = true)
    protected CadastrarClienteArenaResponseType.Message message;
    @XmlElement(name = "cliente_arena")
    protected ClienteArenaType clienteArena;
    @XmlElement(name = "status_cadastro")
    protected Boolean statusCadastro;
    protected String mesagem;

    /**
     * Obt�m o valor da propriedade message.
     * 
     * @return
     *     possible object is
     *     {@link CadastrarClienteArenaResponseType.Message }
     *     
     */
    public CadastrarClienteArenaResponseType.Message getMessage() {
        return message;
    }

    /**
     * Define o valor da propriedade message.
     * 
     * @param value
     *     allowed object is
     *     {@link CadastrarClienteArenaResponseType.Message }
     *     
     */
    public void setMessage(CadastrarClienteArenaResponseType.Message value) {
        this.message = value;
    }

    /**
     * Obt�m o valor da propriedade clienteArena.
     * 
     * @return
     *     possible object is
     *     {@link ClienteArenaType }
     *     
     */
    public ClienteArenaType getClienteArena() {
        return clienteArena;
    }

    /**
     * Define o valor da propriedade clienteArena.
     * 
     * @param value
     *     allowed object is
     *     {@link ClienteArenaType }
     *     
     */
    public void setClienteArena(ClienteArenaType value) {
        this.clienteArena = value;
    }

    /**
     * Obt�m o valor da propriedade statusCadastro.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isStatusCadastro() {
        return statusCadastro;
    }

    /**
     * Define o valor da propriedade statusCadastro.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStatusCadastro(Boolean value) {
        this.statusCadastro = value;
    }

    /**
     * Obt�m o valor da propriedade mesagem.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMesagem() {
        return mesagem;
    }

    /**
     * Define o valor da propriedade mesagem.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMesagem(String value) {
        this.mesagem = value;
    }


    /**
     * <p>Classe Java de anonymous complex type.
     * 
     * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://impl.service.soap.arenaservicos.portopar.financeiro.porto.com/}baseVO">
     *       &lt;sequence>
     *         &lt;element name="TipoCritica" type="{http://impl.service.soap.arenaservicos.portopar.financeiro.porto.com/}tipoCriticaEnum"/>
     *         &lt;element name="Mensagem" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Validacoes" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Validacao" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "tipoCritica",
        "mensagem",
        "validacoes"
    })
    public static class Message
        extends BaseVO
    {

        @XmlElement(name = "TipoCritica", required = true)
        @XmlSchemaType(name = "string")
        protected TipoCriticaEnum tipoCritica;
        @XmlElement(name = "Mensagem", required = true)
        protected String mensagem;
        @XmlElement(name = "Validacoes")
        protected CadastrarClienteArenaResponseType.Message.Validacoes validacoes;

        /**
         * Obt�m o valor da propriedade tipoCritica.
         * 
         * @return
         *     possible object is
         *     {@link TipoCriticaEnum }
         *     
         */
        public TipoCriticaEnum getTipoCritica() {
            return tipoCritica;
        }

        /**
         * Define o valor da propriedade tipoCritica.
         * 
         * @param value
         *     allowed object is
         *     {@link TipoCriticaEnum }
         *     
         */
        public void setTipoCritica(TipoCriticaEnum value) {
            this.tipoCritica = value;
        }

        /**
         * Obt�m o valor da propriedade mensagem.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMensagem() {
            return mensagem;
        }

        /**
         * Define o valor da propriedade mensagem.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMensagem(String value) {
            this.mensagem = value;
        }

        /**
         * Obt�m o valor da propriedade validacoes.
         * 
         * @return
         *     possible object is
         *     {@link CadastrarClienteArenaResponseType.Message.Validacoes }
         *     
         */
        public CadastrarClienteArenaResponseType.Message.Validacoes getValidacoes() {
            return validacoes;
        }

        /**
         * Define o valor da propriedade validacoes.
         * 
         * @param value
         *     allowed object is
         *     {@link CadastrarClienteArenaResponseType.Message.Validacoes }
         *     
         */
        public void setValidacoes(CadastrarClienteArenaResponseType.Message.Validacoes value) {
            this.validacoes = value;
        }


        /**
         * <p>Classe Java de anonymous complex type.
         * 
         * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Validacao" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "validacao"
        })
        public static class Validacoes {

            @XmlElement(name = "Validacao")
            protected List<String> validacao;

            /**
             * Gets the value of the validacao property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the validacao property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getValidacao().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getValidacao() {
                if (validacao == null) {
                    validacao = new ArrayList<String>();
                }
                return this.validacao;
            }

        }

    }

}
