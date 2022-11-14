package com.fernandoegustavo.projetolojamaven.model.DAO;

import com.fernandoegustavo.projetolojamaven.model.bo.Venda;
import java.util.List;
import com.fernandoegustavo.projetolojamaven.model.bo.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

public class VendaDAO implements InterfaceDAO<Venda>{

private static VendaDAO instance;
    protected EntityManager entityManager;
    
    public static VendaDAO getInstance() {
        if(instance == null) {
            instance = new VendaDAO();
        }
        return instance;
    }
    
    public VendaDAO() {
        entityManager = getEntityManager();
    }
    
    private EntityManager getEntityManager() {
        EntityManagerFactory factory =  Persistence.createEntityManagerFactory("LojaPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        } 
        
        return entityManager;
    }
    
    @Override
    public void create(Venda objeto) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(objeto);
            entityManager.getTransaction().commit();
            
        } catch (Exception ex) {
            
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public List<Venda> retrieve() {
        List<Venda> cidadesLista;
        CriteriaQuery<Venda> criteria = entityManager.getCriteriaBuilder().createQuery(Venda.class);

        criteria.select(criteria.from(Venda.class));
        cidadesLista = entityManager.createQuery(criteria).getResultList();
        return cidadesLista;
    }
    
    public Venda retrieve(int codigo) {
        return entityManager.find(Venda.class, codigo);
    }
    
    @Override
    public void update(Venda objeto) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(objeto);
            entityManager.getTransaction().commit();
            
        } catch (Exception ex) {
            
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    @Override
    public void delete(Venda objeto) {
        try {
            entityManager.getTransaction().begin();
            
            objeto = entityManager.find(Venda.class, objeto.getIdvenda());
            
            entityManager.remove(this);
            entityManager.getTransaction().commit();
            
        } catch (Exception ex) {
            
            ex.printStackTrace();
        }
    }

    @Override
    public Venda retrieve(String descricao) {
        return entityManager.find(Venda.class, descricao);
    }










//    public void create(Venda objeto) {
//        //Abrindo conexão
//        Connection conexao = ConnectionFactory.getConnection();
//        String sqlExecutar = "INSERT INTO venda (serieVenda, dtVenda, hrVenda, valDescontoVenda, valTotalVenda, cliente_idcliente, condicaoPagamento_idcondicaoPagamento, vendedor_idvendedor, diaVencimentoParcela) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
//        PreparedStatement pstm = null;
//        
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            pstm.setString(1, objeto.getSerieVenda());
//            pstm.setString(2, objeto.getDtVenda());
//            pstm.setString(3, objeto.getHrVenda());
//            pstm.setFloat(4, objeto.getValDescontoVenda());
//            pstm.setFloat(5, objeto.getValTotalVenda());
//            pstm.setInt(6, objeto.getCliente_idcliente().getIdcliente());
//            pstm.setInt(7, objeto.getCondicaoPagamento_idcondicaoPagamento().getIdcondicaoPagamento());
//            pstm.setInt(8, objeto.getVendedor_idvendedor().getIdvendedor());
//            pstm.setInt(9, objeto.getDiaVencimentoParcela());
//
//
//
//            pstm.executeUpdate();
//        } catch(Exception ex){
//            ex.printStackTrace();
//        }
//        //fechar a conexão
//        ConnectionFactory.closeConnection(conexao, pstm);
//    }
//
//
//
//   

   

    
}
