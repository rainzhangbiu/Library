package club.rain.service;

import club.rain.entity.Book;

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
}
