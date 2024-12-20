package cn.hl.hlhrms.repository;

import cn.hl.hlhrms.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 员工持久层接口
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    /**
     * 根据姓名模糊查询员工
     *
     * @param name 员工姓名（模糊匹配）
     * @return 员工列表
     */
    List<Employee> findByNameContaining(String name);

    /**
     * 根据部门 ID 查询员工
     *
     * @param departmentId 部门 ID
     * @return 员工列表
     */
    List<Employee> findByDepartment_DeptId(Integer departmentId);

    /**
     * 根据职位 ID 查询员工
     *
     * @param positionId 职位 ID
     * @return 员工列表
     */
    List<Employee> findByPosition_PosId(Integer positionId);
}
