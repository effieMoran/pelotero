package com.metodologia.sistemas.controller;

import com.metodologia.sistemas.entity.Tematica;
import com.metodologia.sistemas.service.imp.TematicaServiceImplementation;
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

@Api(value = "Tematica", description = "CRUD de tematica")
@RestController
@RequestMapping("/tematica")
public class TematicaController {

    @Autowired
    private TematicaServiceImplementation tematicaServiceImplementation;

    @ApiOperation(value = "Crear una tematica")
    @RequestMapping(method= RequestMethod.POST)
    public void save(@RequestBody Tematica tematica){
        tematicaServiceImplementation.save(tematica);
    }

    @ApiOperation(value = "Actualiza una tematica")
    @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable int id, @RequestBody Tematica tematica){
        tematicaServiceImplementation.update(id, tematica);
    }

    @ApiOperation(value = "Borra una tematica")
    @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/{id}", method= RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        tematicaServiceImplementation.delete(id);
    }

    @ApiOperation(value = "Devuelve una bebida por su ID")
    @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Tematica getTematica(@PathVariable int id){
        return  tematicaServiceImplementation.findById(id);
    }

    @ApiOperation(value = "Devuelve una lista de tematicas")
    @RequestMapping(method=RequestMethod.GET)
    public List<Tematica> list() {
        return tematicaServiceImplementation.findAll();
    }
}
