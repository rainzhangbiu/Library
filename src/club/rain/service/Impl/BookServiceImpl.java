package club.rain.service.Impl;

import club.rain.entity.Book;
import club.rain.entity.BorrowInfo;
import club.rain.repository.BookRepository;
import club.rain.repository.BorrowRepository;
import club.rain.repository.Impl.BookRepositoryImpl;
import club.rain.repository.Impl.BorrowRepositoryImpl;
import club.rain.service.BookService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * @author zyyy
 */
public class BookServiceImpl implements BookService {
    /**
     * 每页保存的最大书籍信息条数
     */
    private final int LIMIT = 6;

    private BookRepository bookRepository = new BookRepositoryImpl();
    private BorrowRepository borrowRepository = new BorrowRepositoryImpl();

    @Override
    public int getCount() {
        int count = bookRepository.getCount();
        // 总页数
        int pages;
        if ((count % LIMIT) == 0) {
            pages = count / 6;
        } else {
            pages = count / 6 + 1;
        }
        return pages;
    }

    @Override
    public List<Book> findAllBooks(int page) {
        int index = (page - 1) * LIMIT;
        return bookRepository.findAllBooks(index, LIMIT);
    }

    @Override
    public void addBorrow(Integer bookId, Integer readerId) {
        //借书时间
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String borrowTime = simpleDateFormat.format(date);
        //还书时间，借书时间+14天
        Calendar calendar = Calendar.getInstance();
        int dates = calendar.get(Calendar.DAY_OF_YEAR) + 14;
        calendar.set(Calendar.DAY_OF_YEAR, dates);
        Date date2 = calendar.getTime();
        String returnTime = simpleDateFormat.format(date2);

        borrowRepository.insert(bookId, readerId, borrowTime, returnTime, null, 0);
    }

    @Override
    public List<BorrowInfo> findBorrowInfo(Integer readerId, Integer page) {
        int index = (page - 1) * LIMIT;
        return borrowRepository.findBorrowInfo(readerId, index, LIMIT);
    }

    @Override
    public int getCount(Integer readerId) {
        int count = borrowRepository.getCount(readerId);
        // 总页数
        int pages;
        if ((count % LIMIT) == 0) {
            pages = count / 6;
        } else {
            pages = count / 6 + 1;
        }
        return pages;
    }

    @Override
    public List<BorrowInfo> findBorrowByState(Integer state, Integer page) {
        int index = (page - 1) * LIMIT;
        return borrowRepository.findBorrowByState(state, index, LIMIT);
    }

    @Override
    public int getBorrowCountByState(Integer state) {
        int count = borrowRepository.getBorrowCountByState(state);
        // 总页数
        int pages;
        if ((count % LIMIT) == 0) {
            pages = count / 6;
        } else {
            pages = count / 6 + 1;
        }
        return pages;
    }

    @Override
    public int getBorrowPagesByState(Integer state) {
        int count = borrowRepository.getBorrowCountByState(state);
        int page = 0;
        if (count % LIMIT == 0) {
            page = count / LIMIT;
        } else {
            page = count / LIMIT + 1;
        }
        return page;
    }

    @Override
    public void handleBorrow(Integer borrowId, Integer state, Integer adminId) {
        borrowRepository.handle(borrowId, state, adminId);
    }
}
