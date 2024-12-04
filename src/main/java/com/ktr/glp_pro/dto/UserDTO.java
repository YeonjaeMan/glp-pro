package com.ktr.glp_pro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDTO {

    private String userId;

    private String password;

    private String userName;

    private String userEnName;

    private String userNick;

    private LocalDate birthDate;

    private String phoneNumber;

    private String level;

    private LocalDate enteredDate;

    private String emailAddress;

    private LocalDate registedDate;

    private LocalDate changePasswordDate;

    private LocalDate lastLogin;

    private String denied;
}
