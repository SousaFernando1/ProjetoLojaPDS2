/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernandoegustavo.projetolojamaven.model.DAO;

import com.fernandoegustavo.projetolojamaven.model.bo.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.fernandoegustavo.projetolojamaven.model.bo.Fornecedor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author gusta
 */
public class FornecedorDAO implements InterfaceDAO<Fornecedor>{


private static FornecedorDAO instance;
    protected EntityManager entityManager;
    
    public static FornecedorDAO getInstance() {
        if(instance == null) {
            instance = new FornecedorDAO();
        }
        return instance;
    }
    
    public FornecedorDAO() {
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
    public void create(Fornecedor objeto) {
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
    public List<Fornecedor> retrieve() {
        List<Fornecedor> cidadesLista;
        CriteriaQuery<Fornecedor> criteria = entityManager.getCriteriaBuilder().createQuery(Fornecedor.class);

        criteria.select(criteria.from(Fornecedor.class));
        cidadesLista = entityManager.createQuery(criteria).getResultList();
        return cidadesLista;
    }
    
    @Override
    public Fornecedor retrieve(int codigo) {
        return entityManager.find(Fornecedor.class, codigo);
    }

    @Override
    public Fornecedor retrieve(String cnpj) {
        return entityManager.find(Fornecedor.class, cnpj);
    }
    
    @Override
    public void update(Fornecedor objeto) {
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
    public void delete(Fornecedor objeto) {
        try {
            entityManager.getTransaction().begin();
            
            objeto = entityManager.find(Fornecedor.class, objeto.getIdfornecedor());
            
            entityManager.remove(this);
            entityManager.getTransaction().commit();
            
        } catch (Exception ex) {
            
            ex.printStackTrace();
        }
    }





    


//    @Override
//    public void create(Fornecedor objeto) {
//        //Abrindo conexão
//        Connection conexao = ConnectionFactory.getConnection();
//        String sqlExecutar = "INSERT INTO fornecedor (razaoSocialFornecedor, nomeFantasiaFornecedor, cnpjFornecedor, inscEstadualFornecedor, emailFornecedor, compleEnderecofornecedor, endereco_idcep) VALUES(?, ?, ?, ?, ?, ?, ?)";
//        PreparedStatement pstm = null;
//        
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            pstm.setString(1, objeto.getRazaoSocialFornecedor());
//            pstm.setString(2, objeto.getNome());
//            pstm.setString(3, objeto.getCnpjFornecedor());
//            pstm.setString(4, objeto.getInscEstadualFornecedor());
//            pstm.setString(5, objeto.getEmail());
//            pstm.setString(6, objeto.getCompleEndereco());
//            pstm.setInt(7, objeto.getEndereco_idcep().getIdCep());
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
//    public List<Fornecedor> retrieve() {
//        String sqlExecutar     =    " SELECT idfornecedor, "
//                                   + "razaoSocialFornecedor, "
//                                   + "nomeFantasiaFornecedor, "
//                                   + "cnpjFornecedor, "
//                                   + "inscEstadualFornecedor, "
//                                   + "emailFornecedor, "
//                                   + "compleEnderecofornecedor, "
//                                   + "endereco_idcep "
//                                   + " FROM fornecedor ";
//        
//        Connection conexao     = ConnectionFactory.getConnection();
//        PreparedStatement pstm = null;
//        ResultSet rst          = null;
//        List<Fornecedor> fornecedores = new ArrayList<>();
//        
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//
//            rst = pstm.executeQuery();            
//            
//            while(rst.next()){
//                Fornecedor fornecedor = new Fornecedor();
//                fornecedor.setIdfornecedor(rst.getInt("idfornecedor"));
//                fornecedor.setRazaoSocialFornecedor(rst.getString("razaoSocialFornecedor"));
//                fornecedor.setNome(rst.getString("nomeFantasiaFornecedor"));
//                fornecedor.setCnpjFornecedor(rst.getString("cnpjFornecedor"));
//                fornecedor.setInscEstadualFornecedor(rst.getString("inscEstadualFornecedor"));
//                fornecedor.setEmail(rst.getString("emailFornecedor"));
//                fornecedor.setCompleEndereco(rst.getString("compleEnderecofornecedor"));
//
//		System.out.println(rst.getString("endereco_idcep"));
//
//                EnderecoDAO endereco = new EnderecoDAO();
//                fornecedor.setEndereco_idcep(endereco.retrieve(rst.getString("endereco_idcep")));
//                
//                fornecedores.add(fornecedor);
//            }
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return fornecedores;       
//        } catch(Exception ex){
//            ex.printStackTrace();
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return null;
//        }
//    }
//
//
//
//    @Override
//    public Fornecedor retrieve(int codigo) {
//        String sqlExecutar     =   " SELECT idfornecedor, "
//                                   + "razaoSocialFornecedor, "
//                                   + "nomeFantasiaFornecedor, "
//                                   + "cnpjFornecedor, "
//                                   + "inscEstadualFornecedor, "
//                                   + "emailFornecedor, "
//                                   + "compleEnderecofornecedor, "
//                                   + "endereco_idcep "
//                                   + "FROM fornecedor "
//                                   + "WHERE fornecedor.idfornecedor = ?";
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
//            Fornecedor fornecedor = new Fornecedor();
//            while(rst.next()){
//                fornecedor.setIdfornecedor(rst.getInt("idfornecedor"));
//                fornecedor.setRazaoSocialFornecedor(rst.getString("razaoSocialFornecedor"));
//                fornecedor.setNome(rst.getString("nomeFantasiaFornecedor"));
//                fornecedor.setCnpjFornecedor(rst.getString("cnpjFornecedor"));
//                fornecedor.setInscEstadualFornecedor(rst.getString("inscEstadualFornecedor"));
//                fornecedor.setEmail(rst.getString("emailFornecedor"));
//                fornecedor.setCompleEndereco(rst.getString("compleEnderecofornecedor"));
//
//		System.out.println(rst.getString("endereco_idcep"));
//
//                EnderecoDAO endereco = new EnderecoDAO();
//                fornecedor.setEndereco_idcep(endereco.retrieve(rst.getString("endereco_idcep")));
//            }
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return fornecedor; 
//        } catch(Exception ex){
//            ex.printStackTrace();
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return null;
//        }
//          
//    }
//
//public Fornecedor retrieveCNPJ(String CNPJ) {
//        String sqlExecutar     =   " SELECT idfornecedor, "
//                                   + "razaoSocialFornecedor, "
//                                   + "nomeFantasiaFornecedor, "
//                                   + "cnpjFornecedor, "
//                                   + "inscEstadualFornecedor, "
//                                   + "emailFornecedor, "
//                                   + "compleEnderecofornecedor, "
//                                   + "endereco_idcep "
//                                   + "FROM fornecedor "
//                                   + "WHERE fornecedor.cnpjFornecedor = ?";
//        
//        Connection conexao     = ConnectionFactory.getConnection();
//        PreparedStatement pstm = null;
//        ResultSet rst          = null;
//        
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            pstm.setString(1, CNPJ);
//            
//            rst = pstm.executeQuery();  
//            Fornecedor fornecedor = new Fornecedor();
//            while(rst.next()){
//                fornecedor.setIdfornecedor(rst.getInt("idfornecedor"));
//                fornecedor.setRazaoSocialFornecedor(rst.getString("razaoSocialFornecedor"));
//                fornecedor.setNome(rst.getString("nomeFantasiaFornecedor"));
//                fornecedor.setCnpjFornecedor(rst.getString("cnpjFornecedor"));
//                fornecedor.setInscEstadualFornecedor(rst.getString("inscEstadualFornecedor"));
//                fornecedor.setEmail(rst.getString("emailFornecedor"));
//                fornecedor.setCompleEndereco(rst.getString("compleEnderecofornecedor"));
//
//		System.out.println(rst.getString("endereco_idcep"));
//
//                EnderecoDAO endereco = new EnderecoDAO();
//                fornecedor.setEndereco_idcep(endereco.retrieve(rst.getString("endereco_idcep")));
//            }
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return fornecedor; 
//        } catch(Exception ex){
//            ex.printStackTrace();
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return null;
//        }
//          
//    }
//
//
//    @Override
//    public Fornecedor retrieve(String nomeFantasiaFornecedor) {
//        String sqlExecutar     =   " SELECT idfornecedor, "
//                                   + "razaoSocialFornecedor, "
//                                   + "nomeFantasiaFornecedor, "
//                                   + "cnpjFornecedor, "
//                                   + "inscEstadualFornecedor, "
//                                   + "emailFornecedor, "
//                                   + "compleEnderecofornecedor, "
//                                   + "endereco_idcep "
//                                   + "FROM fornecedor "
//                                   + "WHERE fornecedor.nomeFantasiaFornecedor = ?";
//        Connection conexao     = ConnectionFactory.getConnection();
//        PreparedStatement pstm = null;
//        ResultSet rst          = null;
//        
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            pstm.setString(1, nomeFantasiaFornecedor);
//            rst = pstm.executeQuery();  
//            Fornecedor fornecedor = new Fornecedor();
//            
//            while(rst.next()){
//                fornecedor.setIdfornecedor(rst.getInt("idfornecedor"));
//                fornecedor.setRazaoSocialFornecedor(rst.getString("razaoSocialFornecedor"));
//                fornecedor.setNome(rst.getString("nomeFantasiaFornecedor"));
//                fornecedor.setCnpjFornecedor(rst.getString("cnpjFornecedor"));
//                fornecedor.setInscEstadualFornecedor(rst.getString("inscEstadualFornecedor"));
//                fornecedor.setEmail(rst.getString("emailFornecedor"));
//                fornecedor.setCompleEndereco(rst.getString("compleEnderecofornecedor"));
//
//		System.out.println(rst.getString("endereco_idcep"));
//                
//                EnderecoDAO endereco = new EnderecoDAO();
//                fornecedor.setEndereco_idcep(endereco.retrieve(rst.getString("endereco_idcep")));
//}
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//
//            return fornecedor; 
//        } catch(Exception ex){
//            ex.printStackTrace();
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return null;
//        }  
//    }
//
//    @Override
//    public void update(Fornecedor objeto) {
//        Connection conexao = ConnectionFactory.getConnection();
//        String sqlExecutar = " UPDATE fornecedor "
//			     + "SET razaoSocialFornecedor = ?, "
//			     + "nomeFantasiaFornecedor = ?, "
//			     + "cnpjFornecedor = ?, "
//			     + "inscEstadualFornecedor = ?, "
//			     + "emailFornecedor = ?, "
//			     + "compleEnderecofornecedor = ?, "
//			     + "endereco_idcep = ? "
//			     + "WHERE fornecedor.idfornecedor = ?";
//        PreparedStatement pstm = null;
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            pstm.setString(1, objeto.getRazaoSocialFornecedor());
//	    pstm.setString(2, objeto.getNome());
//            pstm.setString(3, objeto.getCnpjFornecedor());
//            pstm.setString(4, objeto.getInscEstadualFornecedor());
//            pstm.setString(5, objeto.getEmail());
//            pstm.setString(6, objeto.getCompleEndereco());
//            pstm.setInt(7, objeto.getEndereco_idcep().getIdCep());
//            pstm.setInt(8, objeto.getIdfornecedor());
//	    pstm.executeUpdate();
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//        ConnectionFactory.closeConnection(conexao, pstm);
//    }
//
//    @Override
//    public void delete(Fornecedor objeto) {
//        Connection conexao = ConnectionFactory.getConnection();
//        String sqlExecutar = " DELETE FROM fornecedor WHERE fornecedor.idfornecedor = ? ";
//        PreparedStatement ptsm = null;
//        try {
//            ptsm = conexao.prepareStatement(sqlExecutar);
//            ptsm.setInt(1, objeto.getIdfornecedor());
//            ptsm.executeUpdate();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        ConnectionFactory.closeConnection(conexao, ptsm);
//   }
}
