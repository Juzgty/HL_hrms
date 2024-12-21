package cn.hl.hlhrms.repository;

import cn.hl.hlhrms.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 部门持久层接口
 */

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    /**
     * 根据部门名称查询部门
     *
     * @param deptName 部门名称
     * @return 部门实体
     */
    Department findByDeptName(String deptName);

    List<Department> findByNameContaining(String name);
}

