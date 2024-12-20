package cn.hl.hlhrms.service.impl;

import cn.hl.hlhrms.entity.Admin;
import cn.hl.hlhrms.repository.AdminRepository;
import cn.hl.hlhrms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 管理员服务层实现类
 */

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin registerAdmin(Admin admin) {
        // 可以在此添加重复检查等逻辑
        return adminRepository.save(admin);
    }

    @Override
    public Admin login(String username, String password) {
        Admin admin = adminRepository.findByUsernameAndPassword(username, password);
        if (admin == null) {
            System.out.println("用户名或密码错误");
        }
        return admin;
    }

    @Override
    public Admin getAdminByUsername(String username) {
        Admin admin = adminRepository.findByUsername(username);
        if (admin == null) {
            System.out.println("用户名不存在");
        }
        return admin;
    }
}
