package com.foursys.fourstore.controller;

import com.foursys.fourstore.dto.AddressDTO;
import com.foursys.fourstore.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping()
    public ResponseEntity<List<AddressDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.findById(id));
    }

    @GetMapping("/byUser/userId")
    public ResponseEntity<List<AddressDTO>> findByUser(@PathVariable Long userId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(addressService.findByUser(userId));
    }

    @PostMapping
    public ResponseEntity<AddressDTO> save(@RequestBody AddressDTO addressDTO, @RequestParam Long userId) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(addressService.save(userId, addressDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressDTO> update(@PathVariable Long id, @RequestBody AddressDTO addressDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(addressService.update(id, addressDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        addressService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
