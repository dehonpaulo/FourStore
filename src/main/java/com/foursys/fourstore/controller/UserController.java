package com.foursys.fourstore.controller;

import com.foursys.fourstore.dto.UserRequestDTO;
import com.foursys.fourstore.dto.UserResponseDTO;
import com.foursys.fourstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.findAll());
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> save(@RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.save(userRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.update(id, userRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
