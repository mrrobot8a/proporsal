package com.example.projectproposal.service;

import com.example.projectproposal.entity.Sede;
import com.example.projectproposal.repository.dao.ISedeDao;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SedeServiceImpl implements ISedeService {

    @Autowired // injecion de dependecia para utulizar la calse que extiende de crudrepository
               // jpa
    private ISedeDao SedeDao;

    @Override
    @Transactional(readOnly = true)//está anotado con @Transactional(readOnly = true), lo que indica que la transacción es de solo lectura.
    public List<Sede> findAll() {
        return (List<Sede>) SedeDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Sede findById(Long id) {

        return SedeDao.findById(id).orElse(null);

    }

    @Override
    @Transactional
    public Sede save(Sede sede) {
        return SedeDao.save(sede);
    }

   

    @Override
    @Transactional
    public void delete(Long id) {
        SedeDao.deleteById(id);
    }

}
