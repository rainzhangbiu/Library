package club.rain.repository.Impl;

import club.rain.entity.Book;
import club.rain.entity.BookCase;
import club.rain.repository.BookRepository;
import club.rain.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zyyy
 */
public class BookRepositoryImpl implements BookRepository {
    @Override
    public int getCount() {
        Connection connection = JDBCTools.getConnection();
        String sql = "select count(*) from book,bookcase where book.bookcaseid = bookcase.id;";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int count = 0;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection, statement, resultSet);
        }
        return count;
    }

    @Override
    public List<Book> findAllBooks(int index, int limit) {
        List<Book> books = new ArrayList<>();
        Connection connection = JDBCTools.getConnection();
        String sql = "select * from book,bookcase where book.bookcaseid = bookcase.id limit ?,?;";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,index);
            statement.setInt(2,limit);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                BookCase bookcase = new BookCase(resultSet.getInt(9),resultSet.getString(10));
                books.add(new Book(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),resultSet.getDouble(6),bookcase));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection, statement, resultSet);
        }

        return books;
    }
}
