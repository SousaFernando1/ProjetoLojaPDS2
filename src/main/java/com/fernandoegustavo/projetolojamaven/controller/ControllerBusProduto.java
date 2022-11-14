package com.fernandoegustavo.projetolojamaven.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import com.fernandoegustavo.projetolojamaven.model.bo.Produto;
import com.fernandoegustavo.projetolojamaven.model.bo.Vendedor;
import com.fernandoegustavo.projetolojamaven.service.ProdutoService;
import com.fernandoegustavo.projetolojamaven.service.VendedorService;
import com.fernandoegustavo.projetolojamaven.view.TelaBusProduto;
import com.fernandoegustavo.projetolojamaven.view.TelaBusVendedor;
public class ControllerBusProduto implements ActionListener{
    
    TelaBusProduto telaBusProduto;

    public ControllerBusProduto(TelaBusProduto telaBusProduto) {
        
        this.telaBusProduto = telaBusProduto;
        
        telaBusProduto.getjButtonCarregar().addActionListener(this);
        telaBusProduto.getjButtonSair().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.telaBusProduto.getjTable1().getModel();
        
        ProdutoService produtoService = new ProdutoService();        
        for (Produto produtoAtualDaLista : produtoService.buscar()) {
            tabela.addRow(new Object[]{ produtoAtualDaLista.getIdproduto(), 
                                        produtoAtualDaLista.getDescricaoProduto(),
                                        produtoAtualDaLista.getValProduto()});
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaBusProduto.getjButtonCarregar()){
         ControllerCadProduto.codigo = 
         (int)this.telaBusProduto.getjTable1().getValueAt(this.telaBusProduto.getjTable1().getSelectedRow(), 0);
         this.telaBusProduto.dispose();
        }else if(e.getSource() == this.telaBusProduto.getjButtonSair()){
            this.telaBusProduto.dispose();
        }
    }
}