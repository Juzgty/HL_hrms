package cn.hl.hlhrms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/home")
    public class HomeController {

    /**
     * 显示首页
     *
     * @return 首页视图
     */
    @GetMapping
    public String showHomePage() {
        return "home"; // 显示首页模板
    }

    /**
     * 跳转到员工管理页面
     *
     * @return 员工管理视图
     */
    @GetMapping("/employee")
    public String showEmployeePage() {
        return "employee"; // 显示员工管理页面模板
    }

    /**
     * 跳转到部门管理页面
     *
     * @return 部门管理视图
     */
    @GetMapping("/department")
    public String showDepartmentPage() {
        return "department"; // 显示部门管理页面模板
    }

    /**
     * 跳转到职位管理页面
     *
     * @return 职位管理视图
     */
    @GetMapping("/position")
    public String showPositionPage() {
        return "position"; // 显示职位管理页面模板
    }
}
