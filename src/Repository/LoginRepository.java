/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class LoginRepository {
    private Connection conn;
    public LoginRepository(){
        try {
            this.conn = DAO.DBContext.getConnection();
        } catch (Exception e) {
        }
    }
    public User login (String username,String password){
        String sql = "select * from USERS where Username =  ? and Password = ?";
            try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            
                if (rs.next() == true) {
                    String user = rs.getString("Username");
                    String pwd = rs.getString("Password");
                    String role = rs.getString("Role");
                    
                    return new User(username, password,role);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return null;
    }
}
