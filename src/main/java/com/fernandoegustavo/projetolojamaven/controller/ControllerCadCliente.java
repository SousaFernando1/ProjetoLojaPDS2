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
import com.fernandoegustavo.projetolojamaven.model.DAO.EnderecoDAO;
import com.fernandoegustavo.projetolojamaven.model.bo.Bairro;
import com.fernandoegustavo.projetolojamaven.model.bo.Cliente;
import com.fernandoegustavo.projetolojamaven.model.bo.Cidade;
import com.fernandoegustavo.projetolojamaven.model.bo.Endereco;
import com.fernandoegustavo.projetolojamaven.service.ClienteService;
import com.fernandoegustavo.projetolojamaven.view.ModeloCadastros;
import com.fernandoegustavo.projetolojamaven.view.TelaBusCliente;
import com.fernandoegustavo.projetolojamaven.view.TelaCadCliente;

public class ControllerCadCliente implements ActionListener {

    TelaCadCliente telaCadCliente;
    public static int codigo;

    public ControllerCadCliente(TelaCadCliente telaCadCliente) {
        this.telaCadCliente = telaCadCliente;

        telaCadCliente.getjButtonBuscar().addActionListener(this);
        telaCadCliente.getjButtonNovo().addActionListener(this);
        telaCadCliente.getjButtonCancelar().addActionListener(this);
        telaCadCliente.getjButtonGravar().addActionListener(this);
        telaCadCliente.getjButtonSair().addActionListener(this);
//        telaCadCliente.getjComboBoxCidade().addActionListener(this);


        ativa(true);
        ligaDesliga(false);

    }

    //Nesse método controlamos o que fazer quando uma ação acontece
    //Não foram desenvolvidas ainda as funcionalidades de persistência
    @Override
    public void actionPerformed(ActionEvent acao) {
//	if(acao.getSource() == telaCadCliente.getjComboBoxCidade()){
//            EnderecoDAO enderecoDAO = new EnderecoDAO();
//	    CidadeDAO cidadeDAO = new CidadeDAO();
//
//	    Cidade tempCidade = cidadeDAO.retrieve(telaCadCliente.getjComboBoxCidade().getSelectedItem().toString());
//
//
//          List<Endereco> list = enderecoDAO.retrieve();
//	  telaCadCliente.getjComboBoxCep().removeAllItems();
//          for(Endereco item: list){
//	    telaCadCliente.getjComboBoxCep().addItem(item.getCepCep());
//          }
//
////	    System.out.println(telaCadCliente.getjComboBoxCidade().getSelectedItem().toString());
//	}
        if (acao.getSource() == telaCadCliente.getjButtonNovo()) {
            ativa(false);
            ligaDesliga(true);
	    this.telaCadCliente.getjTFIdCliente().setEnabled(false);
        } else if (acao.getSource() == telaCadCliente.getjButtonCancelar()) {
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadCliente.getjButtonGravar()) {

            Cliente cliente = new Cliente();
            
            EnderecoDAO enderecoDAO = new EnderecoDAO();

//            cidade.setUfCidade(this.telaCadCidade.getjTFUF().getText());

	    cliente.setNome(this.telaCadCliente.getNome().getText());
	    cliente.setDtNascCliente(this.telaCadCliente.getDtNascimento().getText());	    
	    cliente.setEmail(this.telaCadCliente.getEmail().getText());
	    cliente.setCpfCliente(this.telaCadCliente.getCpf().getText());
	    cliente.setRgCliente(this.telaCadCliente.getRg().getText());
	    cliente.setCompleEndereco(this.telaCadCliente.getCompEndereco().getText());
	    cliente.setFoneCliente(this.telaCadCliente.getFone().getText());
            cliente.setCompleEndereco(this.telaCadCliente.getCompEndereco().getText());
            cliente.setEndereco_idcep(enderecoDAO.retrieve(this.telaCadCliente.getjComboBoxCep().getSelectedItem().toString()));
            
            ClienteService clienteService = new ClienteService();
            if (this.telaCadCliente.getjTFIdCliente().getText().trim().equalsIgnoreCase("")) {
                clienteService.salvar(cliente);
            } else {
                cliente.setIdcliente(Integer.parseInt(this.telaCadCliente.getjTFIdCliente().getText()));
                clienteService.atualizar(cliente);
            }

            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadCliente.getjButtonBuscar()) {
            codigo = 0;
            //chamada da tela da busca
            TelaBusCliente telaBusCliente = new TelaBusCliente(null, true);
            ControllerBusCliente controllerBusCliente = new ControllerBusCliente(telaBusCliente);
            telaBusCliente.setVisible(true);

            if (codigo != 0) {
                Cliente cliente;
                ClienteService clienteService = new ClienteService();
                cliente = clienteService.buscar(codigo);

                ativa(false);
                ligaDesliga(true);

                this.telaCadCliente.getjTFIdCliente().setText(cliente.getIdcliente()+ "");
                this.telaCadCliente.getNome().setText(cliente.getNome());
                this.telaCadCliente.getCpf().setText(cliente.getCpfCliente());

                this.telaCadCliente.getjTFIdCliente().setEnabled(false);
            }
        } else if (acao.getSource() == telaCadCliente.getjButtonSair()) {
	    this.telaCadCliente.dispose();
        }
    }

    //Método para habilitar/desabilitar botões(controle de estados)
    public void ativa(boolean estado) {
        telaCadCliente.getjButtonNovo().setEnabled(estado);
        telaCadCliente.getjButtonCancelar().setEnabled(!estado);
        telaCadCliente.getjButtonGravar().setEnabled(!estado);
        telaCadCliente.getjButtonBuscar().setEnabled(estado);
        telaCadCliente.getjButtonSair().setEnabled(estado);
    }

    //Método para Ativação/Desativação/Limpeza ds 
    //Componentes do jPanelDados
    public void ligaDesliga(boolean estado) {
        Component[] componentes = this.telaCadCliente.getjPanelDados().getComponents();
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
