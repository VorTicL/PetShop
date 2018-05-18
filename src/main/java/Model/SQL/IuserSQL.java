/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Model.Entity.Iuser;
import java.sql.ResultSet;

/**
 *
 * @author João
 */
public class IuserSQL {
    public void insert(Connection conexao, PreparedStatement pst, Iuser iuser) throws SQLException {

        String sql = "insert into iuser(login,senha,email,idfuncionario,dataCri) values (?,?,?,?,date(now()))";

        pst = conexao.prepareStatement(sql);

        pst.setString(1, iuser.getLogin());
        pst.setString(2, iuser.getSenha());
        pst.setString(3, iuser.getEmail());
        pst.setInt(4, iuser.getIdfuncionario());
        pst.execute();

    }

    public void update(Connection conexao, PreparedStatement pst, Iuser iuser) throws SQLException {

        String sql = "update iuser set login = ? , senha = ? , email = ? , idfuncionario = ? where id = ? and ativo = true";

        pst = conexao.prepareStatement(sql);

        pst.setString(1, iuser.getLogin());
        pst.setString(2, iuser.getSenha());
        pst.setString(3, iuser.getEmail());
        pst.setInt(4, iuser.getIdfuncionario());
        pst.setInt(5, iuser.getId());
        

        pst.executeUpdate();
    }

    public ResultSet selectAll(Connection conexao, PreparedStatement pst, Iuser iuser) throws SQLException {
        String sql = "select id,login,senha,idfuncionario,email,dataCri from iuser and ativo = true";
        pst = conexao.prepareStatement(sql);

        return pst.executeQuery();
    }

    public ResultSet selectId(Connection conexao, PreparedStatement pst, Iuser iuser) throws SQLException {
        String sql = "select id,login,senha,idfuncionario,email,dataCri from iuser where id = ? and ativo = true";
        pst = conexao.prepareStatement(sql);
        pst.setInt(1, iuser.getId());

        return pst.executeQuery();
    }

 
    public void delete(Connection conexao, PreparedStatement pst, Iuser user) throws SQLException {
        String sql = "update iuser set ativo = false where id = ? and ativo = true";
        pst = conexao.prepareStatement(sql);
        pst.setInt(1, user.getId());

        pst.execute();
    }

    public ResultSet login(Connection conexao, PreparedStatement pst, Iuser iuser) throws SQLException {
        String sql = "select id,idfuncionario from iuser where login = ? and senha = ?"; //and ativo = true";
        pst = conexao.prepareStatement(sql);
        pst.setString(1, iuser.getLogin());
        pst.setString(2, iuser.getSenha());

        return pst.executeQuery();
    }
}
