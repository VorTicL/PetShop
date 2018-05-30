/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Model.Entity.User;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 *
 * @author João
 */
public class UserSQL {
    public void insert(Connection conexao, PreparedStatement pst, User user) throws SQLException {

        String sql = "insert into user1(login,senha,filialId,email,dataCri,nome,dataNasc,"
                + "sexo,rg,cpf,typeUser) values (?,?,?,?,?,?,?,?,?,?,?)";

        pst = conexao.prepareStatement(sql);

        pst.setString(1, user.getLogin());
        pst.setString(2, user.getSenha());
        pst.setInt(3, user.getIdFilial());
        pst.setString(4, user.getEmail());
        pst.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
        pst.setString(6, user.getNome());
        pst.setTimestamp(7, user.getDataNasc());
        pst.setString(8, user.getSexo());
        pst.setString(9, user.getRg());
        pst.setString(10, user.getCpf());
        pst.setString(11, user.getType());
        pst.execute();

    }

    public void update(Connection conexao, PreparedStatement pst, User user) throws SQLException {

        String sql = "update user1 set login = ?,senha = ?,filialId = ?,email = ?,nome = ?,dataNasc = ?,"
                + "sexo = ?,rg = ?,cpf = ?,typeUser = ? where id = ? and ativo = 1";

        pst = conexao.prepareStatement(sql);

        pst.setString(1, user.getLogin());
        pst.setString(2, user.getSenha());
        pst.setInt(3, user.getIdFilial());
        pst.setString(4, user.getEmail());
        pst.setString(5, user.getNome());
        pst.setTimestamp(6, user.getDataNasc());
        pst.setString(7, user.getSexo());
        pst.setString(8, user.getRg());
        pst.setString(9, user.getCpf());
        pst.setString(10, user.getType());
        pst.setInt(11, user.getId());
        pst.executeUpdate();
    }

    public ResultSet selectAll(Connection conexao, PreparedStatement pst, User iuser) throws SQLException {
        String sql = "select * from user1 where ativo = 1";
        pst = conexao.prepareStatement(sql);
        
        return pst.executeQuery();
    }

    public ResultSet selectId(Connection conexao, PreparedStatement pst, int id) throws SQLException {
        String sql = "select * from user1 where id = ? and ativo = 1";
        pst = conexao.prepareStatement(sql);
        pst.setInt(1, id);

        return pst.executeQuery();
    }

 
    public void delete(Connection conexao, PreparedStatement pst, int id) throws SQLException {
        String sql = "update user1 set ativo = 0 where id = ?";
        pst = conexao.prepareStatement(sql);
        pst.setInt(1, id);

        pst.execute();
    }

    public ResultSet login(Connection conexao, PreparedStatement pst, String login, String senha) throws SQLException {
        String sql = "select * from user1 where login = ? and senha = ? and ativo = 1";
        pst = conexao.prepareStatement(sql);
        pst.setString(1, login);
        pst.setString(2, senha);

        return pst.executeQuery();
    }
    
    public ResultSet selectName(Connection conexao, PreparedStatement pst, String nome) throws SQLException {
        String sql = "select * from user1 where nome like ? and ativo = 1";
        pst = conexao.prepareStatement(sql);
        pst.setString(1, nome);

        return pst.executeQuery();
    }
}
