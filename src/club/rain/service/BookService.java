package club.rain.service;

import club.rain.entity.Book;
import club.rain.entity.BorrowInfo;

import java.util.List;

/**
 * @author zyyy
 */

public interface BookService {
    /**
     * 查询当前页数所有书籍信息
     *
     * @param page 当前页数
     * @return 返回一个 List<Book>
     */
    List<Book> findAllBooks(int page);

    /**
     * 获取总页数
     *
     * @return 总页数
     */
    int getCount();

    /**
     * 添加借阅信息
     *
     * @param bookId   被借图书的 id
     * @param readerId 借阅人 id
     */
    void addBorrow(Integer bookId, Integer readerId);

    /**
     * 根据用户 id 查询借阅信息
     *
     * @param readerId 用户 id
     * @param page     当前页数
     * @return 借阅信息集合
     */
    List<BorrowInfo> findBorrowInfo(Integer readerId, Integer page);

    /**
     * 查询当前用户借阅书籍总数
     *
     * @param readerId 读者 id
     * @return 总借阅信息数
     */
    int getCount(Integer readerId);

    /**
     * 查询指定审核状态的借阅信息并分页
     *
     * @param state 审核状态
     * @param page  页码
     * @return 返回借阅信息集合
     */
    List<BorrowInfo> findBorrowByState(Integer state, Integer page);

    /**
     * 获取指定审核状态的借阅信息数量
     *
     * @param state 审核状态
     * @return 数量
     */
    int getBorrowCountByState(Integer state);


    int getBorrowPagesByState(Integer state);

    /**
     * 处理借阅
     *
     * @param borrowId 借阅信息 id
     * @param state    借阅状态
     * @param adminId  处理者 id
     */
    void handleBorrow(Integer borrowId, Integer state, Integer adminId);
}
