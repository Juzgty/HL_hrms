package cn.hl.hlhrms.controller;

import cn.hl.hlhrms.entity.Department;
import cn.hl.hlhrms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门控制器类
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    /**
     * 获取所有部门信息
     *
     * @param model 存储部门列表
     * @return 部门列表页面
     */
    @GetMapping("/list")
    public String listAllDepartments(Model model) {
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("departments", departments);
        System.out.println("部门列表：" + departments);
        return "department"; // 返回部门列表页面
    }

    /**
     * 添加部门页面
     *
     * @return 添加部门页面视图
     */
    @GetMapping("/add")
    public String addDepartmentPage() {
        return "adddepartment"; // Thymeleaf 视图模板
    }

    /**
     * 添加部门处理
     *
     * @param department 部门信息
     * @param model      存储反馈信息
     * @return 部门添加成功页面
     */
    @PostMapping("/add")
    public String addDepartment(@ModelAttribute Department department, Model model) {
        Department savedDepartment = departmentService.addDepartment(department);
        model.addAttribute("department", savedDepartment);
        return "redirect:/department/list"; // 添加完成后返回部门列表页面
    }

    /**
     * 修改部门页面
     *
     * @param departmentId 部门ID
     * @param model        存储部门信息
     * @return 修改部门页面视图
     */
    @GetMapping("/edit/{id}")
    public String editDepartmentPage(@PathVariable("id") Integer departmentId, Model model) {
        Department department = departmentService.findDepartmentById(departmentId);
        model.addAttribute("department", department);
        return "editdepartment"; // Thymeleaf 视图模板
    }

    /**
     * 修改部门处理
     *
     * @param department 部门信息
     * @param model      存储反馈信息
     * @return 修改后的部门列表页面
     */
    @PostMapping("/edit")
    public String editDepartment(@ModelAttribute Department department, Model model) {
        Department updatedDepartment = departmentService.updateDepartment(department);
        model.addAttribute("department", updatedDepartment);
        return "redirect:/department/list"; // 更新后返回部门列表页面
    }
}
