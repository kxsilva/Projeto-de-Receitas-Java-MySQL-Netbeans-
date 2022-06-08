


import Connection.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author grautecnico
 */
public class rec_DAO {
     
    public void create (dadosRec t, int i){
        Connection con = DBConnect.getConnection();
        PreparedStatement stmt = null;
        
        
        try {
            stmt = con.prepareStatement("insert into cad_rec values (null, ?, ?, ?, ?)");
            stmt.setString(1, t.getNome_rec());
            stmt.setString(2, t.getIg());
            stmt.setString(3, t.getMod_preparo());
            stmt.setInt(4, i);
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Salvo " + ex);
        } finally {
            DBConnect.closeConnection(con, stmt);
        }
    }
    
    public List<dadosRec> read(){
        Connection con = DBConnect.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<dadosRec> dados = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("Select * from cad_rec");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                dadosRec gd = new dadosRec();
                gd.setNome_rec(rs.getString("nome_rec"));
                gd.setIg(rs.getString("ig"));
                gd.setMod_preparo(rs.getString("mod_preparo"));
                dados.add(gd);
            }
            
        } catch (SQLException ex) {
            System.out.print("erro!" + ex);
        } finally{
            DBConnect.closeConnection(con, stmt, rs);
        }
        return dados;
    }
    public List<dadosRec> readOne(int i){
        Connection con = DBConnect.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<dadosRec> dados = new ArrayList<>();
        
        System.out.print(i);
        try {
            stmt = con.prepareStatement("Select * from cad_rec where id_user = " + i);
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                dadosRec gd = new dadosRec();
                gd.setNome_rec(rs.getString("nome_rec"));
                gd.setIg(rs.getString("ig"));
                gd.setMod_preparo(rs.getString("mod_preparo"));
                dados.add(gd);
            }
            
        } catch (SQLException ex) {
            System.out.print("erro!" + ex);
        } finally{
            DBConnect.closeConnection(con, stmt, rs);
        }
        return dados;
    }
}
    