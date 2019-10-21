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

@WebServlet(name = "CreatWord", urlPatterns = {"/createWord"})
public class CreatWord extends HttpServlet {
    public static final long serialVersionUID = 1L;
    public CreatWord(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtlis.getStoredConnection(request);
        String name = (String) request.getParameter("name");
        String mean = (String) request.getParameter("mean");
        String keyst = (String) request.getParameter("key");
        int key = 0;
        key = Integer.parseInt(keyst);
        Word word = new Word(name,mean,key);
        try {
            DBUtlis.insertWord(conn,word);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("word", word);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/createWordView.jsp");
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/createWordView.jsp");
        dispatcher.forward(request,response);
    }
}
