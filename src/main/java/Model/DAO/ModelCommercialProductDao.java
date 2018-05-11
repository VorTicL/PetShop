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
public class ModelCommercialProductDao extends ModelCommercialProductSQL {

    private Connection conexao; 
    private PreparedStatement pst; 
    private ResultSet rs; 

    public int insert(ModelCommercialProduct produto) {

        try {
            conexao = Model.Connect.Connect.connect();

            int id = insert(conexao, pst, produto);

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

    public boolean update(ModelCommercialProduct produto) {
        try {
            conexao = Model.Connect.Connect.connect();

            update(conexao, pst, produto);

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

    public List<ModelCommercialProduct> selectAll() {
        try {
            List<ModelCommercialProduct> produto = null;

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
            conexao.close();

            return produto;
        } catch (SQLException t) {

            try {
                conexao.close();
            } catch (SQLException ex) {
            }
            return null;
        }
    }

    public ModelCommercialProduct selectId( ModelCommercialProduct produto) {
        try {

            conexao = Model.Connect.Connect.connect();

            rs = selectId(conexao, pst, produto);

            if (rs.next()) {
                
                ModelCommercialProduct modelCommercialProduct = new ModelCommercialProduct(
                        rs.getString(1), rs.getDouble(2), rs.getString(3), rs.getInt(4));
                ;
                /*return new ModelCommercialProduct(,
                            ,
                            ,s
                            );*/
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

    public boolean delete(ModelCommercialProduct produto) {
        try {
            conexao = Model.Connect.Connect.connect();

            delete(conexao, pst, produto);

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
