package com.example.proyectogrupal.Controladores;


import com.example.proyectogrupal.Entidades.Bodega;
import com.example.proyectogrupal.Servicios.ServicioBase;
import com.example.proyectogrupal.Servicios.ServicioBodega;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/bodega")
public class BodegaControlador {

    @Autowired
    protected ServicioBodega bodegaServicio;

    @PostMapping
    public ResponseEntity<Bodega> registrar(@RequestBody Bodega datosAGuardar){
        try{
            Bodega bodegaRegistrado=bodegaServicio.registrar(datosAGuardar);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(bodegaRegistrado);
        }catch(Exception error){
            String mensaje="Tenemos un error al registrar "+error.getMessage();
            Bodega bodegaConError= new Bodega();
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(bodegaConError);

        }
    }

    @GetMapping
    public ResponseEntity<List<Bodega>>buscarTodos(){
        try{

            List<Bodega> bodega=ServicioBodega.buscarTodos();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(bodega);
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bodega>buscarPorId(@PathVariable Integer id){
        try{
            Bodega BodegaEncontrada= (Bodega) ServicioBodega.buscarPorId(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(BodegaEncontrada);
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);

        }
    }

}





