/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernandoegustavo.projetolojamaven.view;

import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.fernandoegustavo.projetolojamaven.model.DAO.BairroDAO;
import com.fernandoegustavo.projetolojamaven.model.DAO.CidadeDAO;
import com.fernandoegustavo.projetolojamaven.model.DAO.EnderecoDAO;
import com.fernandoegustavo.projetolojamaven.model.bo.Cidade;
import com.fernandoegustavo.projetolojamaven.model.bo.Bairro;
import com.fernandoegustavo.projetolojamaven.model.bo.Endereco;


/**
 *
 * @author house
 */
public class TelaCadCliente extends javax.swing.JFrame {

    /**
     * Creates new form FormModeloCadastros
     */
    public TelaCadCliente() {


        initComponents();
	carregarComboEndereco();
//	carregarComboBairro();

    }

  public void carregarComboEndereco(){

          EnderecoDAO enderecoDAO = new EnderecoDAO();
          List<Endereco> enderecoList = enderecoDAO.retrieve();
          for(Endereco item: enderecoList){
	    jComboBoxCep.addItem(item);
          }

    }     

//	public void carregarComboBairro(){
//	  String cidadeAtual = jComboBoxCidade.getSelectedItem().toString();
//	  
//          BairroDAO bairroDAO = new BairroDAO();
//          List<Bairro> list = bairroDAO.retrieveDesc(cidadeAtual);
//          for(Bairro item: list){
//	    jComboBoxBairro.addItem(item.getDescricaoBairro());
//          }
//    }      

    public JTextField getjTFIdCliente() {
        return jTFIdCliente;
    }

    public void setjTFIdCliente(JTextField jTFIdCliente) {
        this.jTFIdCliente = jTFIdCliente;
    }
        
    public JPanel getjPanelDados() {
        return jPanelDados;
    }

    public JLabel getjLabel1() {
	return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
	this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel10() {
	return jLabel10;
    }

    public void setjLabel10(JLabel jLabel10) {
	this.jLabel10 = jLabel10;
    }

    public JLabel getjLabel2() {
	return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
	this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
	return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
	this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel4() {
	return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
	this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel5() {
	return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
	this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
	return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
	this.jLabel6 = jLabel6;
    }

    public JLabel getjLabel8() {
	return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
	this.jLabel8 = jLabel8;
    }

    public JLabel getjLabelTitulo() {
	return jLabelTitulo;
    }

    public void setjLabelTitulo(JLabel jLabelTitulo) {
	this.jLabelTitulo = jLabelTitulo;
    }

    public JPanel getjPanelBotoes() {
	return jPanelBotoes;
    }

    public void setjPanelBotoes(JPanel jPanelBotoes) {
	this.jPanelBotoes = jPanelBotoes;
    }

    public JPanel getjPanelTitulo() {
	return jPanelTitulo;
    }

    public void setjPanelTitulo(JPanel jPanelTitulo) {
	this.jPanelTitulo = jPanelTitulo;
    }

    public JTextField getNome() {
	return Nome;
    }

    public void setNome(JTextField Nome) {
	this.Nome = Nome;
    }

    public JTextField getCompEndereco() {
	return compEndereco;
    }

    public void setCompEndereco(JTextField compEndereco) {
	this.compEndereco = compEndereco;
    }

    public JTextField getCpf() {
	return cpf;
    }

    public void setCpf(JTextField cpf) {
	this.cpf = cpf;
    }

    public JTextField getDtNascimento() {
	return dtNascimento;
    }

    public void setDtNascimento(JTextField dtNascimento) {
	this.dtNascimento = dtNascimento;
    }

    public JTextField getEmail() {
	return email;
    }

    public void setEmail(JTextField email) {
	this.email = email;
    }

    public JTextField getFone() {
	return fone;
    }

    public void setFone(JTextField fone) {
	this.fone = fone;
    }

//    public JComboBox<String> getjComboBoxBairro() {
//	return jComboBoxCep;
//    }
//
//    public void setjComboBoxBairro(JComboBox<String> jComboBoxBairro) {
//	this.jComboBoxCep = jComboBoxBairro;
//    }
//
//    public JComboBox<String> getjComboBoxCidade() {
//	return jComboBoxCidade;
//    }
//
//    public void setjComboBoxCidade(JComboBox<String> jComboBoxCidade) {
//	this.jComboBoxCidade = jComboBoxCidade;
//    }

    public JTextField getRg() {
	return rg;
    }

    public void setRg(JTextField rg) {
	this.rg = rg;
    }

    public JComboBox<Endereco> getjComboBoxCep() {
        return jComboBoxCep;
    }

    public void setjComboBoxCep(JComboBox<Endereco> jComboBoxCep) {
        this.jComboBoxCep = jComboBoxCep;
    }
    
    



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTitulo = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jPanelDados = new javax.swing.JPanel();
        Nome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rg = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dtNascimento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        compEndereco = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxCep = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cpf = new javax.swing.JTextField();
        jTFIdCliente = new javax.swing.JTextField();
        jLId = new javax.swing.JLabel();
        jPanelBotoes = new javax.swing.JPanel();
        jButtonNovo = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonGravar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Cliente");
        setResizable(false);

        jPanelTitulo.setBackground(new java.awt.Color(204, 255, 0));
        jPanelTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelTitulo.setPreferredSize(new java.awt.Dimension(533, 75));

        jLabelTitulo.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(51, 0, 153));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Cliente");

        javax.swing.GroupLayout jPanelTituloLayout = new javax.swing.GroupLayout(jPanelTitulo);
        jPanelTitulo.setLayout(jPanelTituloLayout);
        jPanelTituloLayout.setHorizontalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
        );
        jPanelTituloLayout.setVerticalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelTitulo, java.awt.BorderLayout.NORTH);

