package com.fernandoegustavo.projetolojamaven.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.fernandoegustavo.projetolojamaven.model.bo.TipoProduto;
import com.fernandoegustavo.projetolojamaven.service.TipoProdutoService;
import com.fernandoegustavo.projetolojamaven.view.ModeloCadastros;
import com.fernandoegustavo.projetolojamaven.view.TelaBusTipoProduto;
import com.fernandoegustavo.projetolojamaven.view.TelaCadCondicaoPagamento;
import com.fernandoegustavo.projetolojamaven.view.TelaCadFornecedor;
import com.fernandoegustavo.projetolojamaven.view.TelaCadTipoProduto;

public class ControllerCadTipoProduto implements ActionListener {

    TelaCadTipoProduto telaCadTipoProduto;
    public static int codigo;

    public ControllerCadTipoProduto(TelaCadTipoProduto telaCadTipoProduto) {
        this.telaCadTipoProduto = telaCadTipoProduto;

        telaCadTipoProduto.getjButtonBuscar().addActionListener(this);
        telaCadTipoProduto.getjButtonNovo().addActionListener(this);
        telaCadTipoProduto.getjButtonCancelar().addActionListener(this);
        telaCadTipoProduto.getjButtonGravar().addActionListener(this);
        telaCadTipoProduto.getjButtonSair().addActionListener(this);

        ativa(true);
        ligaDesliga(false);

    }

    //Nesse método controlamos o que fazer quando uma ação acontece
    //Não foram desenvolvidas ainda as funcionalidades de persistência
    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaCadTipoProduto.getjButtonNovo()) {
            ativa(false);
            ligaDesliga(true);
	    this.telaCadTipoProduto.getjTFIdTipoProduto().setEnabled(false);

        } else if (acao.getSource() == telaCadTipoProduto.getjButtonCancelar()) {
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadTipoProduto.getjButtonGravar()) {
	    TipoProduto tipoProduto = new TipoProduto();
            
            tipoProduto.setDescricaoTipoProduto(this.telaCadTipoProduto.getjTFDescricaoTipoProduto().getText());  


            TipoProdutoService tipoProdutoService = new TipoProdutoService();
            if (this.telaCadTipoProduto.getjTFIdTipoProduto().getText().trim().equalsIgnoreCase("")) {
                tipoProdutoService.salvar(tipoProduto);
            } else {
                tipoProduto.setIdTipoProduto(Integer.parseInt(this.telaCadTipoProduto.getjTFIdTipoProduto().getText()));
                tipoProdutoService.atualizar(tipoProduto);
            }


            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadTipoProduto.getjButtonBuscar()) {
	    codigo = 0;
            //chamada da tela da busca
            TelaBusTipoProduto telaBusTipoProduto = new TelaBusTipoProduto(null, true);
            ControllerBusTipoProduto controllerBusTipoProduto = new ControllerBusTipoProduto(telaBusTipoProduto);
            telaBusTipoProduto.setVisible(true);

            if (codigo != 0) {
                TipoProduto tipoProduto;
                TipoProdutoService tipoProdutoService = new TipoProdutoService();
                tipoProduto = tipoProdutoService.buscar(codigo);

                ativa(false);
                ligaDesliga(true);

                this.telaCadTipoProduto.getjTFIdTipoProduto().setText(tipoProduto.getIdTipoProduto() + "");
                this.telaCadTipoProduto.getjTFDescricaoTipoProduto().setText(tipoProduto.getDescricaoTipoProduto());
//                this.telaCadBairro.getjTFUF().setText(cidade.getUfCidade());

                this.telaCadTipoProduto.getjTFIdTipoProduto().setEnabled(false);
            }
        } else if (acao.getSource() == telaCadTipoProduto.getjButtonSair()) {
	    this.telaCadTipoProduto.dispose();
        }
    }

    //Método para habilitar/desabilitar botões(controle de estados)
    public void ativa(boolean estado) {
        telaCadTipoProduto.getjButtonNovo().setEnabled(estado);
        telaCadTipoProduto.getjButtonCancelar().setEnabled(!estado);
        telaCadTipoProduto.getjButtonGravar().setEnabled(!estado);
        telaCadTipoProduto.getjButtonBuscar().setEnabled(estado);
        telaCadTipoProduto.getjButtonSair().setEnabled(estado);
    }

    //Método para Ativação/Desativação/Limpeza ds 
    //Componentes do jPanelDados
    public void ligaDesliga(boolean estado) {
        Component[] componentes = this.telaCadTipoProduto.getjPanelDados().getComponents();
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
