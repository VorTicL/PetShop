/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*package Model.DAO;

import Model.AbstractDAO.AbstractIuser;
import Model.Connect.Connect;
import Model.Entity.Iuser;
import Model.SQL.IuserSQL;
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
 /
public class IuserDAO extends IuserSQL implements AbstractIuser {

    private Connection conexao; 
    private PreparedStatement pst; 
    private ResultSet rs; 

    @Override
    public boolean insert(Iuser iuser) {

        try {
            conexao = Model.Connect.Connect.connect();

            insert(conexao, pst, iuser);

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

    @Override
    public boolean update(Iuser iuser) {
        try {
            conexao = Model.Connect.Connect.connect();

            update(conexao, pst, iuser);

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

    @Override
    public List<Iuser> selectAll() {
        try {
            List<Iuser> iuser = null;

            conexao = Model.Connect.Connect.connect();

            rs = selectAll(conexao, pst, null);

            if (rs.next()) {
                iuser = new ArrayList<>();

                while (rs.next()) {
                    iuser.add(new Iuser(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getInt(4),
                            rs.getString(5),
                            rs.getString(6)));
                }
            }
            conexao.close();

            return iuser;
        } catch (SQLException t) {

            try {
                conexao.close();
            } catch (SQLException ex) {
            }
            return null;
        }
    }

    @Override
    public Iuser selectId(Iuser iuser) {
        try {

            conexao = Model.Connect.Connect.connect();

            rs = selectId(conexao, pst, iuser);

            if (rs.next()) {
                iuser.setId(rs.getInt(1));
                iuser.setLogin(rs.getString(2));
                iuser.setSenha(rs.getString(3));
                iuser.setIdfuncionario(rs.getInt(4));
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

    @Override
    public boolean delete(Iuser iuser) {
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

    /*@Override
    public boolean login(Iuser iuser) {
        try {

            conexao = Model.Connect.Connect.connect();

            rs = login(conexao, pst, iuser);

            if (rs.next()) {

                ResultSet rs1 = selectNivel(conexao, pst, iuser);

                if (rs1.next()) {
                    iuser.setId(rs.getInt(1));
                    iuser.setIdfuncionario(rs.getInt(2));
                    iuser.setEmail(rs.getString(3));
                   
                }

                conexao.close();

                return true;
            }

            conexao.close();

            return false;
        } catch (SQLException t) {
            try {
                conexao.close();
            } catch (SQLException ex) {
            }
            return false;
        }
    }

}
*/