        jPanelDados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome:");

        jLabel2.setText("RG:");

        jLabel3.setText("Data de Nascimento");

        jLabel4.setText("E-mail:");

        jLabel5.setText("CPF:");

        jLabel6.setText("Comp. Endereço:");

        jLabel8.setText("Cep:");

        jComboBoxCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCepActionPerformed(evt);
            }
        });

        jLabel10.setText("Fone:");

        jTFIdCliente.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLId.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLId.setText("ID:");

        javax.swing.GroupLayout jPanelDadosLayout = new javax.swing.GroupLayout(jPanelDados);
        jPanelDados.setLayout(jPanelDadosLayout);
        jPanelDadosLayout.setHorizontalGroup(
            jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(compEndereco))
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanelDadosLayout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(10, 10, 10)
                                    .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanelDadosLayout.createSequentialGroup()
                                            .addGap(246, 246, 246)
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jComboBoxCep, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGroup(jPanelDadosLayout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Nome))
                                .addGroup(jPanelDadosLayout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(cpf)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(fone))
                                .addGroup(jPanelDadosLayout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(dtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(rg)))
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addComponent(jLId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 24, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelDadosLayout.setVerticalGroup(
            jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLId))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(rg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBoxCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(compEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelDados, java.awt.BorderLayout.CENTER);

        jPanelBotoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelBotoes.setPreferredSize(new java.awt.Dimension(533, 50));

        jButtonNovo.setText("Novo");
        jButtonNovo.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanelBotoes.add(jButtonNovo);

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanelBotoes.add(jButtonCancelar);

        jButtonGravar.setText("Gravar");
        jButtonGravar.setEnabled(false);
        jButtonGravar.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanelBotoes.add(jButtonGravar);

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanelBotoes.add(jButtonBuscar);

        jButtonSair.setText("Sair");
        jButtonSair.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanelBotoes.add(jButtonSair);

        getContentPane().add(jPanelBotoes, java.awt.BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeActionPerformed

    private void jComboBoxCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCepActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Nome;
    private javax.swing.JTextField compEndereco;
    private javax.swing.JTextField cpf;
    private javax.swing.JTextField dtNascimento;
    private javax.swing.JTextField email;
    private javax.swing.JTextField fone;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JComboBox<Endereco> jComboBoxCep;
    private javax.swing.JLabel jLId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelBotoes;
    private javax.swing.JPanel jPanelDados;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JTextField jTFIdCliente;
    private javax.swing.JTextField rg;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton getjButtonBuscar() {
        return jButtonBuscar;
    }

    public javax.swing.JButton getjButtonCancelar() {
        return jButtonCancelar;
    }

    public javax.swing.JButton getjButtonGravar() {
        return jButtonGravar;
    }

    public javax.swing.JButton getjButtonNovo() {
        return jButtonNovo;
    }

    public javax.swing.JButton getjButtonSair() {
        return jButtonSair;
    }
}
