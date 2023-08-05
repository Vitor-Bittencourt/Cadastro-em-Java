package com.example.appsenai.view;

import com.example.appsenai.controller.Controller;
import com.example.appsenai.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
// import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonView {

    @Autowired
    Controller controller;
    @GetMapping("/person")
    public Person findPerson(@PathParam("name") String name){
        return controller.findPerson(name);
    }


    @DeleteMapping("/person")
    public String deletePerson(@PathParam("name") String name){
        controller.removePerson(name);

        return "Pessoa com o Nome de " + name + " foi deletada";
    }

    @PostMapping("/person")
    public Person addPerson(@PathParam("name") String name, @PathParam("sexo") String sexo){
       return controller.addPerson(name, sexo);
    }

    @PutMapping("/person")
    public Person updatePerson(@PathParam("name") String name, @PathParam("sexo") String sexo){
        return controller.editPerson(name, sexo);
    }

    @GetMapping("/all")
    public List<Person> listAll(){
        return controller.listAll();
    }

    @GetMapping("/home")
    public String helloWorld(){
        return "Hello world";
    }
}