package com.example.projectproposal.Entity;

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

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name= "facultades")
@Entity
public class Facultad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
     

    @NotEmpty(message= "No puede estar vacio") // 'message' mesanje custom para erorres 
    @Size(min = 4 ,  max = 20)
    @Column(name= "`nombrefacultad`" ,nullable = false , length = 20)
    private String nombreFacultad;


    @NotEmpty(message= "No puede estar vacio")
    @Column( name= "description", length = 150,nullable = false)
    private String descripcion;
    
    
    @NotEmpty(message= "No puede estar vacio")
    @Column(  length = 20,nullable = false)
    private String direccion ;
  
    @NotEmpty(message= "No puede estar vacio")
    @Column(name = "telefono",  length = 20)
    private String telefono ;
  
    @NotEmpty(message= "No puede estar vacio")
    @Column(name = "sitio_web",  length = 50)
    private String sitioWeb;
    
    @Email(message="El formato del correo no es correcto")
    @NotEmpty(message= "No puede estar vacio")
    @Column(name = "email",  length = 50 , unique = true)
    private String email ;
    
    @NotEmpty(message= "No puede estar vacio")
    @Column(  length = 30)
    private String decano ;

  
    @Column(name= "numero_departamentos",  length = 10)
    private Integer numeroDepartamentos;


    @Column(name= "numero_programas_estudio" , length = 10)
    private Integer numeroProgramasEstudio;

    @Column(name="create_at")//nombre de la columna en la base de datos
	@Temporal(TemporalType.DATE)// el formato de fecha 
	private Date createAt;
  
    @PrePersist // anotacion para ejecutar una funcion antes de guardad en la base dato o antes que se ejecute la consulta en la base de datos
    public void prePersist(){
        createAt = new Date();
    }
}
