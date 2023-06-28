package com.example.projectproposal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectproposal.entity.Sede;
import com.example.projectproposal.service.ISedeService;
import java.util.List;

@RestController
@RequestMapping("/proposal")
public class SedeRestController {

   @Autowired // va a buscar el primer candidato , una clase concreta que implementación esta interface y la va a inyectar
   private ISedeService sedeService;
   
   @GetMapping("/sedes")
    public  List<Sede> index(){
       return sedeService.findAll();
    }
    

}
