package com.ktr.glp_pro.controller;

import com.ktr.glp_pro.dto.UserFindRequestDto;
import com.ktr.glp_pro.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthService authService;

    @GetMapping
    public String showLoginForm() {
        return "contents/login";
    }

    @PostMapping
    public String login(@RequestParam("userId") String userId, @RequestParam("password") String password, Model model) {
        boolean isAuthenticated = authService.authenticateUser(userId, password);

        // 로그인 성공 시 홈 화면으로 리다이렉트
        if (isAuthenticated) {
            return "redirect:/home";
        }
        // 로그인 실패 시 에러 메시지 추가 후 다시 로그인 화면으로 포워드
        else {
            model.addAttribute("error", "Invalid userId or password");
            return "login";
        }
    }
}
