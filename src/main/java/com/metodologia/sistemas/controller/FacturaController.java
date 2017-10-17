package com.metodologia.sistemas.controller;


import com.metodologia.sistemas.entity.Factura;
import com.metodologia.sistemas.entity.Fiesta;
import com.metodologia.sistemas.entity.Pago;
import com.metodologia.sistemas.repository.FacturaRepository;
import com.metodologia.sistemas.service.imp.FacturaServiceImplementation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;

@Api(value = "Factura", description = "CRUD de Factura")
@RestController
@RequestMapping("/factura")
public class FacturaController {

    @Autowired
    private FacturaServiceImplementation facturaServiceImplementation;

    @ApiOperation(value = "Crear una factura")
    @RequestMapping(value = "/{fecha}", method = RequestMethod.POST)
    public void save(@PathVariable @DateTimeFormat(pattern="dd-MM-yyyy") Date fecha){
        facturaServiceImplementation.crearFactura(fecha);
    }

    @ApiOperation(value = "Devuelve una lista de combos")
    @RequestMapping(method=RequestMethod.GET)
    public List<Factura> list() {
        return facturaServiceImplementation.findAll();
    }

    @ApiOperation(value = "Borra una factura")
    @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/{id}", method= RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        facturaServiceImplementation.delete(id);
    }

    @ApiOperation(value = "Devuelve una factura por su ID")
    @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Factura getTematica(@PathVariable int id){
        return  facturaServiceImplementation.findById(id);
    }

    @ApiOperation(value = "Agrega una fiesta a una factura")
    @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/fiesta/{id}", method = RequestMethod.PUT)
    public void agregarFiesta(@PathVariable int id, @RequestBody Fiesta fiesta){

        facturaServiceImplementation.addFiesta(id, fiesta);
    }

    @ApiOperation(value = "Agrega un pago a una factura")
    @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/pago/{id}", method = RequestMethod.PUT)
    public void agregarPago(@PathVariable int id, @RequestBody Pago pago){
        facturaServiceImplementation.addPago(id, pago);
    }

    @ApiOperation(value = "Devuelve un la diferencia entre el monto total y el monto a pagar")
    @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/pago/{id}", method = RequestMethod.GET)
    public double pagoCompleto(@PathVariable int id){
        return facturaServiceImplementation.getDiferencia(id);
    }

}
