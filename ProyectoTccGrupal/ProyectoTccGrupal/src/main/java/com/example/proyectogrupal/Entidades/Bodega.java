package com.example.proyectogrupal.Entidades;


import jakarta.persistence.*;

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

    @OneToOne(mappedBy = "Bodega", cascade = CascadeType.ALL)
    @JoinColumn
    private Bodega bodega;

    public Bodega() {
    }

    public Bodega(Integer id, String controEntrada, String controlSalida, String ubicacion, Bodega bodega) {
        this.id = id;
        ControEntrada = controEntrada;
        ControlSalida = controlSalida;
        Ubicacion = ubicacion;
        this.bodega = bodega;
    }

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

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }
}
