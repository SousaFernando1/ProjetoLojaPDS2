package com.fernandoegustavo.projetolojamaven.model.bo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tamanho")
public class Tamanho implements Serializable {
    
    @Id
    private int idTamanho;
    
    @Column (name = "descricaoTamanho")
    private String descricaoTamanho;

    public Tamanho() {
    }

    public Tamanho(int idTamanho, String descricaoTamanho) {
        this.idTamanho = idTamanho;
        this.descricaoTamanho = descricaoTamanho;
    }

    public int getIdTamanho() {
        return idTamanho;
    }

    public void setIdTamanho(int idTamanho) {
        this.idTamanho = idTamanho;
    }

    public String getDescricaoTamanho() {
        return descricaoTamanho;
    }

    public void setDescricaoTamanho(String descricaoTamanho) {
        this.descricaoTamanho = descricaoTamanho;
    }

    @Override
    public String toString() {
        return this.getIdTamanho() + ", " + this.getDescricaoTamanho();
    }
    
    
}
