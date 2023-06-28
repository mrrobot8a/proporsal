package com.example.projectproposal.entity;




import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity // anotacion entity para declarar  una clase como entidad o objeto
@Table(name= "sedes") // anotacion Table para declarar el nombre de la tabla en la base datos (para diferencia el nombre de la tabla ala clase o artributo en ella)
@Data // nos declara los metodos getter , setter , hashcode , toString
@AllArgsConstructor
@NoArgsConstructor
 public class Sede implements Serializable{
    @Id//anotacion para declar lleve primaria 
    @GeneratedValue(strategy = GenerationType.IDENTITY) //anotacion para generar un auto incrementable para este caso un id
    private Long id ;
    @Column(name = "nombre_Sede", nullable = false, length = 20)
    private String nombreSede ;
}
