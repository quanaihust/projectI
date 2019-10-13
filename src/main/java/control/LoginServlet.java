package control;

import Model.UserAccount;
import utlis.DBUtlis;
import utlis.MyUtlis;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public LoginServlet(){
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/loginView.jsp");
        dispatcher.forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");
        boolean remember = "Y".equals(rememberMe);

        UserAccount user = null;
        boolean hasError = false;
        String errorString = null;

        if(userName == null || password == null || userName.length() == 0|| password.length() == 0 ){
            hasError = true;
            errorString = "Sai tên đăng nhập hoặc mật khẩu";
            doGet(request,response);
        } else {
            Connection conn = MyUtlis.getStoredConnection(request);
            try {
                user = DBUtlis.findUser(conn, userName, password);
                if(user == null){
                    hasError = true;
                    errorString = "Sai tên đăng nhập hoặc mật khẩu";
                }
            } catch (SQLException e) {
                e.printStackTrace();
                hasError = true;
                errorString = e.getMessage();
            }
        }
        if (hasError){
            user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
            request.setAttribute("errorString",errorString);
            request.setAttribute("user",user);
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/loginView.jsp");
            dispatcher.forward(request,response);
        } else {
            HttpSession session = request.getSession();
            MyUtlis.storedLoginedUser(session,user);
            if (remember){
                MyUtlis.storeUserCookie(response,user);
            } else {
                MyUtlis.deleteUserCookie(response);
            }
            response.sendRedirect(request.getContextPath() + "/userinfo");
        }
    }
}
