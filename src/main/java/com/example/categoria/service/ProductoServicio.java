package com.example.categoria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.categoria.entity.Producto;
import com.example.categoria.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoServicio {

    private final ProductoRepository productoRepo;

    // Crear un producto
    public Producto createProducto(Producto producto) {
        return productoRepo.save(producto);
    }

    // Obtener todos los productos
    public List<Producto> getAllProductos() {
        return productoRepo.findAll();
    }

    // Obtener un producto por su ID
    public Producto getProductoById(Long id) {
        return productoRepo.findById(id).orElse(null);  // Devuelve null si no se encuentra el producto
    }

    // Actualizar un producto
    public Producto updateProducto(Long id, Producto producto) {
        if (productoRepo.existsById(id)) {
            producto.setId(id);  // Asegura que se actualice el producto correcto
            return productoRepo.save(producto);  // Guarda el producto actualizado
        }
        return null;  // Si no existe, retorna null
    }

    // Eliminar un producto por su ID
    public boolean deleteProducto(Long id) {
        if (productoRepo.existsById(id)) {
            productoRepo.deleteById(id);
            return true;
        }
        return false;  // Si no existe el producto, retorna false
    }
}