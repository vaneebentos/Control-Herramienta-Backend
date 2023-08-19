package com.gestion.empleados.inventario_backend.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.empleados.inventario_backend.Exception.ResourceNotFoundException;
import com.gestion.empleados.inventario_backend.Repositories.HerramientaRepository;
import com.gestion.empleados.inventario_backend.models.Herramienta;

  @RestController
@RequestMapping("/api/v1/")
@CrossOrigin (origins ="http://localhost:4200")

public class HerramientaControlador {
  

    @Autowired
    private HerramientaRepository herramientarepository;

    // este metodo sirve para listar todos los herramienta
    @GetMapping("/herramientas")
    public List<Herramienta> listarTodasLasherramientas() {
        return herramientarepository.findAll();
    }

    @PostMapping("/herramientas")
    public Herramienta guardarherramienta(@RequestBody Herramienta herramienta){
        return herramientarepository.save(herramienta);
    }



    // este metodo sirve para buscar un herramienta por id
    @GetMapping("/herramientas/{id}")
    public  ResponseEntity<Herramienta> obtenerherramientaPorId(@PathVariable Long id){
        Herramienta herramienta= herramientarepository.findById(id)
                            .orElseThrow(()-> new ResourceNotFoundException("No existe el herramienta con el ID :"+ id));
        return ResponseEntity.ok(herramienta);
    
    }


    @PutMapping("/herramientas/{id}")
    public  ResponseEntity<Herramienta>actualizarherramientaPorId(@PathVariable Long id, @RequestBody Herramienta detallesherramienta){
        Herramienta herramienta= herramientarepository.findById(id)
                            .orElseThrow(()-> new ResourceNotFoundException("No existe el herramienta con el ID :"+ id));
       herramienta.setNombreHerramienta(detallesherramienta.getNombreHerramienta());
       herramienta.setTipo(detallesherramienta.getTipo());
       herramienta.setCantidad(detallesherramienta.getCantidad());
       herramienta.setFechaIngreso(detallesherramienta.getFechaIngreso());
       herramienta.setFechaSalida(detallesherramienta.getFechaSalida());

       Herramienta herramientaActualizado = herramientarepository.save(herramienta);
        return ResponseEntity.ok(herramientaActualizado);
    
}
    @DeleteMapping("/herramientas/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarherramienta(@PathVariable Long id){
    Herramienta herramienta = herramientarepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("No existe el herramienta con el ID : " + id));
    
    herramientarepository.delete(herramienta);
    Map<String, Boolean> respuesta = new HashMap<>();
    respuesta.put("eliminar",Boolean.TRUE);
    return ResponseEntity.ok(respuesta);
}



 
}

