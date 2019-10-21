package control;

import Model.UserAccount;
import Model.Word;
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
import java.util.List;

@WebServlet(name = "MyList", urlPatterns = {"/myList"})
public class MyList extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public MyList(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserAccount loginedUser = MyUtlis.getLoginUser(session);
        if (loginedUser == null){
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        request.setAttribute("user",loginedUser);
        Connection conn = MyUtlis.getStoredConnection(request);
        String errorString = null;
        List<Word> list = null;
        try {
            list = DBUtlis.queryWord(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("errorString",errorString);
        request.setAttribute("wordList",list);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/myListView.jsp");
        dispatcher.forward(request,response);
    }
}
