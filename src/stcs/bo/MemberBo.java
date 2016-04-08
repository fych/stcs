/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stcs.bo;

import java.sql.*;
import java.util.UUID;
import stcs.ui.Main;

/**
 *
 * @author lucas-fang
 */
public class MemberBo {
    /*删除会员
    *@param m_id
    *return
    */
    public boolean doDelete(String m_id) {
        boolean rtn = false;
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Drivers");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/st","root","root");
            stmt = conn.createStatement();
            String sql = "delete from st_member where m_id='"+m_id+"'";
            stmt.executeUpdate(sql);
            rtn=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return rtn;
        }
    }
    /*
    *添加会员
    *@param vo
    */
    public boolean doAdd(stcs.vo.MemberVo vo) {
        boolean rtn = false;
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Drivers");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/st","root","root");
            stmt = conn.createStatement();
            String sql = "insert into st_member(m_id,m_name,m_sex,m_major,m_dorm,m_qq,m_email,m_phone,m_dept,m_post,m_money,m_addtime,m_state,st_id) value('"
                    + UUID.randomUUID().toString()+"','"
                    + vo.getM_name() + "','"
                    + vo.getM_sex() + "','"
                    + vo.getM_major() + "','"
                    + vo.getM_dorm() + "','"
                    + vo.getM_qq() + "','"
                    + vo.getM_email() + "','"
                    + vo.getM_phone() + "','"
                    + vo.getM_dept() + "','"
                    + vo.getM_post() + "','"
                    + vo.getM_money() + "','"
                    + vo.getM_addtime() + "','在册',"
                    + Main.st_id
                    +")";
            stmt.executeUpdate(sql);
            rtn = true;
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return rtn;
        }
    }
    
    /*
    *修改会员
    *@param vo
    *@return
    */
    public boolean doUpdate(stcs.vo.MemberVo vo) {
        boolean rtn = false;
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Drivers");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/st","root","root");
            stmt = conn.createStatement();
            String sql;
            if (vo.getM_leavetime().equals("")||vo.getM_leavetime()==null) {
                vo.setM_leavetime(null);
                
                sql = "update st_member set m_name='"+vo.getM_name()+"',"
                    + "m_sex=" + vo.getM_sex() + "',"
                    + "m_major=" + vo.getM_major() + "',"
                    + "m_dorm=" + vo.getM_dorm() + "',"
                    + "m_qq=" + vo.getM_qq() + "',"
                    + "m_email=" + vo.getM_email() + "',"
                    + "m_phone=" + vo.getM_phone() + "',"
                    + "m_dept=" + vo.getM_dept() + "',"
                    + "m_post=" + vo.getM_post() + "',"
                    + "m_money=" + vo.getM_money() + "',"
                    + "m_state=" + vo.getM_state() + "',"
                    + "m_leavetime=" + null + ","
                    + "m_desc=" + vo.getM_desc() + "'"
                    + "where m_id=" + vo.getM_id() + "'";
            }else{
                sql = "update st_member set m_name='"+vo.getM_name()+"',"
                    + "m_sex=" + vo.getM_sex() + "',"
                    + "m_major=" + vo.getM_major() + "',"
                    + "m_dorm=" + vo.getM_dorm() + "',"
                    + "m_qq=" + vo.getM_qq() + "',"
                    + "m_email=" + vo.getM_email() + "',"
                    + "m_phone=" + vo.getM_phone() + "',"
                    + "m_dept=" + vo.getM_dept() + "',"
                    + "m_post=" + vo.getM_post() + "',"
                    + "m_money=" + vo.getM_money() + "',"
                    + "m_state=" + vo.getM_state() + "',"
                    + "m_leavetime=" + vo.getM_leavetime() + "',"
                    + "m_desc=" + vo.getM_desc() + "'"
                    + "where m_id=" + vo.getM_id() + "'";            
            }
            stmt.executeUpdate(sql);
            rtn = true;
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return rtn;
        }
    }
    
    /*
    *根据会员id查询会员信息
    *@param m_id
    *@return
    */
    public stcs.vo.MemberVo findMemberByM_id(String m_id){
        stcs.vo.MemberVo vo = new stcs.vo.MemberVo();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/st","root","root");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from st_member where m_id='"+ m_id+"'");
            if (rs.next()) {
                vo.setM_name(rs.getString("m_name"));
                vo.setM_sex(rs.getString("m_sex"));
                vo.setM_dorm(rs.getString("m_dorm"));
                vo.setM_phone(rs.getString("m_phone"));
                vo.setM_qq(rs.getString("m_qq"));
                vo.setM_email(rs.getString("m_email"));
                vo.setM_dept(rs.getString("m_dept"));
                vo.setM_post(rs.getString("m_post"));
                vo.setM_leavetime(rs.getString("m_leavetime"));
                vo.setM_desc(rs.getString("m_desc"));
                vo.setM_money(rs.getString("m_money"));
                vo.setM_major(rs.getString("m_major"));
                vo.setM_addtime(rs.getString("m_addtime"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception e){
                e.printStackTrace();
            }
            return vo;
        }
    }
}
