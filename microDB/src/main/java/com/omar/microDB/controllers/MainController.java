/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omar.microDB.controllers;

import com.omar.microDB.bean.Respuesta;
import com.omar.microDB.bean.User;
import com.omar.microDB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Omar Rodriguez
 * @version 1.0.0
 */
@Controller // This means that this class is a Controller
@RequestMapping(path = "/user") // This means URL's start with /demo (after Application path)
public class MainController {

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;

    /**
     *
     * @param name
     * @param email
     * @param apellidos
     * @param cedula
     * @return
     * @throws java.lang.Exception
     */
    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody
    Respuesta addNewUser(@RequestParam(required = false) String name, @RequestParam(required = false) String email, @RequestParam String apellidos, @RequestParam Long cedula) throws Exception {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Respuesta respuesta = new Respuesta();

        if (name == null) {
            respuesta.setRespuesta("Error, en agregar el usuario");
            respuesta.setError("El nombre esta vacio");
            return respuesta;

        } else if (email == null) {
            respuesta.setRespuesta("Error, en agregar el usuario");
            respuesta.setError("El email esta vacio");
            return respuesta;
        }
        User n = new User();
        n.setName(name);
        
        try {
            n.setEmail(email);
        } catch (Exception e) {
            respuesta.setRespuesta("¡Erro, al agregar el usuario!");
            respuesta.setError(e.getMessage());
             return respuesta;
        }
        
        n.setApellidos(apellidos);
        n.setCedula(cedula);

        try {

            userRepository.save(n);

        } catch (Exception e) {
            respuesta.setRespuesta("¡Erro, al agregar el usuario!");
            respuesta.setError(e.getMessage());
             return respuesta;
        }

        respuesta.setRespuesta("¡Usuario agregado exitosamente!");

        return respuesta;

    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users

        try {
            return userRepository.findAll();

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return null;
    }

}
