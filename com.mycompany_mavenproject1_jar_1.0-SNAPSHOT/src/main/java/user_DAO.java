

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



import Connection.DBConnect;
import java.sql.*;
import java.sql.Connection;        
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class user_DAO {
    
    
    public void create (dadosUser t){
        Connection con = DBConnect.getConnection();
        PreparedStatement stmt = null;
        
        
        try {
            stmt = con.prepareStatement("insert into cad_user values (null, ?, ?, ?, ?)");
            stmt.setString(1, t.getName());
            stmt.setString(2, t.getPass());
            stmt.setString(3, t.getEmail());
            stmt.setString(4, t.getSex());
            
            
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Salvo" + ex);
        } finally {
            DBConnect.closeConnection(con, stmt);
        }
    }
    
     
}
