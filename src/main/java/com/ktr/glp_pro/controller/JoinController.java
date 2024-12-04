package com.ktr.glp_pro.controller;

import com.ktr.glp_pro.dto.UserDTO;
import com.ktr.glp_pro.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/join")
public class JoinController {

    @Autowired
    private RegisterService registerService;

    @GetMapping
    public String showJoinForm() {
        return "contents/join";
    }

    @PostMapping
    public String registUser(@ModelAttribute UserDTO userDto, Model model) {
        try {
            registerService.registerUser(userDto);
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("error", "User registration failed: " + e.getMessage());
            return "contents/join";
        }
    }
}
