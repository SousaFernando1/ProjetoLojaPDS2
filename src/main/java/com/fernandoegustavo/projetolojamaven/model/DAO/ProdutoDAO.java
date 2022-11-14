package com.fernandoegustavo.projetolojamaven.model.DAO;

import com.fernandoegustavo.projetolojamaven.model.bo.Produto;
import java.util.List;
import com.fernandoegustavo.projetolojamaven.model.bo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

public class ProdutoDAO implements InterfaceDAO<Produto>{

private static ProdutoDAO instance;
    protected EntityManager entityManager;
    
    public static ProdutoDAO getInstance() {
        if(instance == null) {
            instance = new ProdutoDAO();
        }
        return instance;
    }
    
    public ProdutoDAO() {
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
    public void create(Produto objeto) {
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
    public List<Produto> retrieve() {
        List<Produto> cidadesLista;
        CriteriaQuery<Produto> criteria = entityManager.getCriteriaBuilder().createQuery(Produto.class);

        criteria.select(criteria.from(Produto.class));
        cidadesLista = entityManager.createQuery(criteria).getResultList();
        return cidadesLista;
    }
    
    @Override
    public Produto retrieve(int codigo) {
        return entityManager.find(Produto.class, codigo);
    }
    
    @Override
    public void update(Produto objeto) {
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
    public void delete(Produto objeto) {
        try {
            entityManager.getTransaction().begin();
            
            objeto = entityManager.find(Produto.class, objeto.getIdproduto());
            
            entityManager.remove(this);
            entityManager.getTransaction().commit();
            
        } catch (Exception ex) {
            
            ex.printStackTrace();
        }
    }

    @Override
    public Produto retrieve(String descricao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }







//    @Override
//    public void create(Produto objeto) {
//        //Abrindo conexão
//        Connection conexao = ConnectionFactory.getConnection();
//        String sqlExecutar = "INSERT INTO produto (descricaoProduto,  marca_idmarca, tamanho_idtamanho, tipoProduto_idtipoProduto, valProduto) VALUES(?, ?, ?, ?, ?)";
//        PreparedStatement pstm = null;
//        
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            pstm.setString(1, objeto.getDescricaoProduto());
//            pstm.setInt(2, objeto.getMarca_idmarca());
//            pstm.setInt(3, objeto.getTamanho_idtamanho());
//            pstm.setInt(4, objeto.getTipoProduto_idtipoProduto());
//            pstm.setFloat(5, objeto.getValProduto());
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
//    @Override
//    public List<Produto> retrieve() {
//        String sqlExecutar     =   " SELECT idproduto, "
//                                 + " descricaoProduto,"
//                                 + " marca_idmarca,"
//                                 + " tamanho_idtamanho,"
//                                 + " tipoProduto_idtipoProduto,"
//				 + " valProduto"
//                                 + " FROM produto";
//        
//        Connection conexao     = ConnectionFactory.getConnection();
//        PreparedStatement pstm = null;
//        ResultSet rst          = null;
//        List<Produto> produtos = new ArrayList<>();
//        
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            rst = pstm.executeQuery();            
//            
//            while(rst.next()){
//                Produto produto = new Produto();
//                produto.setIdproduto(rst.getInt("idproduto"));
//                produto.setDescricaoProduto(rst.getString("descricaoProduto"));
//                produto.setMarca_idmarca(rst.getInt("marca_idmarca"));                
//                produto.setTamanho_idtamanho(rst.getInt("tamanho_idtamanho"));                
//                produto.setTipoProduto_idtipoProduto(rst.getInt("tipoProduto_idtipoProduto"));                                
//		produto.setValProduto(rst.getFloat("valProduto"));
//                produtos.add(produto);
//            }
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return produtos;       
//        } catch(Exception ex){
//            ex.printStackTrace();
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return null;
//        }
//    }
//    @Override
//    public Produto retrieve(int codigo) {
//        String sqlExecutar     =   " SELECT idproduto, "
//                                 + " descricaoProduto,"
//                                 + " marca_idmarca,"
//                                 + " tamanho_idtamanho,"
//                                 + " tipoProduto_idtipoProduto,"
//				 + " valProduto"
//                                 + " FROM produto "
//                                 + " WHERE produto.idproduto = ?";
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
//            Produto produto = new Produto();
//            while(rst.next()){
//                produto.setIdproduto(rst.getInt("idproduto"));
//                produto.setDescricaoProduto(rst.getString("descricaoProduto"));
//                produto.setMarca_idmarca(rst.getInt("marca_idmarca"));                
//                produto.setTamanho_idtamanho(rst.getInt("tamanho_idtamanho"));                
//                produto.setTipoProduto_idtipoProduto(rst.getInt("tipoProduto_idtipoProduto"));                                
//		produto.setValProduto(rst.getFloat("valProduto"));
//            }
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return produto; 
//        } catch(Exception ex){
//            ex.printStackTrace();
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return null;
//        }
//          
//    }
//
//    @Override
//    public Produto retrieve(String descricao) {
//        String sqlExecutar     =   " SELECT idproduto, "
//                                 + " descricaoProduto,"
//                                 + " marca_idmarca,"
//                                 + " tamanho_idtamanho,"
//                                 + " tipoProduto_idtipoProduto,"
//				 + " valProduto"
//                                 + " FROM produto "
//                                 + " WHERE produto.descricaoProduto= ?";
//        Connection conexao     = ConnectionFactory.getConnection();
//        PreparedStatement pstm = null;
//        ResultSet rst          = null;
//        
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            pstm.setString(1, descricao);
//            rst = pstm.executeQuery();  
//            Produto produto = new Produto();
//            
//            while(rst.next()){
//                produto.setIdproduto(rst.getInt("idproduto"));
//                produto.setDescricaoProduto(rst.getString("descricaoProduto"));
//                produto.setMarca_idmarca(rst.getInt("marca_idmarca"));                
//                produto.setTamanho_idtamanho(rst.getInt("tamanho_idtamanho"));                
//                produto.setTipoProduto_idtipoProduto(rst.getInt("tipoProduto_idtipoProduto"));                                
//		produto.setValProduto(rst.getFloat("valProduto"));
//            }
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//
//            return produto; 
//        } catch(Exception ex){
//            ex.printStackTrace();
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return null;
//        }  
//    }
//
//    @Override
//    public void update(Produto objeto) {
//        Connection conexao = ConnectionFactory.getConnection();
//        String sqlExecutar = " UPDATE produto "
//                           + " SET descricaoProduto   = ? ,"
//                           + " marca_idmarca = ?,"
//                           + " tamanho_idtamanho = ?,"
//                           + " tipoProduto_idtipoProduto = ?,"
//			   + " valProduto = ?"
//                           + " WHERE produto.idproduto= ? ";
//        PreparedStatement pstm = null;
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            pstm.setString(1, objeto.getDescricaoProduto());
//            pstm.setInt(2, objeto.getMarca_idmarca());
//            pstm.setInt(3, objeto.getTamanho_idtamanho());
//            pstm.setInt(4, objeto.getTipoProduto_idtipoProduto());
//            pstm.setFloat(5, objeto.getValProduto());
//            pstm.setFloat(6, objeto.getIdproduto());
//            pstm.executeUpdate();
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//        ConnectionFactory.closeConnection(conexao, pstm);
//    }
//
//    @Override
//    public void delete(Produto objeto) {
//        Connection conexao = ConnectionFactory.getConnection();
//        String sqlExecutar = " DELETE FROM produto WHERE produto.idproduto= ? ";
//        PreparedStatement ptsm = null;
//        try {
//            ptsm = conexao.prepareStatement(sqlExecutar);
//            ptsm.setInt(1, objeto.getIdproduto());
//            ptsm.executeUpdate();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        ConnectionFactory.closeConnection(conexao, ptsm);
//   }
    
}
