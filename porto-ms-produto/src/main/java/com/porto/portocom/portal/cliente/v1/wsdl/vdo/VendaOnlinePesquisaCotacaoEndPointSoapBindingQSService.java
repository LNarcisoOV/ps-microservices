
package com.porto.portocom.portal.cliente.v1.wsdl.vdo;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * OSB Service
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "VendaOnlinePesquisaCotacaoEndPointSoapBindingQSService", targetNamespace = "http://ws.integracao.vendaonline.marketing.porto.com", wsdlLocation = "https://osbtstcrp.portoseguro.brasil/VendaOnlineIntegrationService/VendaOnlineIntegrationServiceSoap11V1_0?wsdl")
public class VendaOnlinePesquisaCotacaoEndPointSoapBindingQSService
    extends Service
{

    private final static URL VENDAONLINEPESQUISACOTACAOENDPOINTSOAPBINDINGQSSERVICE_WSDL_LOCATION;
    private final static WebServiceException VENDAONLINEPESQUISACOTACAOENDPOINTSOAPBINDINGQSSERVICE_EXCEPTION;
    private final static QName VENDAONLINEPESQUISACOTACAOENDPOINTSOAPBINDINGQSSERVICE_QNAME = new QName("http://ws.integracao.vendaonline.marketing.porto.com", "VendaOnlinePesquisaCotacaoEndPointSoapBindingQSService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://osbtstcrp.portoseguro.brasil/VendaOnlineIntegrationService/VendaOnlineIntegrationServiceSoap11V1_0?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        VENDAONLINEPESQUISACOTACAOENDPOINTSOAPBINDINGQSSERVICE_WSDL_LOCATION = url;
        VENDAONLINEPESQUISACOTACAOENDPOINTSOAPBINDINGQSSERVICE_EXCEPTION = e;
    }

    public VendaOnlinePesquisaCotacaoEndPointSoapBindingQSService() {
        super(__getWsdlLocation(), VENDAONLINEPESQUISACOTACAOENDPOINTSOAPBINDINGQSSERVICE_QNAME);
    }

    public VendaOnlinePesquisaCotacaoEndPointSoapBindingQSService(WebServiceFeature... features) {
        super(__getWsdlLocation(), VENDAONLINEPESQUISACOTACAOENDPOINTSOAPBINDINGQSSERVICE_QNAME, features);
    }

    public VendaOnlinePesquisaCotacaoEndPointSoapBindingQSService(URL wsdlLocation) {
        super(wsdlLocation, VENDAONLINEPESQUISACOTACAOENDPOINTSOAPBINDINGQSSERVICE_QNAME);
    }

    public VendaOnlinePesquisaCotacaoEndPointSoapBindingQSService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, VENDAONLINEPESQUISACOTACAOENDPOINTSOAPBINDINGQSSERVICE_QNAME, features);
    }

    public VendaOnlinePesquisaCotacaoEndPointSoapBindingQSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public VendaOnlinePesquisaCotacaoEndPointSoapBindingQSService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns VendaOnlinePesquisaCotacaoEndPoint
     */
    @WebEndpoint(name = "VendaOnlinePesquisaCotacaoEndPointSoapBindingQSPort")
    public VendaOnlinePesquisaCotacaoEndPoint getVendaOnlinePesquisaCotacaoEndPointSoapBindingQSPort() {
        return super.getPort(new QName("http://ws.integracao.vendaonline.marketing.porto.com", "VendaOnlinePesquisaCotacaoEndPointSoapBindingQSPort"), VendaOnlinePesquisaCotacaoEndPoint.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns VendaOnlinePesquisaCotacaoEndPoint
     */
    @WebEndpoint(name = "VendaOnlinePesquisaCotacaoEndPointSoapBindingQSPort")
    public VendaOnlinePesquisaCotacaoEndPoint getVendaOnlinePesquisaCotacaoEndPointSoapBindingQSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.integracao.vendaonline.marketing.porto.com", "VendaOnlinePesquisaCotacaoEndPointSoapBindingQSPort"), VendaOnlinePesquisaCotacaoEndPoint.class, features);
    }

    private static URL __getWsdlLocation() {
        if (VENDAONLINEPESQUISACOTACAOENDPOINTSOAPBINDINGQSSERVICE_EXCEPTION!= null) {
            throw VENDAONLINEPESQUISACOTACAOENDPOINTSOAPBINDINGQSSERVICE_EXCEPTION;
        }
        return VENDAONLINEPESQUISACOTACAOENDPOINTSOAPBINDINGQSSERVICE_WSDL_LOCATION;
    }

}
