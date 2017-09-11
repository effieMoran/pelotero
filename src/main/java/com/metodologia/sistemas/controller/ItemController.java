package com.metodologia.sistemas.controller;

import com.metodologia.sistemas.entity.Item;
import com.metodologia.sistemas.service.imp.ItemServiceImplementation;
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

@Api(value = "Item", description = "CRUD de item")
@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemServiceImplementation itemServiceImplementation;

    @ApiOperation(value = "Crear un item")
    @RequestMapping(method= RequestMethod.POST)
    public void save(@RequestBody Item item){
        itemServiceImplementation.save(item);
    }

    @ApiOperation(value = "Actualiza un item")
    @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateClient(@PathVariable int id, @RequestBody Item item){
        itemServiceImplementation.update(id, item);
    }

    @ApiOperation(value = "Borra un item")
    @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/{id}", method= RequestMethod.DELETE)
    public void save(@PathVariable int id){
        itemServiceImplementation.delete(id);
    }

    @ApiOperation(value = "Devuelve un item por su ID")
    @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Item getCliente(@PathVariable int id){
        return  itemServiceImplementation.findById(id);
    }

    @ApiOperation(value = "Devuelve una lista de items")
    @RequestMapping(method=RequestMethod.GET)
    public List<Item> list() {
        return itemServiceImplementation.findAll();
    }
    
}
