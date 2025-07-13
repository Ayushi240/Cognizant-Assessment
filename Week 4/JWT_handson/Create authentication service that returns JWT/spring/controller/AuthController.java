package com.cognizant.spring.controller;
import com.cognizant.spring.util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.*;

import java.util.Base64;

@RestController
public class AuthController {

    @PostMapping("/authenticate")
    public ResponseEntity<Map<String, String>> authenticate(@RequestHeader("Authorization") String authHeader) {
        try {
            String[] credentials = extractAndDecodeHeader(authHeader);
            String username = credentials[0];
            String password = credentials[1];

            // Dummy user validation
            if ("user".equals(username) && "pwd".equals(password)) {
                String token = JwtUtil.generateToken(username);
                Map<String, String> tokenMap = new HashMap<>();
                tokenMap.put("token", token);
                return ResponseEntity.ok(tokenMap);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", e.getMessage()));
        }
    }

    private String[] extractAndDecodeHeader(String header) {
        if (!header.toLowerCase().startsWith("basic ")) {
            throw new RuntimeException("Missing Basic Authorization header");
        }

        byte[] base64Token = header.substring(6).getBytes(StandardCharsets.UTF_8);
        byte[] decoded = Base64.getDecoder().decode(base64Token);
        String token = new String(decoded, StandardCharsets.UTF_8);

        String[] parts = token.split(":", 2);
        if (parts.length != 2) {
            throw new RuntimeException("Invalid basic authentication token");
        }
        return parts;
    }
}
