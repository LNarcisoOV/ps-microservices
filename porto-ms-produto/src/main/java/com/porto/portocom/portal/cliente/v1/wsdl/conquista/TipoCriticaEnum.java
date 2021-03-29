
package com.porto.portocom.portal.cliente.v1.wsdl.conquista;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de tipoCriticaEnum.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="tipoCriticaEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SUCESSO"/>
 *     &lt;enumeration value="CRITICA_NEGOCIO"/>
 *     &lt;enumeration value="CRITICA_VALIDACAO"/>
 *     &lt;enumeration value="CRITICA_ERRO_APLICACAO"/>
 *     &lt;enumeration value="CRITICA_ALERTA"/>
 *     &lt;enumeration value="BLOQUEIO"/>
 *     &lt;enumeration value="FALHA"/>
 *     &lt;enumeration value="CRITICA_ASSINATURA_ELETRONICA"/>
 *     &lt;enumeration value="CRITICA_OTP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tipoCriticaEnum")
@XmlEnum
public enum TipoCriticaEnum {

    SUCESSO,
    CRITICA_NEGOCIO,
    CRITICA_VALIDACAO,
    CRITICA_ERRO_APLICACAO,
    CRITICA_ALERTA,
    BLOQUEIO,
    FALHA,
    CRITICA_ASSINATURA_ELETRONICA,
    CRITICA_OTP;

    public String value() {
        return name();
    }

    public static TipoCriticaEnum fromValue(String v) {
        return valueOf(v);
    }

}
