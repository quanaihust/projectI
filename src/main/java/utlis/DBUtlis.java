package utlis;

import Model.UserAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtlis {
    public static UserAccount findUser (Connection conn, String userName, String password) throws SQLException {
        String sql = "SELECT * FROM `englishapp`.`user_account` " + "WHERE `userName` = ? AND `password` = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,userName);
        pstm.setString(2,password);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
                UserAccount user = new UserAccount();
                user.setUserName(userName);
                user.setPassword(password);
                return user;
            }
        return null;
        }
    }
