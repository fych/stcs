/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stcs.bo;

import java.sql.*;
import stcs.ui.Main;

/**
 *
 * @author lucas-fang
 */
public class SocietyBO {
    /*
    *login
    *@param st_id
    *@param pass
    *@return
    */
    public boolean doLogin(int st_id, String pass){
        boolean rtn = false;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/st","root","root");
            stmt = conn.createStatement();
            //resure if the old password is right
            rs = stmt.executeQuery("select * from st_society where st_id+"+st_id+"and st_password='"+pass+"'");
            if (rs.next()) {
                Main.st_id = rs.getInt("st_id");
                rtn = true;
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return rtn;
        }
    }
}
