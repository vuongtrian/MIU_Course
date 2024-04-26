package cs489.miu.edu.hotel_reservation_service.service.impl;

import cs489.miu.edu.hotel_reservation_service.configuration.JwtService;
import cs489.miu.edu.hotel_reservation_service.entity.Officer;
import cs489.miu.edu.hotel_reservation_service.entity.dto.userauth.AuthenticationRequest;
import cs489.miu.edu.hotel_reservation_service.entity.dto.userauth.AuthenticationResponse;
import cs489.miu.edu.hotel_reservation_service.entity.dto.userauth.RegisterRequest;
import cs489.miu.edu.hotel_reservation_service.repository.IOfficerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final IOfficerRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var officer = Officer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        repository.save(officer);
        var jwtToken = jwtService.generateToken(officer);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var officer = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var jwtToken = jwtService.generateToken(officer);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
