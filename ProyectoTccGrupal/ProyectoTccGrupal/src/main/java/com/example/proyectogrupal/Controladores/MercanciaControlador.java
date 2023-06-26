package com.example.proyectogrupal.Controladores;


import com.example.proyectogrupal.Entidades.Mercancia;
import com.example.proyectogrupal.Servicios.ServicioMercancia;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@Tag(name="Servicio Mercancia", description = "Servicios que ofrece el CRUD en la entidad estudiante")
public class MercanciaControlador {
    @Autowired
    protected ServicioMercancia servicioMercancia;


    @PostMapping
    @Operation(summary = "Registra un cliente en la BD")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "201", description = "Cliente fue creado con exito"),
            @ApiResponse(responseCode = "400", description = "Fallamos en el registro, revise su peticion")
    })
    public ResponseEntity<Mercancia> registrar(@RequestBody Mercancia datosARegistrar) {
        try {
            Mercancia MercanciaRegistrada = servicioMercancia.registrar(datosARegistrar);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(MercanciaRegistrada);

        } catch (Exception error) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }



    @GetMapping
    public ResponseEntity<List<Mercancia>> buscarTodos() {
        try {
            List<Mercancia> mercancias = servicioMercancia.buscarTodos();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(mercancias);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }


}
