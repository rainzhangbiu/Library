package club.rain.repository;

import club.rain.entity.Book;

import java.util.List;

/**
 * @author zyyy
 */
public interface BookRepository {
    /**
     * 查询当前页面所有书籍信息
     *
     * @param index 当前页码
     * @param limit 常量 LIMIT
     * @return 返回当前书籍信息
     */
    List<Book> findAllBooks(int index, int limit);

    /**
     * 获取总页数
     *
     * @return 总页数
     */
    int getCount();
}
