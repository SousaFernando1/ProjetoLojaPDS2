package com.fernandoegustavo.projetolojamaven.model.DAO;

import com.fernandoegustavo.projetolojamaven.model.bo.FoneFornecedor;
import java.util.List;
import com.fernandoegustavo.projetolojamaven.model.bo.FoneFornecedor;
import com.fernandoegustavo.projetolojamaven.model.bo.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;


public class FoneFornecedorDAO implements InterfaceDAO<FoneFornecedor>{
private static FoneFornecedorDAO instance;
    protected EntityManager entityManager;
    
    public static FoneFornecedorDAO getInstance() {
        if(instance == null) {
            instance = new FoneFornecedorDAO();
        }
        return instance;
    }
    
    public FoneFornecedorDAO() {
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
    public void create(FoneFornecedor objeto) {
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
    public List<FoneFornecedor> retrieve() {
        List<FoneFornecedor> cidadesLista;
        CriteriaQuery<FoneFornecedor> criteria = entityManager.getCriteriaBuilder().createQuery(FoneFornecedor.class);

        criteria.select(criteria.from(FoneFornecedor.class));
        cidadesLista = entityManager.createQuery(criteria).getResultList();
        return cidadesLista;
    }
    
    @Override
    public FoneFornecedor retrieve(int codigo) {
        return entityManager.find(FoneFornecedor.class, codigo);
    }
    
    @Override
    public void update(FoneFornecedor objeto) {
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
    public void delete(FoneFornecedor objeto) {
        try {
            entityManager.getTransaction().begin();
            
            objeto = entityManager.find(FoneFornecedor.class, objeto.getFoneFornecedor());
            
            entityManager.remove(this);
            entityManager.getTransaction().commit();
            
        } catch (Exception ex) {
            
            ex.printStackTrace();
        }
    }

    @Override
    public FoneFornecedor retrieve(String descricao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }










//
//    @Override
//    public void create(FoneFornecedor objeto) {
//        //Abrindo conexão
//        Connection conexao = ConnectionFactory.getConnection();
//        String sqlExecutar = "INSERT INTO foneFornecedor (foneFornecedor, fornecedor_idfornecedor) VALUES(?, ?)";
//        PreparedStatement pstm = null;
//        
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            pstm.setString(1, objeto.getFoneFornecedor());
//            pstm.setInt(2, objeto.getFornecedor_idfornecedor().getIdfornecedor());
//            pstm.executeUpdate();
//        } catch(Exception ex){
//            ex.printStackTrace();
//        }
//        //fechar a conexão
//        ConnectionFactory.closeConnection(conexao, pstm);
//    }
//
//    @Override
//    public List<FoneFornecedor> retrieve() {
//        String sqlExecutar     =   " SELECT foneFornecedor, fornecedor_idfornecedor"
//                                 + " FROM foneFornecedor";
//        
//        Connection conexao     = ConnectionFactory.getConnection();
//        PreparedStatement pstm = null;
//        ResultSet rst          = null;
//        List<FoneFornecedor> fones = new ArrayList<>();
//        
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            rst = pstm.executeQuery();            
//            
//            while(rst.next()){
//                FoneFornecedor foneFornecedor = new FoneFornecedor();
//                foneFornecedor.setFoneFornecedor(rst.getString("foneFornecedor"));
//		
//		FornecedorDAO fornecedorDAO = new FornecedorDAO();
//		Fornecedor fornecedor = new Fornecedor();
//		fornecedor = fornecedorDAO.retrieve(rst.getString("fornecedor_idfornecedor"));
//
//                foneFornecedor.setFornecedor_idfornecedor(fornecedor);
//                fones.add(foneFornecedor);
//            }
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return fones;       
//        } catch(Exception ex){
//            ex.printStackTrace();
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return null;
//        }
//    }
//    @Override
//    public FoneFornecedor retrieve(int codigo) {
//        String sqlExecutar     =  " SELECT foneFornecedor,"
//				 + " fornecedor_idfornecedor"
//                                 + " FROM foneFornecedor"
//                                 + " WHERE foneFornecedor.foneFornecedor = ?";
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
//            FoneFornecedor foneFornecedor = new FoneFornecedor();
//            while(rst.next()){
//                foneFornecedor.setFoneFornecedor(rst.getString("foneFornecedor"));
////                foneFornecedor.setFornecedor_idFornecedor(rst.getObject("fornecedor_idfornecedor"));
//            }
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return foneFornecedor; 
//        } catch(Exception ex){
//            ex.printStackTrace();
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return null;
//        }
//          
//    }
//
//    @Override
//    public FoneFornecedor retrieve(String descricao) {
//        String sqlExecutar     =   " SELECT foneFornecedor, "
//				 + "fornecedor_idfornecedor"
//                                 + " FROM foneFornecedor"
//                                 + " WHERE foneFornecedor.foneFornecedor = ?";
//        Connection conexao     = ConnectionFactory.getConnection();
//        PreparedStatement pstm = null;
//        ResultSet rst          = null;
//        
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            pstm.setString(1, descricao);
//            rst = pstm.executeQuery();  
//            FoneFornecedor foneFornecedor = new FoneFornecedor();
//            
//            while(rst.next()){
//                foneFornecedor.setFoneFornecedor(rst.getString("foneFornecedor"));
////                foneFornecedor.setFornecedor_idfornecedor(rst.getString("fornecedor_idfornecedor"));
//            }
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//
//            return foneFornecedor; 
//        } catch(Exception ex){
//            ex.printStackTrace();
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return null;
//        }  
//    }
//
//    @Override
//    public void update(FoneFornecedor objeto) {
//        Connection conexao = ConnectionFactory.getConnection();
//        String sqlExecutar = " UPDATE foneFornecedor "
//                           + " SET foneFornecedor   = ?,"
//			   + " fornecedor_idfornecedor = ?"
//                           + " WHERE foneFornecedor = ? ";
//        PreparedStatement pstm = null;
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            pstm.setString(1, objeto.getFoneFornecedor());
//            pstm.setObject(2, objeto.getFornecedor_idfornecedor());
//            pstm.executeUpdate();
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//        ConnectionFactory.closeConnection(conexao, pstm);
//    }
//
//    @Override
//    public void delete(FoneFornecedor objeto) {
//        Connection conexao = ConnectionFactory.getConnection();
//        String sqlExecutar = " DELETE FROM foneFornecedor WHERE foneFornecedor.foneFornecedor = ? ";
//        PreparedStatement ptsm = null;
//        try {
//            ptsm = conexao.prepareStatement(sqlExecutar);
//            ptsm.setString(1, objeto.getFoneFornecedor());
//            ptsm.executeUpdate();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        ConnectionFactory.closeConnection(conexao, ptsm);
//   }
//    
}
