package com.fernandoegustavo.projetolojamaven.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.fernandoegustavo.projetolojamaven.model.DAO.CidadeDAO;
import com.fernandoegustavo.projetolojamaven.model.bo.Bairro;
import com.fernandoegustavo.projetolojamaven.model.bo.Cidade;
import com.fernandoegustavo.projetolojamaven.service.BairroService;
import com.fernandoegustavo.projetolojamaven.view.ModeloCadastros;
import com.fernandoegustavo.projetolojamaven.view.TelaBusBairro;
import com.fernandoegustavo.projetolojamaven.view.TelaCadBairro;

public class ControllerCadBairro implements ActionListener {

    TelaCadBairro telaCadBairro;
    public static int codigo;

    public ControllerCadBairro(TelaCadBairro telaCadBairro) {
        this.telaCadBairro = telaCadBairro;


        telaCadBairro.getjButtonBuscar().addActionListener(this);
        telaCadBairro.getjButtonNovo().addActionListener(this);
        telaCadBairro.getjButtonCancelar().addActionListener(this);
        telaCadBairro.getjButtonGravar().addActionListener(this);
        telaCadBairro.getjButtonSair().addActionListener(this);

        ativa(true);
        ligaDesliga(false);

    
    }        

    //Nesse método controlamos o que fazer quando uma ação acontece
    //Não foram desenvolvidas ainda as funcionalidades de persistência
    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaCadBairro.getjButtonNovo()) {
            ativa(false);
            ligaDesliga(true);
	    this.telaCadBairro.getjTFIdCidade().setEnabled(false);
        } else if (acao.getSource() == telaCadBairro.getjButtonCancelar()) {
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadBairro.getjButtonGravar()) {
            Bairro bairro = new Bairro();

	    
            bairro.setDescricaoBairro(this.telaCadBairro.getjTFNomeBairro().getText());
//            bairro.setCidadeMae(cidade.getIdCidade());  
  
            BairroService bairroService = new BairroService();
            if (this.telaCadBairro.getjTFIdCidade().getText().trim().equalsIgnoreCase("")) {
                bairroService.salvar(bairro);
            } else {
      
                System.out.println("Verificar a linha acima e ver se é cidade no início ou bairro");
                bairroService.atualizar(bairro);
            }

            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == telaCadBairro.getjButtonBuscar()) {
	    codigo = 0;
            //chamada da tela da busca
            TelaBusBairro telaBusBairro = new TelaBusBairro(null, true);
            ControllerBusBairro controllerBusBairro = new ControllerBusBairro(telaBusBairro);
            telaBusBairro.setVisible(true);

            if (codigo != 0) {
                Bairro bairro;
                BairroService bairroService = new BairroService();
                bairro = bairroService.buscar(codigo);

                ativa(false);
                ligaDesliga(true);

                this.telaCadBairro.getjTFIdCidade().setText(bairro.getIdBairro()+ "");
                this.telaCadBairro.getjTFNomeBairro().setText(bairro.getDescricaoBairro());
//                this.telaCadBairro.getjTFUF().setText(cidade.getUfCidade());
//		this.telaCadBairro.getjComboBox1().setSelectedItem(bairro.getCidadeMae());

                this.telaCadBairro.getjTFIdCidade().setEnabled(false);
            }
        } else if (acao.getSource() == telaCadBairro.getjButtonSair()) {
	    this.telaCadBairro.dispose();
        }
    }

    //Método para habilitar/desabilitar botões(controle de estados)
    public void ativa(boolean estado) {
        telaCadBairro.getjButtonNovo().setEnabled(estado);
        telaCadBairro.getjButtonCancelar().setEnabled(!estado);
        telaCadBairro.getjButtonGravar().setEnabled(!estado);
        telaCadBairro.getjButtonBuscar().setEnabled(estado);
        telaCadBairro.getjButtonSair().setEnabled(estado);
    }

    //Método para Ativação/Desativação/Limpeza ds 
    //Componentes do jPanelDados
    public void ligaDesliga(boolean estado) {
        Component[] componentes = this.telaCadBairro.getjPanelDados().getComponents();
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
