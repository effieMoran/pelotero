package com.metodologia.sistemas.controller;

import com.metodologia.sistemas.entity.Usuario;
import com.metodologia.sistemas.service.imp.UserServiceImplementation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

    //TODO: VERIFY IF THERE IS OTHER USER WITH THE SAME NAME
    @ApiOperation(value = "Crear un Usuario")
    @RequestMapping(value = "/registrar", method= RequestMethod.POST)
    public void save(@RequestBody Usuario user){
        if(!userServiceImplementation.userExists(user.getUsername())) {
            userServiceImplementation.saveUser(user);
        }
    }

}
