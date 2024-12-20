package cn.hl.hlhrms.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 职位实体类
 */

@Entity
@Data
@ToString(exclude = "employees")
@Table(name = "hl_position")
public class Position {
    // 职位id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pos_id", nullable = false)
    private Integer posId;

    // 职位名称
    @Column(name = "pos_name", nullable = false, unique = true, length = 100)
    private String posName;

    // 员工集合
    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees;
}
