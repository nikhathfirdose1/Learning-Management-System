package com.sjsu.vansbackend.userAuth.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sjsu.vansbackend.userAuth.models.ApplicationUser;
import com.sjsu.vansbackend.userAuth.models.LoginResponseDTO;
import com.sjsu.vansbackend.userAuth.models.Role;
import com.sjsu.vansbackend.userAuth.repository.RoleRepository;
import com.sjsu.vansbackend.userAuth.repository.UserRepository;

@Service
@Transactional
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public ApplicationUser registerUser(String username, String password){

        String encodedPassword = passwordEncoder.encode(password);

        // Retrieve the user role from the repository
        Optional<Role> userRoleOptional = roleRepository.findByAuthority("STUDENT");

        // Check if the user role is present in the optional
        if (userRoleOptional.isPresent()) {
            // User role found, get the role from optional
            Role userRole = userRoleOptional.get();

            // Create a set of authorities with the user role
            Set<Role> authorities = new HashSet<>();
            authorities.add(userRole);

            // Save the user with the provided username, encoded password, and authorities
            return userRepository.save(new ApplicationUser(0, username, encodedPassword, authorities));
        } else {
            // User role not found, handle the error (e.g., throw an exception or log an error)
            throw new IllegalStateException("User role not found");
        }
    }

    public LoginResponseDTO loginUser(String username, String password){

        try{
            Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
            );

            String token = tokenService.generateJwt(auth);

            return new LoginResponseDTO(userRepository.findByUsername(username).get(), token);

        } catch(AuthenticationException e){
            return new LoginResponseDTO(null, "");
        }
    }

}
