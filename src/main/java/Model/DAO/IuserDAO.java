/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.AbstractDAO.AbstractIuser;
import Model.Connect.Connect;
import Model.Entity.Iuser;
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
 * @author dev
 */
public class IuserDAO extends AbstractIuser {

    private Connection conexao;
    private PreparedStatement pst;
    private ResultSet rs;

    @Override
    public boolean insert(Iuser iuser) {

        conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("insert into iuser(login,senha,email,idfuncionario,dataCri)");
            sql.append(" values (?,?,?,?,date(now()))");

            pst = conexao.prepareStatement(sql.toString());

            pst.setString(1, iuser.getLogin());
            pst.setString(2, iuser.getSenha());
            pst.setString(3, iuser.getEmail());
            pst.setInt(4, iuser.getIdfuncionario());

            pst.execute();

            return true;
        } catch (SQLException e) {

            try {
                conexao.close();
            } catch (SQLException ex) {
            }
            
            return false;
        }

    }

    @Override
    public List<Iuser> selectAll() {

        ArrayList<Iuser> iusers = new ArrayList<>();
        
        conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("select id,login,senha,idfuncionario,email,dataCri");
            sql.append(" from iuser and ativo = true");

            pst = conexao.prepareStatement(sql.toString());

            rs = pst.executeQuery();
            
            while(rs.next()){
                iusers.add(new Iuser(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3), 
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6)));
            }

            return iusers;
        } catch (SQLException e) {

            try {
                conexao.close();
            } catch (SQLException ex) {
            }
            
            return iusers;
        }

    }

    @Override
    public Iuser selectId(Iuser iuser) {
        
        conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("select id,login,senha,idfuncionario,email,dataCri");
            sql.append(" from iuser where id = ? and ativo = true");

            pst = conexao.prepareStatement(sql.toString());
            
            pst.setInt(1, iuser.getId());

            rs = pst.executeQuery();
            
            if(rs.next()){
                iuser.setLogin(rs.getString(2));
                iuser.setSenha(rs.getString(3));
                iuser.setIdfuncionario(rs.getInt(4));
                iuser.setEmail(rs.getString(5));
                iuser.setDataCri(rs.getString(6));
            }

            return iuser;
        } catch (SQLException e) {

            try {
                conexao.close();
            } catch (SQLException ex) {
            }
            
            return iuser;
        }
    }

    @Override
    public boolean update(Iuser iuser) {
         conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("update iuser set login = ? , senha = ? , email = ? , idfuncionario = ?");
            sql.append(" where id = ? and ativo = true");

            pst = conexao.prepareStatement(sql.toString());

            pst.setString(1, iuser.getLogin());
            pst.setString(2, iuser.getSenha());
            pst.setString(3, iuser.getEmail());
            pst.setInt(4, iuser.getIdfuncionario());
            pst.setInt(5, iuser.getId());

            pst.executeUpdate();

            return true;
        } catch (SQLException e) {

            try {
                conexao.close();
            } catch (SQLException ex) {
            }
            
            return false;
        }
    }

    @Override
    public boolean delete(Iuser iuser) {
         conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("update iuser set ativo = false");
            sql.append(" where id = ?");

            pst = conexao.prepareStatement(sql.toString());
            
            pst.setInt(1, iuser.getId());

            pst.execute();

            return true;
        } catch (SQLException e) {

            try {
                conexao.close();
            } catch (SQLException ex) {
            }
            
            return false;
        }
    }

    @Override
    public boolean login(Iuser iuser) {
     
        conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("select id,login,senha,idfuncionario,email,dataCri");
            sql.append(" from iuser where login = ? and senha = ? and ativo = true");

            pst = conexao.prepareStatement(sql.toString());
            
            pst.setString(1, iuser.getLogin());
            pst.setString(2, iuser.getSenha());

            rs = pst.executeQuery();
            
            if(rs.next()){
                iuser.setId(rs.getInt(1));
                iuser.setIdfuncionario(rs.getInt(4));
                iuser.setEmail(rs.getString(5));
                iuser.setDataCri(rs.getString(6));
            
                return true;
            }

            return false;
        } catch (SQLException e) {

            try {
                conexao.close();
            } catch (SQLException ex) {
            }
            
            return false;
        }
    }

}
