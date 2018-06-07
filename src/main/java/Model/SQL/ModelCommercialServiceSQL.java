/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.SQL;

import Model.Entity.ModelCommercialProduct;
import Model.Entity.ModelCommercialService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author João
 */
public class ModelCommercialServiceSQL {
    public void insert(Connection conexao, PreparedStatement pst, ModelCommercialService servico) throws SQLException {

         String sql = "insert into servico (pet,preco,nome,filialId) values (?,?,?,?)";


        pst = conexao.prepareStatement(sql);

        pst.setString(1, servico.getPet());
        pst.setDouble(2, servico.getValor());
        pst.setString(3, servico.getNome());
        pst.setInt(4, servico.getFilial());
        
        pst.execute();

    }

    public void update(Connection conexao, PreparedStatement pst, ModelCommercialService servico) throws SQLException {

        String sql = "update servico set nome = ?, preco = ?, filialId = ?, pet = ? where id = ? and ativo = 1";

        pst = conexao.prepareStatement(sql);

       pst.setString(1, servico.getNome());
       pst.setDouble(2, servico.getValor());
       pst.setInt(3, servico.getFilial());
       pst.setString(4, servico.getPet());
       pst.setInt(5, servico.getId());
        
        pst.executeUpdate();
    }

    public ResultSet selectAll(Connection conexao, PreparedStatement pst) throws SQLException {
        String sql = "select * from servico where ativo = 1";
        pst = conexao.prepareStatement(sql);

        return pst.executeQuery();
    }

    public ResultSet selectId(Connection conexao, PreparedStatement pst, int id) throws SQLException {
        String sql = "select * from servico where id = ? and ativo = 1";
        pst = conexao.prepareStatement(sql);
        pst.setInt(1, id);

        return pst.executeQuery();
    }

    public void delete(Connection conexao, PreparedStatement pst, int id) throws SQLException {
        String sql = "update servico set ativo = 0 where id = ?";
        pst = conexao.prepareStatement(sql);
        pst.setInt(1, id);

        pst.execute();
    }
    
    public ResultSet selectProduto(Connection conexao, PreparedStatement pst, String nome) throws SQLException {
        String sql = "select * from servico where nome like ? and ativo = 1";

        pst = conexao.prepareStatement(sql);
        pst.setString(1, nome);
        
        return pst.executeQuery();
    }
}

