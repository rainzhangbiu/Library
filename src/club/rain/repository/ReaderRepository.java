package club.rain.repository;

import club.rain.entity.Reader;

/**
 * @author zyyy
 */
public interface ReaderRepository {
    /**
     * 验证读者登陆
     *
     * @param username 用户输入的用户名
     * @param password 用户输入的密码
     * @return 返回一个 Reader 对象
     */
    Reader login(String username, String password);
}
