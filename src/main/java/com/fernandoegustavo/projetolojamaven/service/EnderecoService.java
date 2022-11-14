package com.fernandoegustavo.projetolojamaven.service;

import com.fernandoegustavo.projetolojamaven.controller.InterfaceService;
import java.util.List;
import com.fernandoegustavo.projetolojamaven.model.DAO.EnderecoDAO;
import com.fernandoegustavo.projetolojamaven.model.bo.Endereco;

public class EnderecoService implements InterfaceService<Endereco> {

    @Override
    public  void salvar(Endereco objeto) {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.create(objeto);
    }

    @Override
    public List<Endereco> buscar() {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        return enderecoDAO.retrieve();
    }

    @Override
    public Endereco buscar(int codigo) {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        return enderecoDAO.retrieve(codigo);
    }

    @Override
    public Endereco buscar(String descricao) {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        return enderecoDAO.retrieve(descricao);
    }

    @Override
    public void atualizar(Endereco objeto) {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.update(objeto);
    }

    @Override
    public void apagar(Endereco objeto) {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.delete(objeto);
    }

}
