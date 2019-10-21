package utlis;

import Model.UserAccount;
import Model.Word;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtlis {
    public static UserAccount findUser(Connection conn, String userName, String password) throws SQLException {
        String sql = "SELECT * FROM `englishapp`.`user_account` " + "WHERE `userName` = ? AND `password` = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            UserAccount user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
            return user;
        }
        return null;
    }

    public static UserAccount findUser(Connection conn, String userName) throws SQLException {
        String sql = "SELECT * FROM `englishapp`.`user_account` " + "WHERE `userName` = ? ";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            String password = rs.getString("Password");
            UserAccount user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
            return user;
        }
        return null;
    }

    public static List<Word> queryWord(Connection conn) throws SQLException {
        String sql = "SELECT a.Word_ID, a.Word_Name, a.Word_Mean from word_study a";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<Word> list = new ArrayList<Word>();
        while (rs.next()) {
            int id = rs.getInt("Word_ID");
            String name = rs.getString("Word_Name");
            String mean = rs.getString("Word_Mean");
            Word word = new Word();
            word.setWord_ID(id);
            word.setWord_Name(name);
            word.setWord_Mean(mean);
            list.add(word);
        }
        return list;
    }

    public static Word findWord(Connection conn, int id) throws SQLException {
        String sql = "SELECT a.word_id, a.word_name, a.word_mean from word_study a where a.word_id = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,id);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
            String mean = rs.getString("Word_Mean");
            String name = rs.getString("Word_Name");
            Word word = new Word(id,name,mean);
            return word;
        }
        return null;
    }
    public static void updateWord(Connection conn, Word word) throws SQLException{
        String sql = "Update word_study set word_name = ?, word_mean = ? where word_id = ? ";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,word.getWord_Name());
        pstm.setString(2,word.getWord_Mean());
        pstm.setInt(3,word.getWord_ID());
        pstm.executeUpdate();
    }
    public static void insertWord(Connection conn, Word word) throws SQLException{
        String sql = "INSERT INTO word_study(word_name, word_mean, word_key VALUES (?,?,?))";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, word.getWord_Name());
        pstm.setString(2,word.getWord_Mean());
        pstm.setInt(3,word.getWord_key());
        pstm.executeUpdate();
    }
    public static void deleteWord(Connection conn, int word_id) throws SQLException{
        String sql = "DELETE FROM word_study where word_id = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, word_id);
        pstm.executeUpdate();
    }
}
