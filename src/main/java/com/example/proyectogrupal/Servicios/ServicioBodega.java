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
    public class ServicioBodega implements ServicioBase <Bodega> {

        @Autowired
        private BodegaRepositorio BodegaRepositorio;

        @Override
        @Transactional(readOnly = true)
        public List<Bodega> buscarTodos() throws Exception {
            try{
                List<Bodega>bodegas=BodegaRepositorio.findAll();
                return bodegas;

            }catch(Exception error){
                throw new Exception(error.getMessage());

            }
        }

    @Override
    public Bodega buscarPorId(Integer id) throws Exception {
        return null;
    }

    @Override
    public Bodega registrar(Bodega datosARegistrar) throws Exception {
        return null;
    }

    @Override
    public Bodega actualizar(Integer id, Bodega datosNuevos) throws Exception {
        return null;
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        return false;
    }


}
