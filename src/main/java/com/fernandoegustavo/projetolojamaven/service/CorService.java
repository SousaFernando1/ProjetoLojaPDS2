package com.fernandoegustavo.projetolojamaven.service;

import com.fernandoegustavo.projetolojamaven.controller.InterfaceService;
import java.util.List;
import com.fernandoegustavo.projetolojamaven.model.DAO.CorDAO;
import com.fernandoegustavo.projetolojamaven.model.bo.Cor;

public class CorService implements InterfaceService<Cor> {

    @Override
    public  void salvar(Cor objeto) {
        CorDAO corDAO = new CorDAO();
        corDAO.create(objeto);
    }

    @Override
    public List<Cor> buscar() {
        CorDAO corDAO = new CorDAO();
        return corDAO.retrieve();
    }

    @Override
    public Cor buscar(int codigo) {
        CorDAO corDAO = new CorDAO();
        return corDAO.retrieve(codigo);
    }

    @Override
    public Cor buscar(String descricao) {
        CorDAO corDAO = new CorDAO();
        return corDAO.retrieve(descricao);
    }

    @Override
    public void atualizar(Cor objeto) {
        CorDAO corDAO = new CorDAO();
        corDAO.update(objeto);
    }

    @Override
    public void apagar(Cor objeto) {
        CorDAO corDAO = new CorDAO();
        corDAO.delete(objeto);
    }

}
