package com.mibanco.clientecdtdigital.es.services.impl;

import com.mibanco.clientecdtdigital.es.controller.ClienteCDTDigidalController;
import com.mibanco.clientecdtdigital.es.dao.ClienteCDTDigitalDao;
import com.mibanco.clientecdtdigital.es.entity.ClienteCDTDigital;
import com.mibanco.clientecdtdigital.es.gen.type.ClienteCDTDigitalType;
import com.mibanco.clientecdtdigital.es.services.contract.IClienteCDTDigital;
import com.mibanco.clientecdtdigital.es.utils.exception.ApplicationException;
import com.mibanco.clientecdtdigital.es.utils.mapper.ClienteCDTDigitalMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.mibanco.clientecdtdigital.es.constant.Constant.ERROR_SERVICIO;

@ApplicationScoped
public class ClienteCDTDigitalImpl implements IClienteCDTDigital {
    private  static  final Logger LOG = LoggerFactory.getLogger(ClienteCDTDigidalController.class);
    @Inject
    ClienteCDTDigitalMapper clienteCDTDigitalMapper;
    @Inject
    ClienteCDTDigitalDao clienteCDTDigitalDao;

    @Transactional
    @Override
    public ClienteCDTDigitalType crearClienteCdtDigital(ClienteCDTDigitalType clienteCDTDigitalType) {
        try {
            ClienteCDTDigital clienteCDTDigital = clienteCDTDigitalMapper.clienteCDTDigitalTypeToEntity(clienteCDTDigitalType);
            clienteCDTDigitalDao.persist(clienteCDTDigital);
            return clienteCDTDigitalType;
        }catch(ApplicationException e){
            LOG.error("Se presento un error en el metodo crearClienteCdtDigital Impl"+ e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage());
        }
    }
}
