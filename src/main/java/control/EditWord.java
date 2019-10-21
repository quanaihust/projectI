package control;

import Model.Word;
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

@WebServlet(name = "EditWord", urlPatterns = {"/editWord"})
public class EditWord extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EditWord() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtlis.getStoredConnection(request);
        String idst = (String) request.getParameter("id");
        String name = (String) request.getParameter("name");
        String mean = (String) request.getParameter("mean");
        int id = 0;
        id = Integer.parseInt(idst);
        Word word = new Word(id,name,mean);
        String errorString = null;
        try {
            DBUtlis.updateWord(conn,word);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("word",word);
        if (errorString != null){
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/editWordView.jsp");
            dispatcher.forward(request,response);
        } else {
            response.sendRedirect(request.getContextPath() + "/myList");
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtlis.getStoredConnection(request);
        String idst = (String) request.getParameter("id");
        int id = 0;
        id = Integer.parseInt(idst);
        Word word = null;
        String errorString = null;
        try {
            word = DBUtlis.findWord(conn,id);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        if (errorString != null && word != null){
            response.sendRedirect(request.getServletPath() + "/myList");
            return;
        }
        request.setAttribute("errorString",errorString);
        request.setAttribute("word",word);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/editWordView.jsp");
        dispatcher.forward(request,response);
    }
}
