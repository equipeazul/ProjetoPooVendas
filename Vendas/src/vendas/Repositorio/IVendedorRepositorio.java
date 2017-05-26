/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.Repositorio;

/**
 *
 * @author aluno
 */
import java.util.ArrayList;
import vendas.Excecoes.ExcecaoRepositorio;
import vendas.Excecoes.ExcecaoConexao;
import vendas.entidades.Vendedor;

public interface IVendedorRepositorio {
    
    public void incluir(Vendedor vendedor)throws ExcecaoRepositorio,ExcecaoConexao ;
    public void excluir(Integer id)throws ExcecaoRepositorio,ExcecaoConexao ;
    public void alterar(Vendedor vendedor)throws ExcecaoRepositorio,ExcecaoConexao ;
    public ArrayList<Vendedor> listar(String nome)throws ExcecaoRepositorio,ExcecaoConexao ;
    public Vendedor consultar(Integer id)throws ExcecaoRepositorio,ExcecaoConexao ;
}
