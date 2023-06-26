package com.example.proyectogrupal.Controladores;


import com.example.proyectogrupal.Entidades.Bodega;
import com.example.proyectogrupal.Servicios.ServicioBodega;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/bodega")
@Tag(name="Servicio Bodega", description = "Servicios CRUD en la entidad Bodega")

public class BodegaControlador {

    @Autowired
    protected ServicioBodega servicioBodega;

    @PostMapping
    @Operation(summary = "Registra una bodega en la Base de datos")

    public ResponseEntity<Bodega> registrar(@RequestBody Bodega datosAGuardar){
        try{
            Bodega bodegaRegistrado= servicioBodega.registrar(datosAGuardar);
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
    @Operation(summary = "Buscar todas las bodegas")
    public ResponseEntity<List<Bodega>>buscarTodos(){
        try{

            List<Bodega> bodega= servicioBodega.buscarTodos();
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
    @Operation(summary = "Buscar mercancia por ID")
    public ResponseEntity<Bodega>buscarPorId(@PathVariable Integer id){
        try{
            Bodega BodegaEncontrada= (Bodega) servicioBodega.buscarPorId(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(BodegaEncontrada);
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);

        }
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar bodega")
    public  ResponseEntity<Bodega> eliminar(@PathVariable Integer id){
        try{
            servicioBodega.eliminar(id);
            return ResponseEntity
                    .status(HttpStatus.OK).build();
        }  catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }
    @PutMapping
    @Operation(summary = "Actualizar bodega")
    public ResponseEntity<Bodega> actualizar(@PathVariable Integer id,@RequestBody Bodega datosNuevos ){
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicioBodega.actualizar(id, datosNuevos));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

}





