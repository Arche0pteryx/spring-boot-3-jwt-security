package com.alibou.security.controller;

import com.alibou.security.service.AuthenticationRequest;
import com.alibou.security.service.AuthenticationResponse;
import com.alibou.security.service.AuthenticationService;
import com.alibou.security.service.RegisterRequest;
import com.alibou.security.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import com.alibou.security.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
  @Autowired
  private UserRepository userRepository      ;
  private final AuthenticationService service;

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(
      @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.register(request));
  }
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate (
      @RequestBody AuthenticationRequest request
  ) throws Exception{
    try {
      return ResponseEntity.ok(service.authenticate(request));
    } catch (Exception e) {
     // return ResponseEntity.badRequest().build();
      throw new Exception("Incorrect username or password", e);
    }

  }
  @GetMapping("/user-profile")
  public User getUserById(@AuthenticationPrincipal User user) {
    return userRepository.findById(user.getId()).orElse(  null);
  }

}
