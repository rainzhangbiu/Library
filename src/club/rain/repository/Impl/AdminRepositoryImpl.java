package club.rain.repository.Impl;

import club.rain.entity.Admin;
import club.rain.repository.AdminRepository;
import club.rain.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author zyyy
 */
public class AdminRepositoryImpl implements AdminRepository {
    @Override
    public Admin login(String username, String password) {
        Admin admin = null;
        Connection connection = JDBCTools.getConnection();
        String sql = "select * from bookadmin where username = ? and password = ?;";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            statement.setString(2,password);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                admin = new Admin(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection, statement, resultSet);
        }
        return admin;
    }
}
