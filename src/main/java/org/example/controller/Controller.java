package org.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class Controller {

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Hello!");
    }
}
