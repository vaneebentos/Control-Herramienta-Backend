package com.gestion.empleados.inventario_backend.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

@Entity
@Table (name = "herramientas")
public class Herramienta {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     @Column(name = "nombreherramienta", length = 60, nullable = false)
    private String nombreHerramienta;

     @Column(name = "tipo", length = 60, nullable = false)
    private String tipo;
     @Column(name = "cantidad", length = 60, nullable = true)
    private int cantidad;

    //  @Temporal(TemporalType.DATE)
      @DateTimeFormat(iso=ISO.DATE)
      @Column(name = "fechaSalida", length = 60, nullable = true)
     
    private Date fechaSalida;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaIngreso")
    private Date fechaIngreso;


    public Herramienta (){
      
    }

    public Herramienta(Long id, String nombreHerramienta, String tipo, int cantidad,  Date fechaSalida , Date fechaIngreso) {
      this.id = id;
      this.nombreHerramienta = nombreHerramienta;
      this.tipo = tipo;
      this.cantidad = cantidad;
      this.fechaSalida = fechaSalida;
      this.fechaIngreso= fechaIngreso;
    }

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getNombreHerramienta(){
      return nombreHerramienta;
    }

    public void setNombreHerramienta(String nombreHerramienta) {
      this.nombreHerramienta = nombreHerramienta;
    }

    public String getTipo() {
      return tipo;
    }

    public void setTipo(String tipo) {
      this.tipo = tipo;
    }

    public int getCantidad() {
      return cantidad;
    }

    public void setCantidad(int cantidad) {
      this.cantidad = cantidad;
    }

    public Date getFechaSalida() {
      return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
      this.fechaSalida = fechaSalida;
    }

    public Date getFechaIngreso() {
      return fechaIngreso;
  }

    public void setFechaIngreso(Date fechaIngreso) {
      this.fechaIngreso = fechaIngreso;
  }
}
