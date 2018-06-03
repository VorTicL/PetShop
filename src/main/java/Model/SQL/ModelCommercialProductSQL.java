/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.SQL;

import Model.Entity.ModelCommercialProduct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author João
 */
public class ModelCommercialProductSQL {
    public void insert(Connection conexao, PreparedStatement pst, ModelCommercialProduct produto) throws SQLException {

         String sql = "insert into produto (nome,valor,filial,estoque) values (?,?,?,?)";


        pst = conexao.prepareStatement(sql);

        pst.setString(1, produto.getNome());
        pst.setDouble(2, produto.getValor());
        pst.setInt(3, produto.getFilial());
        pst.setInt(4, produto.getQtdProd());
        
        pst.execute();

    }

    public void update(Connection conexao, PreparedStatement pst, ModelCommercialProduct produto) throws SQLException {

        String sql = "update produto set nome = ?, valor = ?, filial = ?, estoque = ? where id = ? and ativo = true";

        pst = conexao.prepareStatement(sql);

       pst.setString(1, produto.getNome());
       pst.setDouble(2, produto.getValor());
       pst.setInt(3, produto.getFilial());
       pst.setInt(4, produto.getQtdProd());
       pst.setInt(5, produto.getId());
        
        pst.executeUpdate();
    }

    public ResultSet selectAll(Connection conexao, PreparedStatement pst) throws SQLException {
        String sql = "select id,nome,valor,filial,estoque from produto where ativo = true";
        pst = conexao.prepareStatement(sql);

        return pst.executeQuery();
    }

    public ResultSet selectId(Connection conexao, PreparedStatement pst, int id) throws SQLException {
        String sql = "select id,nome,valor,filial,"
                + "estoque from produto where id = ? and ativo = 1";
        pst = conexao.prepareStatement(sql);
        pst.setInt(1, id);

        return pst.executeQuery();
    }

    public void delete(Connection conexao, PreparedStatement pst, int id) throws SQLException {
        String sql = "update produto set ativo = false where id = ?";
        pst = conexao.prepareStatement(sql);
        pst.setInt(1, id);

        pst.execute();
    }
    
    public ResultSet selectProduto(Connection conexao, PreparedStatement pst, String nome) throws SQLException {
        String sql = "select id,nome,valor,filial,estoque "
                + "from produto where nome like ? and ativo = 1";

        pst = conexao.prepareStatement(sql);
        pst.setString(1, nome);
        
        return pst.executeQuery();
    }
}

