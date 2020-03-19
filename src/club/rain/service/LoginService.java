package club.rain.service;

/**
 * @author zyyy
 */
public interface LoginService {
    /**
     * 用于验证用户登陆
     *
     * @param username 用户输入账号名
     * @param password 用户输入密码
     * @param type     用户登陆类型
     * @return 返回一个 Object 对象，可能是 Reader 也可能是 Admin
     */
    Object login(String username, String password, String type);
}
