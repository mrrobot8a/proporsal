package com.example.projectproposal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
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

      Sede sede = null;
      Map<String, Object> response = new HashMap<>(); // instancia de hashmap

      try {
         sede = sedeService.findById(id); // consutar el objeto en la base de datos
      } catch (DataAccessException e) {
         // TODO: handle exception
         response.put("mensaje", "Error al realizar la consulta en la base de datos");
         response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
         return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
      }
      // si no se encuentra el objecto que se busca en la base de datos
      if (sede == null) {
         response.put("mensaje", "El cliente ID:".concat(id.toString().concat(" - no existe en la base de datosQ")));
         return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
      }

      return new ResponseEntity<Sede>(sede, HttpStatus.OK);

   }

   @PostMapping("/sedes") // crea el endpoint
   public ResponseEntity<?> create(@RequestBody Sede sede) {

      Sede sedeNew = null;
      Map<String, Object> response = new HashMap<>(); // instancia de hashmap para crear un map para el manejo de
                                                      // errores
      // manejo de errorees en la consulta en la base de datos
      try {
         sedeNew = sedeService.save(sede);// metodo para guardar en la base datos
      } catch (DataAccessException e) {
         // TODO: handle exception
         response.put("mensaje", "Error al realizar la insersion en la base de datos");
         response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
         return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
      }
      //
      response.put("mensaje", "El cliente ha sido creado con exito!");
      response.put("cliente", sedeNew);

      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
   }

   @PutMapping("/sedes/{id}")
   public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Sede sede) {
      Sede sedeActual = sedeService.findById(id); // atributos

      Sede sedeUpdate = null;

      Map<String, Object> response = new HashMap<>(); // instancia de hashmap para crear un map para el manejo de
                                                      // errores
      if (sedeActual == null) {

         response.put("mensaje", "El cliente ID:".concat(id.toString().concat(" - no existe en la base de datosQ")));
         return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_MODIFIED);
      }

      try {

         sedeActual.setNombreSede(sede.getNombreSede());
         sedeActual.setDireccion(sede.getDireccion());
         sedeActual.setTelefono(sede.getTelefono());
         sedeActual.setEmail(sede.getEmail());
         sedeUpdate = sedeService.save(sedeActual);

      } catch (DataAccessException e) {
         // TODO: handle exception

         response.put("mensaje", "Error al realizar la actualizacion en la base de datos");
         response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
         return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
      }

      response.put("mensaje", "El cliente ha sido actualizado con exito!");
      response.put("cliente", sedeUpdate);
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);// se utiliza el mismo metodo que en
                                                                                   // el crear para actualizar esto por
                                                                                   // detra
      // se entiendo como merger , si el metodo trae un id este lo actuliza de lo
      // contraio crear el objeto en la base de datos
   }

   
   @DeleteMapping("/sedes/{id}")
   public ResponseEntity<?> delete(@PathVariable Long id) {
      Sede sedeActual = sedeService.findById(id);
      Map<String, Object> response = new HashMap<>();
      
      if (sedeActual == null) {

         response.put("mensaje", "El cliente ID:".concat(id.toString().concat(" - no existe en la base de datos")));
         return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
      }

      try {
         sedeService.delete(id);
      } catch (EmptyResultDataAccessException e) {
         response.put("mensaje", "La sede con el ID " + id + " no existe");
         return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
      } catch (DataAccessException e) {
         // TODO: handle exception
         response.put("mensaje", "Error al realizar el eliminar en la base de datos");
         response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
         return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
      }

      response.put("mensaje", "El cliente ha sido eliminadoo con exito!");
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
   }

}
