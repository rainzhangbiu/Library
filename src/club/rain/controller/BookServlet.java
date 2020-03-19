package club.rain.controller;

import club.rain.entity.Book;
import club.rain.entity.Reader;
import club.rain.service.BookService;
import club.rain.service.Impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/**
 * @author zyyy
 */
@WebServlet("/book")
public class BookServlet extends HttpServlet {
    private BookService bookService = new BookServiceImpl();


    /**
     * 加载图书数据
     * @param req 页面请求
     * @param resp 页面响应
     * @throws ServletException Servlet 异常
     * @throws IOException IO 异常
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method == null) {
            method = "findAllBooks";
        }
        switch (method) {
            case "findAllBooks" :
                String pageStr = req.getParameter("page");
                Integer page = Integer.parseInt(pageStr);
                HttpSession session = req.getSession();
                List<Book> books = bookService.findAllBooks(page);
                session.setAttribute("books", books);
                session.setAttribute("dataPerPage", 6);
                session.setAttribute("currentPage", page);
                session.setAttribute("pages", bookService.getCount());
                resp.sendRedirect("/index.jsp");
                break;

            case "addBorrow":
                String bookStr = req.getParameter("bookid");
                Integer bookId = Integer.parseInt(bookStr);
                HttpSession session1 =req.getSession();
                Reader reader = (Reader) session1.getAttribute("reader");
                bookService.addBorrow(bookId, reader.getId());
                break;

            default:
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
