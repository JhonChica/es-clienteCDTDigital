package com.mibanco.clientecdtdigital.es.controller;

import com.mibanco.clientecdtdigital.es.entity.ClienteCDTDigital;
import com.mibanco.clientecdtdigital.es.services.impl.ClienteCDTDigitalImpl;
import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.GraphQLApi;
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
        return clienteCDTDigitalImpl.obtenerTodosLosClienteCDTDigitalGraphQl();
    }
}
