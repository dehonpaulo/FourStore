package com.foursys.fourstore.controller;

import com.foursys.fourstore.dto.BrandDTO;
import com.foursys.fourstore.model.Brand;
import com.foursys.fourstore.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping
    public ResponseEntity<List<BrandDTO>> findAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(brandService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandDTO> findById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(brandService.findById(id));
    }

    @PostMapping
    public ResponseEntity<BrandDTO> save(@RequestBody BrandDTO brandDTO) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(brandService.save(brandDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        brandService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}