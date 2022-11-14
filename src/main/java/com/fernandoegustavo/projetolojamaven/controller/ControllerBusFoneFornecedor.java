package com.fernandoegustavo.projetolojamaven.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import com.fernandoegustavo.projetolojamaven.model.bo.FoneFornecedor;
import com.fernandoegustavo.projetolojamaven.service.FoneFornecedorService;
import com.fernandoegustavo.projetolojamaven.view.TelaBusFoneFornecedor;
public class ControllerBusFoneFornecedor implements ActionListener{
    
    TelaBusFoneFornecedor telaBusFoneFornecedor;

    public ControllerBusFoneFornecedor(TelaBusFoneFornecedor telaBusFoneFornecedor) {
        
        this.telaBusFoneFornecedor = telaBusFoneFornecedor;
        
        telaBusFoneFornecedor.getjButtonCarregar().addActionListener(this);
        telaBusFoneFornecedor.getjButtonSair().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.telaBusFoneFornecedor.getjTable1().getModel();
        
        FoneFornecedorService fornecedorService = new FoneFornecedorService();        
        for (FoneFornecedor fornecedorAtualDaLista : fornecedorService.buscar()) {
            tabela.addRow(new Object[]{ 

		fornecedorAtualDaLista.getFoneFornecedor(),
		fornecedorAtualDaLista.getFornecedor_idfornecedor().getIdfornecedor()
});
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaBusFoneFornecedor.getjButtonCarregar()){
         ControllerCadFoneFornecedor.codigo = 
         (int)this.telaBusFoneFornecedor.getjTable1().getValueAt(this.telaBusFoneFornecedor.getjTable1().getSelectedRow(), 0);
         this.telaBusFoneFornecedor.dispose();
        }else if(e.getSource() == this.telaBusFoneFornecedor.getjButtonSair()){
            this.telaBusFoneFornecedor.dispose();
        }
    }
}