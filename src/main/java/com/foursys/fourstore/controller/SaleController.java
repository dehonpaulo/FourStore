package com.foursys.fourstore.controller;

import com.foursys.fourstore.dto.SaleRequestDTO;
import com.foursys.fourstore.dto.SaleResponseDTO;
import com.foursys.fourstore.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    private SaleService saleService;

    @GetMapping
    public ResponseEntity<List<SaleResponseDTO>> findAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(saleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleResponseDTO> findById(@PathVariable Long id) {
        return  ResponseEntity
                .status(HttpStatus.OK)
                .body(saleService.findById(id));
    }

    @GetMapping("/byUser")
    public ResponseEntity<List<SaleResponseDTO>> findByUser(@RequestParam Long userId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(saleService.findByUser(userId));
    }

    @PostMapping
    public ResponseEntity<SaleResponseDTO> save(@RequestBody SaleRequestDTO saleRequestDTO) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(saleService.save(saleRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        saleService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}