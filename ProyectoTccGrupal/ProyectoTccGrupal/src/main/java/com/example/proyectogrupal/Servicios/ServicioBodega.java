package com.example.proyectogrupal.Servicios;

import com.example.proyectogrupal.Controladores.BodegaControlador;
import com.example.proyectogrupal.Entidades.Bodega;
import com.example.proyectogrupal.Entidades.Mercancia;
import com.example.proyectogrupal.repositorio.BodegaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioBodega implements ServicioBase<Bodega> {

    @Autowired
    protected BodegaRepositorio bodegaRepositorio;



    @Override
    @Transactional
    public  List<Bodega> buscarTodos() throws Exception {
        try{
            List<Bodega>bodegas =bodegaRepositorio.findAll();
            return bodegas;
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }

    }


    @Override
    public  Bodega buscarPorId(Integer id) throws Exception {
        try{
            Optional<Bodega>bodegaOpcional =bodegaRepositorio.findById(id);
            if(bodegaOpcional.isPresent()){
                return bodegaOpcional.get();
            }else{
                throw new Exception("Bodega no encontrada");
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Bodega registrar(Bodega datosARegistrar) throws Exception {
        try{
            Bodega bodegaGuardada=bodegaRepositorio.save(datosARegistrar);
            return bodegaGuardada;
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }


    @Override
    public Bodega actualizar(Integer id, Bodega datosNuevos) throws Exception {
        return null;
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        try {

            Optional<Bodega> bodegaOptional = bodegaRepositorio.findById(id);
            if (bodegaOptional.isPresent()) {
                bodegaRepositorio.deleteById(id);
                return true;
            } else {
                throw new Exception("Bodega no encontrada");
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
