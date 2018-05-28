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

        } finally {

            conexao.close();

        }
        return aux;
    }

    public boolean update(User user) throws SQLException {
        boolean aux = false;
        try {
            conexao = Model.Connect.Connect.connect();

            update(conexao, pst, user);

            aux = true;

        } catch (SQLException t) {

            aux = false;

        } finally {

            conexao.close();

        }
        return aux;
    }

    public List<User> selectAll() throws SQLException {

        List<User> userList = new ArrayList<>();

        try {

            conexao = Model.Connect.Connect.connect();

            rs = selectAll(conexao, pst, null);

            while (rs.next()) {

            }

        } catch (SQLException t) {
            userList = null;
        } finally {

            conexao.close();
        }
        return userList;
    }

    public User selectId(int id) throws SQLException {
        
        User user = new User();
        
        try {

            conexao = Model.Connect.Connect.connect();

            rs = selectId(conexao, pst, id);

            if(rs.next()) {
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
                user.setSenha(rs.getString("senha"));
                user.setIdFilial(rs.getInt("filialId"));
                user.setEmail(rs.getString("email"));
                user.setDataCri(rs.getTimestamp("dataCri"));
                user.setCpf(rs.getString("cpf"));
                user.setDataNasc(rs.getTimestamp("dataNasc"));
                user.setNome(rs.getString("nome"));
                user.setSobrenome(rs.getString("sobrenome"));
                user.setSexo(rs.getString("sexo"));
                user.setRg(rs.getString("rg"));
                user.setType(rs.getString("typeUser"));
            }else{
                user = null;
            }
            
        } catch (SQLException t) {
            user = null;            
        }finally{
            conexao.close();
        }
        return user;
    }

    public boolean delete(int id) throws SQLException {
        
        boolean aux = false;
        
        try {
            conexao = Model.Connect.Connect.connect();

            delete(conexao, pst, id);

            aux = true;
        } catch (SQLException t) {
            
            aux = false;
            
        }finally{
            conexao.close();
        }
        return aux;
    }

    public User login(String login, String senha) throws SQLException {
        User user = new User();
        try {

            conexao = Model.Connect.Connect.connect();

            rs = login(conexao, pst, login, senha);

            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
                user.setSenha(rs.getString("senha"));
                user.setIdFilial(rs.getInt("filialId"));
                user.setEmail(rs.getString("email"));
                user.setDataCri(rs.getTimestamp("dataCri"));
                user.setCpf(rs.getString("cpf"));
                user.setDataNasc(rs.getTimestamp("dataNasc"));
                user.setNome(rs.getString("nome"));
                user.setSobrenome(rs.getString("sobrenome"));
                user.setSexo(rs.getString("sexo"));
                user.setRg(rs.getString("rg"));
                user.setType(rs.getString("typeUser"));
            } else {
                user = null;
            }

        } catch (SQLException t) {
            user = null;
        } finally {
            
            conexao.close();
        
        }
        return user;
    }
    
     public List<User> selectNome(String nome) throws SQLException {
        List<User> listUser = null;
        User user = new User();
        
        try {

            conexao = Model.Connect.Connect.connect();

            rs = selectName(conexao, pst, nome);
            listUser = new ArrayList<>();
            while(rs.next()) {
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
                user.setSenha(rs.getString("senha"));
                user.setIdFilial(rs.getInt("filialId"));
                user.setEmail(rs.getString("email"));
                user.setDataCri(rs.getTimestamp("dataCri"));
                user.setCpf(rs.getString("cpf"));
                user.setDataNasc(rs.getTimestamp("dataNasc"));
                user.setNome(rs.getString("nome"));
                user.setSobrenome(rs.getString("sobrenome"));
                user.setSexo(rs.getString("sexo"));
                user.setRg(rs.getString("rg"));
                user.setType(rs.getString("typeUser"));
                listUser.add(user);
            }
            
        } catch (SQLException t) {
            user = null;            
        }finally{
            conexao.close();
        }
        return listUser;
    }

}
