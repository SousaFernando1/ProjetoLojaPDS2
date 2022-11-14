package com.fernandoegustavo.projetolojamaven.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import com.fernandoegustavo.projetolojamaven.model.bo.CaracteristicaProduto;
import com.fernandoegustavo.projetolojamaven.model.bo.Vendedor;
import com.fernandoegustavo.projetolojamaven.service.CaracteristicaProdutoService;
import com.fernandoegustavo.projetolojamaven.service.VendedorService;
import com.fernandoegustavo.projetolojamaven.view.TelaBusCaracteristicaProduto;
import com.fernandoegustavo.projetolojamaven.view.TelaBusVendedor;
public class ControllerBusCaracteristicaProduto implements ActionListener{
    
    TelaBusCaracteristicaProduto telaBusCaracteristicaProduto;

    public ControllerBusCaracteristicaProduto(TelaBusCaracteristicaProduto telaBusCaracteristicaProduto) {
        
        this.telaBusCaracteristicaProduto = telaBusCaracteristicaProduto;
        
        telaBusCaracteristicaProduto.getjButtonCarregar().addActionListener(this);
        telaBusCaracteristicaProduto.getjButtonSair().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.telaBusCaracteristicaProduto.getjTable1().getModel();
        
        CaracteristicaProdutoService caracteristicaProdutoService = new CaracteristicaProdutoService();        
        for (CaracteristicaProduto produtoAtualDaLista : caracteristicaProdutoService.buscar()) {
            tabela.addRow(new Object[]{ produtoAtualDaLista.getIdCaracteristicaProduto(), 
                                        produtoAtualDaLista.getProduto_idproduto(),
                                        produtoAtualDaLista.getBarraProduto()});
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaBusCaracteristicaProduto.getjButtonCarregar()){
         ControllerCadCaracteristicaProduto.codigo = 
         (int)this.telaBusCaracteristicaProduto.getjTable1().getValueAt(this.telaBusCaracteristicaProduto.getjTable1().getSelectedRow(), 0);
	 ControllerCadVendas.codigo = 
(int)this.telaBusCaracteristicaProduto.getjTable1().getValueAt(this.telaBusCaracteristicaProduto.getjTable1().getSelectedRow(), 0);
this.telaBusCaracteristicaProduto.dispose();
        }else if(e.getSource() == this.telaBusCaracteristicaProduto.getjButtonSair()){
	     ControllerCadVendas.codigo = 0;
            this.telaBusCaracteristicaProduto.dispose();
        }
    }
}