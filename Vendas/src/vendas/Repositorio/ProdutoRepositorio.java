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
import vendas.Conexao.*;
import vendas.Excecoes.ExcecaoConexao;
import vendas.Excecoes.ExcecaoRepositorio;
import vendas.entidades.Produto;
/**
 *
 * @author Felipe
 */
public class ProdutoRepositorio implements IProdutoRepositorio {
    
    @Override
    public void incluir(Produto produto)throws ExcecaoRepositorio,ExcecaoConexao
    {       
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="INSERT INTO Produtos (descricao, unidade, precovenda, idfabricante) values (?,?,?,?);";
        
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, produto.getDescricao());
            pstm.setString(2, produto.getUnidade()); 
            pstm.setDouble(3, produto.getPrecovenda());
            pstm.setInt(4, produto.getFabricante().getIdFabricante()); 
            pstm.executeUpdate();
        }catch(SQLException e){
           throw new ExcecaoRepositorio(ExcecaoRepositorio.erroAoIncluirProduto);
        }finally{
            sqlConn.desconectar(conn);
        }
        
        
    }
    
    @Override
    public void excluir(Integer id)throws ExcecaoRepositorio,ExcecaoConexao
    {
        IConexao sqlConn = Conexao.getInstancia();
           Connection conn = sqlConn.conectar();
           String sql ="DELETE FROM produtos WHERE idProduto = ? ";
           try{
               PreparedStatement pstm= conn.prepareStatement(sql);
               pstm.setInt(1, id);
               pstm.executeUpdate();
           }catch(SQLException e){
               throw new ExcecaoRepositorio(ExcecaoRepositorio.erroAoExcluirProduto);
           }finally{
               sqlConn.desconectar(conn);
           }    
    
    }
    
    @Override
    public void alterar(Produto produto)throws ExcecaoRepositorio,ExcecaoConexao
    {
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="UPDATE produto SET descricao = ? , unidade = ?, precovenda = ?  WHERE idProduto = ? ";
        try{
            PreparedStatement pstm= conn.prepareStatement(sql);
            pstm.setString(1, produto.getDescricao());
            pstm.setString(2, produto.getUnidade()); 
            pstm.setDouble(3, produto.getPrecovenda()); 
            pstm.setDouble(4, produto.getIdproduto()); 
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.erroAoAlterarProduto);
        }finally{
            sqlConn.desconectar(conn);
        }
    }
    
    @Override
    public ArrayList<Produto> listar(String descricao)throws ExcecaoRepositorio,ExcecaoConexao
    {
        ArrayList<Produto> lista;
        
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="SELECT idProduto, descricao, unidade, precovenda, idfabricante FROM produto ";
        
        if (!descricao.equals("")) {
            sql = sql + " WHERE descricao LIKE '%" + descricao + "%'";
        }
             
        try{
            PreparedStatement pstm= conn.prepareStatement(sql);
            ResultSet rset = pstm.executeQuery();
            
            lista = new ArrayList<Produto>();
            while (rset.next()) {
                Produto produto;
                produto = new Produto();
                produto.setIdProduto(rset.getInt("idProduto"));
                produto.setDescricao(rset.getString("descricao"));
                produto.setUnidade(rset.getString("unidade"));
                produto.setPrecovenda(rset.getDouble("precovenda"));
                
                lista.add(produto);
            }
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.erroAoConsultarProduto);
        }finally{
            sqlConn.desconectar(conn);
        }
        
        return lista;
    }
    
    @Override
    public Produto consultar(Integer id)throws ExcecaoRepositorio,ExcecaoConexao
    {
        Produto produto = new Produto();
        
        IConexao sqlConn = Conexao.getInstancia();
        Connection conn = sqlConn.conectar();
        String sql ="SELECT idProduto, descricao, unidade, precovenda FROM Produto WHERE idProduto = ? ";
        try{
            PreparedStatement pstm= conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rset = pstm.executeQuery();
            
            if (rset.next()) {
                produto.setIdProduto(rset.getInt("idProduto"));
                produto.setDescricao(rset.getString("descricao"));
                produto.setUnidade(rset.getString("unidade"));
                produto.setPrecovenda(rset.getDouble("precovenda"));
            }
        }catch(SQLException e){
            throw new ExcecaoRepositorio(ExcecaoRepositorio.erroAoConsultarProduto);
        }finally{
            sqlConn.desconectar(conn);
        }
        
        return produto;
    }        
}
    
