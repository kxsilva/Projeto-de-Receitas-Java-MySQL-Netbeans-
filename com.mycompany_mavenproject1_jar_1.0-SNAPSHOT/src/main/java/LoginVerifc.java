
import Connection.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kaynã
 */
public class LoginVerifc {
    
    
    public int check(String login, String senha){
        Connection con = DBConnect.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int check = 0;
        
        try {
            stmt = con.prepareStatement("Select * from cad_user where email = ? and pass = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            
            if(rs.next()){
                
                check = rs.getInt("id");
                
            }
            
            
        } catch (SQLException ex) {
            System.out.print("erro!" + ex);
        } finally{
            DBConnect.closeConnection(con, stmt, rs);
        }
        return check;
    }
    public int check(String email){
        Connection con = DBConnect.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int check = 0;
        
        try {
            stmt = con.prepareStatement("Select * from cad_user where email = ?");
            stmt.setString(1, email);
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                
                check = rs.getInt("id");
                
            }
            
            
        } catch (SQLException ex) {
            System.out.print("erro!" + ex);
        } finally{
            DBConnect.closeConnection(con, stmt, rs);
        }
        return check;
    }
    
}
