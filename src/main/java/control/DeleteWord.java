package control;

import utlis.DBUtlis;
import utlis.MyUtlis;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "DeleteWord", urlPatterns = {"/deleteWord"})
public class DeleteWord extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public DeleteWord(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtlis.getStoredConnection(request);
        String idst = request.getParameter("id");
        String errorString = null;
        int id = Integer.parseInt(idst);
        try {
            DBUtlis.deleteWord(conn, id);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        if(errorString != null){
            request.setAttribute("errorString",errorString);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/deleteWordView.jsp");
            dispatcher.forward(request,response);
        } else {
            response.sendRedirect(request.getContextPath() + "/myList");
        }
    }
}
