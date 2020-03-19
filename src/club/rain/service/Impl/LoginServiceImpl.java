package club.rain.service.Impl;

import club.rain.repository.AdminRepository;
import club.rain.repository.Impl.AdminRepositoryImpl;
import club.rain.repository.Impl.ReaderRepositoryImpl;
import club.rain.repository.ReaderRepository;
import club.rain.service.LoginService;

/**
 * @author zyyy
 */
public class LoginServiceImpl implements LoginService {
    ReaderRepository readerRepository = new ReaderRepositoryImpl();
    AdminRepository adminRepository = new AdminRepositoryImpl();

    @Override
    public Object login(String username, String password, String type) {
        Object object = null;
        if ("reader".equals(type)) {
            object = readerRepository.login(username, password);
        } else if ("admin".equals(type)) {
            object = adminRepository.login(username, password);
        }
        return object;
    }
}
