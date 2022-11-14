package com.fernandoegustavo.projetolojamaven.model.DAO;

import com.fernandoegustavo.projetolojamaven.model.bo.TipoProduto;
import java.util.List;
import com.fernandoegustavo.projetolojamaven.model.bo.TipoProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

public class TipoProdutoDAO implements InterfaceDAO<TipoProduto>{

private static TipoProdutoDAO instance;
    protected EntityManager entityManager;
    
    public static TipoProdutoDAO getInstance() {
        if(instance == null) {
            instance = new TipoProdutoDAO();
        }
        return instance;
    }
    
    public TipoProdutoDAO() {
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
    public void create(TipoProduto objeto) {
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
    public List<TipoProduto> retrieve() {
        List<TipoProduto> cidadesLista;
        CriteriaQuery<TipoProduto> criteria = entityManager.getCriteriaBuilder().createQuery(TipoProduto.class);

        criteria.select(criteria.from(TipoProduto.class));
        cidadesLista = entityManager.createQuery(criteria).getResultList();
        return cidadesLista;
    }
    
    @Override
    public TipoProduto retrieve(int codigo) {
        return entityManager.find(TipoProduto.class, codigo);
    }
    
    @Override
    public void update(TipoProduto objeto) {
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
    public void delete(TipoProduto objeto) {
        try {
            entityManager.getTransaction().begin();
            
            objeto = entityManager.find(TipoProduto.class, objeto.getIdTipoProduto());
            
            entityManager.remove(this);
            entityManager.getTransaction().commit();
            
        } catch (Exception ex) {
            
            ex.printStackTrace();
        }
    }

    @Override
    public TipoProduto retrieve(String descricao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }








//    @Override
//    public void create(TipoProduto objeto) {
//        //Abrindo conexão
//        Connection conexao = ConnectionFactory.getConnection();
//        String sqlExecutar = "INSERT INTO tipoProduto (descricaoTipoProduto) VALUES(?) ";
//        PreparedStatement pstm = null;
//        
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            pstm.setString(1, objeto.getDescricaoTipoProduto());
//            pstm.executeUpdate();
//        } catch(Exception ex){
//            ex.printStackTrace();
//        }
//        //fechar a conexão
//        ConnectionFactory.closeConnection(conexao, pstm);
//    }
//
//    @Override
//    public List<TipoProduto> retrieve() {
//        String sqlExecutar     =   " SELECT idtipoProduto, "
//                                 + " descricaoTipoProduto"
//                                 + " FROM tipoProduto";
//        
//        Connection conexao     = ConnectionFactory.getConnection();
//        PreparedStatement pstm = null;
//        ResultSet rst          = null;
//        List<TipoProduto> tipos = new ArrayList<>();
//        
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            rst = pstm.executeQuery();            
//            
//            while(rst.next()){
//                TipoProduto tipoProduto = new TipoProduto();
//                tipoProduto.setIdTipoProduto(rst.getInt("idtipoProduto"));
//                tipoProduto.setDescricaoTipoProduto(rst.getString("descricaoTipoProduto"));                
//                tipos.add(tipoProduto);
//            }
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return tipos;       
//        } catch(Exception ex){
//            ex.printStackTrace();
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return null;
//        }
//    }
//    @Override
//    public TipoProduto retrieve(int codigo) {
//        String sqlExecutar     =   " SELECT idtipoProduto, "
//                                 + " descricaoTipoProduto"
//                                 + " FROM tipoProduto "
//                                 + " WHERE tipoProduto.idtipoProduto= ?";
//        
//        Connection conexao     = ConnectionFactory.getConnection();
//        PreparedStatement pstm = null;
//        ResultSet rst          = null;
//        
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            pstm.setInt(1, codigo);
//            
//            rst = pstm.executeQuery();  
//            TipoProduto tipoProduto = new TipoProduto();
//            while(rst.next()){
//                tipoProduto.setIdTipoProduto(rst.getInt("idtipoProduto"));
//                tipoProduto.setDescricaoTipoProduto(rst.getString("descricaoTipoProduto"));
//            }
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return tipoProduto; 
//        } catch(Exception ex){
//            ex.printStackTrace();
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return null;
//        }
//          
//    }
//
//    @Override
//    public TipoProduto retrieve(String descricao) {
//        String sqlExecutar     =   " SELECT idtipoProduto, descricaoTipoProduto"
//                                 + " FROM tipoProduto"
//                                 + " WHERE tipoProduto.descricaoTipoProduto= ?";
//        Connection conexao     = ConnectionFactory.getConnection();
//        PreparedStatement pstm = null;
//        ResultSet rst          = null;
//        
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            pstm.setString(1, descricao);
//            rst = pstm.executeQuery();  
//            TipoProduto tipoProduto = new TipoProduto();
//            
//            while(rst.next()){
//                tipoProduto.setIdTipoProduto(rst.getInt("idtipoProduto"));
//                tipoProduto.setDescricaoTipoProduto(rst.getString("descricaoTipoProduto"));
//            }
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//
//            return tipoProduto; 
//        } catch(Exception ex){
//            ex.printStackTrace();
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return null;
//        }  
//    }
//
//    @Override
//    public void update(TipoProduto objeto) {
//        Connection conexao = ConnectionFactory.getConnection();
//        String sqlExecutar = " UPDATE tipoProduto "
//                           + " SET descricaoTipoProduto = ? "
//                           + " WHERE tipoProduto.idtipoProduto = ? ";
//        PreparedStatement pstm = null;
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            pstm.setString(1, objeto.getDescricaoTipoProduto());
//            pstm.setInt(2, objeto.getIdTipoProduto());
//            pstm.executeUpdate();
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//        ConnectionFactory.closeConnection(conexao, pstm);
//    }
//
//    @Override
//    public void delete(TipoProduto objeto) {
//        Connection conexao = ConnectionFactory.getConnection();
//        String sqlExecutar = " DELETE FROM tipoProduto WHERE tipoProduto.idtipoProduto= ? ";
//        PreparedStatement ptsm = null;
//        try {
//            ptsm = conexao.prepareStatement(sqlExecutar);
//            ptsm.setInt(1, objeto.getIdTipoProduto());
//            ptsm.executeUpdate();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        ConnectionFactory.closeConnection(conexao, ptsm);
//   }
//    
}
