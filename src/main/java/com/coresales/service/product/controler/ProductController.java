package com.coresales.service.product.controler;

import com.coresales.service.product.model.Product;
import com.coresales.service.product.service.ProductService;
import org.springframework.http.HttpStatus;  //
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin("http://localhost:5173")
public class ProductController {
    private final ProductService productService;

    //==========================================
    // CONSTRUCTOR
    //==========================================
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //==========================================
    // GET /api/productos/Listar
    //==========================================
    @GetMapping("/listar")
    public /*ResponseEntity<*/List<Product>/*>*/ listar() {
        return /*ResponseEntity.ok(*/productService.listar()/*)*/;
    }

    //==========================================
    // GET /api/productos/buscar/{id}
    //==========================================
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Product> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(productService.obtenerPorId(id));
    }

    //==========================================
    // POST /api/productos/crear
    //==========================================
    @PostMapping
    public ResponseEntity<Product> crear(@RequestBody Product request) {
        Product response = productService.crear(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    //==========================================
    // PUT /api/productos/actualizar/{id}
    //==========================================
    @PutMapping("/{id}")
    public ResponseEntity<Product> actualizar(@PathVariable Long id,@RequestBody Product request) {
        Product response = productService.actualizar(id, request);
        return ResponseEntity.ok(response);
    }

    //==========================================
    // DELETE /api/productos/eliminar/{id}
    //==========================================
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        productService.eliminar(id);
        return ResponseEntity.noContent().build();
    }


}
