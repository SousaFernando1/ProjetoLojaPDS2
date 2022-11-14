package com.fernandoegustavo.projetolojamaven.model.DAO;

import java.util.List;
import com.fernandoegustavo.projetolojamaven.model.bo.Cidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

public class CidadeDAO implements InterfaceDAO<Cidade>{

private static CidadeDAO instance;
    protected EntityManager entityManager;
    
    public static CidadeDAO getInstance() {
        if(instance == null) {
            instance = new CidadeDAO();
        }
        return instance;
    }
    
    public CidadeDAO() {
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
    public void create(Cidade objeto) {
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
    public List<Cidade> retrieve() {
	System.out.println("CidadeDao");        

List<Cidade> cidadesLista;
        CriteriaQuery<Cidade> criteria = entityManager.getCriteriaBuilder().createQuery(Cidade.class);

        criteria.select(criteria.from(Cidade.class));
        cidadesLista = entityManager.createQuery(criteria).getResultList();
        return cidadesLista;
    }
    
    @Override
    public Cidade retrieve(int codigo) {
        return entityManager.find(Cidade.class, codigo);
    }
    
    @Override
    public void update(Cidade objeto) {
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
    public void delete(Cidade objeto) {
        try {
            entityManager.getTransaction().begin();
            
            objeto = entityManager.find(Cidade.class, objeto.getIdCidade());
            
            entityManager.remove(this);
            entityManager.getTransaction().commit();
            
        } catch (Exception ex) {
            
            ex.printStackTrace();
        }
    }

    @Override
    public Cidade retrieve(String descricao) {
	System.out.println(descricao);
	System.out.println(entityManager.find(Cidade.class, descricao));

	return entityManager.find(Cidade.class, descricao);

	
    }









//@Override
//    public void create(Cidade objeto) {
//        //Abrindo conexão
//        Connection conexao = ConnectionFactory.getConnection();
//
////	System.out.println(objeto.getDescricaoCidade());
//
//        String sqlExecutar = "INSERT INTO cidade (descricaoCidade, ufCidade) VALUES(?,?)";
//        PreparedStatement pstm = null;
//        
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            pstm.setString(1, objeto.getDescricaoCidade());
//            pstm.setString(2, objeto.getUfCidade());
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
//    public List<Cidade> retrieve() {
//        String sqlExecutar     =   " SELECT idcidade, "
//                                 + " descricaoCidade, "
//                                 + " ufCidade "
//                                 + " FROM cidade";
//        
//        Connection conexao     = ConnectionFactory.getConnection();
//        PreparedStatement pstm = null;
//        ResultSet rst          = null;
//        List<Cidade> cidades = new ArrayList<>();
//        
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            rst = pstm.executeQuery();            
//            
//            while(rst.next()){
//                Cidade cidade = new Cidade();
//                cidade.setIdCidade(rst.getInt("idcidade"));
//                cidade.setDescricaoCidade(rst.getString("descricaoCidade"));
//                cidade.setUfCidade(rst.getString("ufCidade"));
//                cidades.add(cidade);
//            }
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return cidades;       
//        } catch(Exception ex){
//            ex.printStackTrace();
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return null;
//        }
//    }
//    @Override
//    public Cidade retrieve(int codigo) {
//        String sqlExecutar     =   " SELECT idcidade, "
//                                 + " descricaoCidade, "
//                                 + " ufCidade "
//                                 + " FROM cidade "
//                                 + " WHERE cidade.idcidade = ?";
//        Connection conexao     = ConnectionFactory.getConnection();
//        PreparedStatement pstm = null;
//        ResultSet rst          = null;
//        
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            pstm.setInt(1, codigo);
//            rst = pstm.executeQuery();  
//            Cidade cidade = new Cidade();
//            while(rst.next()){
//                cidade.setIdCidade(rst.getInt("idcidade"));
//                cidade.setDescricaoCidade(rst.getString("descricaoCidade"));
//                cidade.setUfCidade(rst.getString("ufCidade"));
//            }
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return cidade; 
//        } catch(Exception ex){
//            ex.printStackTrace();
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return null;
//        }
//    }
//
//    @Override
//    public Cidade retrieve(String descricao) {
//        String sqlExecutar     =   " SELECT idcidade, "
//                                 + " descricaoCidade, "
//                                 + " ufCidade "
//                                 + " FROM cidade "
//                                 + " WHERE cidade.descricaoCidade = ?";
//        Connection conexao     = ConnectionFactory.getConnection();
//        PreparedStatement pstm = null;
//        ResultSet rst          = null;
//        
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            pstm.setString(1, descricao);
//            rst = pstm.executeQuery();  
//            Cidade cidade = new Cidade();
//            
//            while(rst.next()){
//                cidade.setIdCidade(rst.getInt("idcidade"));
//                cidade.setDescricaoCidade(rst.getString("descricaoCidade"));
//                cidade.setUfCidade(rst.getString("ufCidade"));
//            }
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//
//            return cidade; 
//        } catch(Exception ex){
//            ex.printStackTrace();
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return null;
//        }  
//    }
//
//    @Override
//    public void update(Cidade objeto) {
//        Connection conexao = ConnectionFactory.getConnection();
//        String sqlExecutar = " UPDATE cidade "
//                           + " SET descricaoCidade   = ? ,"
//                           + " ufCidade = ? "
//                           + " WHERE cidade.idcidade = ? ";
//        PreparedStatement pstm = null;
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            pstm.setString(1, objeto.getDescricaoCidade());
//            pstm.setString(2, objeto.getUfCidade());
//            pstm.setInt(3, objeto.getIdCidade());
//            pstm.executeUpdate();
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//        ConnectionFactory.closeConnection(conexao, pstm);
//    }
//
//    @Override
//    public void delete(Cidade objeto) {
//        
//    }
   
}
