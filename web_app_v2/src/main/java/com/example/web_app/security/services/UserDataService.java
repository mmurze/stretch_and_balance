package com.example.web_app.security.services;

import com.example.web_app.entity.UserEntity;
import com.example.web_app.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDataService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("EMAIL_NOT_FOUND"));

        return UserData.build(user);
    }

//    public void updateResetPasswordToken(String token, String username) throws UsernameNotFoundException {
//        UserEntity user = userRepo.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("EMAIL_NOT_FOUND"));
//        if (user != null) {
//            user.setResetPasswordToken(token);
//            userRepo.save(user);
//        } else {
//            throw new UserEntityNotFoundException("Could not find any user with the email " + email);
//        }
//    }
//
//    public UserEntity getByResetPasswordToken(String token) {
//        return userRepo.findByResetPasswordToken(token);
//    }
//
//    public void updatePassword(UserEntity user, String newPassword) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = passwordEncoder.encode(newPassword);
//        user.setPassword(encodedPassword);
//
//        user.setResetPasswordToken(null);
//        userRepo.save(user);
//    }

}