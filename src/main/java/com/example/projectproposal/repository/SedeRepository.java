package com.example.projectproposal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.example.projectproposal.entity.Sede;

public interface SedeRepository extends JpaRepository<Sede,Long> {

    //public List<Sede> finallsSedes(); esta no se ha tocado

    
}
