package com.example.proyectogrupal.Controladores;

import com.example.proyectogrupal.Entidades.Bodega;
import com.example.proyectogrupal.Servicios.ServicioBodega;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("api/v1/mercancia")
public class MercanciaControlador {

    @Autowired
    protected ServicioBodega servicioBodega;

    @PostMapping
    public ResponseEntity<Bodega> registrar(@RequestBody Bodega datosAGuardar){
        try{
            Bodega clienteRegistrado=ServicioBodega.registrar(datosAGuardar);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(clienteRegistrado);
        }catch(Exception error){
            String mensaje="Tenemos un error al registrar "+error.getMessage();
            Bodega acudienteConError= new Bodega();
            acudienteConError.Setmensajeerror(mensaje);
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(BodegaConError);

        }
    }


}
