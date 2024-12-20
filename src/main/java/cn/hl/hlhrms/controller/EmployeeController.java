package cn.hl.hlhrms.controller;

import cn.hl.hlhrms.entity.Employee;
import cn.hl.hlhrms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 员工控制器类
 */

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * 获取所有员工信息
     *
     * @param model 存储员工列表
     * @return 员工列表页面
     */
    @GetMapping("/list")
    public String listAllEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        System.out.println("员工列表：" + employees);
        return "employee"; // 返回员工列表页面
    }

    /**
     * 添加员工页面
     *
     * @return 添加员工页面视图
     */
    @GetMapping("/add")
    public String addEmployeePage() {
        return "employee/add"; // Thymeleaf 视图模板
    }

    /**
     * 添加员工处理
     *
     * @param employee 员工信息
     * @param model    存储反馈信息
     * @return 添加员工结果页面
     */
    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee, Model model) {
        Employee savedEmployee = employeeService.addEmployee(employee);
        model.addAttribute("employee", savedEmployee);
        return "employee/detail"; // 员工添加成功后，跳转到员工详情页面
    }

    /**
     * 修改员工页面
     *
     * @param employeeId 员工ID
     * @param model      存储员工信息
     * @return 修改员工页面视图
     */
    @GetMapping("/edit/{id}")
    public String editEmployeePage(@PathVariable("id") Integer employeeId, Model model) {
        Employee employee = employeeService.findEmployeeById(employeeId);
        model.addAttribute("employee", employee);
        return "employee/edit"; // Thymeleaf 视图模板
    }

    /**
     * 修改员工处理
     *
     * @param employee 员工信息
     * @param model    存储反馈信息
     * @return 修改结果页面
     */
    @PostMapping("/edit")
    public String editEmployee(@ModelAttribute Employee employee, Model model) {
        Employee updatedEmployee = employeeService.updateEmployee(employee);
        model.addAttribute("employee", updatedEmployee);
        return "employee/detail"; // 更新后的员工详情页面
    }

    /**
     * 查询员工列表（通过姓名模糊查询）
     *
     * @param name  员工姓名
     * @param model 存储查询结果
     * @return 员工列表页面
     */
    @GetMapping("/search")
    public String searchEmployeeByName(@RequestParam("name") String name, Model model) {
        List<Employee> employees = employeeService.searchEmployeeByName(name);
        model.addAttribute("employees", employees);
        return "employee/list"; // 显示员工列表页面
    }

    /**
     * 查询部门员工
     *
     * @param departmentId 部门ID
     * @param model        存储查询结果
     * @return 员工列表页面
     */
    @GetMapping("/department/{departmentId}")
    public String findEmployeeByDepartment(@PathVariable("departmentId") Integer departmentId, Model model) {
        List<Employee> employees = employeeService.findEmployeeByDepartment(departmentId);
        model.addAttribute("employees", employees);
        return "employee/list"; // 显示员工列表页面
    }

    /**
     * 查询职位员工
     *
     * @param positionId 职位ID
     * @param model      存储查询结果
     * @return 员工列表页面
     */
    @GetMapping("/position/{positionId}")
    public String findEmployeeByPosition(@PathVariable("positionId") Integer positionId, Model model) {
        List<Employee> employees = employeeService.findEmployeeByPosition(positionId);
        model.addAttribute("employees", employees);
        return "employee/list"; // 显示员工列表页面
    }
}
