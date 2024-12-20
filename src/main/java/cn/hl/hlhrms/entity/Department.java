package cn.hl.hlhrms.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 部门实体类
 */

@Entity
@Data
@ToString(exclude = "employees")
@Table(name = "hl_department")
public class Department {
    // 部门id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id", nullable = false)
    private Integer deptId;

    // 部门名称
    @Column(name = "dept_name", nullable = false, unique = true, length = 100)
    private String deptName;

    // 员工集合
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees;
}
