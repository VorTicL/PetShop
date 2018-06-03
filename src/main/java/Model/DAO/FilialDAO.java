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
import Model.Entity.Filial;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author João
 */
public class FilialDAO{
    
    private Connection conexao;
    private PreparedStatement pst;
    private ResultSet rs;
    
    /*public boolean insert(Cliente cliente) throws SQLException {
        boolean aux = false;
        conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("insert into cliente(nome,dataNasc,sexo,rg,cpf,endereco,dataCri) values (?,?,?,?,?,?,?)");

            pst = conexao.prepareStatement(sql.toString());

            pst.setString(1, cliente.getNome());
            pst.setTimestamp(2, cliente.getDataNasc());
            pst.setString(3, cliente.getSexo());
            pst.setString(4, cliente.getRg());
            pst.setString(5, cliente.getCpf());
            pst.setString(6, cliente.getEndereco());
            pst.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            pst.execute();

            aux = true;
        } catch (SQLException e) {
            aux = false;
        }finally{
            conexao.close();
        }
        return aux;
    }*/
    
    public Map<Integer, Filial> selectAll() throws SQLException {

        Map<Integer, Filial> filial = new HashMap<>();
        
        conexao = Connect.connect();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("select * from filial");

            pst = conexao.prepareStatement(sql.toString());

            rs = pst.executeQuery();
            
            while(rs.next()){
                Filial fili = new Filial(rs.getInt("idFilial"), rs.getString("nome"), 
                        rs.getTimestamp("dataCri"), rs.getString("endereco"), rs.getInt("numeroEnd"));
                
                filial.put(rs.getInt("idFilial"), fili);
            }
            
        } catch (SQLException e) {
            filial = null;
        }finally{
            conexao.close();
        }
        return filial;
    }
    
    public Filial selectId(int id) throws SQLException {
        
        conexao = Connect.connect();
        Filial fili = new Filial();
        
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("select * from cliente where idFilial = ?");

            pst = conexao.prepareStatement(sql.toString());
            
            pst.setInt(1, id);

            rs = pst.executeQuery();
            
            if(rs.next()){
                fili = new Filial(rs.getInt("idFilial"), rs.getString("nome"), 
                        rs.getTimestamp("dataCri"), rs.getString("endereco"), rs.getInt("numeroEnd"));
            }
        } catch (SQLException e) {
            fili = null;
        }finally{
            conexao.close();
        }
        return fili;
    }
    
    
    /*public boolean update(Cliente cliente) throws SQLException {
         conexao = Connect.connect();
         boolean aux = false;
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("update cliente set nome = ? , dataNasc = ? "
                    + ", sexo = ? , rg = ? , cpf = ? , endereco = ?, dataCri = ?");
            sql.append(" where id = ? and ativo = 1");

            pst = conexao.prepareStatement(sql.toString());

            pst.setString(1, cliente.getNome());
            pst.setTimestamp(2, cliente.getDataNasc());
            pst.setString(3, cliente.getSexo());
            pst.setString(4, cliente.getRg());
            pst.setString(5, cliente.getCpf());
            pst.setString(6, cliente.getEndereco());
            pst.setTimestamp(7, cliente.getDataCri());
            pst.setInt(8, cliente.getId());

            pst.executeUpdate();

            aux = true;
        } catch (SQLException e) {
            aux = false;
        }finally{
            conexao.close();
        }
        return aux;
    }*/
    
    
    /*public boolean delete(int id) throws SQLException {
         conexao = Connect.connect();
         boolean aux = false;
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("update cliente set ativo = false");
            sql.append(" where id = ?");

            pst = conexao.prepareStatement(sql.toString());
            
            pst.setInt(1, id);

            pst.execute();

            aux = true;
        } catch (SQLException e) {
            aux = false;
        }finally{
            conexao.close();
        }
        return aux;
    }*/
    
    /*public List<Cliente> buscaNome(String nome) throws SQLException {
        Cliente cli = new Cliente();
        conexao = Connect.connect();
        List<Cliente> listCliente = new ArrayList<>();
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("select * from cliente "
                    + "where nome like ? and ativo = 1");

            pst = conexao.prepareStatement(sql.toString());
            
            pst.setString(1, nome);

            rs = pst.executeQuery();
            
            while(rs.next()){
                cli.setNome(rs.getString("nome"));
                cli.setDataNasc(rs.getTimestamp("dataNasc"));
                cli.setSexo(rs.getString("sexo"));
                cli.setRg(rs.getString("rg"));
                cli.setCpf(rs.getString("cpf"));
                cli.setDataCri(rs.getTimestamp("dataCri"));
                cli.setEndereco(rs.getString("endereco"));
                cli.setId(rs.getInt("id"));
                listCliente.add(cli);
            }
            
        } catch (SQLException e) {
            listCliente = null;
        }finally{
            conexao.close();
        }
        return listCliente;
    }*/
}
