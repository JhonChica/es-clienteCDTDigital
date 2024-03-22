package com.mibanco.clientecdtdigital.es.controller;

import com.mibanco.clientecdtdigital.es.entity.ClienteCDTDigital;
import com.mibanco.clientecdtdigital.es.gen.type.ClienteCDTDigitalType;
import com.mibanco.clientecdtdigital.es.services.impl.ClienteCDTDigitalImpl;
import com.mibanco.clientecdtdigital.es.utils.exception.ApplicationException;
import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@GraphQLApi
public class ClienteCDTDigidalGraphQlController {
    private  static  final Logger LOG = LoggerFactory.getLogger(ClienteCDTDigidalGraphQlController.class);

    @Inject
    ClienteCDTDigitalImpl clienteCDTDigitalImpl;

    @Query("allCliente")
    public List<ClienteCDTDigital> obtenerTodosLosClienteCDTDigitalGraphQl(){
        LOG.info("Inicia el proceso de obtenerTodosLosClienteCDTDigitalGraphQl Controller");
        List<ClienteCDTDigital> allClient = null;
        try{
            allClient = clienteCDTDigitalImpl.obtenerTodosLosClienteCDTDigitalImpl();
        }catch(ApplicationException e){
            LOG.error("Error en el proceso de obtenerTodosLosClienteCDTDigitalGraphQl Controller: " + e.getMessage());
        }
        LOG.info("Finaliza el proceso de obtenerTodosLosClienteCDTDigitalGraphQl Controller");
        return allClient;
    }
    @Mutation("crearCliente")
    public ClienteCDTDigital crearClienteCDTDigitalGraphQl(ClienteCDTDigitalType clienteCDTDigitalType){
        LOG.info("Inicia el proceso de crearClienteCDTDigitalGraphQl Impl");
        ClienteCDTDigital clienteCDTDigital = null;
        try{
            clienteCDTDigital = clienteCDTDigitalImpl.crearClienteCDTDigitalImpl(clienteCDTDigitalType);
        }catch(ApplicationException e){
            LOG.error("Error en el proceso de crearClienteCDTDigitalGraphQl Impl: " + e.getMessage());
        }
        LOG.info("Finaliza el proceso de crearClienteCDTDigitalGraphQl Impl");
        return clienteCDTDigital;
    }
}
