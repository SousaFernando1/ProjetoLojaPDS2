package com.fernandoegustavo.projetolojamaven.model.bo;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class Pessoa {
    @Column
    private String nome;
    
    @Column
    private String compleEndereco;
    
    @Column
    private String email;
    

    public Pessoa() {
    }

    public Pessoa(String nome, String compleEndereco, String email) {
        this.nome = nome;
        this.compleEndereco = compleEndereco;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCompleEndereco() {
        return compleEndereco;
    }

    public void setCompleEndereco(String compleEndereco) {
        this.compleEndereco = compleEndereco;
    
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public String toString() {
        return this.getNome() + ", " + this.getEmail();
    }
    
    
}
