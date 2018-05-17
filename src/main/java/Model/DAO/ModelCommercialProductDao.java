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
 * @author João
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

            rs = selectAll(conexao, pst, null);

            if (rs.next()) {
                produto = new ArrayList<>();

                while (rs.next()) {
                    produto.add(new ModelCommercialProduct(rs.getString(1),
                            rs.getDouble(2),
                            rs.getString(3),
                            rs.getInt(4)));
                                
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
                
                 modelCommercialProduct = new ModelCommercialProduct(
                        rs.getString(1), rs.getDouble(2), rs.getString(3), rs.getInt(4));
                 
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
                    
                    produto.add(new ModelCommercialProduct(rs.getString(1),
                            rs.getDouble(2),
                            rs.getString(3),
                            rs.getInt(4)));
                                
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
