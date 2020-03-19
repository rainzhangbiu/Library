package club.rain.repository.Impl;

import club.rain.repository.BookRepository;
import club.rain.repository.BorrowRepository;
import club.rain.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BorrowRepositoryImpl implements BorrowRepository {
    @Override
    public void insert(Integer bookId, Integer readerId, String borrowTime, String returnTime, Integer adminId, Integer statement) {
        Connection connection = JDBCTools.getConnection();
        String sql = "insert into borrow(bookid, readerid, borrowtime, returntime, state) values(?,?,?,?,0)";
        PreparedStatement preparedStatements = null;
        try {
            preparedStatements = connection.prepareStatement(sql);
            preparedStatements.setInt(1, bookId);
            preparedStatements.setInt(2, readerId);
            preparedStatements.setString(3, borrowTime);
            preparedStatements.setString(4, returnTime);
            preparedStatements.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection, preparedStatements, null);
        }
    }
}
