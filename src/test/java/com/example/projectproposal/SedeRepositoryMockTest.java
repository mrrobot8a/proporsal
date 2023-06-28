package com.example.projectproposal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import  com.example.projectproposal.repository.SedeRepository;
@DataJpaTest// anotacion para testar una clase que extendiende de jpa
public class SedeRepositoryMockTest {
    
    @Autowired// anotacion para injeccion de dependencia
    private SedeRepository SedeRepository ;
    
}
