package com.example.proyectogrupal.repositorio;

import com.example.proyectogrupal.Entidades.Mercancia;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MercanciaRepositorio extends JpaRepository<Mercancia,Integer> {

}
