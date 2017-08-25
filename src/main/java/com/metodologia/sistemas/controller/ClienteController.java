package com.metodologia.sistemas.controller;


import com.metodologia.sistemas.entity.Cliente;
import com.metodologia.sistemas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @RequestMapping(method= RequestMethod.POST)
    public void save(@RequestBody Cliente cliente){
        clienteRepository.save(cliente);
    }

    @RequestMapping(method=RequestMethod.GET)
    public List<Cliente> list() {
        return clienteRepository.findAll();
    }

}
