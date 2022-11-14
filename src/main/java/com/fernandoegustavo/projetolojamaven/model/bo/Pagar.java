package com.fernandoegustavo.projetolojamaven.model.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pagar implements Serializable{
	
	@Id
    private int idpagar;
    
	@OneToOne
	private Compra compra_idcompra;
    
	@Column
	private String dtHrEmissaoPagar;
    
	@Column
	private String dtVencimentoPagar;
    
	@Column
	private float valemitidoPagar;
    
	@Column
	private float acrescimoPagar;
    
	@Column
	private float descontoPagar;
    
	@Column
	private String dtHrPgtoPagar;
    
	@Column
	private float valPagoPagar;
    
	@Column
	private String statusPagar;

    public Pagar() {
    }

    public Pagar(int idpagar, Compra compra_idcompra, String dtHrEmissaoPagar, String dtVencimentoPagar, float valemitidoPagar, float acrescimoPagar, float descontoPagar, String dtHrPgtoPagar, float valPagoPagar, String statusPagar) {
        this.idpagar = idpagar;
        this.compra_idcompra = compra_idcompra;
        this.dtHrEmissaoPagar = dtHrEmissaoPagar;
        this.dtVencimentoPagar = dtVencimentoPagar;
        this.valemitidoPagar = valemitidoPagar;
        this.acrescimoPagar = acrescimoPagar;
        this.descontoPagar = descontoPagar;
        this.dtHrPgtoPagar = dtHrPgtoPagar;
        this.valPagoPagar = valPagoPagar;
        this.statusPagar = statusPagar;
    }

    public int getIdpagar() {
        return idpagar;
    }

    public void setIdpagar(int idpagar) {
        this.idpagar = idpagar;
    }

    public Compra getCompra_idcompra() {
        return compra_idcompra;
    }

    public void setCompra_idcompra(Compra compra_idcompra) {
        this.compra_idcompra = compra_idcompra;
    }

    public String getDtHrEmissaoPagar() {
        return dtHrEmissaoPagar;
    }

    public void setDtHrEmissaoPagar(String dtHrEmissaoPagar) {
        this.dtHrEmissaoPagar = dtHrEmissaoPagar;
    }

    public String getDtVencimentoPagar() {
        return dtVencimentoPagar;
    }

    public void setDtVencimentoPagar(String dtVencimentoPagar) {
        this.dtVencimentoPagar = dtVencimentoPagar;
    }

    public float getValemitidoPagar() {
        return valemitidoPagar;
    }

    public void setValemitidoPagar(float valemitidoPagar) {
        this.valemitidoPagar = valemitidoPagar;
    }

    public float getAcrescimoPagar() {
        return acrescimoPagar;
    }

    public void setAcrescimoPagar(float acrescimoPagar) {
        this.acrescimoPagar = acrescimoPagar;
    }

    public float getDescontoPagar() {
        return descontoPagar;
    }

    public void setDescontoPagar(float descontoPagar) {
        this.descontoPagar = descontoPagar;
    }

    public String getDtHrPgtoPagar() {
        return dtHrPgtoPagar;
    }

    public void setDtHrPgtoPagar(String dtHrPgtoPagar) {
        this.dtHrPgtoPagar = dtHrPgtoPagar;
    }

    public float getValPagoPagar() {
        return valPagoPagar;
    }

    public void setValPagoPagar(float valPagoPagar) {
        this.valPagoPagar = valPagoPagar;
    }

    public String getStatusPagar() {
        return statusPagar;
    }

    public void setStatusPagar(String statusPagar) {
        this.statusPagar = statusPagar;
    }

    @Override
    public String toString() {
        return this.getDtVencimentoPagar() + ", " + this.getValPagoPagar();
    }
    
    
}
