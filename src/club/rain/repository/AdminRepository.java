package club.rain.repository;

import club.rain.entity.Admin;

/**
 * @author zyyy
 */
public interface AdminRepository {
    /**
     * 管理员登陆验证
     *
     * @param username 用户输入的用户名
     * @param password 用户输入的密码
     * @return 返回一个 Admin 对象
     */
    Admin login(String username, String password);
}
