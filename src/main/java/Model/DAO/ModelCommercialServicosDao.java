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
public class ModelCommercialServicosDao extends ModelCommercialServiceSQL {

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

        } finally {

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

        } finally {
            conexao.close();
        }
        return result;
    }

    public List<ModelCommercialService> selectAllServices() throws SQLException {

        List<ModelCommercialService> servico = new ArrayList<>();

        try {

            conexao = Model.Connect.Connect.connect();

            rs = selectAll(conexao, pst);

            while (rs.next()) {
                ModelCommercialService modelCommercialService = new ModelCommercialService(rs.getString("pet"),
                        rs.getDouble("preco"),
                        rs.getString("nome"),
                        rs.getInt("filialId"));
                modelCommercialService.setId(rs.getInt("id"));
                servico.add(modelCommercialService);

            }

        } catch (SQLException t) {

            servico = null;

        } finally {
            conexao.close();
        }

        return servico;
    }

    public ModelCommercialService selectIdServices(int id) throws SQLException {

        ModelCommercialService modelCommercialService = new ModelCommercialService();

        try {

            conexao = Model.Connect.Connect.connect();

            rs = selectId(conexao, pst, id);

            if (rs.next()) {
                modelCommercialService = new ModelCommercialService(rs.getString("pet"),
                        rs.getDouble("preco"),
                        rs.getString("nome"),
                        rs.getInt("filialId"));
                modelCommercialService.setId(rs.getInt("id"));

            }

        } catch (Exception t) {
            modelCommercialService = null;
        } finally {
            conexao.close();
        }

        return modelCommercialService;

    }

    public boolean deleteServices(int a) throws SQLException {
        boolean aux = false;
        try {
            conexao = Model.Connect.Connect.connect();

            delete(conexao, pst, a);

            conexao.close();

            aux = true;
        } catch (SQLException t) {

            aux = false;

        } finally {

            conexao.close();
        }
        return aux;
    }

    public List<ModelCommercialService> selectNameServices(String nome) throws SQLException {

        List<ModelCommercialService> servico = null;
        
        try {

            conexao = Model.Connect.Connect.connect();

            rs = selectProduto(conexao, pst, nome);

            while (rs.next()) {
                ModelCommercialService modelCommercialService = new ModelCommercialService(rs.getString("pet"),
                        rs.getDouble("preco"),
                        rs.getString("nome"),
                        rs.getInt("filialId"));
                modelCommercialService.setId(rs.getInt("id"));
                servico.add(modelCommercialService);
            }

        } catch (SQLException t) {

            servico = null;

        } finally {
            conexao.close();
        }

        return servico;
    }
}
