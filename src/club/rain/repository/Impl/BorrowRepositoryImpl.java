package club.rain.repository.Impl;

import club.rain.entity.Book;
import club.rain.entity.BorrowInfo;
import club.rain.entity.Reader;
import club.rain.repository.BorrowRepository;
import club.rain.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * \
 *
 * @author zyyy
 */
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

    @Override
    public List<BorrowInfo> findBorrowInfo(Integer readerId) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select br.id,b.name,b.author,b.publish,br.borrowtime,br.returntime,r.name,r.tel,r.cardid,br.state  from borrow br,reader r,book b where r.id = ? and br.readerid = r.id and br.bookid = b.id;";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<BorrowInfo> borrowInfos = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, readerId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                borrowInfos.add(new BorrowInfo(resultSet.getInt(1),
                        new Book(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)),
                        new Reader(resultSet.getString(7), resultSet.getString(8), resultSet.getString(9)),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getInt(10)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection, statement, resultSet);
        }
        return borrowInfos;
    }
}
