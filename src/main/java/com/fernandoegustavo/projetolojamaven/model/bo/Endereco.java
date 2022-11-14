package com.fernandoegustavo.projetolojamaven.model.bo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "endereco")
public class Endereco implements Serializable {
    
    @Id 
    private int idCep;
    
    @Column (name = "cepCep")
    private String cepCep;
    
    @Column (name = "logradouroCep")
    private String logradouroCep;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "cidade_idcidade")
    private Cidade cidade;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "bairro_idbairro")
    private Bairro bairro;

    public Endereco() {
    }

    public Endereco(int idCep, String cepCep, String logradouroCep, Cidade cidade, Bairro bairro) {
        this.idCep = idCep;
        this.cepCep = cepCep;
        this.logradouroCep = logradouroCep;
        this.cidade = cidade;
        this.bairro = bairro;
    }

    public int getIdCep() {
        return idCep;
    }

    public void setIdCep(int idCep) {
        this.idCep = idCep;
    }

    public String getCepCep() {
        return cepCep;
    }

    public void setCepCep(String cepCep) {
        this.cepCep = cepCep;
    }

    public String getLogradouroCep() {
        return logradouroCep;
    }

    public void setLogradouroCep(String logradouroCep) {
        this.logradouroCep = logradouroCep;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return  this.getIdCep() + ", " + 
                this.getCepCep() + ", " +
                this.getLogradouroCep() + ", " + 
                this.getCidade().getDescricaoCidade() + ", " +
                this.getBairro().getDescricaoBairro();
    }
    
}
