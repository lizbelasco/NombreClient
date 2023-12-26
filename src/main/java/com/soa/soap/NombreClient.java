/**
 * 
 */
package com.soa.soap;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.soa.dto.LizbethRequest;
import com.soa.dto.VelascoRicardezResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Clase que genera el método de ejecución de un servicio web.
 */
public class NombreClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(NombreClient.class);

    public VelascoRicardezResponse execute() {

        LizbethRequest request = new LizbethRequest();
        request.setNombreCompleto("VELASCO, RICARDEZ, LIZBETH MARIA");

        log.info("Executing WS");

        VelascoRicardezResponse response = (VelascoRicardezResponse) 
                getWebServiceTemplate().marshalSendAndReceive(
                "http://localhost:8080/nombre", request, 
                new SoapActionCallback("http://soa.com/LizbethRequest"));

        return response;
    }

}