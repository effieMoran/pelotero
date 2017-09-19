package com.metodologia.sistemas.controller;

import com.metodologia.sistemas.entity.Reserva;
import com.metodologia.sistemas.service.imp.ReservaServiceImplementation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Reserva", description = "CRUD de reserva")
@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaServiceImplementation reservaServiceImplementation;

    @ApiOperation(value = "Crear una reserva")
    @RequestMapping(method= RequestMethod.POST)
    public void save(@RequestBody Reserva reserva){
        reservaServiceImplementation.save(reserva);
    }

    @ApiOperation(value = "Devuelve una lista de combo")
    @RequestMapping(method=RequestMethod.GET)
    public List<Reserva> list() {
        return reservaServiceImplementation.findAll();
    }

}
