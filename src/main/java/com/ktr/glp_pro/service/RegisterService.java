package com.ktr.glp_pro.service;

import com.ktr.glp_pro.dto.UserDTO;
import com.ktr.glp_pro.entity.User;
import com.ktr.glp_pro.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RegisterService {

    private static final Logger logger = LoggerFactory.getLogger(RegisterService.class);

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(UserDTO userDto) {
        if (userDto.getPassword() == null || userDto.getPassword().length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long");
        }

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
            logger.warn("User registration failed: UserId already exists - {}", user.getUserId());
            throw new RuntimeException("UserId already exists");
        }

        userRepo.save(user);
        logger.info("User registered successfully: {}", user.getUserId());
    }
}
