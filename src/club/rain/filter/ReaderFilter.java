package club.rain.filter;

import club.rain.entity.Reader;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author zyyy
 * <p>
 * 过滤器
 */
@WebFilter("/book")
public class ReaderFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 判断是否有读者登陆
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        Reader reader = (Reader) session.getAttribute("reader");
        if (reader == null) {
            ((HttpServletResponse) servletResponse).sendRedirect("/login.jsp");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
