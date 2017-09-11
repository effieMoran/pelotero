package com.metodologia.sistemas.controller;

import com.metodologia.sistemas.entity.Cliente;
import com.metodologia.sistemas.service.imp.ClienteServiceImplementation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Cliente", description = "CRUD de clientes")
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteServiceImplementation clienteServiceImplementation;

    @ApiOperation(value = "Crear un cliente")
    @RequestMapping(method= RequestMethod.POST)
    public void save(@RequestBody Cliente cliente){
        clienteServiceImplementation.saveCliente(cliente);
    }

    @ApiOperation(value = "Actualiza un cliente")
    @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateClient(@PathVariable int id, @RequestBody Cliente cliente){
        clienteServiceImplementation.updateCliente(id, cliente);
    }

    @ApiOperation(value = "Borra un cliente")
    @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/{id}", method= RequestMethod.DELETE)
    public void save(@PathVariable int id){
        clienteServiceImplementation.deleteCliente(id);
    }

    @ApiOperation(value = "Devuelve un cliente por su ID")
    @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Cliente getCliente(@PathVariable int id){
        return  clienteServiceImplementation.findById(id);
    }

    @ApiOperation(value = "Devuelve una lista de clientes")
    @RequestMapping(method=RequestMethod.GET)
    public List<Cliente> list() {
        return clienteServiceImplementation.findAll();
    }


}
