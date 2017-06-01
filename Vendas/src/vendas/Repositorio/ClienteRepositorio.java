/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.Repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import vendas.Conexao.Conexao;
import vendas.Conexao.IConexao;
import vendas.Excecoes.ExcecaoConexao;
import vendas.Excecoes.ExcecaoRepositorio;
import vendas.entidades.Cliente;

/**
 *
 * @author Felipe
 */
public class ClienteRepositorio implements IClienteRepositorio {

    @Override
    public void incluir(Cliente cliente) throws ExcecaoRepositorio, ExcecaoConexao {
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="INSERT INTO Clientes (nome, cpf) values (?,?);";
        
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getCpf()); 
            
            pstm.executeUpdate();
            
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.erroAoIncluirCliente);
        }finally{
            sqlConn.desconectar(conn);
        }     
    }

    @Override
    public void excluir(Integer id) throws ExcecaoRepositorio, ExcecaoConexao {
         IConexao sqlConn = Conexao.getInstancia();
           Connection conn = sqlConn.conectar();
           String sql ="DELETE FROM Clientes WHERE idCliente = ?";
           try{
               PreparedStatement pstm= conn.prepareStatement(sql);
               pstm.setInt(1, id);
               pstm.executeUpdate();
               
           }catch(SQLException e){
               throw new ExcecaoRepositorio(ExcecaoRepositorio.erroAoExcluirCliente);
           }finally{
               sqlConn.desconectar(conn);
           } 
    }

    @Override
    public void alterar(Cliente cliente) throws ExcecaoRepositorio, ExcecaoConexao {
          IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="UPDATE Clientes SET Nome = ?, Cpf = ?  WHERE idCliente = ? ";
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
                       
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getCpf()); 
            pstm.setInt(3, cliente.getIdCliente());
            
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.erroAoAlterarCliente);
        }finally{
            sqlConn.desconectar(conn);
        }
    }

    
    //Irá ser listado pela columa (cpf) do database.
    
    @Override
    public ArrayList<Cliente> listar(String nome) throws ExcecaoRepositorio, ExcecaoConexao {
           ArrayList<Cliente> lista;
        
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="SELECT * FROM Clientes ";
        
        if (!nome.equals("")) {
            sql = sql + " WHERE nome LIKE '%" + nome + "%'";
        }
             
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rset = pstm.executeQuery();
            
            lista = new ArrayList<Cliente>();
            
            while (rset.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rset.getInt("idCliente"));
                cliente.setNome(rset.getString("nome"));
                cliente.setCpf(rset.getString("cpf"));
                
                lista.add(cliente);
            }
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.erroAoConsultarCliente);
        }finally{
            sqlConn.desconectar(conn);
        }
        return lista;
    }

    @Override
    public Cliente consultar(Integer id) throws ExcecaoRepositorio, ExcecaoConexao {
        Cliente cliente = new Cliente();
        
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="SELECT * FROM Clientes WHERE idCliente = ? ";
        try{
            PreparedStatement pstm= conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rset = pstm.executeQuery();
            
            if (rset.next()) {
                cliente.setIdCliente(rset.getInt("idCliente"));
                cliente.setNome(rset.getString("nome"));
                cliente.setCpf(rset.getString("cpf"));
            }
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.erroAoConsultarCliente);
        }finally{
            sqlConn.desconectar(conn);
        }
        
        return cliente;
    }
    
    
    
}