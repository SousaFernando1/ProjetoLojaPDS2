package com.fernandoegustavo.projetolojamaven.controller;

import static com.fernandoegustavo.projetolojamaven.controller.ControllerCadCidade.codigo;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.fernandoegustavo.projetolojamaven.model.DAO.BairroDAO;
import com.fernandoegustavo.projetolojamaven.model.DAO.CidadeDAO;
import com.fernandoegustavo.projetolojamaven.model.DAO.EnderecoDAO;
import com.fernandoegustavo.projetolojamaven.model.bo.Cidade;
import com.fernandoegustavo.projetolojamaven.model.bo.Endereco;
import com.fernandoegustavo.projetolojamaven.model.bo.Fornecedor;
import com.fernandoegustavo.projetolojamaven.service.CidadeService;
import com.fernandoegustavo.projetolojamaven.service.FornecedorService;
import com.fernandoegustavo.projetolojamaven.view.ModeloCadastros;
import com.fernandoegustavo.projetolojamaven.view.TelaBusCidade;
import com.fernandoegustavo.projetolojamaven.view.TelaBusFoneFornecedor;
import com.fernandoegustavo.projetolojamaven.view.TelaBusFornecedor;
import com.fernandoegustavo.projetolojamaven.view.TelaCadFoneFornecedor;
import com.fernandoegustavo.projetolojamaven.view.TelaCadFornecedor;

public class ControllerCadFornecedor implements ActionListener {

    TelaCadFornecedor telaCadFornecedor;
    public static int codigo;

    public ControllerCadFornecedor(TelaCadFornecedor telaCadFornecedor) {
        this.telaCadFornecedor = telaCadFornecedor;

        telaCadFornecedor.getjButtonBuscar().addActionListener(this);
        telaCadFornecedor.getjButtonNovo().addActionListener(this);
        telaCadFornecedor.getjButtonCancelar().addActionListener(this);
        telaCadFornecedor.getjButtonGravar().addActionListener(this);
        telaCadFornecedor.getjButtonSair().addActionListener(this);
        telaCadFornecedor.getjComboBoxCidade().addActionListener(this);

        ativa(true);
        ligaDesliga(false);

    }

