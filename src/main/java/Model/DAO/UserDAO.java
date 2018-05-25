/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Connect.Connect;
import Model.Entity.User;
import Model.SQL.UserSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author João
 */
public class UserDAO extends UserSQL {

    private Connection conexao;
    private PreparedStatement pst;
    private ResultSet rs;

    public boolean insert(User iuser) throws SQLException {
        boolean aux = false;
        try {
            conexao = Model.Connect.Connect.connect();

            insert(conexao, pst, iuser);
            
            aux = true;
        } catch (SQLException t) {
            
            aux = false;
            
        }finally{
            
            conexao.close();  
            
        }
        return aux;
    }

    public boolean update(User iuser) throws SQLException{
        boolean aux = false;
        try {
            conexao = Model.Connect.Connect.connect();
            
            update(conexao, pst, iuser);
            
            aux = true;
            
        } catch (SQLException t) {
            
            aux = false;
        }finally{
            
            conexao.close();  
            
        }
        return aux;
    }

    public List<User> selectAll() throws SQLException {
        
        List<User> user = new ArrayList<>();
        
        try {

            conexao = Model.Connect.Connect.connect();

            rs = selectAll(conexao, pst, null);

                while (rs.next()) {
                
                }
            

            
        } catch (SQLException t) {
            user = null;
        }finally{
            
            conexao.close();
        }
        return user;
    }

    public User selectId(User iuser) {
        try {

            conexao = Model.Connect.Connect.connect();

            rs = selectId(conexao, pst, iuser);

            if (rs.next()) {
                iuser.setId(rs.getInt(1));
                iuser.setLogin(rs.getString(2));
                iuser.setSenha(rs.getString(3));
                //iuser.setIdfuncionario(rs.getInt(4));
                iuser.setEmail(rs.getString(5));
                iuser.setDataCri(rs.getString(6));
            }
            conexao.close();

            return null;
        } catch (SQLException t) {

            try {
                conexao.close();
            } catch (SQLException ex) {
            }
            return null;
        }
    }

    public boolean delete(User iuser) {
        try {
            conexao = Model.Connect.Connect.connect();

            delete(conexao, pst, iuser);

            conexao.close();

            return true;
        } catch (SQLException t) {

            try {
                conexao.close();
            } catch (SQLException ex) {
            }

            return false;
        }
    }

    public boolean login(User iuser) throws SQLException {
        boolean retorno;
        try {

            conexao = Model.Connect.Connect.connect();

            rs = login(conexao, pst, iuser);

            if (rs.next()) {

                iuser.setId(rs.getInt(1));
                //iuser.setIdfuncionario(rs.getInt(2));
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (SQLException t) {
            retorno = false;
        } finally {
            conexao.close();
        }
        return retorno;
    }

}
