package cn.hl.hlhrms.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * 管理员实体类
 */

@Entity
@Data
@Table(name = "hl_admin")
public class Admin {
    // 管理员id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id", nullable = false)
    private Integer adminId;

    // 用户名
    @Column(name = "username", nullable = false, unique = true, length = 50)
    private String username;

    // 密码
    @Column(name = "password", nullable = false, length = 100)
    private String password;
}
