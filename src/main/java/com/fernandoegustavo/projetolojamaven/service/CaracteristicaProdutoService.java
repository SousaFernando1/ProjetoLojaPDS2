package com.fernandoegustavo.projetolojamaven.service;

import com.fernandoegustavo.projetolojamaven.controller.InterfaceService;
import java.util.List;
import com.fernandoegustavo.projetolojamaven.model.DAO.CaracteristicaProdutoDAO;
import com.fernandoegustavo.projetolojamaven.model.bo.CaracteristicaProduto;

public class CaracteristicaProdutoService implements InterfaceService<CaracteristicaProduto> {

    @Override
    public  void salvar(CaracteristicaProduto objeto) {
        CaracteristicaProdutoDAO caracteristicaProdutoDAO = new CaracteristicaProdutoDAO();
        caracteristicaProdutoDAO.create(objeto);
    }

    @Override
    public List<CaracteristicaProduto> buscar() {
        CaracteristicaProdutoDAO caracteristicaProdutoDAO = new CaracteristicaProdutoDAO();
        return caracteristicaProdutoDAO.retrieve();
    }

    @Override
    public CaracteristicaProduto buscar(int codigo) {
        CaracteristicaProdutoDAO caracteristicaProdutoDAO = new CaracteristicaProdutoDAO();
        return caracteristicaProdutoDAO.retrieve(codigo);
    }

    @Override
    public CaracteristicaProduto buscar(String codBarra) {
        CaracteristicaProdutoDAO caracteristicaProdutoDAO = new CaracteristicaProdutoDAO();
        return caracteristicaProdutoDAO.retrieve(codBarra);
    }

    @Override
    public void atualizar(CaracteristicaProduto objeto) {
        CaracteristicaProdutoDAO caracteristicaProdutoDAO = new CaracteristicaProdutoDAO();
        caracteristicaProdutoDAO.update(objeto);
    }

    @Override
    public void apagar(CaracteristicaProduto objeto) {
        CaracteristicaProdutoDAO caracteristicaProdutoDAO = new CaracteristicaProdutoDAO();
        caracteristicaProdutoDAO.delete(objeto);
    }

}
