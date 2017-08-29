package com.metodologia.sistemas.service.imp;

import com.metodologia.sistemas.entity.Cliente;
import com.metodologia.sistemas.repository.ClienteRepository;
import com.metodologia.sistemas.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImplementation implements ClienteService{

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public void saveCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public Cliente findById(int id) {
        return clienteRepository.getOne(id);
    }

    @Override
    public void deleteCliente(int id) {
        clienteRepository.delete(id);
    }

    @Override
    public void updateCliente(int id, Cliente cliente) {
        cliente.setId(id);
        clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }
}
