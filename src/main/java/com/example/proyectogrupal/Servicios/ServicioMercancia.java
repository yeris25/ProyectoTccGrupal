package com.example.proyectogrupal.Servicios;


import com.example.proyectogrupal.Entidades.Bodega;
import com.example.proyectogrupal.Entidades.Mercancia;
import com.example.proyectogrupal.repositorio.BodegaRepositorio;
import com.example.proyectogrupal.repositorio.MercanciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public  class ServicioMercancia implements  ServicioBase <Mercancia> {

    @Autowired
    protected MercanciaRepositorio MercanciaRepositorio;


    @Override
    public List<Mercancia> buscarTodos() throws Exception {
        return null;
    }

    @Override
    public Mercancia buscarPorId(Integer id) throws Exception {
        return null;
    }

    @Override
    public Mercancia registrar(Mercancia datosARegistrar) throws Exception {
        return null;
    }

    @Override
    public Mercancia actualizar(Integer id, Mercancia datosNuevos) throws Exception {
        return null;
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        return false;
    }
}
