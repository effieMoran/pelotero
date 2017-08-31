package com.metodologia.sistemas.controller;

import com.metodologia.sistemas.entity.Cliente;
import com.metodologia.sistemas.service.imp.ClienteServiceImplementation;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Cliente", description = "CRUD de clientes")
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteServiceImplementation clienteServiceImplementation;

    @RequestMapping(method= RequestMethod.POST)
    public void save(@RequestBody Cliente cliente){
        clienteServiceImplementation.saveCliente(cliente);
    }

    @RequestMapping(method=RequestMethod.GET)
    public List<Cliente> list() {
        return clienteServiceImplementation.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateClient(@PathVariable int id, @RequestBody Cliente cliente){
        clienteServiceImplementation.updateCliente(id, cliente);
    }

    @RequestMapping(value = "/{id}", method= RequestMethod.DELETE)
    public void save(@PathVariable int id){
        clienteServiceImplementation.deleteCliente(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public void updateClient(@PathVariable int id){
        clienteServiceImplementation.findById(id);
    }
}
