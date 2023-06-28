package com.example.projectproposal.repository.dao;

//import org.springframework.data.repository.Repository;
import org.springframework.data.repository.CrudRepository;

import  com.example.projectproposal.entity.Sede;

public interface ISedeDao extends CrudRepository<Sede,Long>{
    
}
