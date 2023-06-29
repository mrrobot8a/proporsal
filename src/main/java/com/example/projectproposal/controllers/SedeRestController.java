package com.example.projectproposal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectproposal.entity.Sede;
import com.example.projectproposal.service.ISedeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin({ "http://localhost:4200" }) // cors origin perimitir concectar dos herrramientas en diferentes dominios ,
                                          // en este caso el frontend con el backend
@RestController
@RequestMapping("/proposal")
public class SedeRestController {

   @Autowired // va a buscar el primer candidato , una clase concreta que implementación esta
              // interface y la va a inyectar
   private ISedeService sedeService;

   @GetMapping("/sedes")
   public List<Sede> index() {
      return sedeService.findAll();
   }

   @GetMapping("/sedes/{id}")
   public ResponseEntity<?> GetById(@PathVariable("id") Long id) {
      
      Sede sede = null ;
      Map<String, Object> response = new HashMap<>();
      
       try {
         sede = sedeService.findById(id);
       } catch (DataAccessException e) {
         // TODO: handle exception
        response.put("mensaje", "Error al realizar la consulta en la base de datos");
        response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
        return new ResponseEntity<Map<String, Object>>(response , HttpStatus.NOT_FOUND);
      }
   
       if(sede == null){
         response.put("mensaje", "El cliente ID:".concat(id.toString().concat(" - no existe en la base de datosQ")));
         return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
       }

       return new ResponseEntity<Sede>(sede , HttpStatus.OK);
      
      }



   @PostMapping("/sedes") // crea el endpoint
   @ResponseStatus(HttpStatus.CREATED) // indica que se debe devolver el código de estado HTTP 201 (Created) en la   // respuesta cuando se crea un nuevo recurso.
   public Sede create(@RequestBody Sede sede) {
      return sedeService.save(sede);
   }
                        

   @PutMapping("/sedes/{id}")
   @ResponseStatus(HttpStatus.CREATED)
   public Sede update(@PathVariable("id") Long id, @RequestBody Sede sede) {

      Sede sedeActual = sedeService.findById(id); // se trae la sede que esta en la base de datos y se le actulizan sus
                                                  // atributos
      
      sedeActual.setNombreSede(sede.getNombreSede());
      sedeActual.setDireccion(sede.getDireccion());
      sedeActual.setTelefono(sede.getTelefono());
      sedeActual.setEmail(sede.getEmail());

      return sedeService.save(sedeActual); // se utiliza el mismo metodo que en el crear para actualizar esto por detra
                                           // se entiendo como merger , si el metodo trae un id este lo actuliza de lo
                                           // contraio crear el objeto en la base de datos
   }

   @DeleteMapping("/sedes/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public void delete(@PathVariable("id") Long id) {
      sedeService.delete(id);
   }

}
