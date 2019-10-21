package filter;

import connection.ConnectionUtlis;
import connection.DBConn;
import utlis.MyUtlis;

import javax.security.sasl.SaslException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

@WebFilter(filterName = "jdbcFilter", urlPatterns = {"/*"})
public class JDBCFilter implements Filter {
    public JDBCFilter() {

    }
    @Override
    public void init(FilterConfig fConfig) throws ServletException{

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        if (this.needJDBC(req)){
            System.out.println("Open Connection for:" + req.getServletPath());
            Connection conn = null;
            try {
                conn = ConnectionUtlis.getConnection();
                conn.setAutoCommit(false);
                MyUtlis.storeConnection(servletRequest, conn);
                filterChain.doFilter(servletRequest,servletResponse);
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
                ConnectionUtlis.rollbackQuietly(conn);
                throw new SaslException();
            } finally {
                ConnectionUtlis.closeQuietly(conn);
            }

        } else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }

    private boolean needJDBC(HttpServletRequest request){
        System.out.println("JDBC Filter");
        String servletPath = request.getServletPath();
        String pathinfo = request.getPathInfo();
        String urlPattern = servletPath;
        if (pathinfo != null){
            urlPattern = servletPath + "/*";
        }

        Map<String, ? extends ServletRegistration> servletRegistration = request.getServletContext().getServletRegistrations();
        Collection < ? extends ServletRegistration> values = servletRegistration.values();
        for (ServletRegistration sr : values){
                Collection<String> mappings = sr.getMappings();
                if(mappings.contains(urlPattern)){
                    return true;
                }
        }
        return false;
    }

}
