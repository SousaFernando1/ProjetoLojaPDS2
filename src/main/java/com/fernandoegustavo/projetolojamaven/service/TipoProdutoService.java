package com.fernandoegustavo.projetolojamaven.service;

import com.fernandoegustavo.projetolojamaven.controller.InterfaceService;
import java.util.List;
import com.fernandoegustavo.projetolojamaven.model.DAO.TipoProdutoDAO;
import com.fernandoegustavo.projetolojamaven.model.bo.TipoProduto;

public class TipoProdutoService implements InterfaceService<TipoProduto> {

    @Override
    public  void salvar(TipoProduto objeto) {
        TipoProdutoDAO tipoProdutoDAO = new TipoProdutoDAO();
        tipoProdutoDAO.create(objeto);
    }

    @Override
    public List<TipoProduto> buscar() {        
        TipoProdutoDAO tipoProdutoDAO = new TipoProdutoDAO();
        return tipoProdutoDAO.retrieve();
    }

    @Override
    public TipoProduto buscar(int codigo) {
        TipoProdutoDAO tipoProdutoDAO = new TipoProdutoDAO();
        return tipoProdutoDAO.retrieve(codigo);
    }

    @Override
    public TipoProduto buscar(String descricao) {
        TipoProdutoDAO tipoProdutoDAO = new TipoProdutoDAO();
        return tipoProdutoDAO.retrieve(descricao);
    }

    @Override
    public void atualizar(TipoProduto objeto) {
        TipoProdutoDAO tipoProdutoDAO = new TipoProdutoDAO();
        tipoProdutoDAO.update(objeto);
    }

    @Override
    public void apagar(TipoProduto objeto) {
        TipoProdutoDAO tipoProdutoDAO = new TipoProdutoDAO();
        tipoProdutoDAO.delete(objeto);
    }

}
