/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;


import Model.Entity.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Connect.Connect;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author João
 */
public class ClienteDAO{
    
    private Connection conexao;
    private PreparedStatement pst;
    private ResultSet rs;
    
    
   
    public boolean insert(Cliente cliente) {

        conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("insert into cliente(nome,dataNasc,sexo,rg,cpf,endereco,dataCri)");
            sql.append(" values (?,?,?,?,?,?,date(now()))");

            pst = conexao.prepareStatement(sql.toString());

            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getDataNasc());
            pst.setString(3, cliente.getSexo());
            pst.setString(4, cliente.getRg());
            pst.setString(5, cliente.getCpf());
            
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
    
    public List<Cliente> selectAll() {

        ArrayList<Cliente> cliente = new ArrayList<>();
        
        conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("select id,nome,dataNasc,sexo,rg,cpf,endereco,dataCri");
            sql.append(" from cliente and ativo = true");

            pst = conexao.prepareStatement(sql.toString());

            rs = pst.executeQuery();
            
            while(rs.next()){
                cliente.add(new Cliente(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3), 
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(8)
                ));
            }

            return cliente;
        } catch (SQLException e) {

            try {
                conexao.close();
            } catch (SQLException ex) {
            }
            
            return cliente;
        }

    }
    
    public Cliente selectId(Cliente cliente) {
        
        conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("select id,nome,dataNasc,sexo,rg,cpf,endereco,dataCri");
            sql.append(" from cliente where id = ? and ativo = true");

            pst = conexao.prepareStatement(sql.toString());
            
            pst.setInt(1, cliente.getId());

            rs = pst.executeQuery();
            
            if(rs.next()){
                cliente.setNome(rs.getString(2));
                cliente.setDataNasc(rs.getString(3));
                cliente.setSexo(rs.getString(4));
                cliente.setRg(rs.getString(5));
                cliente.setCpf(rs.getString(6));
                cliente.setDataCri(rs.getString(8));
            }

            return cliente;
        } catch (SQLException e) {

            try {
                conexao.close();
            } catch (SQLException ex) {
            }
            
            return cliente;
        }
    }
    
    
    public boolean update(Cliente cliente) {
         conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("update cliente set nome = ? , dataNasc = ? , sexo = ? , rg = ? , cpf = ? , endereco = ?");
            sql.append(" where id = ? and ativo = true");

            pst = conexao.prepareStatement(sql.toString());

            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getDataNasc());
            pst.setString(3, cliente.getSexo());
            pst.setString(4, cliente.getRg());
            pst.setString(5, cliente.getCpf());
            pst.setInt(7, cliente.getId());

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
    
    
    public boolean delete(Cliente cliente) {
         conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("update cliente set ativo = false");
            sql.append(" where id = ?");

            pst = conexao.prepareStatement(sql.toString());
            
            pst.setInt(1, cliente.getId());

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
    
    public boolean cliente(Cliente cliente) {
     
        conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("select id,nome,dataNasc,sexo,rg,cpf,endereco,dataCri");
            sql.append(" from cliente where nome = ? and dataNasc = ? and sexo = ? and rg = ? and cpf = ? and ativo = true");

            pst = conexao.prepareStatement(sql.toString());
            
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getDataNasc());
            pst.setString(3, cliente.getSexo());
            pst.setString(4, cliente.getRg());
            pst.setString(5, cliente.getCpf());

            rs = pst.executeQuery();
            
            if(rs.next()){
                cliente.setId(rs.getInt(1));
                cliente.setDataCri(rs.getString(8));
            
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
