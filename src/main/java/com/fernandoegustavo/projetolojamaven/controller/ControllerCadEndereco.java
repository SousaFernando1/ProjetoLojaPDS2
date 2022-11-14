package com.fernandoegustavo.projetolojamaven.controller;

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
import com.fernandoegustavo.projetolojamaven.model.bo.Bairro;
import com.fernandoegustavo.projetolojamaven.model.bo.Cidade;
import com.fernandoegustavo.projetolojamaven.model.bo.Endereco;
import com.fernandoegustavo.projetolojamaven.service.BairroService;
import com.fernandoegustavo.projetolojamaven.service.EnderecoService;
import com.fernandoegustavo.projetolojamaven.view.ModeloCadastros;
import com.fernandoegustavo.projetolojamaven.view.TelaBusBairro;
import com.fernandoegustavo.projetolojamaven.view.TelaBusEndereco;
import com.fernandoegustavo.projetolojamaven.view.TelaCadBairro;
import com.fernandoegustavo.projetolojamaven.view.TelaCadEndereco;

public class ControllerCadEndereco implements ActionListener {

    TelaCadEndereco telaCadEndereco;
    public static int codigo;

    public ControllerCadEndereco(TelaCadEndereco telaCadEndereco) {
        this.telaCadEndereco = telaCadEndereco;


        telaCadEndereco.getjButtonBuscar().addActionListener(this);
        telaCadEndereco.getjButtonNovo().addActionListener(this);
        telaCadEndereco.getjButtonCancelar().addActionListener(this);
        telaCadEndereco.getjButtonGravar().addActionListener(this);
        telaCadEndereco.getjButtonSair().addActionListener(this);
        telaCadEndereco.getjComboBoxCidade().addActionListener(this);

        ativa(true);
        ligaDesliga(false);

    
    }        

    //Nesse método controlamos o que fazer quando uma ação acontece
    //Não foram desenvolvidas ainda as funcionalidades de persistência
    @Override
    public void actionPerformed(ActionEvent acao) {
		if(acao.getSource() == telaCadEndereco.getjComboBoxCidade()){
	  BairroDAO bairroDAO = new BairroDAO();
	    CidadeDAO cidadeDAO = new CidadeDAO();

//
//          List<Bairro> list = bairroDAO.retrieve();
//	  telaCadEndereco.getjComboBoxBairro().removeAllItems();
//          for(Bairro item: list){
//	    telaCadEndereco.getjComboBoxBairro().addItem(item());
//          }

//	    System.out.println(telaCadCliente.getjComboBoxCidade().getSelectedItem().toString());
	}
        if (acao.getSource() == telaCadEndereco.getjButtonNovo()) {
            ativa(false);
            ligaDesliga(true);
	    this.telaCadEndereco.getjTFIdCidade().setEnabled(false);
        } else if (acao.getSource() == telaCadEndereco.getjButtonCancelar()) {
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadEndereco.getjButtonGravar()) {
            Endereco endereco = new Endereco();

//            cidade.setUfCidade(this.telaCadCidade.getjTFUF().getText());

	    endereco.setCepCep(this.telaCadEndereco.getjTFCEP().getText());
	    endereco.setLogradouroCep(this.telaCadEndereco.getjTFLogradouro().getText());

	    Bairro bairro = new Bairro();


	    String tempString, tempString2;

//            tempString = this.telaCadEndereco.getjComboBoxBairro().getSelectedItem().toString();
//	    BairroDAO bairroDAO = new BairroDAO();
	    endereco.setBairro((Bairro) this.telaCadEndereco.getjComboBoxBairro().getSelectedItem());
//
//
//	    tempString2 = this.telaCadEndereco.getjComboBoxCidade().getSelectedItem().toString();
//	    CidadeDAO cidadeDAO = new CidadeDAO();
	    endereco.setCidade((Cidade) this.telaCadEndereco.getjComboBoxCidade().getSelectedItem());

            EnderecoService enderecoService = new EnderecoService();
           
            if (this.telaCadEndereco.getjTFIdCidade().getText().trim().equalsIgnoreCase("")) {
                enderecoService.salvar(endereco);
            } else {
                endereco.setIdCep(Integer.parseInt(this.telaCadEndereco.getjTFIdCidade().getText()));
                enderecoService.atualizar(endereco);
            }

            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadEndereco.getjButtonBuscar()) {
	    codigo = 0;
            //chamada da tela da busca
            TelaBusEndereco telaBusEndereco = new TelaBusEndereco(null, true);
            ControllerBusEndereco controllerBusEndereco = new ControllerBusEndereco(telaBusEndereco);
            telaBusEndereco.setVisible(true);

            if (codigo !=0) {
                Endereco endereco;
                EnderecoService enderecoService = new EnderecoService();
                endereco = enderecoService.buscar(codigo);

                ativa(false);
                ligaDesliga(true);

                this.telaCadEndereco.getjTFIdCidade().setText(endereco.getIdCep()+ "");
                this.telaCadEndereco.getjTFNomeBairro().setText(endereco.getCepCep());

                this.telaCadEndereco.getjTFIdCidade().setEnabled(false);
            }
        } else if (acao.getSource() == telaCadEndereco.getjButtonSair()) {
	    this.telaCadEndereco.dispose();
        }
    }

    //Método para habilitar/desabilitar botões(controle de estados)
    public void ativa(boolean estado) {
        telaCadEndereco.getjButtonNovo().setEnabled(estado);
        telaCadEndereco.getjButtonCancelar().setEnabled(!estado);
        telaCadEndereco.getjButtonGravar().setEnabled(!estado);
        telaCadEndereco.getjButtonBuscar().setEnabled(estado);
        telaCadEndereco.getjButtonSair().setEnabled(estado);
    }

    //Método para Ativação/Desativação/Limpeza ds 
    //Componentes do jPanelDados
    public void ligaDesliga(boolean estado) {
        Component[] componentes = this.telaCadEndereco.getjPanelDados().getComponents();
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
