package com.metodologia.sistemas.controller;

import com.metodologia.sistemas.entity.Combo;
import com.metodologia.sistemas.service.imp.ComboServiceImplementation;
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

@Api(value = "Combo", description = "CRUD de combo")
@RestController
@RequestMapping("/combo")

public class ComboController {


    @Autowired
    private ComboServiceImplementation comboServiceImplementation;

    @ApiOperation(value = "Crear un combo")
    @RequestMapping(method= RequestMethod.POST)
    public void save(@RequestBody Combo combo){
        comboServiceImplementation.save(combo);
    }

    @ApiOperation(value = "Actualiza un combo")
    @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateClient(@PathVariable int id, @RequestBody Combo combo){
        comboServiceImplementation.update(id, combo);
    }

    @ApiOperation(value = "Borra un combo")
    @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/{id}", method= RequestMethod.DELETE)
    public void save(@PathVariable int id){
        comboServiceImplementation.delete(id);
    }

    @ApiOperation(value = "Devuelve un combo por su ID")
    @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Combo getCombo(@PathVariable int id){
        return  comboServiceImplementation.findById(id);
    }

    @ApiOperation(value = "Devuelve una lista de combo")
    @RequestMapping(method=RequestMethod.GET)
    public List<Combo> list() {
        return comboServiceImplementation.findAll();
    }

}
