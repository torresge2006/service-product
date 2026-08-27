package com.coresales.service.product.model;

import jakarta.persistence.*;
import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

//import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "Producto")  // nombre de tabla es Producto
@Data
@NoArgsConstructor  // Nuevo
@AllArgsConstructor // Nuevo
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductoId")
    Long ProductoId;

    @Column(name = "Codigo", length = 30, nullable = false)
    String Codigo;

    @Column(name = "Nombre", length = 150, nullable = false)
    String Nombre;

    @Column(name = "Descripcion", length = 500) // , nullable = false)
    String Descripcion;

    @Column(name = "CategoriaProductoId", nullable = false)
    Integer CategoriaProductoId;

    @Column(name = "MarcaId") //, nullable = false)
    Integer MarcaId;

    @Column(name = "PrecioCompra", precision = 12/*, scale = 2*/)
    BigDecimal PrecioCompra;

    @Column(name = "PrecioVenta", precision = 12/*, scale = 2*/)
    BigDecimal PrecioVenta;

    @Column(name = "StockMinimo", nullable = false)
    Integer StockMinimo;

    @Column(name = "Activo", nullable = false)
    Boolean Activo;

    @Column(name = "FechaRegistro", nullable = false)
    LocalDateTime FechaRegistro;
}
