package com.fernandoegustavo.projetolojamaven.model.DAO;

import java.util.List;
import com.fernandoegustavo.projetolojamaven.model.bo.Cor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

public class CorDAO implements InterfaceDAO<Cor>{




private static CorDAO instance;
    protected EntityManager entityManager;
    
    public static CorDAO getInstance() {
        if(instance == null) {
            instance = new CorDAO();
        }
        return instance;
    }
    
    public CorDAO() {
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
    public void create(Cor objeto) {
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
    public List<Cor> retrieve() {
        List<Cor> cidadesLista;
        CriteriaQuery<Cor> criteria = entityManager.getCriteriaBuilder().createQuery(Cor.class);

        criteria.select(criteria.from(Cor.class));
        cidadesLista = entityManager.createQuery(criteria).getResultList();
        return cidadesLista;
    }
    
    @Override
    public Cor retrieve(int codigo) {
        return entityManager.find(Cor.class, codigo);
    }
    
    @Override
    public void update(Cor objeto) {
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
    public void delete(Cor objeto) {
        try {
            entityManager.getTransaction().begin();
            
            objeto = entityManager.find(Cor.class, objeto.getIdCor());
            
            entityManager.remove(this);
            entityManager.getTransaction().commit();
            
        } catch (Exception ex) {
            
            ex.printStackTrace();
        }
    }

    @Override
    public Cor retrieve(String descricao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }










//    @Override
//    public void create(Cor objeto) {
//        //Abrindo conexão
//        Connection conexao = ConnectionFactory.getConnection();
//        String sqlExecutar = "INSERT INTO cor (descricaoCor) VALUES(?)";
//        PreparedStatement pstm = null;
//        
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            pstm.setString(1, objeto.getDescricaoCor());
//            pstm.executeUpdate();
//        } catch(Exception ex){
//            ex.printStackTrace();
//        }
//        //fechar a conexão
//        ConnectionFactory.closeConnection(conexao, pstm);
//    }
//
//    @Override
//    public List<Cor> retrieve() {
//        String sqlExecutar     =   " SELECT idcor, "
//                                 + " descricaoCor  "
//                                 + " FROM cor";
//        
//        Connection conexao     = ConnectionFactory.getConnection();
//        PreparedStatement pstm = null;
//        ResultSet rst          = null;
//        List<Cor> cores = new ArrayList<>();
//        
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            rst = pstm.executeQuery();            
//            
//            while(rst.next()){
//                Cor cor = new Cor();
//                cor.setIdCor(rst.getInt("idcor"));
//                cor.setDescricaoCor(rst.getString("descricaoCor"));
//                cores.add(cor);
//            }
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return cores;       
//        } catch(Exception ex){
//            ex.printStackTrace();
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return null;
//        }
//    }
//    @Override
//    public Cor retrieve(int codigo) {
//        String sqlExecutar     =  " SELECT idcor, "
//                                 + " descricaoCor  "
//                                 + " FROM cor"
//                                 + " WHERE cor.idcor = ?";
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
//
//            Cor cor = new Cor();
//            while(rst.next()){
//                cor.setIdCor(rst.getInt("idcor"));
//                cor.setDescricaoCor(rst.getString("descricaoCor"));
//            }
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return cor; 
//        } catch(Exception ex){
//            ex.printStackTrace();
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return null;
//        }
//          
//    }
//
//    @Override
//    public Cor retrieve(String descricao) {
//        String sqlExecutar     =   " SELECT idcor, "
//                                 + " descricaoCor  "
//                                 + " FROM cor"
//                                 + " WHERE cor.descricaoCor = ?";
//        Connection conexao     = ConnectionFactory.getConnection();
//        PreparedStatement pstm = null;
//        ResultSet rst          = null;
//        
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            pstm.setString(1, descricao);
//            rst = pstm.executeQuery();  
//            Cor cor = new Cor();
//            
//            while(rst.next()){
//                cor.setIdCor(rst.getInt("idcor"));
//                cor.setDescricaoCor(rst.getString("descricaoCor"));
//            }
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//
//            return cor; 
//        } catch(Exception ex){
//            ex.printStackTrace();
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return null;
//        }  
//    }
//
//    @Override
//    public void update(Cor objeto) {
//        Connection conexao = ConnectionFactory.getConnection();
//        String sqlExecutar = " UPDATE cor "
//                           + " SET descricaoCor   = ? "
//                           + " WHERE cor.idcor = ? ";
//        PreparedStatement pstm = null;
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            pstm.setString(1, objeto.getDescricaoCor());
//            pstm.setInt(2, objeto.getIdCor());
//            pstm.executeUpdate();
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//        ConnectionFactory.closeConnection(conexao, pstm);
//    }
//
//    @Override
//    public void delete(Cor objeto) {
//        Connection conexao = ConnectionFactory.getConnection();
//        String sqlExecutar = " DELETE FROM cor WHERE cor.idcor = ? ";
//        PreparedStatement ptsm = null;
//        try {
//            ptsm = conexao.prepareStatement(sqlExecutar);
//            ptsm.setInt(1, objeto.getIdCor());
//            ptsm.executeUpdate();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        ConnectionFactory.closeConnection(conexao, ptsm);
//   }
    
}
