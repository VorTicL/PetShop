/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;


import Model.Connect.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Entity.Venda;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author João
 */
public class VendaDAO{
    
    private Connection conexao;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public boolean insert(Venda venda) {

        conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("insert into venda(idservico,idcliente,dataCri)");
            sql.append(" values (?,?,date(now()))");

            pst = conexao.prepareStatement(sql.toString());

            pst.setInt(1, venda.getIdservico());
            pst.setInt(2, venda.getIdcliente());
            

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
    public List<Venda> selectAll() {

        ArrayList<Venda> venda= new ArrayList<>();
        
        conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("select id,idservico,idcliente,dataCri");
            sql.append(" from venda and ativo = true");

            pst = conexao.prepareStatement(sql.toString());

            rs = pst.executeQuery();
            
            while(rs.next()){
                venda.add(new Venda(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3), 
                        rs.getString(4)));
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
    }


}
