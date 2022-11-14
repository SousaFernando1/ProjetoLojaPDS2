package com.fernandoegustavo.projetolojamaven.service;

import com.fernandoegustavo.projetolojamaven.controller.InterfaceService;
import java.util.List;
import com.fernandoegustavo.projetolojamaven.model.DAO.TamanhoDAO;
import com.fernandoegustavo.projetolojamaven.model.bo.Tamanho;

public class TamanhoService implements InterfaceService<Tamanho> {

    @Override
    public  void salvar(Tamanho objeto) {
        TamanhoDAO tamanhoDAO = new TamanhoDAO();
        tamanhoDAO.create(objeto);
    }

    @Override
    public List<Tamanho> buscar() {
        TamanhoDAO tamanhoDAO = new TamanhoDAO();
        return tamanhoDAO.retrieve();
    }

    @Override
    public Tamanho buscar(int codigo) {
        TamanhoDAO tamanhoDAO = new TamanhoDAO();
        return tamanhoDAO.retrieve(codigo);
    }

    @Override
    public Tamanho buscar(String descricao) {
        TamanhoDAO tamanhoDAO = new TamanhoDAO();
        return tamanhoDAO.retrieve(descricao);
    }

    @Override
    public void atualizar(Tamanho objeto) {
        TamanhoDAO tamanhoDAO = new TamanhoDAO();
        tamanhoDAO.update(objeto);
    }

    @Override
    public void apagar(Tamanho objeto) {
        TamanhoDAO tamanhoDAO = new TamanhoDAO();
        tamanhoDAO.delete(objeto);
    }

}
