/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Entity.ModelCommercialProduct;
import Model.SQL.ModelCommercialProductSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor de Lucca
 */
public class ModelCommercialProductDao extends ModelCommercialProductSQL{

    private Connection conexao; 
    private PreparedStatement pst; 
    private ResultSet rs;
    private boolean result = false;

    public boolean insertProduct(ModelCommercialProduct produto) throws SQLException {
        
        try {
            conexao = Model.Connect.Connect.connect();

            insert(conexao, pst, produto);
            
            result = true;
                    
        } catch (Exception e) {
            
            result = false;
            
        }finally{
            conexao.close();
        }
        return result;
    }

    public boolean updateProduct(ModelCommercialProduct produto) throws SQLException {
        try {
            conexao = Model.Connect.Connect.connect();

            update(conexao, pst, produto);

            conexao.close();

            result = true;
        } catch (SQLException t) {
            
            result = false;
            
        }finally{
            conexao.close();
        }
        return result;
    }

    public List<ModelCommercialProduct> selectAllProducts()throws SQLException {
        
        List<ModelCommercialProduct> produto = null;
        
        try {

            conexao = Model.Connect.Connect.connect();

            rs = selectAll(conexao, pst);

            if (rs.next()) {
                
                while (rs.next()) {
                    ModelCommercialProduct modelCommercialProduct = new ModelCommercialProduct();
                    modelCommercialProduct.setId(rs.getInt(1));
                    modelCommercialProduct.setNome(rs.getString(2));
                    modelCommercialProduct.setValor(rs.getDouble(3));
                    modelCommercialProduct.setFilial(rs.getString(4));
                    modelCommercialProduct.setQtdProd(rs.getInt(5));
                    produto.add(modelCommercialProduct);
                }
            }
            
        } catch (SQLException t) {
            
            produto = null;
            
        }finally{
            conexao.close();
        }
        
        return produto;
    }

    public ModelCommercialProduct selectIdProduct(int id) throws SQLException{
        
        ModelCommercialProduct modelCommercialProduct = null;
        
        try {

            conexao = Model.Connect.Connect.connect();

            rs = selectId(conexao, pst, id);

            if (rs.next()) {
                    modelCommercialProduct.setId(rs.getInt(1));
                    modelCommercialProduct.setNome(rs.getString(2));
                    modelCommercialProduct.setValor(rs.getDouble(3));
                    modelCommercialProduct.setFilial(rs.getString(4));
                    modelCommercialProduct.setQtdProd(rs.getInt(5));
            }
            
        } catch (Exception t) {
            
        }finally{
            modelCommercialProduct = null;
            conexao.close();
        
        }
        
        return modelCommercialProduct;
        
    }

    public boolean deleteProduct(int a)throws SQLException {
        try {
            conexao = Model.Connect.Connect.connect();

            delete(conexao, pst, a);

            conexao.close();

            return true;
        } catch (SQLException t) {
            
            return false;
            
        }finally{
            
            conexao.close();
        }
    }
    
    public List<ModelCommercialProduct> selectNameProducts(String nome) throws SQLException{
        
        List<ModelCommercialProduct> produto = null;
        
        try {

            conexao = Model.Connect.Connect.connect();

            rs = selectProduto(conexao, pst, nome);

            if (rs.next()) {
                produto = new ArrayList<>();
                while (rs.next()) {
                    
                    ModelCommercialProduct modelCommercialProduct = new ModelCommercialProduct();
                    modelCommercialProduct.setId(rs.getInt(1));
                    modelCommercialProduct.setNome(rs.getString(2));
                    modelCommercialProduct.setValor(rs.getDouble(3));
                    modelCommercialProduct.setFilial(rs.getString(4));
                    modelCommercialProduct.setQtdProd(rs.getInt(5));
                    produto.add(modelCommercialProduct);
                    
                }
            }
            
        } catch (SQLException t) {
            
             produto = null;
            
        }finally{
            conexao.close();
        }
        
        return produto;
    }
}
