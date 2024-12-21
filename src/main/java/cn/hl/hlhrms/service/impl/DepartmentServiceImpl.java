package cn.hl.hlhrms.service.impl;

import cn.hl.hlhrms.entity.Department;
import cn.hl.hlhrms.repository.DepartmentRepository;
import cn.hl.hlhrms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 部门服务层实现类
 */

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department findDepartmentById(Integer id) {
        Optional<Department> department = departmentRepository.findById(id);
        return department.orElse(null); // 如果找不到部门，返回 null
    }

    @Override
    public Department addDepartment(Department department) {
        // 可以添加额外的逻辑，比如检查名称是否重复
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Department department) {
        // 检查部门是否存在并更新
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
