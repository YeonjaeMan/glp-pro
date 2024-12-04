package com.ktr.glp_pro.service;

import com.ktr.glp_pro.dto.UserDTO;
import com.ktr.glp_pro.entity.User;
import com.ktr.glp_pro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RegistService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registUser(UserDTO userDto) {
        String hashedPassword = passwordEncoder.encode(userDto.getPassword());

        User user = User.builder()
                .userId(userDto.getUserId())
                .password(hashedPassword)
                .userName(userDto.getUserName())
                .userEnName(userDto.getUserEnName())
                .birthDate(userDto.getBirthDate())
                .phoneNumber(userDto.getPhoneNumber())
                .level(userDto.getLevel())
                .enteredDate(userDto.getEnteredDate())
                .emailAddress(userDto.getEmailAddress())
                .registedDate(LocalDate.now())
                .changePasswordDate(LocalDate.now())
                .lastLogin(LocalDate.now())
                .denied("N")
                .build();

        if (userRepo.findByUserId(user.getUserId()).isPresent()) {
            throw new RuntimeException("UserId already exists");
        }

        userRepo.save(user);
    }
}
