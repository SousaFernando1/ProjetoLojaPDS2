package com.fernandoegustavo.projetolojamaven.model.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Receber implements Serializable{
	
	@Id
    private int idreceber;
    
	@OneToOne
	private Venda venda_idvenda;
    
	@Column
	private String dtHremissaoRec;
    
	@Column
	private float ValEmissaoRec;
    
	@Column
	private String dtVencimentoRec;
    
	@Column
	private String dtPgtoRec;
    
	@Column
	private float acrescimoRec;
    
	@Column
	private float descontoRec;
    
	@Column
	private float valPagoRec;
    
	@Column
	private String statusRec;

    public Receber() {
    }

    public Receber(int idreceber, Venda venda_idvenda, String dtHremissaoRec, float ValEmissaoRec, String dtVencimentoRec, String dtPgtoRec, float acrescimoRec, float descontoRec, float valPagoRec, String statusRec) {
        this.idreceber = idreceber;
        this.venda_idvenda = venda_idvenda;
        this.dtHremissaoRec = dtHremissaoRec;
        this.ValEmissaoRec = ValEmissaoRec;
        this.dtVencimentoRec = dtVencimentoRec;
        this.dtPgtoRec = dtPgtoRec;
        this.acrescimoRec = acrescimoRec;
        this.descontoRec = descontoRec;
        this.valPagoRec = valPagoRec;
        this.statusRec = statusRec;
    }

    public int getIdreceber() {
        return idreceber;
    }

    public void setIdreceber(int idreceber) {
        this.idreceber = idreceber;
    }

    public Venda getVenda_idvenda() {
        return venda_idvenda;
    }

    public void setVenda_idvenda(Venda venda_idvenda) {
        this.venda_idvenda = venda_idvenda;
    }

    public String getDtHremissaoRec() {
        return dtHremissaoRec;
    }

    public void setDtHremissaoRec(String dtHremissaoRec) {
        this.dtHremissaoRec = dtHremissaoRec;
    }

    public float getValEmissaoRec() {
        return ValEmissaoRec;
    }

    public void setValEmissaoRec(float ValEmissaoRec) {
        this.ValEmissaoRec = ValEmissaoRec;
    }

    public String getDtVencimentoRec() {
        return dtVencimentoRec;
    }

    public void setDtVencimentoRec(String dtVencimentoRec) {
        this.dtVencimentoRec = dtVencimentoRec;
    }

    public String getDtPgtoRec() {
        return dtPgtoRec;
    }

    public void setDtPgtoRec(String dtPgtoRec) {
        this.dtPgtoRec = dtPgtoRec;
    }

    public float getAcrescimoRec() {
        return acrescimoRec;
    }

    public void setAcrescimoRec(float acrescimoRec) {
        this.acrescimoRec = acrescimoRec;
    }

    public float getDescontoRec() {
        return descontoRec;
    }

    public void setDescontoRec(float descontoRec) {
        this.descontoRec = descontoRec;
    }

    public float getValPagoRec() {
        return valPagoRec;
    }

    public void setValPagoRec(float valPagoRec) {
        this.valPagoRec = valPagoRec;
    }

    public String getStatusRec() {
        return statusRec;
    }

    public void setStatusRec(String statusRec) {
        this.statusRec = statusRec;
    }

    @Override
    public String toString() {
        return this.getDtVencimentoRec() + ", " + this.getValPagoRec();
    }
    
    
}
