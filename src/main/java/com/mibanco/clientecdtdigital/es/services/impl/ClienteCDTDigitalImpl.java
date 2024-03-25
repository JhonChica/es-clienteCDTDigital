package com.mibanco.clientecdtdigital.es.services.impl;

import com.google.protobuf.Empty;
import com.google.protobuf.Int64Value;
import com.mibanco.clientecdtdigital.es.dao.ClienteCDTDigitalDao;
import com.mibanco.clientecdtdigital.es.entity.ClienteCDTDigital;
import com.mibanco.clientecdtdigital.es.proto.service.Cliente;
import com.mibanco.clientecdtdigital.es.proto.service.ClienteCDTDigitalService;
import com.mibanco.clientecdtdigital.es.utils.exception.ApplicationException;
import com.mibanco.clientecdtdigital.es.utils.mapper.ClienteCDTDigitalMapper;
import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
@GrpcService
public class ClienteCDTDigitalImpl implements ClienteCDTDigitalService {
    private  static  final Logger LOG = LoggerFactory.getLogger(ClienteCDTDigitalImpl.class);
    @Inject
    ClienteCDTDigitalMapper clienteCDTDigitalMapper;
    @Inject
    ClienteCDTDigitalDao clienteCDTDigitalDao;

    @Override
    public Uni<Cliente> create(Cliente request) {
        LOG.info("Se inicia en el metodo create Impl");
        ClienteCDTDigital clienteCDTDigital = null;
        try{
            clienteCDTDigital = clienteCDTDigitalMapper.clienteCDTDigitalTypeToEntity(request);
            System.out.println(clienteCDTDigital);
            clienteCDTDigitalDao.persist(clienteCDTDigital);
        }catch(ApplicationException e){
            LOG.error("Se presento un error en el metodo buscarClienteCDTDigital_1 controller"+ e.getMessage());
        }
        return null;
    }

    @Override
    public Uni<Cliente> update(Cliente request) {
        return null;
    }

    @Override
    public Uni<Cliente> finById(Int64Value request) {
        return null;
    }

    @Override
    public Uni<Cliente> list(Empty request) {
        return null;
    }

    @Override
    public Uni<Cliente> delete(Int64Value request) {
        return null;
    }
}
