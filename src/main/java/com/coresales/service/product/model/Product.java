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
    String codigo;

    @Column(name = "Nombre", length = 150, nullable = false)
    String nombre;

    @Column(name = "Descripcion", length = 500) // , nullable = false)
    String descripcion;

    @Column(name = "CategoriaProductoId", nullable = false)
    Integer categoriaProductoId;

    @Column(name = "MarcaId") //, nullable = false)
    Integer marcaId;

    @Column(name = "PrecioCompra", precision = 12/*, scale = 2*/)
    BigDecimal precioCompra;

    @Column(name = "PrecioVenta", precision = 12/*, scale = 2*/)
    BigDecimal precioVenta;

    @Column(name = "StockMinimo", nullable = false)
    Integer stockMinimo;

    @Column(name = "Activo", nullable = false)
    Boolean activo;

    @Column(name = "FechaRegistro", nullable = false)
    LocalDateTime fechaRegistro;
}
