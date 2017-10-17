package com.metodologia.sistemas.controller;

import com.metodologia.sistemas.entity.Rol;
import com.metodologia.sistemas.service.imp.RolServiceImplementation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(value = "Rol", description = "CRUD de roles")
@RestController
@RequestMapping("/rol")

public class RolController {
    @Autowired
    private RolServiceImplementation rolServiceImplementation;

    @ApiOperation(value = "Devuelve una lista de Roles")
    @RequestMapping(method= RequestMethod.GET)
    public List<Rol> list() {
        return rolServiceImplementation.findAll();
    }

    @ApiOperation(value = "Crear un Rol")
    @RequestMapping(value = "/registrarRol", method= RequestMethod.POST)
    public void save(@RequestBody Rol rol){
            rolServiceImplementation.saveRol(rol);
    }

    @ApiOperation(value = "Actualiza un rol")
    @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/rol/{id}", method = RequestMethod.PUT)
    public void updateClient(@PathVariable int id, @RequestBody Rol rol){
        rolServiceImplementation.updateRol(id, rol);
    }

    @ApiOperation(value = "Borra un cliente")
    @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/deleteRol/{id}", method= RequestMethod.DELETE)
    public void save(@PathVariable int id){
        rolServiceImplementation.deleteRol(id);
    }
}
