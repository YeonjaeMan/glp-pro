package com.ktr.glp_pro.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "tb_user")
public class User {

    @Id
    @Column(name = "user_id", length = 8)
    private String userId;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "user_name", nullable = false, length = 30)
    private String userName;

    @Column(name = "user_en_name", nullable = false, length = 50)
    private String userEnName;

    @Column(name = "user_nick", nullable = true, length = 30)
    private String userNick;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;

    @Column(name = "level", nullable = false, length = 10)
    private String level;

    @Column(name = "entered_date", nullable = false)
    private LocalDate enteredDate;

    @Column(name = "email_address", nullable = false)
    private String emailAddress;

    @Column(name = "registed_date", nullable = false)
    private LocalDate registedDate;

    @Column(name = "change_password_date", nullable = false)
    private LocalDate changePasswordDate;

    @Column(name = "last_login", nullable = false)
    private LocalDate lastLogin;

    @Column(name = "denied", nullable = false, length = 1)
    private String denied;
}
