package com.example.projectproposal.service;

import com.example.projectproposal.entity.*;

import java.util.List;

public interface ISedeService {
    
    //metodo para consultar todas las sedes
    public List<Sede> findAll();
    //metodo para consultar por Id
    public Sede findById(Long id);
    //metodo para guardar 
    public Sede save(Sede sede);
    //metodo para actualizar
    public Sede updaSede(Sede sede , Long id);
    //metodo para borrar
    public void delete(Long id);


}
