package club.rain.service;

import club.rain.entity.Book;

import java.util.List;

/**
 * @author zyyy
 */

public interface BookService {
    public List<Book> findAllBooks(int page);
    public int getCount();
    public void addBorrow(Integer bookId, Integer readerId);
}
