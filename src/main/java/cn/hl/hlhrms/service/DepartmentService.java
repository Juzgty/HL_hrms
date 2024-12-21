package cn.hl.hlhrms.service;

import cn.hl.hlhrms.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department updateDepartment(Department department);

    Department findDepartmentById(Integer departmentId);

    Department addDepartment(Department department);

    List<Department> getAllDepartments();
}
