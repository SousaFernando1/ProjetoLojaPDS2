package com.fernandoegustavo.projetolojamaven.model.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "caracteristicaProduto")
public class CaracteristicaProduto implements Serializable{
	
	@Id
	@Column (name = "idCaracteristicaProduto")
    private int idCaracteristicaProduto;
    
	@OneToOne
	@JoinColumn (name = "produto_idproduto")
	private Produto produto_idproduto;
    
	@OneToOne
	@JoinColumn (name = "cor_idcor")
	private Cor cor_idcor;
    
	@Column (name = "tamanhoProduto")
	private String tamanhoProduto;
    
	@Column (name = "barraProduto")
	private String barraProduto;
    
	@Column (name = "qtdEstoqueProduto")
    private float qtdEstoqueProduto;

    public CaracteristicaProduto() {
    }

    public CaracteristicaProduto(int idCaracteristicaProduto, Produto produto_idproduto, Cor cor_idcor, String tamanhoProduto, String barraProduto, float qtdEstoqueProduto) {
        this.idCaracteristicaProduto = idCaracteristicaProduto;
        this.produto_idproduto = produto_idproduto;
        this.cor_idcor = cor_idcor;
        this.tamanhoProduto = tamanhoProduto;
        this.barraProduto = barraProduto;
        this.qtdEstoqueProduto = qtdEstoqueProduto;
    }

    public int getIdCaracteristicaProduto() {
        return idCaracteristicaProduto;
    }

    public void setIdCaracteristicaProduto(int idCaracteristicaProduto) {
        this.idCaracteristicaProduto = idCaracteristicaProduto;
    }

    public Produto getProduto_idproduto() {
        return produto_idproduto;
    }

    public void setProduto_idproduto(Produto produto_idproduto) {
        this.produto_idproduto = produto_idproduto;
    }

    public Cor getCor_idcor() {
        return cor_idcor;
    }

    public void setCor_idcor(Cor cor_idcor) {
        this.cor_idcor = cor_idcor;
    }

    public String getTamanhoProduto() {
        return tamanhoProduto;
    }

    public void setTamanhoProduto(String tamanhoProduto) {
        this.tamanhoProduto = tamanhoProduto;
    }

    public String getBarraProduto() {
        return barraProduto;
    }

    public void setBarraProduto(String barraProduto) {
        this.barraProduto = barraProduto;
    }

    public float getQtdEstoqueProduto() {
        return qtdEstoqueProduto;
    }

    public void setQtdEstoqueProduto(float qtdEstoqueProduto) {
        this.qtdEstoqueProduto = qtdEstoqueProduto;
    }

    @Override
    public String toString() {
        return this.barraProduto;
    }
    
    
}
