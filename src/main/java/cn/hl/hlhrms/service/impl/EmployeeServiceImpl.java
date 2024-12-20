package cn.hl.hlhrms.service.impl;

import cn.hl.hlhrms.entity.Employee;
import cn.hl.hlhrms.repository.EmployeeRepository;
import cn.hl.hlhrms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 员工服务层实现类
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        // 可以添加额外的逻辑，比如重复检查等
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        // 可以添加额外的逻辑，比如检查员工是否存在等
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> searchEmployeeByName(String name) {
        return employeeRepository.findByNameContaining(name);
    }

    @Override
    public List<Employee> findEmployeeByDepartment(Integer departmentId) {
        return employeeRepository.findByDepartment_DeptId(departmentId);
    }

    @Override
    public List<Employee> findEmployeeByPosition(Integer positionId) {
        return employeeRepository.findByPosition_PosId(positionId);
    }
}
