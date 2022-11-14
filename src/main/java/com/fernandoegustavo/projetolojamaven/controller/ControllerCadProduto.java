package com.fernandoegustavo.projetolojamaven.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.fernandoegustavo.projetolojamaven.model.DAO.MarcaDAO;
import com.fernandoegustavo.projetolojamaven.model.DAO.TamanhoDAO;
import com.fernandoegustavo.projetolojamaven.model.DAO.TipoProdutoDAO;
import com.fernandoegustavo.projetolojamaven.model.bo.Marca;
import com.fernandoegustavo.projetolojamaven.model.bo.Produto;
import com.fernandoegustavo.projetolojamaven.model.bo.Tamanho;
import com.fernandoegustavo.projetolojamaven.model.bo.TipoProduto;
import com.fernandoegustavo.projetolojamaven.service.ProdutoService;
import com.fernandoegustavo.projetolojamaven.view.ModeloCadastros;
import com.fernandoegustavo.projetolojamaven.view.TelaBusProduto;
import com.fernandoegustavo.projetolojamaven.view.TelaCadProduto;

public class ControllerCadProduto implements ActionListener {

    TelaCadProduto telaCadProduto;
    public static int codigo;

    public ControllerCadProduto(TelaCadProduto telaCadProduto) {
        this.telaCadProduto = telaCadProduto;

        telaCadProduto.getjButtonBuscar().addActionListener(this);
        telaCadProduto.getjButtonNovo().addActionListener(this);
        telaCadProduto.getjButtonCancelar().addActionListener(this);
        telaCadProduto.getjButtonGravar().addActionListener(this);
        telaCadProduto.getjButtonSair().addActionListener(this);

        ativa(true);
        ligaDesliga(false);

    }

    //Nesse método controlamos o que fazer quando uma ação acontece
    //Não foram desenvolvidas ainda as funcionalidades de persistência
    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaCadProduto.getjButtonNovo()) {
            ativa(false);
            ligaDesliga(true);
	    this.telaCadProduto.getjTFIdProduto().setEnabled(false);
        } else if (acao.getSource() == telaCadProduto.getjButtonCancelar()) {
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadProduto.getjButtonGravar()) {



            Produto produto = new Produto();


//	    String tempTamanho;
//            tempTamanho = this.telaCadProduto.getjComboBox1().getSelectedItem().toString();
//
//	    Tamanho tamanho = new Tamanho();
//	    TamanhoDAO tamanhoDAO = new TamanhoDAO();
//	    tamanho = tamanhoDAO.retrieve(tempTamanho);


//	    String tempTipoProduto;
//            tempTipoProduto = this.telaCadProduto.getjComboBox2().getSelectedItem().toString();
//
//	    TipoProduto tipoProduto = new TipoProduto();
//	    TipoProdutoDAO tipoProdutoDAO = new TipoProdutoDAO();
//	    tipoProduto = tipoProdutoDAO.retrieve(tempTipoProduto);	    

//	    String tempMarca;
//            tempMarca = this.telaCadProduto.getjComboBox3().getSelectedItem().toString();
//
//	    Marca marca = new Marca();
//	    MarcaDAO marcaDAO = new MarcaDAO();
//	    marca = marcaDAO.retrieve(tempMarca);	



	    produto.setMarca_idmarca((Marca) this.telaCadProduto.getjComboBox3().getSelectedItem());
	    produto.setTipoProduto_idtipoProduto((TipoProduto) this.telaCadProduto.getjComboBox2().getSelectedItem());
	    produto.setTamanho_idtamanho((Tamanho) this.telaCadProduto.getjComboBox1().getSelectedItem());
            produto.setDescricaoProduto(this.telaCadProduto.getjTFNome().getText());
	    produto.setValProduto(Float.parseFloat(this.telaCadProduto.getjTFValor().getText()));


            ProdutoService produtoService = new ProdutoService();
            produtoService.salvar(produto);
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadProduto.getjButtonBuscar()) {
            codigo = 0;
            //chamada da tela da busca
            TelaBusProduto telaBusProduto = new TelaBusProduto(null, true);
            ControllerBusProduto controllerBusProduto = new ControllerBusProduto(telaBusProduto);
            telaBusProduto.setVisible(true);

            if (codigo != 0) {
                Produto produto;
                ProdutoService produtoService = new ProdutoService();
                produto = produtoService.buscar(codigo);

                ativa(false);
                ligaDesliga(true);

                this.telaCadProduto.getjTFIdProduto().setText(produto.getIdproduto() + "");
                this.telaCadProduto.getjTFNome().setText(produto.getDescricaoProduto());
                this.telaCadProduto.getjTFValor().setText(produto.getValProduto() + "");

                this.telaCadProduto.getjTFIdProduto().setEnabled(false);
            }
        } else if (acao.getSource() == telaCadProduto.getjButtonSair()) {
	    this.telaCadProduto.dispose();
        }
    }

    //Método para habilitar/desabilitar botões(controle de estados)
    public void ativa(boolean estado) {
        telaCadProduto.getjButtonNovo().setEnabled(estado);
        telaCadProduto.getjButtonCancelar().setEnabled(!estado);
        telaCadProduto.getjButtonGravar().setEnabled(!estado);
        telaCadProduto.getjButtonBuscar().setEnabled(estado);
        telaCadProduto.getjButtonSair().setEnabled(estado);
    }

    //Método para Ativação/Desativação/Limpeza ds 
    //Componentes do jPanelDados
    public void ligaDesliga(boolean estado) {
        Component[] componentes = this.telaCadProduto.getjPanelDados().getComponents();
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
