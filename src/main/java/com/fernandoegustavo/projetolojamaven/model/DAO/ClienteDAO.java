package com.fernandoegustavo.projetolojamaven.model.DAO;

import java.util.List;
import com.fernandoegustavo.projetolojamaven.model.bo.Cliente;
import com.fernandoegustavo.projetolojamaven.model.bo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

public class ClienteDAO implements InterfaceDAO<Cliente>{


private static ClienteDAO instance;
    protected EntityManager entityManager;
    
    public static ClienteDAO getInstance() {
        if(instance == null) {
            instance = new ClienteDAO();
        }
        return instance;
    }
    
    public ClienteDAO() {
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
    public void create(Cliente objeto) {
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
    public List<Cliente> retrieve() {
        List<Cliente> cidadesLista;
        CriteriaQuery<Cliente> criteria = entityManager.getCriteriaBuilder().createQuery(Cliente.class);

        criteria.select(criteria.from(Cliente.class));
        cidadesLista = entityManager.createQuery(criteria).getResultList();
        return cidadesLista;
    }
    
    @Override
    public Cliente retrieve(int codigo) {
        return entityManager.find(Cliente.class, codigo);
    }
    
    @Override
    public void update(Cliente objeto) {
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
    public void delete(Cliente objeto) {
        try {
            entityManager.getTransaction().begin();
            
            objeto = entityManager.find(Cliente.class, objeto.getIdcliente());
            
            entityManager.remove(this);
            entityManager.getTransaction().commit();
            
        } catch (Exception ex) {
            
            ex.printStackTrace();
        }
    }

    @Override
    public Cliente retrieve(String descricao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }







//    @Override
//    public void create(Cliente objeto) {
//        //Abrindo conexão
//        Connection conexao = ConnectionFactory.getConnection();
//        String sqlExecutar = "INSERT INTO cliente (nomeCliente, dtNasCliente, cpfCliente, rgCliente, foneCliente, fone2Cliente, emailCliente, compleEnderecoCliente, endereco_idcep) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
//        PreparedStatement pstm = null;
//        
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            pstm.setString(1, objeto.getNome());
//            pstm.setString(2, objeto.getDtNascCliente());
//            pstm.setString(3, objeto.getCpfCliente());
//            pstm.setString(4, objeto.getRgCliente());
//            pstm.setString(5, objeto.getFoneCliente());
//            pstm.setString(6, objeto.getFone2Cliente());
//            pstm.setString(7, objeto.getEmail());
//            pstm.setString(8, objeto.getCompleEndereco());
//            pstm.setInt(9, objeto.getEndereco_idcep().getIdCep());
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
//    public List<Cliente> retrieve() {
//        String sqlExecutar     =   " SELECT idcliente, "
//                                   + "nomeCliente, "
//				   + "dtNasCliente, "
//				   + "cpfCliente, "
//				   + "rgCliente, "
//				   + "foneCliente, "
//				   + "fone2Cliente, "
//				   + "emailCliente, "
//				   + "compleEnderecoCliente, "
//				   + "endereco_idcep "
//				   + " FROM cliente";
//        
//        Connection conexao     = ConnectionFactory.getConnection();
//        PreparedStatement pstm = null;
//        ResultSet rst          = null;
//        List<Cliente> clientes = new ArrayList<>();
//        
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            rst = pstm.executeQuery();            
//            
//            while(rst.next()){
//                Cliente cliente = new Cliente();
//                cliente.setIdcliente(rst.getInt("idcliente"));
//                cliente.setNome(rst.getString("nomeCliente"));
//                cliente.setDtNascCliente(rst.getString("dtNasCliente"));
//                cliente.setCpfCliente(rst.getString("cpfCliente"));
//                cliente.setRgCliente(rst.getString("rgCliente"));
//                cliente.setFoneCliente(rst.getString("foneCliente"));
//                cliente.setFone2Cliente(rst.getString("fone2Cliente"));
//                cliente.setEmail(rst.getString("emailCliente"));
//                cliente.setCompleEndereco(rst.getString("compleEnderecoCliente"));
//
//		System.out.println(rst.getString("endereco_idcep"));
//
//                EnderecoDAO endereco = new EnderecoDAO();
//                cliente.setEndereco_idcep(endereco.retrieve(rst.getString("endereco_idcep")));
//                
//                clientes.add(cliente);
//            }
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return clientes;       
//        } catch(Exception ex){
//            ex.printStackTrace();
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return null;
//        }
//    }
//    @Override
//    public Cliente retrieve(int codigo) {
//        String sqlExecutar     =   " SELECT idcliente, "
//                                   + "nomeCliente, "
//				   + "dtNasCliente, "
//				   + "cpfCliente, "
//				   + "rgCliente, "
//				   + "foneCliente, "
//				   + "fone2Cliente, "
//				   + "emailCliente, "
//				   + "compleEnderecoCliente, "
//				   + "endereco_idcep "
//				   + " FROM cliente WHERE cliente.idcliente = ?";
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
//            Cliente cliente = new Cliente();
//            while(rst.next()){
//                cliente.setIdcliente(rst.getInt("idcliente"));
//                cliente.setNome(rst.getString("nomeCliente"));
//                cliente.setDtNascCliente(rst.getString("dtNasCliente"));
//                cliente.setCpfCliente(rst.getString("cpfCliente"));
//                cliente.setRgCliente(rst.getString("rgCliente"));
//                cliente.setFoneCliente(rst.getString("foneCliente"));
//                cliente.setFone2Cliente(rst.getString("fone2Cliente"));
//                cliente.setEmail(rst.getString("emailCliente"));
//                cliente.setCompleEndereco(rst.getString("compleEnderecoCliente"));
//
//		System.out.println(rst.getString("endereco_idcep"));
//
//                EnderecoDAO endereco = new EnderecoDAO();
//                cliente.setEndereco_idcep(endereco.retrieve(rst.getString("endereco_idcep")));
//            }
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return cliente; 
//        } catch(Exception ex){
//            ex.printStackTrace();
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return null;
//        }
//          
//    }
//
//    @Override
//    public Cliente retrieve(String nomeCliente) {
//        String sqlExecutar     =   " SELECT idcliente, "
//                                   + "nomeCliente, "
//				   + "dtNasCliente, "
//				   + "cpfCliente, "
//				   + "rgCliente, "
//				   + "foneCliente, "
//				   + "fone2Cliente, "
//				   + "emailCliente, "
//				   + "compleEnderecoCliente, "
//				   + "endereco_idcep "
//				   + " FROM cliente"
//				   + "WHERE cliente.nomeCliente = ?";
//        Connection conexao     = ConnectionFactory.getConnection();
//        PreparedStatement pstm = null;
//        ResultSet rst          = null;
//        
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            pstm.setString(1, nomeCliente);
//            rst = pstm.executeQuery();  
//            Cliente cliente = new Cliente();
//            
//            while(rst.next()){
//               cliente.setIdcliente(rst.getInt("idcliente"));
//                cliente.setNome(rst.getString("nomeCliente"));
//                cliente.setDtNascCliente(rst.getString("dtNasCliente"));
//                cliente.setCpfCliente(rst.getString("cpfCliente"));
//                cliente.setRgCliente(rst.getString("rgCliente"));
//                cliente.setFoneCliente(rst.getString("foneCliente"));
//                cliente.setFone2Cliente(rst.getString("fone2Cliente"));
//                cliente.setEmail(rst.getString("emailCliente"));
//                cliente.setCompleEndereco(rst.getString("compleEnderecoCliente"));
//
//		System.out.println(rst.getString("endereco_idcep"));
//
//                EnderecoDAO endereco = new EnderecoDAO();
//                cliente.setEndereco_idcep(endereco.retrieve(rst.getString("endereco_idcep")));
//}
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//
//            return cliente; 
//        } catch(Exception ex){
//            ex.printStackTrace();
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return null;
//        }  
//    }
//
//    @Override
//    public void update(Cliente objeto) {
//        Connection conexao = ConnectionFactory.getConnection();
//        String sqlExecutar = " UPDATE cliente "
//			     + "SET nomeCliente = ?, "
//			     + "dtNasCliente = ?, "
//			     + "cpfCliente = ?, "
//			     + "rgCliente = ?, "
//			     + "foneCliente = ?, "
//			     + "fone2Cliente = ?, "
//			     + "emailCliente = ?, "
//			     + "compleEnderecoCliente = ?, "
//			     + "endereco_idcep = ? "
//			     + "WHERE cliente.idcliente = ?";
//        PreparedStatement pstm = null;
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//	    pstm.setString(1, objeto.getNome());
//            pstm.setString(2, objeto.getDtNascCliente());
//            pstm.setString(3, objeto.getCpfCliente());
//            pstm.setString(4, objeto.getRgCliente());
//            pstm.setString(5, objeto.getFoneCliente());
//            pstm.setString(6, objeto.getFone2Cliente());
//            pstm.setString(7, objeto.getEmail());
//            pstm.setString(8, objeto.getCompleEndereco());
//            pstm.setString(9, objeto.getEndereco_idcep().toString());
//            pstm.setInt(10, objeto.getIdcliente());
//	    pstm.executeUpdate();
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//        ConnectionFactory.closeConnection(conexao, pstm);
//    }
//
//    @Override
//    public void delete(Cliente objeto) {
//        Connection conexao = ConnectionFactory.getConnection();
//        String sqlExecutar = " DELETE FROM cliente WHERE cliente.idcliente = ? ";
//        PreparedStatement ptsm = null;
//        try {
//            ptsm = conexao.prepareStatement(sqlExecutar);
//            ptsm.setInt(1, objeto.getIdcliente());
//            ptsm.executeUpdate();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        ConnectionFactory.closeConnection(conexao, ptsm);
//   }
    
}
