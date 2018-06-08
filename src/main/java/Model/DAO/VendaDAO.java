/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Connect.Connect;
import Model.Entity.ItensVenda;
import Model.Entity.ModelCommercialProduct;
import Model.Entity.ModelCommercialService;
import Model.Entity.ServicosList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Entity.Venda;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author João
 */
public class VendaDAO {

    private Connection conexao;
    private PreparedStatement pst;
    private ResultSet rs;

    public boolean insert(Venda venda) throws SQLException {

        conexao = Connect.connect();
        boolean aux = false;
        try {

            String sql = "insert into venda(clienteID,dataCri,filialId, valorTotal) values (?,?,?,?)";

            pst = conexao.prepareStatement(sql);

            pst.setInt(1, venda.getIdcliente());
            Timestamp time = new Timestamp(System.currentTimeMillis());
            pst.setTimestamp(2, time);
            pst.setInt(3, venda.getFilialID());
            pst.setDouble(4, venda.getValorTotal());

            pst.execute();
            //conexao.close();

            sql = "select id from venda where dataCri = ?";

            pst = conexao.prepareStatement(sql);

            pst.setTimestamp(1, time);

            rs = pst.executeQuery();
            int id = 0;
            if (rs.next()) {
                id = rs.getInt("id");
            }
            //conexao.close();
            if (id > 0) {
                for (int i = 0; i < venda.getItens().size(); i++) {
                    sql = "insert into itensVenda(vendaId,prodId,quantidade,valorUni) values (?,?,?,?)";

                    pst = conexao.prepareStatement(sql);

                    pst.setInt(1, id);
                    pst.setInt(2, venda.getItens().get(i).getProduto().getId());
                    pst.setInt(3, venda.getItens().get(i).getQuantidade());
                    pst.setDouble(4, venda.getItens().get(i).getValorUni());

                    pst.execute();
                    
                    sql = "update produto set estoque = ? where id = ?";

                    pst = conexao.prepareStatement(sql);

                    pst.setInt(1, venda.getItens().get(i).getProduto().getQtdProd()-venda.getItens().get(i).getQuantidade());
                    pst.setInt(2, venda.getItens().get(i).getProduto().getId());

                    pst.execute();
                }

                for (int i = 0; i < venda.getServList().size(); i++) {
                    sql = "insert into itensServico(vendaId,servId,quantidade,valorUni) values (?,?,?,?)";

                    pst = conexao.prepareStatement(sql);

                    pst.setInt(1, id);
                    pst.setInt(2, venda.getServList().get(i).getServico().getId());
                    pst.setInt(3, venda.getServList().get(i).getQuantidade());
                    pst.setDouble(4, venda.getServList().get(i).getValorUni());

                    pst.execute();
                }

                aux = true;
            } else {
                aux = false;
            }

        } catch (SQLException e) {
            aux = false;
        } finally {
            conexao.close();
        }
        return aux;
    }

