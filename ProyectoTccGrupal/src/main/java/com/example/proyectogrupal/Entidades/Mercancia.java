package com.example.proyectogrupal.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name="Mercancia")

public class Mercancia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="IUP",nullable = false, length =50 )
    private String iup;

    @Column(name="nombre",nullable = false, length =50 )
    private String nombre;

    @Column(name="descripcion",nullable = false, length =50 )
    private String descripcion;

    @Column(name="fechaEntrada",nullable = false, length =50 )
    private String fechaEntrada;

    @Column(name="MotivoDevolucion",nullable = false, length =50 )
    private String MotivoDevolucion;

    @Column(name="VolumenOcupado",nullable = false, length =50 )
    private String VolumenOcupado;

    @OneToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name="bodega",nullable = false)
    @JsonBackReference
    private Bodega bodega;

    public Mercancia() {
    }

    public Mercancia(Integer id, String iup, String nombre, String descripcion, String fechaEntrada, String motivoDevolucion, String volumenOcupado, Bodega bodega) {
        this.id = id;
        this.iup = iup;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaEntrada = fechaEntrada;
        MotivoDevolucion = motivoDevolucion;
        VolumenOcupado = volumenOcupado;
        this.bodega = bodega;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIup() {
        return iup;
    }

    public void setIup(String iup) {
        this.iup = iup;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getMotivoDevolucion() {
        return MotivoDevolucion;
    }

    public void setMotivoDevolucion(String motivoDevolucion) {
        MotivoDevolucion = motivoDevolucion;
    }

    public String getVolumenOcupado() {
        return VolumenOcupado;
    }

    public void setVolumenOcupado(String volumenOcupado) {
        VolumenOcupado = volumenOcupado;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }
}
