package com.mibanco.clientecdtdigital.es.services.impl;

import com.mibanco.clientecdtdigital.es.dao.ClienteCDTDigitalDao;
import com.mibanco.clientecdtdigital.es.entity.ClienteCDTDigital;
import com.mibanco.clientecdtdigital.es.gen.type.ClienteCDTDigitalType;
import com.mibanco.clientecdtdigital.es.utils.exception.ApplicationException;
import com.mibanco.clientecdtdigital.es.utils.mapper.ClienteCDTDigitalMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


@ApplicationScoped
public class ClienteCDTDigitalImpl {
    private  static  final Logger LOG = LoggerFactory.getLogger(ClienteCDTDigitalImpl.class);
    @Inject
    ClienteCDTDigitalMapper clienteCDTDigitalMapper;
    @Inject
    ClienteCDTDigitalDao clienteCDTDigitalDao;

    public List<ClienteCDTDigital> obtenerTodosLosClienteCDTDigitalImpl(){
        LOG.info("Inicia el proceso de obtenerTodosLosClienteCDTDigitalImpl Impl");
        List<ClienteCDTDigital> allClient = null;
        try{
            allClient = clienteCDTDigitalDao.listAll();
        }catch(ApplicationException e){
            LOG.error("Error en el proceso de obtenerTodosLosClienteCDTDigitalImpl Impl: " + e.getMessage());
        }
        LOG.info("Finaliza el proceso de obtenerTodosLosClienteCDTDigitalImpl Impl");
        return allClient;
    }

    @Transactional
    public ClienteCDTDigital crearClienteCDTDigitalImpl(ClienteCDTDigitalType clienteCDTDigitalType){
        LOG.info("Inicia el proceso de crearClienteCDTDigitalImpl Impl");
        ClienteCDTDigital clienteCDTDigital = null;
        try{
            clienteCDTDigital = clienteCDTDigitalMapper.clienteCDTDigitalTypeToEntity(clienteCDTDigitalType);
            clienteCDTDigitalDao.persist(clienteCDTDigital);
        }catch(ApplicationException e){
            LOG.error("Error en el proceso de crearClienteCDTDigitalImpl Impl: " + e.getMessage());
        }
        LOG.info("Finaliza el proceso de crearClienteCDTDigitalImpl Impl");
        return clienteCDTDigital;
    }

}
