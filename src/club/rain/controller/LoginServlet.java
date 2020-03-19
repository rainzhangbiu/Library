package club.rain.controller;

import club.rain.entity.Admin;
import club.rain.entity.Reader;
import club.rain.service.Impl.LoginServiceImpl;
import club.rain.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * @author zyyy
 *
 * 完成用户登陆的功能
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private LoginService loginService = new LoginServiceImpl();

    /**
     * 实现登陆功能
     * @param req 页面请求
     * @param resp 页面响应
     * @throws ServletException Servlet 异常
     * @throws IOException IO 异常
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String type = req.getParameter("type");
        Object user = loginService.login(username,password,type);

        if (user != null) {
            HttpSession session = req.getSession();
            switch (type) {
                case "admin":
                    Admin admin = (Admin) user;
                    session.setAttribute("admin", admin);
                    req.getRequestDispatcher("/index.jsp").forward(req, resp);
                    break;
                case "reader":
                    Reader reader = (Reader) user;
                    session.setAttribute("reader", reader);
                    resp.sendRedirect("/book?page=1");
                    break;
                default:
                    break;
            }
        } else {
            resp.sendRedirect("/login.jsp");
        }
    }
}
