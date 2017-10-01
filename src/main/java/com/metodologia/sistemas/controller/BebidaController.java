package com.metodologia.sistemas.controller;

import com.metodologia.sistemas.entity.Bebida;
import com.metodologia.sistemas.service.imp.BebidaServiceImplementation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Bebidas", description = "CRUD de bebidas")
@RestController
@RequestMapping("/bebidas")
public class BebidaController {

    @Autowired
    private BebidaServiceImplementation bebidaServiceImplementation;

    @ApiOperation(value = "Crear una bebida")
    @RequestMapping(method= RequestMethod.POST)
    public void save(@RequestBody Bebida bebida){
        bebidaServiceImplementation.saveBebida(bebida);
    }

    @ApiOperation(value = "Actualiza una bebida")
    @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateBebida(@PathVariable int id, @RequestBody Bebida bebida){
        bebidaServiceImplementation.updateBebida(id, bebida);
    }

    @ApiOperation(value = "Borra una bebida")
    @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/{id}", method= RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        bebidaServiceImplementation.deleteBebida(id);
    }

    @ApiOperation(value = "Devuelve una bebida por su ID")
    @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Bebida getBebida(@PathVariable int id){
        return  bebidaServiceImplementation.findById(id);
    }

    @ApiOperation(value = "Devuelve una lista de bebidas")
    @RequestMapping(method=RequestMethod.GET)
    public List<Bebida> list() {
        return bebidaServiceImplementation.findAll();
    }
}
