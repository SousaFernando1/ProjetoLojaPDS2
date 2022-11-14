package com.fernandoegustavo.projetolojamaven.service;

import com.fernandoegustavo.projetolojamaven.controller.InterfaceService;
import java.util.List;
import com.fernandoegustavo.projetolojamaven.model.DAO.MarcaDAO;
import com.fernandoegustavo.projetolojamaven.model.bo.Marca;

public class MarcaService implements InterfaceService<Marca> {

    @Override
    public  void salvar(Marca objeto) {
        MarcaDAO marcaDAO = new MarcaDAO();
        marcaDAO.create(objeto);
    }

    @Override
    public List<Marca> buscar() {
        MarcaDAO marcaDAO = new MarcaDAO();
        return marcaDAO.retrieve();
    }

    @Override
    public Marca buscar(int codigo) {
        MarcaDAO marcaDAO = new MarcaDAO();
        return marcaDAO.retrieve(codigo);
    }

    @Override
    public Marca buscar(String descricao) {
        MarcaDAO marcaDAO = new MarcaDAO();
        return marcaDAO.retrieve(descricao);
    }

    @Override
    public void atualizar(Marca objeto) {
        MarcaDAO marcaDAO = new MarcaDAO();
        marcaDAO.update(objeto);
    }

    @Override
    public void apagar(Marca objeto) {
        MarcaDAO marcaDAO = new MarcaDAO();
        marcaDAO.delete(objeto);
    }

}
