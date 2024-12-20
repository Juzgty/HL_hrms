package cn.hl.hlhrms.service;

import cn.hl.hlhrms.entity.Employee;

import java.util.List;

/**
 * 员工服务层接口
 */

public interface EmployeeService {
    /**
     * 添加员工
     *
     * @param employee 员工信息
     * @return 新增的员工实体
     */
    Employee addEmployee(Employee employee);

    /**
     * 修改员工信息
     *
     * @param employee 员工信息
     * @return 更新后的员工实体
     */
    Employee updateEmployee(Employee employee);

    /**
     * 查询员工信息（通过姓名模糊查询）
     *
     * @param name 员工姓名
     * @return 员工列表
     */
    List<Employee> searchEmployeeByName(String name);

    /**
     * 根据部门查询员工
     *
     * @param departmentId 部门ID
     * @return 员工列表
     */
    List<Employee> findEmployeeByDepartment(Integer departmentId);

    /**
     * 根据职位查询员工
     *
     * @param positionId 职位ID
     * @return 员工列表
     */
    List<Employee> findEmployeeByPosition(Integer positionId);
}
