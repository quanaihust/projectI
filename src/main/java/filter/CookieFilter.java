package filter;

import Model.UserAccount;
import utlis.DBUtlis;
import utlis.MyUtlis;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter(filterName = "cookieFilter", urlPatterns = {"/*"})
public class CookieFilter implements Filter {

    public CookieFilter() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        UserAccount userlnSession = MyUtlis.getLoginUser(session);
        if (userlnSession != null) {
            session.setAttribute("COOKIE_CHECKED", "CHECKED");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        Connection conn = MyUtlis.getStoredConnection(servletRequest);
        String checked = (String) session.getAttribute("COOKIE_CHECKED");
        if (checked == null && conn != null) {
            String userName = MyUtlis.getUserNameCookie(req);
            UserAccount user = null;
            try {
                user = DBUtlis.findUser(conn, userName);
                MyUtlis.storedLoginedUser(session,user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            session.setAttribute("COOKIE_CHECKED","CHECKED");
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

@Override
public void destroy(){

        }
}
