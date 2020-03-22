package club.rain.controller;

import club.rain.entity.Admin;
import club.rain.entity.BorrowInfo;
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

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    private BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String method = req.getParameter("method");

        if (method == null) {
            method = "findBorrowByState";
        }
        Admin admin = (Admin) session.getAttribute("admin");
        switch (method) {
            case "findBorrowByState":
                String pageStr = req.getParameter("page");
                Integer page = Integer.parseInt(pageStr);
                List<BorrowInfo> list = bookService.findBorrowByState(0, page);
                session.setAttribute("list", list);
                session.setAttribute("dataPerPage", 6);
                session.setAttribute("currentPage", page);
                session.setAttribute("pages", bookService.getBorrowCountByState(0));
                resp.sendRedirect("/admin.jsp");
                break;
            case "handle":
                String idStr = req.getParameter("id");
                String stateStr = req.getParameter("state");
                Integer id = Integer.parseInt(idStr);
                int state = Integer.parseInt(stateStr);
                bookService.handleBorrow(id, state, admin.getId());
                if (state == 1 || state == 2) {
                    resp.sendRedirect("/admin?page=1");
                }
                if (state == 3) {
                    resp.sendRedirect("/admin?method=getBorrowed&page=1");
                }
                break;
            case "getBorrowed":
                pageStr = req.getParameter("page");
                page = Integer.parseInt(pageStr);
                list = bookService.findBorrowByState(1, page);
                req.setAttribute("list", list);
                req.setAttribute("dataPrePage", 6);
                req.setAttribute("currentPage", page);
                req.setAttribute("pages", bookService.getBorrowPagesByState(1));
                req.getRequestDispatcher("/return.jsp").forward(req, resp);
                break;
            default:
                break;
        }
    }
}
