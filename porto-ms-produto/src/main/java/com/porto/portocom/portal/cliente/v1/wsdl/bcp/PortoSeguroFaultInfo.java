
package com.porto.portocom.portal.cliente.v1.wsdl.bcp;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "portoSeguroFaultInfo", targetNamespace = "http://www.portoseguro.com.br/foundation/PortoSeguroMessage")
public class PortoSeguroFaultInfo
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private PortoSeguroFaultInfoType faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public PortoSeguroFaultInfo(String message, PortoSeguroFaultInfoType faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public PortoSeguroFaultInfo(String message, PortoSeguroFaultInfoType faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.porto.portocom.portal.cliente.wsdl.PortoSeguroFaultInfoType
     */
    public PortoSeguroFaultInfoType getFaultInfo() {
        return faultInfo;
    }

}