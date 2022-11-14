package com.fernandoegustavo.projetolojamaven.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import com.fernandoegustavo.projetolojamaven.model.bo.CondicaoPagamento;
import com.fernandoegustavo.projetolojamaven.service.CondicaoPagamentoService;
import com.fernandoegustavo.projetolojamaven.view.TelaBusCondicaoPagamento;
public class ControllerBusCondicaoPagamento implements ActionListener{
    
    TelaBusCondicaoPagamento telaBusCondicaoPagamento;

    public ControllerBusCondicaoPagamento(TelaBusCondicaoPagamento telaBusCondicaoPagamento) {
        
        this.telaBusCondicaoPagamento = telaBusCondicaoPagamento;
        
        telaBusCondicaoPagamento.getjButtonCarregar().addActionListener(this);
        telaBusCondicaoPagamento.getjButtonSair().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.telaBusCondicaoPagamento.getjTable1().getModel();
        
        CondicaoPagamentoService condicaoPagamentoService = new CondicaoPagamentoService();        
        for (CondicaoPagamento condicaoPagamentoAtualDaLista : condicaoPagamentoService.buscar()) {
            tabela.addRow(new Object[]{ condicaoPagamentoAtualDaLista.getIdcondicaoPagamento(), 
                                        condicaoPagamentoAtualDaLista.getDescricaoCondicaoPagamento(),
                                        condicaoPagamentoAtualDaLista.getNumDiasAtePrimeiraParcela(),
                                        condicaoPagamentoAtualDaLista.getNumDiasEntreParcelas()});
					
}
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaBusCondicaoPagamento.getjButtonCarregar()){
         ControllerCadCondicaoPagamento.codigo = 
         (int)this.telaBusCondicaoPagamento.getjTable1().getValueAt(this.telaBusCondicaoPagamento.getjTable1().getSelectedRow(), 0);
	ControllerCadVendas.codigo = 
         (int)this.telaBusCondicaoPagamento.getjTable1().getValueAt(this.telaBusCondicaoPagamento.getjTable1().getSelectedRow(), 0);
         this.telaBusCondicaoPagamento.dispose();
        }else if(e.getSource() == this.telaBusCondicaoPagamento.getjButtonSair()){
            this.telaBusCondicaoPagamento.dispose();
        }
    }
}