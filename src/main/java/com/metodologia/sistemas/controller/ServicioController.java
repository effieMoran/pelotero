package com.metodologia.sistemas.controller;

import com.metodologia.sistemas.entity.Servicio;
import com.metodologia.sistemas.service.imp.ServicioServiceImplemetation;
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

@Api(value = "Servicio", description = "CRUD de servicio")
@RestController
@RequestMapping("/servicio")
public class ServicioController {

    @Autowired
    private ServicioServiceImplemetation servicioServiceImplemetation;

    @ApiOperation(value = "Crear un item")
    @RequestMapping(method= RequestMethod.POST)
    public Servicio save(@RequestBody Servicio servicio){
        servicioServiceImplemetation.save(servicio);
        return servicio;
    }

    @ApiOperation(value = "Actualiza un item")
    @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateServicio(@PathVariable int id, @RequestBody Servicio servicio){
        servicioServiceImplemetation.update(id, servicio);
    }

    @ApiOperation(value = "Borra un item")
    @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/{id}", method= RequestMethod.DELETE)
    public void save(@PathVariable int id){
        servicioServiceImplemetation.delete(id);
    }

    @ApiOperation(value = "Devuelve un item por su ID")
    @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Servicio getCliente(@PathVariable int id){
        return servicioServiceImplemetation.findById(id);
    }

    @ApiOperation(value = "Devuelve una lista de items")
    @RequestMapping(method=RequestMethod.GET)
    public List<Servicio> list() {
        return servicioServiceImplemetation.findAll();
    }

}
