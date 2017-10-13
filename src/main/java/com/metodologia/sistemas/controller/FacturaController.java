package com.metodologia.sistemas.controller;


import com.metodologia.sistemas.entity.Factura;
import com.metodologia.sistemas.entity.Fiesta;
import com.metodologia.sistemas.repository.FacturaRepository;
import com.metodologia.sistemas.service.imp.FacturaServiceImplementation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Factura", description = "CRUD de Factura")
@RestController
@RequestMapping("/factura")
public class FacturaController {

    @Autowired
    private FacturaServiceImplementation facturaServiceImplementation;

    @ApiOperation(value = "Crear un combo")
    @RequestMapping(method= RequestMethod.POST)
    public void save(@RequestBody Fiesta fiesta){
        facturaServiceImplementation.saveByFiesta(fiesta);
    }

    @ApiOperation(value = "Devuelve una lista de combos")
    @RequestMapping(method=RequestMethod.GET)
    public List<Factura> list() {
        return facturaServiceImplementation.findAll();
    }

}
