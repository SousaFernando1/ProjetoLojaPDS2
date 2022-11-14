package com.fernandoegustavo.projetolojamaven.model.bo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Entity
public class FoneFornecedor implements Serializable {
    
	@Id
    @Column (name = "foneFornecedor")
    private String foneFornecedor;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns ({
		@JoinColumn(name = "fornecedor", referencedColumnName = "idfornecedor", insertable = false, updatable = false)
	})
    private Fornecedor fornecedor_idfornecedor;

    public FoneFornecedor() {
    }

    public FoneFornecedor(String foneFornecedor, Fornecedor fornecedor_idfornecedor) {
        this.foneFornecedor = foneFornecedor;
        this.fornecedor_idfornecedor = fornecedor_idfornecedor;
    }

    public String getFoneFornecedor() {
        return foneFornecedor;
    }

    public void setFoneFornecedor(String foneFornecedor) {
        this.foneFornecedor = foneFornecedor;
    }

    public Fornecedor getFornecedor_idfornecedor() {
        return fornecedor_idfornecedor;
    }

    public void setFornecedor_idfornecedor(Fornecedor fornecedor_idfornecedor) {
        this.fornecedor_idfornecedor = fornecedor_idfornecedor;
    }

    @Override
    public String toString() {
        return this.getFoneFornecedor();
    }
    
    
}
