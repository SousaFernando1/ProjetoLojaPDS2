package com.fernandoegustavo.projetolojamaven.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import com.fernandoegustavo.projetolojamaven.model.bo.Endereco;
import com.fernandoegustavo.projetolojamaven.service.EnderecoService;
import com.fernandoegustavo.projetolojamaven.view.TelaBusEndereco;
import com.fernandoegustavo.projetolojamaven.view.TelaBusEndereco;
public class ControllerBusEndereco implements ActionListener{
    
    TelaBusEndereco telaBusEndereco;

    public ControllerBusEndereco(TelaBusEndereco telaBusEndereco) {
        
        this.telaBusEndereco = telaBusEndereco;
        
        telaBusEndereco.getjButtonCarregar().addActionListener(this);
        telaBusEndereco.getjButtonSair().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.telaBusEndereco.getjTable1().getModel();
        
        EnderecoService enderecoService = new EnderecoService();        
        for (Endereco enderecoAtualDaLista : enderecoService.buscar()) {
            tabela.addRow(new Object[]{ enderecoAtualDaLista.getIdCep(), 
                                        enderecoAtualDaLista.getCepCep()});
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaBusEndereco.getjButtonCarregar()){
         ControllerCadEndereco.codigo = 
         (int)this.telaBusEndereco.getjTable1().getValueAt(this.telaBusEndereco.getjTable1().getSelectedRow(), 0);
         this.telaBusEndereco.dispose();
        }else if(e.getSource() == this.telaBusEndereco.getjButtonSair()){
            this.telaBusEndereco.dispose();
        }
    }
}