    public List<Venda> relatorio(int idFilial, Timestamp dataInit, Timestamp dataFim, String type) throws SQLException {

        List<Venda> vendas = new ArrayList<>();
        Venda venda = new Venda();
        conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("select * from venda");
            sql.append(" where (dataCri BETWEEN ? AND ?)");

            if (idFilial > 0) {
                sql.append(" AND filialID = ?");
            }

            pst = conexao.prepareStatement(sql.toString());

            pst.setTimestamp(1, dataInit);
            pst.setTimestamp(2, dataFim);

            if (idFilial > 0) {
                pst.setInt(3, idFilial);
            }

            rs = pst.executeQuery();

            while (rs.next()) {
                venda = new Venda(rs.getInt("id"),
                        rs.getInt("clienteId"),
                        rs.getTimestamp("dataCri"),
                        rs.getInt("filialId"));

                if (type.compareToIgnoreCase("produto") == 0
                        || type.compareToIgnoreCase("todos") == 0) {

                    ResultSet rs1;
                    Connection conexao1 = Connect.connect();;

                    sql = new StringBuilder();
                    sql.append("select * from itensVenda");
                    sql.append(" FULL JOIN produto ON itensVenda.prodId = produtos.id");
                    sql.append(" where vendaId = ?");

                    pst = conexao1.prepareStatement(sql.toString());

                    pst.setInt(1, rs.getInt("id"));

                    rs1 = pst.executeQuery();
                    List<ItensVenda> listItens = new ArrayList<>();
                    while (rs1.next()) {
                        ItensVenda itensVenda = new ItensVenda();
                        itensVenda.setQuantidade(rs.getInt("itensVenda.quantidade"));
                        itensVenda.setValorUni(rs.getDouble("itensVenda.valorUni"));
                        ModelCommercialProduct modelCommercialProduct = new ModelCommercialProduct(
                                rs1.getString("produto.nome"),
                                rs1.getDouble("itensVenda.valorUni"),
                                rs1.getInt("produto.filialId"),
                                rs1.getInt("produto.estoque"));
                        itensVenda.setProduto(modelCommercialProduct);

                        listItens.add(itensVenda);
                    }
                    venda.setItens(listItens);
                    conexao1.close();
                }
                if (type.compareToIgnoreCase("servico") == 0
                        || type.compareToIgnoreCase("todos") == 0) {

                    ResultSet rs2;
                    Connection conexao2 = Connect.connect();;

                    sql = new StringBuilder();
                    sql.append("select * from itensServico");
                    sql.append(" FULL JOIN servico ON itensServico.servId = servico.id");
                    sql.append(" where vendaId = ?");

                    pst = conexao2.prepareStatement(sql.toString());

                    pst.setInt(1, rs.getInt("id"));

                    rs2 = pst.executeQuery();
                    List<ServicosList> listServ = new ArrayList<>();
                    while (rs2.next()) {
                        ServicosList servicosList = new ServicosList();
                        servicosList.setQuantidade(rs.getInt("itensVenda.quantidade"));
                        servicosList.setValorUni(rs.getDouble("itensVenda.valorUni"));
                        ModelCommercialService modelCommercialService = new ModelCommercialService(
                                rs.getString("servico.pet"),
                                rs.getDouble("itensVenda.valorUni"),
                                rs.getString("servico.nome"),
                                rs.getInt("servico.filialId"));
                        servicosList.setServico(modelCommercialService);

                        listServ.add(servicosList);
                    }
                    venda.setServList(listServ);
                    conexao2.close();
                }
                vendas.add(venda);
            }

        } catch (SQLException e) {
            vendas = null;
        } finally {
            conexao.close();
        }
        return vendas;
    }
    /*
    public Venda selectId(Venda venda) {
        
        conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("select id,idservico,idcliente,dataCri");
            sql.append(" from venda where id = ? and ativo = true");

            pst = conexao.prepareStatement(sql.toString());
            
            pst.setInt(1, venda.getId());

            rs = pst.executeQuery();
            
            if(rs.next()){
                venda.setIdservico(rs.getInt(2));
                venda.setIdcliente(rs.getInt(3));
                venda.setDataCri(rs.getString(4));
            }

            return venda;
        } catch (SQLException e) {

            try {
                conexao.close();
            } catch (SQLException ex) {
            }
            
            return venda;
        }
    }
    
    public boolean update(Venda venda) {
         conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("update venda set idservico = ? , idcliente = ?");
            sql.append(" where id = ? and ativo = true");

            pst = conexao.prepareStatement(sql.toString());

            pst.setInt(1, venda.getIdservico());
            pst.setInt(2, venda.getIdcliente());
            pst.setInt(3, venda.getId());

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
     
    public boolean delete(Venda venda) {
         conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("update venda set ativo = false");
            sql.append(" where id = ?");

            pst = conexao.prepareStatement(sql.toString());
            
            pst.setInt(1, venda.getId());

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
    
    public boolean venda(Venda venda) {
     
        conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("select id,idservico,idcliente,dataCri");
            sql.append(" from venda where idservico = ? and dataCri = ? and ativo = true");

            pst = conexao.prepareStatement(sql.toString());
            
            pst.setInt(1, venda.getIdservico());
            pst.setString(2, venda.getDataCri());

            rs = pst.executeQuery();
            
            if(rs.next()){
                venda.setId(rs.getInt(1));
                venda.setIdcliente(rs.getInt(3));
            
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
    }*/

}
