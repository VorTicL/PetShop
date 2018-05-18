/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Entity.ModelCommercialProduct;
import Model.Entity.ModelCommercialService;
import Model.SQL.ModelCommercialProductSQL;
import Model.SQL.ModelCommercialServiceSQL;
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
public class ModelCommercialServicosDao extends ModelCommercialServiceSQL{

    private Connection conexao; 
    private PreparedStatement pst; 
    private ResultSet rs;
    private boolean result = false;

    public boolean insertService(ModelCommercialService servico) throws SQLException {
        
        try {
            conexao = Model.Connect.Connect.connect();

            insert(conexao, pst, servico);
            
            result = true;
                    
        } catch (Exception e) {
            
            result = false;
            
        }finally{
            
            conexao.close();
            
        }
        return result;
    }

    public boolean updateServices(ModelCommercialService servico) throws SQLException {
        try {
            conexao = Model.Connect.Connect.connect();

            update(conexao, pst, servico);

            conexao.close();

            result = true;
        } catch (SQLException t) {
            
            result = false;
            
        }finally{
            conexao.close();
        }
        return result;
    }

    public List<ModelCommercialService> selectAllServices()throws SQLException {
        
        List<ModelCommercialService> servico = null;
        
        try {

            conexao = Model.Connect.Connect.connect();

            rs = selectAll(conexao, pst);

            if (rs.next()) {
                
                servico = new ArrayList<>();

                while (rs.next()) {
                    servico.add(new ModelCommercialService(rs.getString(1),
                            rs.getDouble(2),
                            rs.getString(3),
                            rs.getString(4)));
                                
                }
            }
            
        } catch (SQLException t) {
            
            servico = null;
            
        }finally{
            conexao.close();
        }
        
        return servico;
    }

    public ModelCommercialService selectIdServices(int id) throws SQLException{
        
        ModelCommercialService modelCommercialServico = null;
        
        try {

            conexao = Model.Connect.Connect.connect();

            rs = selectId(conexao, pst, id);

            if (rs.next()) {
                
                 modelCommercialServico = new ModelCommercialService(
                        rs.getString(1), rs.getDouble(2), rs.getString(3), rs.getString(4));
                 
            }
            
        } catch (Exception t) {
            modelCommercialServico = null;
        }finally{
            conexao.close();
        
        }
        
        return modelCommercialServico;
        
    }

    public boolean deleteServices(int a)throws SQLException {
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
    
    public List<ModelCommercialService> selectNameServices(String nome) throws SQLException{
        
        List<ModelCommercialService> servico = null;
        
        try {

            conexao = Model.Connect.Connect.connect();

            rs = selectProduto(conexao, pst, nome);

            if (rs.next()) {
                
                servico = new ArrayList<>();

                while (rs.next()) {
                    
                    servico.add(new ModelCommercialService(rs.getString(1),
                            rs.getDouble(2),
                            rs.getString(3),
                            rs.getString(4)));
                }
            }
            
        } catch (SQLException t) {
            
             servico = null;
            
        }finally{
            conexao.close();
        }
        
        return servico;
    }
}
