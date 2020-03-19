package club.rain.repository;

import club.rain.entity.Admin;

public interface AdminRepository {
    public Admin login(String username, String password);
}
