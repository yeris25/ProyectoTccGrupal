package com.example.proyectogrupal.Entidades;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "Bodega")
public class Bodega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="ControlEntrada",nullable = false, length =50 )
    private String ControEntrada;

    @Column(name="ControlSalida",nullable = false, length =50 )
    private String ControlSalida;

    @Column(name="Ubicacion",nullable = false, length =50 )
    private String Ubicacion;

    @OneToMany(mappedBy = "Bodega")
    private List<Mercancia> mercancia;



    public Bodega() {
    }

    public Bodega(Integer id, String controEntrada, String controlSalida, String ubicacion, List<Mercancia> mercancia) {
        this.id = id;
        ControEntrada = controEntrada;
        ControlSalida = controlSalida;
        Ubicacion = ubicacion;
        this.mercancia = mercancia;
    }

    @Transient
    private String mensjeError;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getControEntrada() {
        return ControEntrada;
    }

    public void setControEntrada(String controEntrada) {
        ControEntrada = controEntrada;
    }

    public String getControlSalida() {
        return ControlSalida;
    }

    public void setControlSalida(String controlSalida) {
        ControlSalida = controlSalida;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }

    public List<Mercancia> getMercancia() {
        return mercancia;
    }

    public void setMercancia(List<Mercancia> mercancia) {
        this.mercancia = mercancia;
    }

    public String getMensjeError() {
        return mensjeError;
    }

    public void setMensjeError(String mensjeError) {
        this.mensjeError = mensjeError;
    }
}
