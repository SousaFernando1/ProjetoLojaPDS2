package com.fernandoegustavo.projetolojamaven.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import com.fernandoegustavo.projetolojamaven.model.bo.Bairro;
import com.fernandoegustavo.projetolojamaven.service.BairroService;
import com.fernandoegustavo.projetolojamaven.view.TelaBusBairro;
public class ControllerBusBairro implements ActionListener{
    
    TelaBusBairro telaBusBairro;

    public ControllerBusBairro(TelaBusBairro telaBusBairro) {
        
        this.telaBusBairro = telaBusBairro;
        
        telaBusBairro.getjButtonCarregar().addActionListener(this);
        telaBusBairro.getjButtonSair().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.telaBusBairro.getjTable1().getModel();
        
        BairroService bairroService = new BairroService();        
        for (Bairro bairroAtualDaLista : bairroService.buscar()) {
            tabela.addRow(new Object[]{ bairroAtualDaLista.getIdBairro(), 
                                        bairroAtualDaLista.getDescricaoBairro()});
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaBusBairro.getjButtonCarregar()){
         ControllerCadBairro.codigo = 
         (int)this.telaBusBairro.getjTable1().getValueAt(this.telaBusBairro.getjTable1().getSelectedRow(), 0);
         this.telaBusBairro.dispose();
        }else if(e.getSource() == this.telaBusBairro.getjButtonSair()){
            this.telaBusBairro.dispose();
        }
    }
}