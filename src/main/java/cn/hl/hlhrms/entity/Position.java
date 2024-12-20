package cn.hl.hlhrms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * 职位实体类
 */

@Entity
@Data
@Table(name = "hl_position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pos_id", nullable = false)
    private Integer posId;

    @Column(name = "pos_name", nullable = false, unique = true, length = 100)
    private String posName;

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees;
}
