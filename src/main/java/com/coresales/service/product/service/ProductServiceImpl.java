package com.coresales.service.product.service;

import com.coresales.service.product.model.Product;
import com.coresales.service.product.repository.ProductRepository;
//import jakarta.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    //==========================================
    // CONSTRUCTOR
    //==========================================
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //==========================================
    // MÉTODOS
    //==========================================
    @Override
    @Transactional(readOnly = true)
    public List<Product> listar(){
        return new ArrayList<>(productRepository.findAll());  // antes ListarClientes -> cuando se creen los metodos cambiar el nombre
    }

    @Override
    @Transactional(readOnly = true)
    public Product obtenerPorId(Long id){
        return productRepository.findById(id).orElseThrow(null);
    } // revisar

    @Override
    public Product crear(Product producto){
        if (producto.getFechaRegistro() == null) {
            producto.setFechaRegistro(LocalDateTime.now());
        }

        // Para resolver problema del "Activo"
        if (producto.getActivo() == null) {
            producto.setActivo(true);
        }
        return productRepository.save(producto);
        //Product guardado = (Product) productRepository.save(producto);
        //return guardado;
    } // revisar

    @Override
    public Product actualizar(Long id, Product producto) {
        Product productoBusqueda = obtenerPorId(id);

        if (productoBusqueda == null) return null;

        //producto.setProductoId(id); // para que toma el dato de la URL
        // Coloco todos los campos para que se actualice
        productoBusqueda.setCodigo(producto.getCodigo());
        productoBusqueda.setDescripcion(producto.getDescripcion());
        productoBusqueda.setCategoriaProductoId(producto.getCategoriaProductoId());
        productoBusqueda.setMarcaId(producto.getMarcaId());
        productoBusqueda.setPrecioCompra(producto.getPrecioCompra());
        productoBusqueda.setPrecioVenta(producto.getPrecioVenta());
        productoBusqueda.setStockMinimo(producto.getStockMinimo());
        producto.setFechaRegistro(productoBusqueda.getFechaRegistro());

        if (producto.getActivo() != null) {
            productoBusqueda.setActivo(producto.getActivo());
        }

        Product actualizado =  productRepository.save(productoBusqueda); // producto
        // (Product)
        return actualizado;

    }

    @Override
    public void eliminar(Long id) {
        productRepository.deleteById(id);
    }
}
