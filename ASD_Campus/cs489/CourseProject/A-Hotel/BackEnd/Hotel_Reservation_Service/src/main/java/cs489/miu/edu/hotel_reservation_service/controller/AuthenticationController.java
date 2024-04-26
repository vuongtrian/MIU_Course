package cs489.miu.edu.hotel_reservation_service.controller;

import cs489.miu.edu.hotel_reservation_service.entity.dto.userauth.AuthenticationRequest;
import cs489.miu.edu.hotel_reservation_service.entity.dto.userauth.AuthenticationResponse;
import cs489.miu.edu.hotel_reservation_service.entity.dto.userauth.RegisterRequest;
import cs489.miu.edu.hotel_reservation_service.service.impl.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/management/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register (
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register (
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
