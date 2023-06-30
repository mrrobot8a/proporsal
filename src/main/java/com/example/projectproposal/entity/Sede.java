package com.example.projectproposal.entity;




import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Entity // anotacion entity para declarar  una clase como entidad o objeto
@Table(name= "sedes") // anotacion Table para declarar el nombre de la tabla en la base datos (para diferencia el nombre de la tabla ala clase o artributo en ella)
@Data // nos declara los metodos getter , setter , hashcode , toString

 public class Sede implements Serializable{
    private static final long serialVersionUID = 1L;
    
    
  

    @Id//anotacion para declar lleve primaria 
    @GeneratedValue(strategy = GenerationType.IDENTITY) //anotacion para generar un auto incrementable para este caso un id
    private Long id ;


    @NotEmpty(message= "No puede estar vacio") // 'message' mesanje custom para erorres 
    @Size(min = 4 ,  max = 20)
    @Column(name = "nombre_Sede", nullable = false, length = 20)
    private String nombreSede ;
    
    @NotEmpty(message= "No puede estar vacio")
    @Column(name = "direccion", nullable = false, length = 20)
    private String direccion;
    
    @NotEmpty(message= "No puede estar vacio")
    @Column(name = "telefono", nullable = false, length = 20)
    private String telefono ;
     
    @Email(message="El formato del correo no es correcto")
    @NotEmpty(message= "No puede estar vacio")
    @Column(name = "email", nullable = false, length = 50 , unique = true)
    private String email ;
     
     
    @Column(name="create_at")//nombre de la columna en la base de datos
	@Temporal(TemporalType.DATE)// el formato de fecha 
	private Date createAt;
     
    @PrePersist // anotacion para ejecutar una funcion antes de guardad en la base dato o antes que se ejecute la consulta en la base de datos
    public void prePersist(){
        createAt = new Date();
    }
}
