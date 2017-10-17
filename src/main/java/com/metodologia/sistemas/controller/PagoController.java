package com.metodologia.sistemas.controller;

import com.metodologia.sistemas.entity.Pago;
import com.metodologia.sistemas.service.imp.PagoServiceImplementation;
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

@Api(value = "Pagos", description = "CRUD de pagos")
@RestController
@RequestMapping("/pago")
public class PagoController {

    @Autowired
    private PagoServiceImplementation pagoServiceImplementation;

    @ApiOperation(value = "Crear un pago")
    @RequestMapping(method= RequestMethod.POST)
    public Pago save(@RequestBody Pago pago){
        pagoServiceImplementation.savePago(pago);
        return pago;
    }

    @ApiOperation(value = "Actualiza un pago")
    @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateClient(@PathVariable int id, @RequestBody Pago pago){
        pagoServiceImplementation.update(id, pago);
    }

    @ApiOperation(value = "Borra un pago")
    @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/{id}", method= RequestMethod.DELETE)
    public void save(@PathVariable int id){
        pagoServiceImplementation.delete(id);
    }

    @ApiOperation(value = "Devuelve un pago por su ID")
    @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Pago getCombo(@PathVariable int id){
        return  pagoServiceImplementation.findById(id);
    }

    @ApiOperation(value = "Devuelve una lista de pagos")
    @RequestMapping(method=RequestMethod.GET)
    public List<Pago> list() {
        return pagoServiceImplementation.findAll();
    }
}
