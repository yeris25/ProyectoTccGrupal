package com.example.proyectogrupal.Servicios;

import com.example.proyectogrupal.Entidades.Bodega;
import com.example.proyectogrupal.Entidades.Mercancia;
import com.example.proyectogrupal.repositorio.BodegaRepositorio;
import com.example.proyectogrupal.repositorio.MercanciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


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
        try{
            Optional<Acudiente> acudienteOpcional =acudienteRepositorio.findById(id);
            if(acudienteOpcional.isPresent()){
                return acudienteOpcional.get();
            }else{
                throw new Exception("Usuario no encontrado");
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public static Bodega registrar(Bodega datosARegistrar) throws Exception {
        try{
            Acudiente acudianteGuardado=acudienteRepositorio.save(datosARegistrar);
            return acudianteGuardado;
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
    }

    @Override
    public Bodega actualizar(Integer id, Bodega datosNuevos) throws Exception {
        try{
            Optional<Acudiente>acudienteOpcional =acudienteRepositorio.findById(id);
            if(acudienteOpcional.isPresent()){
                Acudiente acudienteExistente=acudienteOpcional.get();
                acudienteExistente.setNombre(datosNuevos.getNombre());
                acudienteExistente.setTelefono(datosNuevos.getTelefono());
                Acudiente acudianteActualizado=acudienteRepositorio.save(acudienteExistente);
                return acudianteActualizado;
            }else{
                throw new Exception("Usuario no encontrado");
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        try{

            Optional<Acudiente>acudienteOpcional =acudienteRepositorio.findById(id);
            if(acudienteOpcional.isPresent()){
                acudienteRepositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("Usuario no encontrado");
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }


}
