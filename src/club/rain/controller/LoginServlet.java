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
        // 从 request 中获取参数 username，password，type
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String type = req.getParameter("type");

        // 调用登陆业务，获取返回结果
        Object user = loginService.login(username, password, type);

        // 用户登陆成功
        if (user != null) {
            // 获取 session，用来保存登陆信息
            HttpSession session = req.getSession();

            // 判断登陆者的类型
            switch (type) {
                case "admin":
                    Admin admin = (Admin) user;
                    session.setAttribute("admin", admin);
                    resp.sendRedirect("/admin?method=findBorrowByState&page=1");
                    break;

                case "reader":
                    Reader reader = (Reader) user;
                    session.setAttribute("reader", reader);
                    // page = 1 为第一次进入 book 是必须的参数
                    resp.sendRedirect("/book?page=1");
                    break;
                default:
                    break;
            }
        } else { // 用户登陆失败
            resp.sendRedirect("/login.jsp");
        }
    }
}
