package com.fernandoegustavo.projetolojamaven.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.fernandoegustavo.projetolojamaven.model.bo.Tamanho;
import com.fernandoegustavo.projetolojamaven.service.TamanhoService;
import com.fernandoegustavo.projetolojamaven.view.ModeloCadastros;
import com.fernandoegustavo.projetolojamaven.view.TelaBusTamanho;
import com.fernandoegustavo.projetolojamaven.view.TelaCadTamanho;

public class ControllerCadTamanho implements ActionListener {

    TelaCadTamanho telaCadTamanho;
    public static int codigo;

    public ControllerCadTamanho(TelaCadTamanho telaCadTamanho) {
        this.telaCadTamanho = telaCadTamanho;

        telaCadTamanho.getjButtonBuscar().addActionListener(this);
        telaCadTamanho.getjButtonNovo().addActionListener(this);
        telaCadTamanho.getjButtonCancelar().addActionListener(this);
        telaCadTamanho.getjButtonGravar().addActionListener(this);
        telaCadTamanho.getjButtonSair().addActionListener(this);

        ativa(true);
        ligaDesliga(false);

    }

    //Nesse método controlamos o que fazer quando uma ação acontece
    //Não foram desenvolvidas ainda as funcionalidades de persistência
    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaCadTamanho.getjButtonNovo()) {
            ativa(false);
            ligaDesliga(true);
	    this.telaCadTamanho.getIdTamanho().setEnabled(false);

        } else if (acao.getSource() == telaCadTamanho.getjButtonCancelar()) {
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadTamanho.getjButtonGravar()) {
	    Tamanho tamanho = new Tamanho();
            
            tamanho.setDescricaoTamanho(this.telaCadTamanho.getDescricaoTamanho().getText());  


            TamanhoService tamanhoService = new TamanhoService();
          
            if (this.telaCadTamanho.getIdTamanho().getText().trim().equalsIgnoreCase("")) {
                tamanhoService.salvar(tamanho);
            } else {
                tamanho.setIdTamanho(Integer.parseInt(this.telaCadTamanho.getIdTamanho().getText()));
                tamanhoService.atualizar(tamanho);
            }



            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadTamanho.getjButtonBuscar()) {
	    codigo = 0;
            //chamada da tela da busca
            TelaBusTamanho telaBusTamanho = new TelaBusTamanho(null, true);
            ControllerBusTamanho controllerBusTamanho = new ControllerBusTamanho(telaBusTamanho);
            telaBusTamanho.setVisible(true);

            if (codigo != 0) {
                Tamanho tamanho;
                TamanhoService tamanhoService = new TamanhoService();
                tamanho = tamanhoService.buscar(codigo);

                ativa(false);
                ligaDesliga(true);

                this.telaCadTamanho.getIdTamanho().setText(tamanho.getIdTamanho() + "");
                this.telaCadTamanho.getDescricaoTamanho().setText(tamanho.getDescricaoTamanho());

                this.telaCadTamanho.getIdTamanho().setEnabled(false);
            }
        } else if (acao.getSource() == telaCadTamanho.getjButtonSair()) {
	    this.telaCadTamanho.dispose();
        }
    }

    //Método para habilitar/desabilitar botões(controle de estados)
    public void ativa(boolean estado) {
        telaCadTamanho.getjButtonNovo().setEnabled(estado);
        telaCadTamanho.getjButtonCancelar().setEnabled(!estado);
        telaCadTamanho.getjButtonGravar().setEnabled(!estado);
        telaCadTamanho.getjButtonBuscar().setEnabled(estado);
        telaCadTamanho.getjButtonSair().setEnabled(estado);
    }

    //Método para Ativação/Desativação/Limpeza ds 
    //Componentes do jPanelDados
    public void ligaDesliga(boolean estado) {
        Component[] componentes = this.telaCadTamanho.getjPanelDados().getComponents();
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
