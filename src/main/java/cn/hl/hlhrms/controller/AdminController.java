package cn.hl.hlhrms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping ("/login")
    public String showLoginPage() {
        return "login"; // 返回 login.html 模板
    }
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // 返回 register.html 模板
    }
}
