package com.malloc.taskmanager.adapters.in.rest;

import com.malloc.taskmanager.adapters.in.rest.dto.AuthRequest;
import com.malloc.taskmanager.adapters.in.rest.dto.AuthResponse;
import com.malloc.taskmanager.adapters.in.rest.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final AuthenticationManager authenticationManager;
  private final JwtUtil jwtUtil;

  public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
    this.authenticationManager = authenticationManager;
    this.jwtUtil = jwtUtil;
  }

  @PostMapping("/login")
  public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.username(), request.password())
    );

    String token = jwtUtil.generateToken(authentication.getName());
    return ResponseEntity.ok(new AuthResponse(token));
  }
}