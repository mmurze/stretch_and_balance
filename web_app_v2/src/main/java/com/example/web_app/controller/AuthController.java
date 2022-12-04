package com.example.web_app.controller;

import com.example.web_app.entity.*;
import com.example.web_app.payload.request.LoginReq;
import com.example.web_app.payload.request.SignupReq;
import com.example.web_app.payload.request.UpdateReq;
import com.example.web_app.payload.response.JwtRes;
import com.example.web_app.payload.response.MessageRes;
import com.example.web_app.repository.RoleRepo;
import com.example.web_app.repository.UserRepo;
import com.example.web_app.security.jwt.JwtUtils;
import com.example.web_app.security.services.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.impl.DefaultJwtBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleRepo roleRepo;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginReq loginReq) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginReq.getUsername(), loginReq.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserData userDetails = (UserData) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtRes(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getFirstName(),
                userDetails.getLastName(),
                roles));
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UpdateReq updateReq) {
        if (updateReq.getUsername().isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageRes("EMAIL_NOT_EXIST"));
        }
        UserEntity user = userRepo.findByUsername(updateReq.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("EMAIL_NOT_FOUND"));
        if (user != null) {
            user.setFirstname(updateReq.getFirstname());
            user.setLastname(updateReq.getLastname());
            user.setUsername(updateReq.getUsername());
            userRepo.save(user);
            System.out.println(user.getFirstname() + "" + user.getLastname());
        } else
            return ResponseEntity.badRequest().body("EMAIL_NOT_FOUND");

        return ResponseEntity.ok(new JwtRes(updateReq.getToken(),
                updateReq.getId(),
                user.getUsername(),
                user.getFirstname(),
                user.getLastname(),
                updateReq.getRole()));
    }


    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupReq signUpReq) {

        if (userRepo.existsByUsername(signUpReq.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageRes("EMAIL_EXISTS"));
        }
        // Create new user's account
        UserEntity user = new UserEntity(signUpReq.getFirstname(),
                signUpReq.getLastname(), signUpReq.getUsername(),
                encoder.encode(signUpReq.getPassword()));

        Set<String> strRoles = signUpReq.getRole();
        Set<RoleEntity> roles = new HashSet<>();

        if (strRoles == null) {
            RoleEntity userRole = roleRepo.findByName(RoleEnum.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: RoleEntity is not found."));
            roles.add(userRole);
            System.out.println(userRole.getRole());
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        RoleEntity adminRole = roleRepo.findByName(RoleEnum.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: RoleEntity is not found."));
                        roles.add(adminRole);

                        break;
                    default:
                        RoleEntity userRole = roleRepo.findByName(RoleEnum.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: RoleEntity is not found."));
                        System.out.println(userRole.getRole());
                        roles.add(userRole);
                        System.out.println("4");
                }
            });
        }

        user.setRoles(roles);
        user = userRepo.save(user);

        return ResponseEntity.ok().body("GREAT_USER");
        //return ResponseEntity.ok(new MessageRes("UserEntity registered successfully!"));
    }
}
