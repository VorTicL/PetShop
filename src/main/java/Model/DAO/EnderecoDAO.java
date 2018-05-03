/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.AbstractDAO.AbstractEndereco;
import Model.Entity.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Connect.Connect;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author João
 */
public class EnderecoDAO extends AbstractEndereco {
    
    private Connection conexao;
    private PreparedStatement pst;
    private ResultSet rs;
    
    @Override
    public boolean insert(Endereco endereco) {

        conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("insert into endereco(rua,bairro,numero,dataCri)");
            sql.append(" values (?,?,?,date(now()))");

            pst = conexao.prepareStatement(sql.toString());

            pst.setString(1, endereco.getRua());
            pst.setString(2, endereco.getBairro());
            pst.setString(3, endereco.getNumero());
            

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
    public List<Endereco> selectAll() {

        ArrayList<Endereco> endereco = new ArrayList<>();
        
        conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("select id,rua,bairro,numero,dataCri");
            sql.append(" from endereco and ativo = true");

            pst = conexao.prepareStatement(sql.toString());

            rs = pst.executeQuery();
            
            while(rs.next()){
                endereco.add(new Endereco(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3), 
                        rs.getString(4),
                        rs.getString(5)));
            }

            return endereco;
        } catch (SQLException e) {

            try {
                conexao.close();
            } catch (SQLException ex) {
            }
            
            return endereco;
        }

    }
    
    @Override
    public Endereco selectId(Endereco endereco) {
        
        conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("select id,rua,bairro,numero,dataCri");
            sql.append(" from endereco where id = ? and ativo = true");

            pst = conexao.prepareStatement(sql.toString());
            
            pst.setInt(1, endereco.getId());

            rs = pst.executeQuery();
            
            if(rs.next()){
                endereco.setRua(rs.getString(2));
                endereco.setBairro(rs.getString(3));
                endereco.setNumero(rs.getString(4));
                endereco.setDataCri(rs.getString(5));
            }

            return endereco;
        } catch (SQLException e) {

            try {
                conexao.close();
            } catch (SQLException ex) {
            }
            
            return endereco;
        }
    }
    @Override
    public boolean update(Endereco endereco) {
         conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("update endereco set rua = ? , bairro = ? , numero = ?");
            sql.append(" where id = ? and ativo = true");

            pst = conexao.prepareStatement(sql.toString());

            pst.setString(1, endereco.getRua());
            pst.setString(2, endereco.getBairro());
            pst.setString(3, endereco.getNumero());
            pst.setInt(4, endereco.getId());
            

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
    public boolean delete(Endereco endereco) {
         conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("update endereco set ativo = false");
            sql.append(" where id = ?");

            pst = conexao.prepareStatement(sql.toString());
            
            pst.setInt(1, endereco.getId());

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
    public boolean endereco(Endereco endereco) {
     
        conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("select id,rua,bairro,numero,dataCri");
            sql.append(" from endereco where rua = ? and bairro = ? and numero = ? and ativo = true");

            pst = conexao.prepareStatement(sql.toString());
            
            pst.setString(1, endereco.getRua());
            pst.setString(2, endereco.getBairro());
            pst.setString(3, endereco.getNumero());
              
            rs = pst.executeQuery();
            
            if(rs.next()){
                endereco.setId(rs.getInt(1));
                endereco.setDataCri(rs.getString(5));
            
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
