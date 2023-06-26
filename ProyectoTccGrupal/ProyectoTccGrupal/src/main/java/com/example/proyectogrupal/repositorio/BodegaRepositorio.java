package com.example.proyectogrupal.repositorio;

import com.example.proyectogrupal.Entidades.Bodega;
import com.example.proyectogrupal.Entidades.Mercancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodegaRepositorio extends JpaRepository<Bodega, Integer> {
    

}
