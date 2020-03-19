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
        // 返回值，既有可能是 Reader，也可能是 Admin，所以使用 Object 类
        Object object = null;

        // 判断登陆类型
        String reader = "reader";
        String admin = "admin";
        if (reader.equals(type)) {
            object = readerRepository.login(username, password);
        } else if (admin.equals(type)) {
            object = adminRepository.login(username, password);
        }
        return object;
    }
}
