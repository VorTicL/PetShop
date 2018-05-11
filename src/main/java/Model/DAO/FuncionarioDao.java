/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.AbstractDAO.AbstractFuncionario;
import Model.Connect.Connect;
import Model.Entity.Funcionario;
import Model.SQL.FuncionarioSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

/**
 *
 * @author João
 */
public class FuncionarioDao extends FuncionarioSQL {

    private Connection conexao; 
    private PreparedStatement pst; 
    private ResultSet rs; 

    public int insert(Funcionario funcionario) {

        try {
            conexao = Model.Connect.Connect.connect();

            int id = insert(conexao, pst, funcionario);

            conexao.close();

            return id;
        } catch (SQLException t) {

            try {
                conexao.close();
            } catch (SQLException ex) {
            }

            return 0;
        }
    }

    public boolean update(Funcionario funcionario) {
        try {
            conexao = Model.Connect.Connect.connect();

            update(conexao, pst, funcionario);

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

    public List<Funcionario> selectAll() {
        try {
            List<Funcionario> funcionario = null;

            conexao = Model.Connect.Connect.connect();

            rs = selectAll(conexao, pst, null);

            if (rs.next()) {
                funcionario = new ArrayList<>();

                while (rs.next()) {
                    funcionario.add(new Funcionario(rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8)));
                            
                }
            }
            conexao.close();

            return funcionario;
        } catch (SQLException t) {

            try {
                conexao.close();
            } catch (SQLException ex) {
            }
            return null;
        }
    }

    public Funcionario selectId(Funcionario funcionario) {
        try {

            conexao = Model.Connect.Connect.connect();

            rs = selectId(conexao, pst, funcionario);

            if (rs.next()) {
                return new Funcionario(rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8));
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

    public boolean delete(Funcionario funcionario) {
        try {
            conexao = Model.Connect.Connect.connect();

            delete(conexao, pst, funcionario);

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
}