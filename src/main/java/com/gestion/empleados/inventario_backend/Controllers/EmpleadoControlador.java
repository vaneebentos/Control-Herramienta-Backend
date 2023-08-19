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
import com.gestion.empleados.inventario_backend.Repositories.EmpleadoRepository;
import com.gestion.empleados.inventario_backend.models.Empleado;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin (origins ="http://localhost:4200")
public class EmpleadoControlador {

    @Autowired
    private EmpleadoRepository empleadorepository;

    // este metodo sirve para listar todos los empleados
    @GetMapping("/empleados")
    public List<Empleado> listarTodosLosEmpleados() {
        return empleadorepository.findAll();
    }

    @PostMapping("/empleados")
    public Empleado guardarEmpleado(@RequestBody Empleado empleado){
        return empleadorepository.save(empleado);
    }

    // este metodo sirve para buscar un empleado por id
    @GetMapping("/empleados/{id}")
    public  ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable Long id){
        Empleado empleado= empleadorepository.findById(id)
                            .orElseThrow(()-> new ResourceNotFoundException("No existe el empleado con el ID :"+ id));
        return ResponseEntity.ok(empleado);
    
    }

    @PutMapping("/empleado/{id}")
    public  ResponseEntity<Empleado>actualizarEmpleadoPorId(@PathVariable Long id, @RequestBody Empleado detallesEmpleado){
        Empleado empleado= empleadorepository.findById(id)
                            .orElseThrow(()-> new ResourceNotFoundException("No existe el empleado con el ID :"+ id));
       empleado.setNombre(detallesEmpleado.getNombre());
       empleado.setApellido(detallesEmpleado.getApellido());
       empleado.setArea(detallesEmpleado.getArea());

       Empleado empleadoActualizado = empleadorepository.save(empleado);
        return ResponseEntity.ok(empleadoActualizado);
    
}
@DeleteMapping("/empleados/{id}")
public ResponseEntity<Map<String,Boolean>> eliminarEmpleado(@PathVariable Long id){
    Empleado empleado = empleadorepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));
    
    empleadorepository.delete(empleado);
    Map<String, Boolean> respuesta = new HashMap<>();
    respuesta.put("eliminar",Boolean.TRUE);
    return ResponseEntity.ok(respuesta);
}

 
}