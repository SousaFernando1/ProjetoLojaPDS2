package com.fernandoegustavo.projetolojamaven.model.bo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "cor")
public class Cor implements Serializable {
    
    @Id
    @Column (name="idCor")
    private int idCor;
    
    @Column (name = "descricaoCor")
    private String descricaoCor;

    public Cor() {
    }

    public Cor(int idCor, String descricaoCor) {
        this.idCor = idCor;
        this.descricaoCor = descricaoCor;
    }

    public int getIdCor() {
        return idCor;
    }

    public void setIdCor(int idCor) {
        this.idCor = idCor;
    }

    public String getDescricaoCor() {
        return descricaoCor;
    }

    public void setDescricaoCor(String descricaoCor) {
        this.descricaoCor = descricaoCor;
    }

    @Override
    public String toString() {
        return this.getIdCor() + ", " + this.getDescricaoCor();
    }
    
    
}
