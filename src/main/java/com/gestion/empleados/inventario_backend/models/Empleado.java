package com.gestion.empleados.inventario_backend.models;

import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "nombre", length = 60, nullable = false)
    private String nombre;
    @Column(name = "apellido", length = 60, nullable = false)
    private String apellido;

    @Column(name = "area", length = 60, nullable = false)
    private String area;

    public Empleado() {

    }

    public Empleado(Long id, String nombre, String apellido, String area) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.area = area;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

}
