package com.example.categoria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.categoria.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    
}
