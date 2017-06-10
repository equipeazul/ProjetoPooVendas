/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.Gui;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import vendas.Excecoes.ExcecaoConexao;
import vendas.Excecoes.ExcecaoRegras;
import vendas.Excecoes.ExcecaoRepositorio;
import vendas.Repositorio.ClienteRepositorio;
import vendas.Repositorio.IClienteRepositorio;
import vendas.entidades.Cliente;
import vendas.entidades.Produto;
import vendas.fachada.Fachada;

/**
 *
 * @author Felipe
 */
public class ProdutoCadastro extends TelaCadastro {

    private static TelaCadastro instancia;
    protected static java.awt.Component componente;
    
    
    private final String DESEJA_EXCLUIR = "Deseja excluir o Produto ?";
    private final String ATENCAO = "Atenção";
    
    private final String FOI_EXCLUSO = "Produto foi excluso";
    private final String FOI_CADASTRADO = "Produto foi cadastrado";
    private final String FOI_ALTERADO = "Produto foi alterado";
    private final String DIGITE_ID = "Digite o ID do Produto";
    private final String VALOR_ID_INVALIDO = "ID do Produto é invalido";
    
    
    /**
     * Creates new form IFrameProdutos
     */
    private ProdutoCadastro(){
        initComponents();
        configurar(CONSULTA);
    }
    
    public void fechar() {
        componente = null;
        this.dispose();
    }

    public static TelaCadastro abrir(javax.swing.JDesktopPane principal) {
        if (componente == null) {
            instancia = new ProdutoCadastro();
            componente = principal.add(instancia);
        }
        instancia.show(800, 450);
        return instancia;
    }
    
