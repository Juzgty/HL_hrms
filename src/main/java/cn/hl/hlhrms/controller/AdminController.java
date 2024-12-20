package cn.hl.hlhrms.controller;

import cn.hl.hlhrms.entity.Admin;
import cn.hl.hlhrms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 管理员控制器类
 */

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    /**
     * 管理员登录页面
     *
     * @return 登录页面视图
     */
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Thymeleaf 视图模板
    }

    /**
     * 管理员登录处理
     *
     * @param username 用户名
     * @param password 密码
     * @param model    存储错误信息
     * @return 登录成功或失败页面
     */
    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        Admin admin = adminService.login(username, password);
        if (admin != null) {
            model.addAttribute("admin", admin);
            return "home"; // 登录成功后跳转到员工列表页面
        } else {
            model.addAttribute("error", "用户名或密码错误");
            return "login"; // 登录失败后返回登录页面
        }
    }

    /**
     * 管理员注册页面
     *
     * @return 注册页面视图
     */
    @GetMapping("/register")
    public String registerPage() {
        return "register"; // Thymeleaf 视图模板
    }

    /**
     * 管理员注册处理
     *
     * @param admin 管理员信息
     * @param model 存储注册信息
     * @return 注册成功或失败页面
     */
    @PostMapping("/register")
    public String register(@ModelAttribute Admin admin, Model model) {
        adminService.registerAdmin(admin);
        model.addAttribute("message", "注册成功");
        return "login"; // 注册成功后跳转到登录页面
    }

}
