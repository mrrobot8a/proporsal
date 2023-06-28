package com.example.projectproposal.service;


import com.example.projectproposal.entity.Sede;
import com.example.projectproposal.repository.dao.ISedeDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SedeServiceImpl implements ISedeService {

    @Autowired // injecion de dependecia de la clase que implementa jpa
    private  ISedeDao SedeDao;


    @Override
    public List<Sede> findAll() {
        return (List<Sede>) SedeDao.findAll();
    }
    
}
