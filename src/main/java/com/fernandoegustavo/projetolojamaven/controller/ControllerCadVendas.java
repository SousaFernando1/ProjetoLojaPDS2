package com.fernandoegustavo.projetolojamaven.controller;

import static com.fernandoegustavo.projetolojamaven.controller.ControllerCadCaracteristicaProduto.codigo;
import static com.fernandoegustavo.projetolojamaven.controller.ControllerCadCliente.codigo;
import static com.fernandoegustavo.projetolojamaven.controller.ControllerCadCondicaoPagamento.codigo;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.fernandoegustavo.projetolojamaven.model.DAO.CidadeDAO;
import com.fernandoegustavo.projetolojamaven.model.DAO.ClienteDAO;
import com.fernandoegustavo.projetolojamaven.model.DAO.VendaDAO;
import com.fernandoegustavo.projetolojamaven.model.bo.Bairro;
import com.fernandoegustavo.projetolojamaven.model.bo.CaracteristicaProduto;
import com.fernandoegustavo.projetolojamaven.model.bo.Cidade;
import com.fernandoegustavo.projetolojamaven.model.bo.Cliente;
import com.fernandoegustavo.projetolojamaven.model.bo.CondicaoPagamento;
import com.fernandoegustavo.projetolojamaven.model.bo.Produto;
import com.fernandoegustavo.projetolojamaven.model.bo.Venda;
import com.fernandoegustavo.projetolojamaven.model.bo.Vendedor;
import com.fernandoegustavo.projetolojamaven.service.BairroService;
import com.fernandoegustavo.projetolojamaven.service.CaracteristicaProdutoService;
import com.fernandoegustavo.projetolojamaven.service.ClienteService;
import com.fernandoegustavo.projetolojamaven.service.CondicaoPagamentoService;
import com.fernandoegustavo.projetolojamaven.service.ProdutoService;
import com.fernandoegustavo.projetolojamaven.service.VendedorService;
import com.fernandoegustavo.projetolojamaven.view.ModeloCadastros;
import com.fernandoegustavo.projetolojamaven.view.TelaBusBairro;
import com.fernandoegustavo.projetolojamaven.view.TelaBusCaracteristicaProduto;
import com.fernandoegustavo.projetolojamaven.view.TelaBusCliente;
import com.fernandoegustavo.projetolojamaven.view.TelaBusCondicaoPagamento;
import com.fernandoegustavo.projetolojamaven.view.TelaBusVendedor;
import com.fernandoegustavo.projetolojamaven.view.TelaVendas;

public class ControllerCadVendas implements ActionListener {

    TelaVendas telaVendas;
    public static int codigo;
    public static int codigoCliente;
    public static int codigoVendedor;
    public static int counter;
    public static float total;
    public static float totalSemDesconto;
    public static float descontoTotal;
    public static float desconto;

    Random random = new Random();



