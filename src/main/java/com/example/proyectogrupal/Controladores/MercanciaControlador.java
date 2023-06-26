package com.example.proyectogrupal.Controladores;


import com.example.proyectogrupal.Entidades.Bodega;
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
@RequestMapping("api/v1/mercancia")
@Tag(name="Servicio Mercancia", description = "Servicios CRUD en la entidad Mercancia")
public class MercanciaControlador {
    @Autowired
    protected ServicioMercancia servicioMercancia;


    @PostMapping
    @Operation(summary = "Registra una mercancia en la Base de datos")
    @ApiResponses(value = {
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
    @Operation(summary = "Buscar todas las mercancias")
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

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una mercancia de la Base de datos")
    public  ResponseEntity<Mercancia> eliminar(@PathVariable Integer id){
        try{
             servicioMercancia.eliminar(id);
            return ResponseEntity
                    .status(HttpStatus.OK).build();
        }  catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar mercancia por ID ")
    public ResponseEntity<Mercancia>buscarPorId(@PathVariable Integer id){
        try{
            Mercancia mercanciaEncontrada= (Mercancia) servicioMercancia.buscarPorId(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(mercanciaEncontrada);
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);

        }

    }
    @PutMapping
    @Operation(summary = "Actualizar Mercancia")
    public ResponseEntity<Mercancia> actualizar(@PathVariable Integer id,@RequestBody Mercancia datosNuevos ){
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicioMercancia.actualizar(id, datosNuevos));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

}
