package com.example.projectproposal.repository.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.Repository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import  com.example.projectproposal.entity.Sede;

@Repository
public interface ISedeDao extends JpaRepository<Sede,Long>{

    @Query("SELECT s FROM Sede s WHERE s.nombre_sede LIKE %:term%") // select a nivel de entity y no a nivel de tabla , se debe utilizar (Select * From Sede) el nombre de la entidad para realizar la consulta
    public List<Sede> findByNombreSede(@Param("term") String term);
    
}
