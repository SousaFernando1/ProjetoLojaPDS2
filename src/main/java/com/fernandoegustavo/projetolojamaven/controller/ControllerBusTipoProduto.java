package com.fernandoegustavo.projetolojamaven.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import com.fernandoegustavo.projetolojamaven.model.bo.TipoProduto;
import com.fernandoegustavo.projetolojamaven.service.TipoProdutoService;
import com.fernandoegustavo.projetolojamaven.view.TelaBusTipoProduto;
public class ControllerBusTipoProduto implements ActionListener{
    
    TelaBusTipoProduto telaBusTipoProduto;

    public ControllerBusTipoProduto(TelaBusTipoProduto telaBusTipoProduto) {
        
        this.telaBusTipoProduto = telaBusTipoProduto;
        
        telaBusTipoProduto.getjButtonCarregar().addActionListener(this);
        telaBusTipoProduto.getjButtonSair().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.telaBusTipoProduto.getjTable1().getModel();
        
        TipoProdutoService tipoProdutoService = new TipoProdutoService();        
        for (TipoProduto tipoProdutoAtualDaLista : tipoProdutoService.buscar()) {
            tabela.addRow(new Object[]{ tipoProdutoAtualDaLista.getIdTipoProduto(), 
                                        tipoProdutoAtualDaLista.getDescricaoTipoProduto()});
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaBusTipoProduto.getjButtonCarregar()){
         ControllerCadTipoProduto.codigo = 
         (int)this.telaBusTipoProduto.getjTable1().getValueAt(this.telaBusTipoProduto.getjTable1().getSelectedRow(), 0);
         this.telaBusTipoProduto.dispose();
        }else if(e.getSource() == this.telaBusTipoProduto.getjButtonSair()){
            this.telaBusTipoProduto.dispose();
        }
    }
}