    public ControllerCadFornecedor(TelaCadFoneFornecedor TelaCadFoneFornecedor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Nesse método controlamos o que fazer quando uma ação acontece
    //Não foram desenvolvidas ainda as funcionalidades de persistência
    @Override
    public void actionPerformed(ActionEvent acao) {
	  if(acao.getSource() == telaCadFornecedor.getjComboBoxCidade()){
	    EnderecoDAO enderecoDAO = new EnderecoDAO();
	    CidadeDAO cidadeDAO = new CidadeDAO();
	    
//	    Cidade tempCidade = cidadeDAO.retrieve(telaCadFornecedor.getjComboBoxCidade().getSelectedItem().toString());

//          List<Cidade> cidadeList = cidadeDAO.retrieve();
//	  telaCadFornecedor.getjComboBoxCidade().removeAllItems();
//          for(Cidade item: cidadeList){
//	    telaCadFornecedor.getjComboBoxCidade().addItem(item);
//          }
//
//
//          List<Endereco> list = enderecoDAO.retrieve();
//	  telaCadFornecedor.getjComboBoxCEP().removeAllItems();
//          for(Endereco item: list){
//	    telaCadFornecedor.getjComboBoxCEP().addItem(item);
//          }
	  }
    
        if (acao.getSource() == telaCadFornecedor.getjButtonNovo()) {
            ativa(false);
            ligaDesliga(true);
	    this.telaCadFornecedor.getjTFIdFornecedor().setEnabled(false);
        } else if (acao.getSource() == telaCadFornecedor.getjButtonCancelar()) {
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadFornecedor.getjButtonGravar()) {

            Fornecedor fornecedor = new Fornecedor();
	    
	    EnderecoDAO enderecoDAO = new EnderecoDAO();

            fornecedor.setRazaoSocialFornecedor(this.telaCadFornecedor.getRazaoSocial().getText());
            fornecedor.setNome(this.telaCadFornecedor.getNomeFantasia().getText());
            fornecedor.setCnpjFornecedor(this.telaCadFornecedor.getCnpj().getText());
            fornecedor.setInscEstadualFornecedor(this.telaCadFornecedor.getInscEstadual().getText());
            fornecedor.setEmail(this.telaCadFornecedor.getEmail().getText());
            fornecedor.setCompleEndereco(this.telaCadFornecedor.getCompleEndereco().getText());
            fornecedor.setEndereco_idcep(enderecoDAO.retrieve(this.telaCadFornecedor.getjComboBoxCEP().getSelectedItem().toString()));
	    
	    fornecedor.setEndereco_idcep((Endereco) this.telaCadFornecedor.getjComboBoxCEP().getSelectedItem());


            FornecedorService fornecedorService = new FornecedorService();
            if (this.telaCadFornecedor.getjTFIdFornecedor().getText().trim().equalsIgnoreCase("")) {
                fornecedorService.salvar(fornecedor);
            } else {
                fornecedor.setIdfornecedor(Integer.parseInt(this.telaCadFornecedor.getjTFIdFornecedor().getText()));
                fornecedorService.atualizar(fornecedor);
            }
            
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadFornecedor.getjButtonBuscar()) {
            codigo = 0;
            //chamada da tela da busca
            TelaBusFornecedor telaBusFornecedor = new TelaBusFornecedor(null, true);
            ControllerBusFornecedor controllerBusFornecedor = new ControllerBusFornecedor(telaBusFornecedor);
            telaBusFornecedor.setVisible(true);
            System.out.println(codigo);
            
            if (codigo != 0) {
                Fornecedor fornecedor;
                FornecedorService fornecedorService = new FornecedorService();
                fornecedor = fornecedorService.buscar(codigo);

                ativa(false);
                ligaDesliga(true);

                this.telaCadFornecedor.getjTFIdFornecedor().setText(fornecedor.getIdfornecedor() + "");
                this.telaCadFornecedor.getRazaoSocial().setText(fornecedor.getRazaoSocialFornecedor());
                this.telaCadFornecedor.getNomeFantasia().setText(fornecedor.getNome());
                this.telaCadFornecedor.getCnpj().setText(fornecedor.getCnpjFornecedor());
                this.telaCadFornecedor.getInscEstadual().setText(fornecedor.getInscEstadualFornecedor());
                this.telaCadFornecedor.getEmail().setText(fornecedor.getEmail());
                this.telaCadFornecedor.getCompleEndereco().setText(fornecedor.getCompleEndereco());
                this.telaCadFornecedor.getjComboBoxCEP().setSelectedItem(fornecedor.getEndereco_idcep());

                this.telaCadFornecedor.getjTFIdFornecedor().setEnabled(false);
            }
        } else if (acao.getSource() == telaCadFornecedor.getjButtonSair()) {
	    this.telaCadFornecedor.dispose();
        }
    }

    //Método para habilitar/desabilitar botões(controle de estados)
    public void ativa(boolean estado) {
        telaCadFornecedor.getjButtonNovo().setEnabled(estado);
        telaCadFornecedor.getjButtonCancelar().setEnabled(!estado);
        telaCadFornecedor.getjButtonGravar().setEnabled(!estado);
        telaCadFornecedor.getjButtonBuscar().setEnabled(estado);
        telaCadFornecedor.getjButtonSair().setEnabled(estado);
    }

    //Método para Ativação/Desativação/Limpeza ds 
    //Componentes do jPanelDados
    public void ligaDesliga(boolean estado) {
        Component[] componentes = this.telaCadFornecedor.getjPanelDados().getComponents();
        for (Component componenteAtual : componentes) {
            if (componenteAtual instanceof JTextField) {
                ((JTextField) componenteAtual).setText("");
                componenteAtual.setEnabled(estado);
            } else if (componenteAtual instanceof JFormattedTextField) {
                ((JFormattedTextField) componenteAtual).setText("");
                componenteAtual.setEnabled(estado);
            } else if (componenteAtual instanceof JComboBox) {
                ((JComboBox) componenteAtual).setSelectedIndex(0);
                componenteAtual.setEnabled(estado);
            }
        }
    }
}
