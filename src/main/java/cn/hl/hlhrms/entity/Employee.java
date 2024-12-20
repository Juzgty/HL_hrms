package cn.hl.hlhrms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

/**
 * 员工实体类
 */

@Entity
@Data
@Table(name = "hl_employee")
public class Employee {
    // 员工id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id", nullable = false)
    private Integer empId;

    // 员工姓名
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    // 性别
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false, length = 2)
    private Gender gender;

    // 出生日期
    @Column(name = "birth_date")
    private Date birthDate;

    // 身份证号
    @Column(name = "id_card", unique = true, length = 18)
    private String idCard;

    // 手机号码
    @Column(name = "phone", length = 20)
    private String phone;

    // 邮箱
    @Column(name = "email", length = 100)
    private String email;

    // 地址
    @Column(name = "address", length = 255)
    private String address;

    // 入职日期
    @Column(name = "hire_date", nullable = false)
    private Date hireDate;

    // 部门
    @ManyToOne
    @JoinColumn(name = "dept_id", nullable = false)
    private Department department;

    // 职位
    @ManyToOne
    @JoinColumn(name = "pos_id", nullable = false)
    private Position position;
}