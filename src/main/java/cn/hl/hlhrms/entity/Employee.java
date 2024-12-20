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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id", nullable = false)
    private Integer empId;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false, length = 2)
    private Gender gender;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "id_card", unique = true, length = 18)
    private String idCard;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "hire_date", nullable = false)
    private Date hireDate;

    @ManyToOne
    @JoinColumn(name = "dept_id", nullable = false)
    private Department department;

    @ManyToOne
    @JoinColumn(name = "pos_id", nullable = false)
    private Position position;
}