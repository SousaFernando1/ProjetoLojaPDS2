//package com.fernandoegustavo.projetolojamaven.model.bo;
//
//import java.io.Serializable;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumns;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
//
//@Entity
//public class ItensVenda implements Serializable {
//    
//    @Id
//    private int iditensVenda;
//    
//    @ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumns ({
//            @JoinColumn(name = "VENDA", referencedColumnName = "idvenda", insertable = false, updatable = false)
//	})
//    private int venda_idvenda;
//    
//    @OneToOne(fetch = FetchType.LAZY)
//    private CaracteristicaProduto caracteristicaProduto_idCaracteristicaProduto;
//    
//    @Column
//    private float valunitarioProduto;
//    
//    @Column
//    private float qtdProduto;
//
//    public ItensVenda() {
//    }
//
//    public ItensVenda(int iditensVenda, int venda_idvenda, CaracteristicaProduto caracteristicaProduto_idCaracteristicaProduto, float valunitarioProduto, float qtdProduto) {
//        this.iditensVenda = iditensVenda;
//        this.venda_idvenda = venda_idvenda;
//        this.caracteristicaProduto_idCaracteristicaProduto = caracteristicaProduto_idCaracteristicaProduto;
//        this.valunitarioProduto = valunitarioProduto;
//        this.qtdProduto = qtdProduto;
//    }
//
//    public int getIditensVenda() {
//        return iditensVenda;
//    }
//
//    public void setIditensVenda(int iditensVenda) {
//        this.iditensVenda = iditensVenda;
//    }
//
//    public int getVenda_idvenda() {
//        return venda_idvenda;
//    }
//
//    public void setVenda_idvenda(int venda_idvenda) {
//        this.venda_idvenda = venda_idvenda;
//    }
//
//    public CaracteristicaProduto getCaracteristicaProduto_idCaracteristicaProduto() {
//        return caracteristicaProduto_idCaracteristicaProduto;
//    }
//
//    public void setCaracteristicaProduto_idCaracteristicaProduto(CaracteristicaProduto caracteristicaProduto_idCaracteristicaProduto) {
//        this.caracteristicaProduto_idCaracteristicaProduto = caracteristicaProduto_idCaracteristicaProduto;
//    }
//
//    public float getValunitarioProduto() {
//        return valunitarioProduto;
//    }
//
//    public void setValunitarioProduto(float valunitarioProduto) {
//        this.valunitarioProduto = valunitarioProduto;
//    }
//
//    public float getQtdProduto() {
//        return qtdProduto;
//    }
//
//    public void setQtdProduto(float qtdProduto) {
//        this.qtdProduto = qtdProduto;
//    }
//
//    @Override
//    public String toString() {
//        return this.getValunitarioProduto() + ", " + this.getQtdProduto();
//    }
//    
//    
//}
