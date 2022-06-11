package com.foursys.fourstore.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.foursys.fourstore.dto.ProductRequestDTO;
import com.foursys.fourstore.dto.ProductResponseDTO;
import com.foursys.fourstore.service.ProductService;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.findBydId(id));
    }

    @GetMapping("/bySku/{sku}")
    public ResponseEntity<ProductResponseDTO> findBySku(@PathVariable String sku) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.findBySku(sku));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> findAll() {
        return ResponseEntity.
                status(HttpStatus.OK).
                body(productService.findAll());
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> save(@RequestBody ProductRequestDTO productRequestDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productService.save(productRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> update(@PathVariable Long id, @RequestBody ProductRequestDTO productRequestDTO) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.update(id, productRequestDTO));
    }

    @PutMapping("/supplyProductStockById/{id}")
    public ResponseEntity<Integer> supplyProductStockById(@PathVariable Long id, @RequestParam Integer quantity) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.supplyProductStockById(id, quantity));
    }

    @PutMapping("/supplyProductStockBySku/{sku}")
    public ResponseEntity<Integer> supplyProductStockBySku(@PathVariable String sku, @RequestParam Integer quantity) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.supplyProductStockBySku(sku, quantity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        productService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}