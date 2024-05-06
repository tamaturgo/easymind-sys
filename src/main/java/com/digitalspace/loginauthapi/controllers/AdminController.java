package com.digitalspace.loginauthapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/test")
    public ResponseEntity<String> getAdmin(){
        return ResponseEntity.ok("sucesso!");
    }
}
