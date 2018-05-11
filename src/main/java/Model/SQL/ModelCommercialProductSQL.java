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
    public int insert(Connection conexao, PreparedStatement pst, ModelCommercialProduct produto) throws SQLException {

         String sql = "insert into produto (nome,valor,filial,qtdProd) values (?,?,?,?,?,?)";


        pst = conexao.prepareStatement(sql);

        pst.setString(1, produto.getNome());
        pst.setDouble(2, produto.getValor());
        pst.setString(3, produto.getFilial());
        pst.setInt(4, produto.getQtdProd());
        
        pst.execute();
        
        ResultSet rs = selectProduto(conexao, pst, produto);

        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
        
    }

    public void update(Connection conexao, PreparedStatement pst, ModelCommercialProduct produto) throws SQLException {

        String sql = "update produto set nome = ? and valor = ? and  filial = ? and qtdProd = ? where id = ? and ativo = true";

        pst = conexao.prepareStatement(sql);

       pst.setString(1, produto.getNome());
       pst.setDouble(2, produto.getValor());
       pst.setString(3, produto.getFilial());
       pst.setInt(4, produto.getQtdProd());
       pst.setInt(5, produto.getId());
        
        pst.executeUpdate();
    }

    public ResultSet selectAll(Connection conexao, PreparedStatement pst, ModelCommercialProduct produto) throws SQLException {
        String sql = "select id,nome,valor,filial,qtdProd from produto where id = ? and ativo = true";
        pst = conexao.prepareStatement(sql);

        return pst.executeQuery();
    }

    public ResultSet selectId(Connection conexao, PreparedStatement pst, ModelCommercialProduct produto) throws SQLException {
        String sql = "select id,nome,valor,filial,qtdProd from produto where id = ? and ativo = true";
        pst = conexao.prepareStatement(sql);
        pst.setInt(1, produto.getId());

        return pst.executeQuery();
    }

    public void delete(Connection conexao, PreparedStatement pst, ModelCommercialProduct produto) throws SQLException {
        String sql = "update produto set ativo = false where id = ?";
        pst = conexao.prepareStatement(sql);
        pst.setInt(1, produto.getId());

        pst.execute();
    }
    
    public ResultSet selectProduto(Connection conexao, PreparedStatement pst, ModelCommercialProduct produto) throws SQLException {
        String sql = "select id from produto where nome = ? and valor = ? and filial = ? and qtdProd = ?  and ativo = true";

        pst = conexao.prepareStatement(sql);
        pst.setString(1, produto.getNome());
        pst.setDouble(2, produto.getValor());
        pst.setString(3, produto.getFilial());
        pst.setInt(4, produto.getQtdProd());
        
        
        return pst.executeQuery();
    }
}

