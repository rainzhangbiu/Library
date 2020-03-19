package club.rain.service;

import club.rain.entity.Reader;

/**
 * @author zyyy
 */
public interface LoginService {
    public Object login(String username, String password, String type);
}
