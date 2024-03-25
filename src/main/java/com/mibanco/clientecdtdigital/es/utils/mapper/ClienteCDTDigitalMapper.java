package com.mibanco.clientecdtdigital.es.utils.mapper;

import com.mibanco.clientecdtdigital.es.entity.ClienteCDTDigital;
import com.mibanco.clientecdtdigital.es.gen.type.ClienteCDTDigitalType;
import com.mibanco.clientecdtdigital.es.proto.service.Cliente;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class ClienteCDTDigitalMapper {
    public ClienteCDTDigital clienteCDTDigitalTypeToEntity(Cliente cliente){
        ClienteCDTDigital clienteCDTDigital = new ClienteCDTDigital();
        clienteCDTDigital.setTipoCorreoElectronico(cliente.getTipoCorreoElectronico());
        clienteCDTDigital.setTelefonoPrincipal(cliente.getTelefonoPrincipal());
        return clienteCDTDigital;
    }
    public Cliente entityToClienteCDTDigitalType(ClienteCDTDigital clienteCDTDigital){
        return new ModelMapper().map(clienteCDTDigital, Cliente.class);
    }
}
