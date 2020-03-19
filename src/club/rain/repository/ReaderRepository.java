package club.rain.repository;

import club.rain.entity.Reader;

/**
 * @author zyyy
 */
public interface ReaderRepository {
    public Reader login(String username, String password);
}
