package com.fernandoegustavo.projetolojamaven.model.DAO;

import java.util.List;
import com.fernandoegustavo.projetolojamaven.model.bo.Bairro;
import com.fernandoegustavo.projetolojamaven.model.bo.Bairro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

public class BairroDAO implements InterfaceDAO<Bairro>{


private static BairroDAO instance;
    protected EntityManager entityManager;
    
    public static BairroDAO getInstance() {
        if(instance == null) {
            instance = new BairroDAO();
        }
        return instance;
    }
    
    public BairroDAO() {
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
    public void create(Bairro objeto) {
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
    public List<Bairro> retrieve() {
     	System.out.println("BairroDao");
	List<Bairro> bairroLista;
        CriteriaQuery<Bairro> criteria = entityManager.getCriteriaBuilder().createQuery(Bairro.class);

        criteria.select(criteria.from(Bairro.class));
        bairroLista = entityManager.createQuery(criteria).getResultList();
        return bairroLista;


    }
    
    @Override
    public Bairro retrieve(int codigo) {
        return entityManager.find(Bairro.class, codigo);
    }
    
    @Override
    public void update(Bairro objeto) {
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
    public void delete(Bairro objeto) {
        try {
            entityManager.getTransaction().begin();
            
            objeto = entityManager.find(Bairro.class, objeto.getIdBairro());
            
            entityManager.remove(this);
            entityManager.getTransaction().commit();
            
        } catch (Exception ex) {
            
            ex.printStackTrace();
        }
    }

    @Override
    public Bairro retrieve(String descricao) {
	return entityManager.find(Bairro.class, descricao);
    }
















//
//    @Override
//    public void create(Bairro objeto) {
//        //Abrindo conexão
//        Connection conexao = ConnectionFactory.getConnection();
//        String sqlExecutar = "INSERT INTO bairro (descricaoBairro, cidadeMae) VALUES(?, ?)";
//        PreparedStatement pstm = null;
//        
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            pstm.setString(1, objeto.getDescricaoBairro());
//            //pstm.setInt(2, objeto.getCidadeMae());
//
//            pstm.executeUpdate();
//        } catch(Exception ex){
//            ex.printStackTrace();
//        }
//        //fechar a conexão
//        ConnectionFactory.closeConnection(conexao, pstm);
//    }
//
//    @Override
//    public List<Bairro> retrieve() {
//        String sqlExecutar     =   " SELECT idbairro, "
//                                 + " descricaoBairro,"
//				 + " cidadeMae"
//                                 + " FROM bairro";
//        
//        Connection conexao     = ConnectionFactory.getConnection();
//        PreparedStatement pstm = null;
//        ResultSet rst          = null;
//        List<Bairro> bairros = new ArrayList<>();
//        
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            rst = pstm.executeQuery();            
//            
//            while(rst.next()){
//                Bairro bairro = new Bairro();
//                bairro.setIdBairro(rst.getInt("idbairro"));
//                bairro.setDescricaoBairro(rst.getString("descricaoBairro"));                
//		//bairro.setCidadeMae(rst.getInt("cidadeMae"));
//                bairros.add(bairro);
//            }
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return bairros;       
//        } catch(Exception ex){
//            ex.printStackTrace();
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return null;
//        }
//    }
//
//    public List<Bairro> retrieveDesc(int cidadeMae) {
//
//        String sqlExecutar     =   " SELECT idbairro, "
//                                 + " descricaoBairro,"
//				 + " cidadeMae"
//                                 + " FROM bairro"
//				 + " WHERE bairro.cidadeMae = ?";
//        
//        Connection conexao     = ConnectionFactory.getConnection();
//        PreparedStatement pstm = null;
//        ResultSet rst          = null;
//        List<Bairro> bairros = new ArrayList<>();
//        
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            pstm.setInt(1, cidadeMae);
//	    rst = pstm.executeQuery();  
//
//            while(rst.next()){
//                Bairro bairro = new Bairro();
//                bairro.setIdBairro(rst.getInt("idbairro"));
//                bairro.setDescricaoBairro(rst.getString("descricaoBairro"));                
////		bairro.setCidadeMae(rst.getInt("cidadeMae"));
//                bairros.add(bairro);
//            }
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//	    System.out.println("TESTEEEEE: " + cidadeMae);
//
//            return bairros;       
//        } catch(Exception ex){
//            ex.printStackTrace();
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return null;
//        }
//    }
//
//
//    @Override
//    public Bairro retrieve(int codigo) {
//        String sqlExecutar     =   " SELECT idbairro, "
//                                 + " descricaoBairro,"
//				 + " cidadeMae"
//                                 + " FROM bairro "
//                                 + " WHERE bairro.idbairro = ?";
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
//            Bairro bairro = new Bairro();
//            while(rst.next()){
//                bairro.setIdBairro(rst.getInt("idbairro"));
//                bairro.setDescricaoBairro(rst.getString("descricaoBairro"));
////		bairro.setCidadeMae(rst.getInt("cidadeMae"));
//            }
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return bairro; 
//        } catch(Exception ex){
//            ex.printStackTrace();
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return null;
//        }
//          
//    }
//
//    @Override
//    public Bairro retrieve(String descricao) {
//        String sqlExecutar     =   " SELECT idbairro, "
//                                 + " descricaoBairro,"
//				 + " cidadeMae"
//                                 + " FROM bairro "
//                                 + " WHERE bairro.descricaoBairro = ?";
//        Connection conexao     = ConnectionFactory.getConnection();
//        PreparedStatement pstm = null;
//        ResultSet rst          = null;
//        
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            pstm.setString(1, descricao);
//            rst = pstm.executeQuery();  
//            Bairro bairro = new Bairro();
//            
//            while(rst.next()){
//                bairro.setIdBairro(rst.getInt("idbairro"));
//                bairro.setDescricaoBairro(rst.getString("descricaoBairro"));
////		bairro.setCidadeMae(rst.getInt("cidadeMae"));
//            }
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//
//            return bairro; 
//        } catch(Exception ex){
//            ex.printStackTrace();
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return null;
//        }  
//    }
//
//    @Override
//    public void update(Bairro objeto) {
//        Connection conexao = ConnectionFactory.getConnection();
//        String sqlExecutar = " UPDATE bairro "
//                           + " SET descricaoBairro = ? ,"
//			   + " cidadeMae = ?"
//                           + " WHERE bairro.idbairro = ? ";
//        PreparedStatement pstm = null;
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            pstm.setString(1, objeto.getDescricaoBairro());
////            pstm.setInt(2, objeto.getCidadeMae());
//            pstm.setInt(3, objeto.getIdBairro());
//            pstm.executeUpdate();
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//        ConnectionFactory.closeConnection(conexao, pstm);
//    }
//
//    @Override
//    public void delete(Bairro objeto) {
//        Connection conexao = ConnectionFactory.getConnection();
//        String sqlExecutar = " DELETE FROM bairro WHERE bairro.idbairro = ? ";
//        PreparedStatement ptsm = null;
//        try {
//            ptsm = conexao.prepareStatement(sqlExecutar);
//            ptsm.setInt(1, objeto.getIdBairro());
//            ptsm.executeUpdate();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        ConnectionFactory.closeConnection(conexao, ptsm);
//   }
    
}
