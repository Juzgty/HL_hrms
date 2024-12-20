package cn.hl.hlhrms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * 部门实体类
 */

@Entity
@Data
@Table(name = "hl_department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id", nullable = false)
    private Integer deptId;

    @Column(name = "dept_name", nullable = false, unique = true, length = 100)
    private String deptName;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees;
}
