package cn.hl.hlhrms.repository;

import  cn.hl.hlhrms.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 管理员持久层接口
 */

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    /**
     * 根据用户名查询管理员
     *
     * @param username 用户名
     * @return Admin 实体
     */
    Admin findByUsername(String username);

    /**
     * 根据用户名和密码查询管理员
     *
     * @param username 用户名，用于查询管理员
     * @param password 密码，用于验证管理员身份
     * @return 返回查询到的管理员对象，如果没有找到则返回null
     */
    Admin findByUsernameAndPassword(String username, String password);
}
