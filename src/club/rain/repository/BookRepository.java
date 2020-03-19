package club.rain.repository;

import club.rain.entity.Book;

import java.util.List;

/**
 * @author zyyy
 */
public interface BookRepository {
    public List<Book> findAllBooks(int index, int limit);
    public int getCount();
}
