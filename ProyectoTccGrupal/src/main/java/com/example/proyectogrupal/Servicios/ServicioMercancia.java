package com.example.proyectogrupal.Servicios;


import com.example.proyectogrupal.Entidades.Mercancia;
import com.example.proyectogrupal.repositorio.MercanciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public  class ServicioMercancia implements  ServicioBase <Mercancia> {

    @Autowired
    protected MercanciaRepositorio MercanciaRepositorio;


    @Override
    public List<Mercancia> buscarTodos() throws Exception {
        try {
            List<Mercancia>mercancias=MercanciaRepositorio.findAll();
            return mercancias;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Mercancia buscarPorId(Integer id) throws Exception {
        try{
            Optional<Mercancia> mercanciaOptional=MercanciaRepositorio.findById(id);
            if (mercanciaOptional.isPresent()){
                return mercanciaOptional.get();
            }else {
                throw new Exception("Usuario no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Mercancia registrar(Mercancia datosARegistrar) throws Exception {
        try {
            Mercancia mercanciaGuardada=MercanciaRepositorio.save(datosARegistrar);
            return mercanciaGuardada;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Mercancia actualizar(Integer id, Mercancia datosNuevos) throws Exception {
        try {
            Optional<Mercancia> mercanciaOptional = MercanciaRepositorio.findById(id);
            if ((mercanciaOptional.isPresent())) {
                Mercancia mercanciaActualizada = MercanciaRepositorio.save(datosNuevos);
                return mercanciaActualizada;
            } else {
                throw new Exception("Bodega no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        try {
            Optional<Mercancia> mercanciaOptional = MercanciaRepositorio.findById(id);
            if ((mercanciaOptional.isPresent())) {
                MercanciaRepositorio.deleteById(id);
                return true;
            } else {
                throw new Exception("Bodega no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
