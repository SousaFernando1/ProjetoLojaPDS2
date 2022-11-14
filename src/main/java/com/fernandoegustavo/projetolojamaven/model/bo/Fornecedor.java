package com.fernandoegustavo.projetolojamaven.model.bo;

import java.io.Serializable;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "fornecedor")
@AttributeOverride(name = "nome", column = @Column(name = "nomeFantasiaFornecedor"))
@AttributeOverride(name = "email", column = @Column(name = "emailFornecedor"))
@AttributeOverride(name = "compleEndereco", column = @Column(name = "compleEnderecoFornecedor"))
@AttributeOverride(name = "cep", column = @Column(name = "cep"))
public class Fornecedor extends Pessoa implements Serializable {
    
    @Id
    @Column (name = "idfornecedor")
    private int idfornecedor;
    
    @Column (name = "razaoSocialFornecedor")
    private String razaoSocialFornecedor;
    
    @Column (name = "cnpjFornecedor")
    private String cnpjFornecedor;
    
    @Column (name = "inscEstadualFornecedor")
    private String inscEstadualFornecedor;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "endereco_idcep")
    private Endereco endereco_idcep;

    public Fornecedor() {
    }

    public Fornecedor(int idfornecedor, String razaoSocialFornecedor, String cnpjFornecedor, String inscEstadualFornecedor, Endereco endereco_idcep, String nome, String compleEndereco, String cep, String email, String status) {
        super(nome, compleEndereco, email);
        this.idfornecedor = idfornecedor;
        this.razaoSocialFornecedor = razaoSocialFornecedor;
        this.cnpjFornecedor = cnpjFornecedor;
        this.inscEstadualFornecedor = inscEstadualFornecedor;
        this.endereco_idcep = endereco_idcep;
    }

    public int getIdfornecedor() {
        return idfornecedor;
    }

    public void setIdfornecedor(int idfornecedor) {
        this.idfornecedor = idfornecedor;
    }
    
    public String getRazaoSocialFornecedor() {
        return razaoSocialFornecedor;
    }

    public void setRazaoSocialFornecedor(String razaoSocialFornecedor) {
        this.razaoSocialFornecedor = razaoSocialFornecedor;
    }

    public String getCnpjFornecedor() {
        return cnpjFornecedor;
    }

    public void setCnpjFornecedor(String cnpjFornecedor) {
        this.cnpjFornecedor = cnpjFornecedor;
    }

    public String getInscEstadualFornecedor() {
        return inscEstadualFornecedor;
    }

    public void setInscEstadualFornecedor(String inscEstadualFornecedor) {
        this.inscEstadualFornecedor = inscEstadualFornecedor;
    }

    public Endereco getEndereco_idcep() {
        return endereco_idcep;
    }

    public void setEndereco_idcep(Endereco endereco_idcep) {
        this.endereco_idcep = endereco_idcep;
    }

    @Override
    public String toString() {
        return this.getRazaoSocialFornecedor() + ", " + this.getCnpjFornecedor() + ", " + this.getInscEstadualFornecedor();
    }
    
    
    
}