    private void configurar(String ac) {
        
        if(ac.equals(CONSULTA)){
            try
            {
                
                Integer id = 0;
                
                //Criar DAO
                Fachada fachada = Fachada.getInstancia();

                if (txtID.getText().equals(VAZIO)) {
                    id = fachada.ultimoProduto();
                    
                }
                else
                {
                    id = Integer.parseInt(txtID.getText());
                }
                
                //Criar Objeto Basico
                Produto produto = new Produto();
                
                if (id != 0) {
                    
                    produto = fachada.consultarProduto(id);
                    if(produto != null)
                    {
                       txtDescricao.setText(produto.getDescricao());  
                       txtID.setText(produto.getIdproduto().toString());
                       txtUnidade.setText(produto.getUnidade()); 
                       txtIdFabricante.setText(produto.getFabricante().getIdFabricante().toString());
                       txtPrecoVenda.setText(String.valueOf(produto.getPrecoVenda()));
                    }
                }
                  
            }catch(ExcecaoRegras ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
            }
           
        }
        
        if (ac.equals(INCLUSAO)){
           // Limpando os campos
            txtID.setText(VAZIO);
        }
        
        if (txtID.getText().equals(VAZIO)){
            txtDescricao.setText(VAZIO);
            txtUnidade.setText(VAZIO);
            txtIdFabricante.setText(VAZIO);
            txtPrecoVenda.setText(VAZIO);
        }
        
        btnIncluir.setEnabled(ac.equals(CONSULTA));
        btnEditar.setEnabled(ac.equals(CONSULTA) && !txtID.getText().equals(VAZIO));
        btnExcluir.setEnabled(ac.equals(CONSULTA) && !txtID.getText().equals(VAZIO));
        btnSalvar.setEnabled(!ac.equals(CONSULTA));
        btnCancelar.setEnabled(!ac.equals(CONSULTA));
        btnIrPara.setEnabled(ac.equals(CONSULTA));
        btnPesquisar.setEnabled(ac.equals(CONSULTA));
        
        txtDescricao.setEnabled(!ac.equals(CONSULTA));
        txtUnidade.setEnabled(!ac.equals(CONSULTA));
        txtIdFabricante.setEnabled(!ac.equals(CONSULTA));
        txtPrecoVenda.setEnabled(!ac.equals(CONSULTA));
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        btnIncluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnIrPara = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtUnidade = new javax.swing.JTextField();
        txtIdFabricante = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPrecoVenda = new javax.swing.JTextField();
        txtNomeFabricante = new javax.swing.JTextField();

        btnIncluir.setText("Incluir");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnIrPara.setText("Ir para");
        btnIrPara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrParaActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cadastro de produtos");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setText("ID");

        txtID.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setText("Descricição");

        txtDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescricaoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setText("Unidade");

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel6.setText("Fabricante");

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel7.setText("Preço de venda");

        txtNomeFabricante.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(txtUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(25, 25, 25)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtIdFabricante))
                            .addGap(18, 18, 18)
                            .addComponent(txtNomeFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(txtPrecoVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addGap(401, 401, 401))))
                .addContainerGap(295, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(252, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnIrPara, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIrPara)
                    .addComponent(btnPesquisar))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(374, 374, 374))
        );
        jDesktopPane1.setLayer(btnIncluir, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnEditar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnExcluir, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnSalvar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnCancelar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnIrPara, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnPesquisar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescricaoActionPerformed

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        configurar(INCLUSAO);
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        Integer dialogButton = JOptionPane.YES_NO_OPTION;
        JOptionPane.showConfirmDialog(null, DESEJA_EXCLUIR,ATENCAO,dialogButton);
       
        Produto produto = new Produto();
        produto.setIdProduto(Integer.parseInt(txtID.getText()));
        produto.setDescricao(txtDescricao.getText());
        produto.setUnidade(txtUnidade.getText());
        produto.setPrecoVenda(Double.parseDouble(txtPrecoVenda.getText()));
        
         Fachada fachada = Fachada.getInstancia();
        if(dialogButton == JOptionPane.YES_OPTION){
          try{  
               fachada.excluirProduto(produto);
           
            txtID.setText(VAZIO);
            configurar(CONSULTA);            
            JOptionPane.showMessageDialog(null, FOI_EXCLUSO);
          }catch(ExcecaoRegras ex){
               JOptionPane.showMessageDialog(null,ex.getMessage());
          }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed
    
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        configurar(ALTERACAO);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
    
        Produto produto = new Produto();
        produto.setDescricao(txtDescricao.getText());
        produto.setUnidade(txtUnidade.getText()); 
        produto.setPrecoVenda(Double.parseDouble(txtPrecoVenda.getText()));
        produto.getFabricante().setIdFabricante(Integer.parseInt(txtIdFabricante.getText()));
        
        
        Fachada fachada = Fachada.getInstancia();
              
        try{
            if (txtID.getText().equals(VAZIO)){
                fachada.incluirProduto(produto);
               JOptionPane.showMessageDialog(null, FOI_CADASTRADO);

            
            }else{
                produto.setIdProduto(Integer.parseInt(txtID.getText()));
                fachada.alterarProduto(produto);
                JOptionPane.showMessageDialog(null, FOI_ALTERADO);
            }
        }catch(ExcecaoRegras ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        configurar(CONSULTA);
         
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        configurar(CONSULTA);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnIrParaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrParaActionPerformed
        
        Fachada fachada = Fachada.getInstancia();
        
        try
        {
            Integer id = Integer.parseInt(JOptionPane.showInputDialog(null, DIGITE_ID));
            
            fachada.consultarCliente(id);
            txtID.setText(id.toString());
            configurar(CONSULTA);
        } catch (ExcecaoRegras ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, VALOR_ID_INVALIDO);
        }
        
    }//GEN-LAST:event_btnIrParaActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
       //
    }//GEN-LAST:event_btnPesquisarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnIrPara;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIdFabricante;
    private javax.swing.JTextField txtNomeFabricante;
    private javax.swing.JTextField txtPrecoVenda;
    private javax.swing.JTextField txtUnidade;
    // End of variables declaration//GEN-END:variables
}
