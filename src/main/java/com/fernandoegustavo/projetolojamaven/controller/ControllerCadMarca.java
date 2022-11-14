package com.fernandoegustavo.projetolojamaven.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.fernandoegustavo.projetolojamaven.model.bo.Marca;
import com.fernandoegustavo.projetolojamaven.service.MarcaService;
import com.fernandoegustavo.projetolojamaven.view.ModeloCadastros;
import com.fernandoegustavo.projetolojamaven.view.TelaBusMarca;
import com.fernandoegustavo.projetolojamaven.view.TelaCadMarca;

public class ControllerCadMarca implements ActionListener {

    TelaCadMarca telaCadMarca;
    public static int codigo;

    public ControllerCadMarca(TelaCadMarca telaCadMarca) {
        this.telaCadMarca = telaCadMarca;

        telaCadMarca.getjButtonBuscar().addActionListener(this);
        telaCadMarca.getjButtonNovo().addActionListener(this);
        telaCadMarca.getjButtonCancelar().addActionListener(this);
        telaCadMarca.getjButtonGravar().addActionListener(this);
        telaCadMarca.getjButtonSair().addActionListener(this);

        ativa(true);
        ligaDesliga(false);

    }

    //Nesse método controlamos o que fazer quando uma ação acontece
    //Não foram desenvolvidas ainda as funcionalidades de persistência
    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaCadMarca.getjButtonNovo()) {
            ativa(false);
            ligaDesliga(true);
	    this.telaCadMarca.getjTFIdCidade().setEnabled(false);

        } else if (acao.getSource() == telaCadMarca.getjButtonCancelar()) {
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadMarca.getjButtonGravar()) {

            Marca marca = new Marca();
            
            marca.setDescricaoMarca(this.telaCadMarca.getjTFNomeCidade().getText());
            
            MarcaService marcaService = new MarcaService();
            if (this.telaCadMarca.getjTFIdCidade().getText().trim().equalsIgnoreCase("")) {
                marcaService.salvar(marca);
            } else {
                marca.setIdMarca(Integer.parseInt(this.telaCadMarca.getjTFIdCidade().getText()));
                marcaService.atualizar(marca);
            }

            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadMarca.getjButtonBuscar()) {
codigo = 0;
            //chamada da tela da busca
            TelaBusMarca telaBusMarca = new TelaBusMarca(null, true);
            ControllerBusMarca controllerBusMarca = new ControllerBusMarca(telaBusMarca);
            telaBusMarca.setVisible(true);

            if (codigo != 0) {
                Marca marca;
                MarcaService marcaService = new MarcaService();
                marca = marcaService.buscar(codigo);

                ativa(false);
                ligaDesliga(true);

                this.telaCadMarca.getjTFIdCidade().setText(marca.getIdMarca()+ "");
                this.telaCadMarca.getjTFNomeCidade().setText(marca.getDescricaoMarca());
//                this.telaCadBairro.getjTFUF().setText(cidade.getUfCidade());

                this.telaCadMarca.getjTFIdCidade().setEnabled(false);
            }
        } else if (acao.getSource() == telaCadMarca.getjButtonSair()) {
	    this.telaCadMarca.dispose();
        }
    }

    //Método para habilitar/desabilitar botões(controle de estados)
    public void ativa(boolean estado) {
        telaCadMarca.getjButtonNovo().setEnabled(estado);
        telaCadMarca.getjButtonCancelar().setEnabled(!estado);
        telaCadMarca.getjButtonGravar().setEnabled(!estado);
        telaCadMarca.getjButtonBuscar().setEnabled(estado);
        telaCadMarca.getjButtonSair().setEnabled(estado);
    }

    //Método para Ativação/Desativação/Limpeza ds 
    //Componentes do jPanelDados
    public void ligaDesliga(boolean estado) {
        Component[] componentes = this.telaCadMarca.getjPanelDados().getComponents();
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