    public ControllerCadVendas(TelaVendas telaVendas) {
        this.telaVendas = telaVendas;


	telaVendas.getjButtonBuscaProduto().setEnabled(true);
//        telaVendas.getjButtonBuscar.addActionListener(this);
//        telaVendas.getjButtonNovo().addActionListener(this);
//        telaVendas.getjButtonCancelar().addActionListener(this);
//        telaVendas.getjButtonGravar().addActionListener(this);
        telaVendas.getjButtonBuscaProduto().addActionListener(this);
	telaVendas.getjButtonBuscaAluno().addActionListener(this);
	telaVendas.getjButtonBuscaPersonal().addActionListener(this);
	telaVendas.getjButtonInsereDesconto().addActionListener(this);
	telaVendas.getjTFDescontoTotal().setEnabled(false);


	String date = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
	telaVendas.getjTextFieldData().setText(date);

	String hour = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
	telaVendas.getjTextFieldHora().setText(hour);

//        ativa(true);
//        ligaDesliga(false);

	 
	 

    this.telaVendas.getjTextFieldBarraProduto().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
		AddTable(telaVendas.getjTextFieldBarraProduto().getText());
		telaVendas.getjTextFieldBarraProduto().setText("");

                } else if (evt.getKeyCode() == KeyEvent.VK_F1) {
                    abrePesquisaProduto(); 
                } else if (evt.getKeyCode() == KeyEvent.VK_F2) {
		    telaVendas.dispose();
		    
		    TelaVendas telaVenda = new TelaVendas(null, true);
		    ControllerCadVendas controllerCadVendas = new ControllerCadVendas(telaVenda);
		    telaVenda.setVisible(true);
                } else if (evt.getKeyCode() == KeyEvent.VK_F3) {
		    telaVendas.dispose();

                } else if (evt.getKeyCode() == KeyEvent.VK_F4) {
		    System.out.println("AQUI");
		 codigo = 0;
            //chamada da tela da busca
		    System.out.println("AQUIii");
            TelaBusCondicaoPagamento telaBusCondicaoPagamento = new TelaBusCondicaoPagamento(null, true);
            ControllerBusCondicaoPagamento controllerBusCondicaoPagamento = new ControllerBusCondicaoPagamento(telaBusCondicaoPagamento);
            telaBusCondicaoPagamento.setVisible(true);

            if (codigo != 0) {
                CondicaoPagamento condicaoPagamento = new CondicaoPagamento();
                CondicaoPagamentoService condicaoPagamentoService = new CondicaoPagamentoService();
                condicaoPagamento = condicaoPagamentoService.buscar(codigo);
		
		ClienteService clienteService = new ClienteService();
		VendedorService vendedorService = new VendedorService();

//                ativa(false);	


//		System.out.println("ID CLIENTE: "+clienteService.buscar(1).getIdcliente());
		Venda venda = new Venda();
                float serieRandom = random.nextInt(10000) + 1;
                venda.setSerieVenda(String.valueOf(serieRandom));

		String dateStamp = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
                venda.setDtVenda(dateStamp);

		String timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
		venda.setHrVenda(timeStamp);

		venda.setCliente_idcliente(clienteService.buscar(codigoCliente));
		venda.setVendedor_idvendedor(vendedorService.buscar(codigoVendedor));
		venda.setCondicaoPagamento_idcondicaoPagamento(condicaoPagamento);
		venda.setValDescontoVenda(descontoTotal);
		venda.setValTotalVenda(totalSemDesconto);

		VendaDAO vendaDAO = new VendaDAO();

		vendaDAO.create(venda);
		telaVendas.dispose();
}    	    



                } else if (evt.getKeyCode() == KeyEvent.VK_F5) {
					    
		    DefaultTableModel tabela = (DefaultTableModel) telaVendas.getjTable1().getModel();
		    int lastRow = tabela.getRowCount();
		    total -= (float)telaVendas.getjTable1().getValueAt(lastRow -1 ,4);
		    telaVendas.getjLabelTotal().setText(total + "");

		    tabela.removeRow(tabela.getRowCount() - 1);
                }
            }
        });
    
    }        

    //Nesse método controlamos o que fazer quando uma ação acontece
    //Não foram desenvolvidas ainda as funcionalidades de persistência

    public void AddTable(String codBarra) {

	 counter = 0;
	 CaracteristicaProdutoService caracteristicaProdutoService = new CaracteristicaProdutoService();
	 CaracteristicaProduto caracteristicaProduto = new CaracteristicaProduto();
	 
	 caracteristicaProduto = caracteristicaProdutoService.buscar(codBarra);
	 System.out.println(caracteristicaProduto.getBarraProduto());


	    counter++;
            DefaultTableModel tabela = (DefaultTableModel) this.telaVendas.getjTable1().getModel();
            tabela.addRow(new Object[]{ counter,
					caracteristicaProduto.getProduto_idproduto().getIdproduto(),
                                        caracteristicaProduto.getProduto_idproduto().getDescricaoProduto(),
                                        1,
					caracteristicaProduto.getProduto_idproduto().getValProduto(),
					caracteristicaProduto.getProduto_idproduto().getValProduto()});
        
					totalSemDesconto += caracteristicaProduto.getProduto_idproduto().getValProduto();
					System.out.println(totalSemDesconto);
					total += caracteristicaProduto.getProduto_idproduto().getValProduto();
					this.telaVendas.getjLabelTotal().setText(total + "");
					insereDesconto();

}

    
    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaVendas.getjButtonBuscaProduto()) {
            abrePesquisaProduto(); 


        } else if (acao.getSource() == telaVendas.getjButtonBuscaAluno()) {
            codigoCliente = 0;
            //chamada da tela da busca
            TelaBusCliente telaBusCliente = new TelaBusCliente(null, true);
            ControllerBusCliente controllerBusCliente = new ControllerBusCliente(telaBusCliente);
            telaBusCliente.setVisible(true);


            if (codigoCliente != 0) {
                Cliente cliente;
                ClienteService clienteService = new ClienteService();
                cliente = clienteService.buscar(codigoCliente);
		
		this.telaVendas.getjFTFidAluno().setText(codigoCliente + "");
		this.telaVendas.getjFTFNomeAluno().setText(cliente.getNome());

                ativa(false);

            }

        } else if (acao.getSource() == telaVendas.getjButtonBuscaPersonal()) {
            codigoVendedor = 0;
            //chamada da tela da busca
            TelaBusVendedor telaBusVendedor = new TelaBusVendedor(null, true);
            ControllerBusVendedor controllerBusVendedor = new ControllerBusVendedor(telaBusVendedor);
            telaBusVendedor.setVisible(true);


            if (codigoVendedor != 0) {
                Vendedor vendedor;
                VendedorService vendedorService = new VendedorService();
                vendedor = vendedorService.buscar(codigoVendedor);
		
		this.telaVendas.getjFTFidPersonal().setText(codigoVendedor + "");
		this.telaVendas.getjFTFNomePersonal().setText(vendedor.getNome());

                ativa(false);

            }

        } else if (acao.getSource() == telaVendas.getjButtonInsereDesconto()) {

	insereDesconto();
}

    }
    
     public void abrePesquisaProduto() {
         this.telaVendas.getjTextFieldBarraProduto().setEnabled(true);
            //chamada da tela da busca
            TelaBusCaracteristicaProduto telaBusCaracteristicaProduto = new TelaBusCaracteristicaProduto(null, true);
            ControllerBusCaracteristicaProduto controllerBusCaracteristicaProduto = new ControllerBusCaracteristicaProduto(telaBusCaracteristicaProduto);
            telaBusCaracteristicaProduto.setVisible(true);
            
            CaracteristicaProduto caracteristicaProduto;
            CaracteristicaProdutoService caracteristicaProdutoService = new CaracteristicaProdutoService();
	    System.out.println(codigo);
	    if (codigo != 0){
	    caracteristicaProduto = caracteristicaProdutoService.buscar(codigo);
	    AddTable(caracteristicaProduto.getBarraProduto());
	    
}

            ativa(false);

            this.telaVendas.getjTextFieldBarraProduto().setText("");
    }
     
    public void insereDesconto() {
	if(this.telaVendas.getjTFDesconto().getText().equalsIgnoreCase("")){
	return;
} else {
desconto = Float.parseFloat(this.telaVendas.getjTFDesconto().getText());
	System.out.println("DESCONTO NA FUNCAO: " + desconto);

	    if(desconto > 0) {
	    float temp;
	    temp = totalSemDesconto;
	    descontoTotal = desconto/100 * temp ;
		System.out.println("Temp:" + temp);
		System.out.println("DescontoTotal:" + descontoTotal);
		System.out.println("Desconto:" + desconto);


	    total = temp - descontoTotal;
	    this.telaVendas.getjLabelTotal().setText(total + "");
	    this.telaVendas.getjTFDescontoTotal().setText(descontoTotal + "");

    }
}

    }

    //Método para habilitar/desabilitar botões(controle de estados)
    public void ativa(boolean estado) {
        telaVendas.getjButtonBuscaAluno().setEnabled(!estado);
        telaVendas.getjButtonBuscaPersonal().setEnabled(!estado);
//        telaVendas.getjButtonCancelar().setEnabled(!estado);
//        telaVendas.getjButtonGravar().setEnabled(!estado);
//        telaVendas.getjButtonBuscar().setEnabled(estado);
//        telaVendas.getjButtonSair().setEnabled(estado);
    }

    //Método para Ativação/Desativação/Limpeza ds 
    //Componentes do jPanelDados
//    public void ligaDesliga(boolean estado) {
//        Component[] componentes = this.telaVendas.getjTable1().getComponents();
//        for (Component componenteAtual : componentes) {
//            if (componenteAtual instanceof JTextField) {
//                ((JTextField) componenteAtual).setText("");
//                componenteAtual.setEnabled(estado);
//            } else if (componenteAtual instanceof JFormattedTextField) {
//                ((JFormattedTextField) componenteAtual).setText("");
//                componenteAtual.setEnabled(estado);
//            } else if (componenteAtual instanceof JComboBox) {
//                ((JComboBox) componenteAtual).setSelectedIndex(0);
//                componenteAtual.setEnabled(estado);
//            }
//        }
//    }
}
