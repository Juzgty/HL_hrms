package cn.hl.hlhrms.service;

import cn.hl.hlhrms.entity.Admin;

/**
 * 管理员服务层接口
 */

public interface AdminService {
    /**
     * 注册管理员
     *
     * @param admin 管理员信息
     * @return 注册后的管理员实体
     */
    Admin registerAdmin(Admin admin);

    /**
     * 管理员登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录成功后的管理员实体
     */
    Admin login(String username, String password);

    /**
     * 查询管理员信息
     *
     * @param username 用户名
     * @return 管理员实体
     */
    Admin getAdminByUsername(String username);
}
