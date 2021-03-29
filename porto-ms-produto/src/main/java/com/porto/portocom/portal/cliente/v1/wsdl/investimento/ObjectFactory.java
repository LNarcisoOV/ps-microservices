
package com.porto.portocom.portal.cliente.v1.wsdl.investimento;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsdlConsultaCotista package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ConsultarCotistaServiceException_QNAME = new QName("http://exception.portopar.financeiro.porto.com", "ConsultarCotistaServiceException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsdlConsultaCotista
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConsultaCotistaPorCpfCnpj }
     * 
     */
    public ConsultaCotistaPorCpfCnpj createConsultaCotistaPorCpfCnpj() {
        return new ConsultaCotistaPorCpfCnpj();
    }

    /**
     * Create an instance of {@link ConsultaCotistaCompletoPorContratoResponse }
     * 
     */
    public ConsultaCotistaCompletoPorContratoResponse createConsultaCotistaCompletoPorContratoResponse() {
        return new ConsultaCotistaCompletoPorContratoResponse();
    }

    /**
     * Create an instance of {@link CotistaCompletoServiceVO }
     * 
     */
    public CotistaCompletoServiceVO createCotistaCompletoServiceVO() {
        return new CotistaCompletoServiceVO();
    }

    /**
     * Create an instance of {@link ConsultaCotistaPorCpfCnpjResponse }
     * 
     */
    public ConsultaCotistaPorCpfCnpjResponse createConsultaCotistaPorCpfCnpjResponse() {
        return new ConsultaCotistaPorCpfCnpjResponse();
    }

    /**
     * Create an instance of {@link CotistaServiceVO }
     * 
     */
    public CotistaServiceVO createCotistaServiceVO() {
        return new CotistaServiceVO();
    }

    /**
     * Create an instance of {@link ConsultaCotistaPorContrato }
     * 
     */
    public ConsultaCotistaPorContrato createConsultaCotistaPorContrato() {
        return new ConsultaCotistaPorContrato();
    }

    /**
     * Create an instance of {@link ConsultaCotistaCompletoPorCpfCnpj }
     * 
     */
    public ConsultaCotistaCompletoPorCpfCnpj createConsultaCotistaCompletoPorCpfCnpj() {
        return new ConsultaCotistaCompletoPorCpfCnpj();
    }

    /**
     * Create an instance of {@link ConsultaCotistaCompletoPorContrato }
     * 
     */
    public ConsultaCotistaCompletoPorContrato createConsultaCotistaCompletoPorContrato() {
        return new ConsultaCotistaCompletoPorContrato();
    }

    /**
     * Create an instance of {@link ConsultaCotistaCompletoPorCpfCnpjResponse }
     * 
     */
    public ConsultaCotistaCompletoPorCpfCnpjResponse createConsultaCotistaCompletoPorCpfCnpjResponse() {
        return new ConsultaCotistaCompletoPorCpfCnpjResponse();
    }

    /**
     * Create an instance of {@link ConsultaCotistaPorContratoResponse }
     * 
     */
    public ConsultaCotistaPorContratoResponse createConsultaCotistaPorContratoResponse() {
        return new ConsultaCotistaPorContratoResponse();
    }

    /**
     * Create an instance of {@link ConsultarCotistaServiceException }
     * 
     */
    public ConsultarCotistaServiceException createConsultarCotistaServiceException() {
        return new ConsultarCotistaServiceException();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarCotistaServiceException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://exception.portopar.financeiro.porto.com", name = "ConsultarCotistaServiceException")
    public JAXBElement<ConsultarCotistaServiceException> createConsultarCotistaServiceException(ConsultarCotistaServiceException value) {
        return new JAXBElement<ConsultarCotistaServiceException>(_ConsultarCotistaServiceException_QNAME, ConsultarCotistaServiceException.class, null, value);
    }

}
