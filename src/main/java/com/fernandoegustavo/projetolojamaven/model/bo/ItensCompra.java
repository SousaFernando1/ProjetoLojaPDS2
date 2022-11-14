package com.fernandoegustavo.projetolojamaven.model.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ItensCompra implements Serializable{
	
	@Id
    private int iditensCompra;
    
	@ManyToOne
	private Compra compra_idcompra;
    
	@OneToOne
	private CaracteristicaProduto caracteristicaProduto_idCaracteristicaProduto;
    
	@Column
	private float qtdProduto;
    
	@Column
	private float valunitarioProduto;

    public ItensCompra() {
    }

    public ItensCompra(int iditensCompra, Compra compra_idcompra, CaracteristicaProduto caracteristicaProduto_idCaracteristicaProduto, float qtdProduto, float valunitarioProduto) {
        this.iditensCompra = iditensCompra;
        this.compra_idcompra = compra_idcompra;
        this.caracteristicaProduto_idCaracteristicaProduto = caracteristicaProduto_idCaracteristicaProduto;
        this.qtdProduto = qtdProduto;
        this.valunitarioProduto = valunitarioProduto;
    }

    public int getIditensCompra() {
        return iditensCompra;
    }

    public void setIditensCompra(int iditensCompra) {
        this.iditensCompra = iditensCompra;
    }

    public Compra getCompra_idcompra() {
        return compra_idcompra;
    }

    public void setCompra_idcompra(Compra compra_idcompra) {
        this.compra_idcompra = compra_idcompra;
    }

    public CaracteristicaProduto getCaracteristicaProduto_idCaracteristicaProduto() {
        return caracteristicaProduto_idCaracteristicaProduto;
    }

    public void setCaracteristicaProduto_idCaracteristicaProduto(CaracteristicaProduto caracteristicaProduto_idCaracteristicaProduto) {
        this.caracteristicaProduto_idCaracteristicaProduto = caracteristicaProduto_idCaracteristicaProduto;
    }

    public float getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(float qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public float getValunitarioProduto() {
        return valunitarioProduto;
    }

    public void setValunitarioProduto(float valunitarioProduto) {
        this.valunitarioProduto = valunitarioProduto;
    }

    @Override
    public String toString() {
        return this.getQtdProduto() + ", " + this.getValunitarioProduto();
    }
    
    
}
