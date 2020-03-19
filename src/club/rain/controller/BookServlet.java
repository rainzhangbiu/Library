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
     * 图书界面
     *
     * @param req  页面请求
     * @param resp 页面响应
     * @throws ServletException Servlet 异常
     * @throws IOException      IO 异常
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 功能参数，如果没有该参数默认查询书籍
        String method = req.getParameter("method");
        if (method == null) {
            method = "findAllBooks";
        }
        switch (method) {
            // 查询书籍功能，是根据 page 来查询当前页面书籍，此处命名不合理
            case "findAllBooks":
                // 获取当前页数。并且转化为 int 类型
                String pageStr = req.getParameter("page");
                int page = Integer.parseInt(pageStr);
                // 获取 session
                HttpSession session = req.getSession();
                // 调用查询书籍业务，保存当前页面书籍信息
                List<Book> books = bookService.findAllBooks(page);
                // 将书籍信息、每页书籍数量、当前页数、总页数装入 session 中
                session.setAttribute("books", books);
                session.setAttribute("dataPerPage", 6);
                session.setAttribute("currentPage", page);
                session.setAttribute("pages", bookService.getCount());

                resp.sendRedirect("/index.jsp");
                break;

            // 借阅功能
            case "addBorrow":
                // 获取被借书 id
                String bookStr = req.getParameter("bookid");
                Integer bookId = Integer.parseInt(bookStr);
                // 获取借阅人 id
                HttpSession session1 =req.getSession();
                Reader reader = (Reader) session1.getAttribute("reader");
                // 调用添加借阅信息业务
                bookService.addBorrow(bookId, reader.getId());
                break;

            default:
                break;
        }

    }

}
