package com.fernandoegustavo.projetolojamaven.model.bo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "marca")
public class Marca implements Serializable {
    
    @Id
    private int idMarca;
    
    @Column (name = "descricaoMarca")
    private String descricaoMarca;

    public Marca() {
    }

    public Marca(int idMarca, String descricaoMarca) {
        this.idMarca = idMarca;
        this.descricaoMarca = descricaoMarca;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getDescricaoMarca() {
        return descricaoMarca;
    }

    public void setDescricaoMarca(String descricaoMarca) {
        this.descricaoMarca = descricaoMarca;
    }

    @Override
    public String toString() {
        return this.getIdMarca() + ", " + this.getDescricaoMarca();
    }
    
    
}
