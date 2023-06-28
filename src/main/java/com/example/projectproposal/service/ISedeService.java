package com.example.projectproposal.service;

import com.example.projectproposal.entity.*;

import java.util.List;

public interface ISedeService {
    
    //metodo para consultar todas las sedes
    public List<Sede> findAll();
}
