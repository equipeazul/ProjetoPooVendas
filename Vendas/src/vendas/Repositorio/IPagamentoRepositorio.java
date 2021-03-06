/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.Repositorio;

import java.util.ArrayList;
import vendas.Excecoes.ExcecaoConexao;
import vendas.Excecoes.ExcecaoRepositorio;
import vendas.Entidades.*;

/**
 *
 * @author Felipe
 */
public interface IPagamentoRepositorio {
    public void incluir(Pagamento pagamento)throws ExcecaoRepositorio,ExcecaoConexao ;
    public void excluir(Integer id)throws ExcecaoRepositorio,ExcecaoConexao ;
    public void alterar(Pagamento pagamento)throws ExcecaoRepositorio,ExcecaoConexao ;
    public ArrayList<Pagamento> listar(Integer idPedido)throws ExcecaoRepositorio,ExcecaoConexao ;
    public Pagamento consultar(Integer idPagamento)throws ExcecaoRepositorio,ExcecaoConexao ; 
    public Boolean existe(Integer id) throws ExcecaoRepositorio, ExcecaoConexao;
    
}
