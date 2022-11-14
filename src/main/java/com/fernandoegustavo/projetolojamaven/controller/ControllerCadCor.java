package com.fernandoegustavo.projetolojamaven.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.fernandoegustavo.projetolojamaven.model.bo.Cor;
import com.fernandoegustavo.projetolojamaven.service.CorService;
import com.fernandoegustavo.projetolojamaven.view.ModeloCadastros;
import com.fernandoegustavo.projetolojamaven.view.TelaBusCor;
import com.fernandoegustavo.projetolojamaven.view.TelaCadCor;

public class ControllerCadCor implements ActionListener {

    TelaCadCor telaCadCor;
    public static int codigo;

    public ControllerCadCor(TelaCadCor telaCadCor) {
        this.telaCadCor = telaCadCor;

        telaCadCor.getjButtonBuscar().addActionListener(this);
        telaCadCor.getjButtonNovo().addActionListener(this);
        telaCadCor.getjButtonCancelar().addActionListener(this);
        telaCadCor.getjButtonGravar().addActionListener(this);
        telaCadCor.getjButtonSair().addActionListener(this);

        ativa(true);
        ligaDesliga(false);

    }

    //Nesse método controlamos o que fazer quando uma ação acontece
    //Não foram desenvolvidas ainda as funcionalidades de persistência
    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaCadCor.getjButtonNovo()) {
            ativa(false);
            ligaDesliga(true);
	    this.telaCadCor.getIdCor().setEnabled(false);
        } else if (acao.getSource() == telaCadCor.getjButtonCancelar()) {
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadCor.getjButtonGravar()) {
	    Cor cor = new Cor();
            
            cor.setDescricaoCor(this.telaCadCor.getDescricaoCor().getText());  


            CorService corService = new CorService();
            
            if (this.telaCadCor.getIdCor().getText().trim().equalsIgnoreCase("")) {
                corService.salvar(cor);
            } else {
                cor.setIdCor(Integer.parseInt(this.telaCadCor.getIdCor().getText()));
                corService.atualizar(cor);
            }

            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadCor.getjButtonBuscar()) {
	    codigo = 0;
            //chamada da tela da busca
            TelaBusCor telaBusCor = new TelaBusCor(null, true);
            ControllerBusCor controllerBusCor = new ControllerBusCor(telaBusCor);
            telaBusCor.setVisible(true);

            if (codigo != 0) {
                Cor cor;
                CorService corService = new CorService();
                cor = corService.buscar(codigo);

                ativa(false);
                ligaDesliga(true);

                this.telaCadCor.getIdCor().setText(cor.getIdCor()+ "");
                this.telaCadCor.getDescricaoCor().setText(cor.getDescricaoCor());
//                this.telaCadBairro.getjTFUF().setText(cidade.getUfCidade());

                this.telaCadCor.getIdCor().setEnabled(false);
            }
        } else if (acao.getSource() == telaCadCor.getjButtonSair()) {
	    this.telaCadCor.dispose();
        }
    }

    //Método para habilitar/desabilitar botões(controle de estados)
    public void ativa(boolean estado) {
        telaCadCor.getjButtonNovo().setEnabled(estado);
        telaCadCor.getjButtonCancelar().setEnabled(!estado);
        telaCadCor.getjButtonGravar().setEnabled(!estado);
        telaCadCor.getjButtonBuscar().setEnabled(estado);
        telaCadCor.getjButtonSair().setEnabled(estado);
    }

    //Método para Ativação/Desativação/Limpeza ds 
    //Componentes do jPanelDados
    public void ligaDesliga(boolean estado) {
        Component[] componentes = this.telaCadCor.getjPanelDados().getComponents();
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
