/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.AbstractDAO.AbstractServico;
import Model.Connect.Connect;
import Model.Entity.Servico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author João
 */
public class ServicoDAO extends AbstractServico {
     private Connection conexao;
    private PreparedStatement pst;
    private ResultSet rs;
    
    @Override
    public boolean insert(Servico servico) {

        conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("insert into servico(nome,preco,animal,dataCri)");
            sql.append(" values (?,?,?,date(now()))");

            pst = conexao.prepareStatement(sql.toString());

            pst.setString(1, servico.getNome());
            pst.setDouble(2, servico.getPreco());
            pst.setInt(3, servico.getAnimal());

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
    public List<Servico> selectAll() {

        ArrayList<Servico> servico = new ArrayList<>();
        
        conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("select id,nome,preco,animal,dataCri");
            sql.append(" from servico and ativo = true");

            pst = conexao.prepareStatement(sql.toString());

            rs = pst.executeQuery();
            
            while(rs.next()){
                servico.add(new Servico(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3), 
                        rs.getInt(4),
                        rs.getString(5)));
            }

            return servico;
        } catch (SQLException e) {

            try {
                conexao.close();
            } catch (SQLException ex) {
            }
            
            return servico;
        }

    }

    @Override
    public Servico selectId(Servico servico) {
        
        conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("select id,nome,preco,animal,dataCri");
            sql.append(" from servico where id = ? and ativo = true");

            pst = conexao.prepareStatement(sql.toString());
            
            pst.setInt(1, servico.getId());

            rs = pst.executeQuery();
            
            if(rs.next()){
                servico.setNome(rs.getString(2));
                servico.setPreco(rs.getDouble(3));
                servico.setAnimal(rs.getInt(4));
                servico.setDataCri(rs.getString(5));
            }

            return servico;
        } catch (SQLException e) {

            try {
                conexao.close();
            } catch (SQLException ex) {
            }
            
            return servico;
        }
    }
    
    @Override
    public boolean update(Servico servico) {
         conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("update servico set nome = ? , preco = ? , animal = ?");
            sql.append(" where id = ? and ativo = true");

            pst = conexao.prepareStatement(sql.toString());

            pst.setString(1, servico.getNome());
            pst.setDouble(2, servico.getPreco());
            pst.setInt(3, servico.getAnimal());
            pst.setInt(4, servico.getId());
            

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
    public boolean delete(Servico servico) {
         conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("update iuser set ativo = false");
            sql.append(" where id = ?");

            pst = conexao.prepareStatement(sql.toString());
            
            pst.setInt(1, servico.getId());

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
    public boolean servico(Servico servico) {
     
        conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("select id,nome,preco,animal,dataCri");
            sql.append(" from servico where nome = ? and preco = ? and ativo = true");

            pst = conexao.prepareStatement(sql.toString());
            
            pst.setString(1, servico.getNome());
            pst.setDouble(2, servico.getPreco());

            rs = pst.executeQuery();
            
            if(rs.next()){
                servico.setId(rs.getInt(1));
                servico.setAnimal(rs.getInt(4));
                servico.setDataCri(rs.getString(5));
                  
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
