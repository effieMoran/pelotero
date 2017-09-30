package com.metodologia.sistemas.controller;

import com.metodologia.sistemas.entity.Usuario;
import com.metodologia.sistemas.service.imp.UserServiceImplementation;
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

@Api(value = "User", description = "CRUD de users")
@RestController
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    private UserServiceImplementation userServiceImplementation;

    @ApiOperation(value = "Devuelve una lista de Usuarios")
    @RequestMapping(method=RequestMethod.GET)
    public List<Usuario> list() {
        return userServiceImplementation.findAll();
    }

    @ApiOperation(value = "Crear un Usuario")
    @RequestMapping(value = "/registrar", method= RequestMethod.POST)
    public boolean save(@RequestBody Usuario user){
        if(!userServiceImplementation.userExists(user.getUsername())) {
            userServiceImplementation.saveUser(user);
            return true;
        }
        return false;
    }

    @ApiOperation(value = "Crear un Usuario")
    @RequestMapping(value = "/loggin", method= RequestMethod.POST)
    public boolean loggin(@RequestBody Usuario user){
        return userServiceImplementation.userMatches(user);
    }

    @ApiOperation(value = "Actualiza un usuario")
    @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateClient(@PathVariable int id, @RequestBody Usuario user){
        userServiceImplementation.updateUser(id, user);
    }

    @ApiOperation(value = "Borra un cliente")
    @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/{id}", method= RequestMethod.DELETE)
    public void save(@PathVariable int id){
        userServiceImplementation.deleteUser(id);
    }
}
