package com.fernandoegustavo.projetolojamaven.model.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Compra implements Serializable {

	@Id
	private int idcompra;
    
	@OneToOne
	private Fornecedor fornecedor_idfornecedor;
    
	@OneToOne
	private CondicaoPagamento condicaoPagamento_idcondicaoPagamento;
    
	@Column
	private int numNFCompra;
    
	@Column
	private String serieNFCompra;
    
	@Column
	private String dtHRCompra;
    
	@Column
	private float descontoCompra;
    
	@Column
	private float valorTotalCompra;

    public Compra() {
    }

    public Compra(int idcompra, Fornecedor fornecedor_idfornecedor, CondicaoPagamento condicaoPagamento_idcondicaoPagamento, int numNFCompra, String serieNFCompra, String dtHRCompra, float descontoCompra, float valorTotalCompra) {
        this.idcompra = idcompra;
        this.fornecedor_idfornecedor = fornecedor_idfornecedor;
        this.condicaoPagamento_idcondicaoPagamento = condicaoPagamento_idcondicaoPagamento;
        this.numNFCompra = numNFCompra;
        this.serieNFCompra = serieNFCompra;
        this.dtHRCompra = dtHRCompra;
        this.descontoCompra = descontoCompra;
        this.valorTotalCompra = valorTotalCompra;
    }

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public Fornecedor getFornecedor_idfornecedor() {
        return fornecedor_idfornecedor;
    }

    public void setFornecedor_idfornecedor(Fornecedor fornecedor_idfornecedor) {
        this.fornecedor_idfornecedor = fornecedor_idfornecedor;
    }

    public CondicaoPagamento getCondicaoPagamento_idcondicaoPagamento() {
        return condicaoPagamento_idcondicaoPagamento;
    }

    public void setCondicaoPagamento_idcondicaoPagamento(CondicaoPagamento condicaoPagamento_idcondicaoPagamento) {
        this.condicaoPagamento_idcondicaoPagamento = condicaoPagamento_idcondicaoPagamento;
    }

    public int getNumNFCompra() {
        return numNFCompra;
    }

    public void setNumNFCompra(int numNFCompra) {
        this.numNFCompra = numNFCompra;
    }

    public String getSerieNFCompra() {
        return serieNFCompra;
    }

    public void setSerieNFCompra(String serieNFCompra) {
        this.serieNFCompra = serieNFCompra;
    }

    public String getDtHRCompra() {
        return dtHRCompra;
    }

    public void setDtHRCompra(String dtHRCompra) {
        this.dtHRCompra = dtHRCompra;
    }

    public float getDescontoCompra() {
        return descontoCompra;
    }

    public void setDescontoCompra(float descontoCompra) {
        this.descontoCompra = descontoCompra;
    }

    public float getValorTotalCompra() {
        return valorTotalCompra;
    }

    public void setValorTotalCompra(float valorTotalCompra) {
        this.valorTotalCompra = valorTotalCompra;
    }

    @Override
    public String toString() {
        return this.getNumNFCompra() + ", " + this.getSerieNFCompra();
    }
    
    
}
