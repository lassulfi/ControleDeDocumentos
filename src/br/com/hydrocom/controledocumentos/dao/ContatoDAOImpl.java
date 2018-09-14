/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hydrocom.controledocumentos.dao;

import br.com.hydrocom.controledocumentos.dal.ModuloConexao;
import br.com.hydrocom.controledocumentos.model.Contato;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe com o padrão DAO para contatos
 * @author luis.assulfi
 */
public class ContatoDAOImpl implements ContatoDAO{
    
    //Atributos
    private static ContatoDAOImpl instance;    
    
    //Banco de dados
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement pst;
        
    //Entidade
    private Contato contato;
    
    //Construtor
    private ContatoDAOImpl(){
    } 
    
    //Métodos
    
    public static ContatoDAOImpl getInstance(){
        if(instance == null){
            instance = new ContatoDAOImpl();
            instance.criarTabela();
        }
        
        return instance;
    }
    
    public void excluirTabela(){
        String sql = "DROP TABLE contatos";
        
        try {
            con = ModuloConexao.connectar();
            st = con.createStatement();
            st.execute(sql);
            
            //Fecha a conexao com o BD
            ModuloConexao.fecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    private void criarTabela(){
             
        //String sql para criar a tabela       
        String sql = "CREATE TABLE IF NOT EXISTS contatos(\n"
                + "id integer PRIMARY KEY AUTOINCREMENT,\n" 
                + " nome text NOT NULL,\n" 
                + " email text NOT NULL\n"
                + ");";
        
        try {
            con = ModuloConexao.connectar();
            st = con.createStatement();
            st.execute(sql);
            
            //Fecha a conexao com o BD
            ModuloConexao.fecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }   
    }
    
    public Contato criarContato(String nome, String email){
        contato = new Contato();
        contato.setNome(nome);
        contato.setEmail(email);
        
        return contato;
    }

    @Override
    public void adicionarContato(Contato contato) {
        
        String sql = "INSERT INTO contatos(nome,email) VALUES(?,?);";
        
        try {
            con = ModuloConexao.connectar();
            
            pst = con.prepareStatement(sql);
            pst.setString(1, contato.getEmail());
            pst.setString(2, contato.getEmail());
            
            pst.executeUpdate();
                                   
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Contato getContato(int id) {
        
        String sql = "SELECT (nome, email) FROM contatos WHERE id=?;";
        
        contato = new Contato();
        try {
            con = ModuloConexao.connectar();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            if(rs.next()){
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
            }
            
             //Fecha a conexao com o BD
            ModuloConexao.fecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return contato;
    }

    @Override
    public void removerContato(int id) {

        String sql = "DELETE FROM contatos WHERE id=?";
        
        try {
            con = ModuloConexao.connectar();
            
            pst = con.prepareStatement(sql);
            
            pst.executeUpdate();
            
             //Fecha a conexao com o BD
            ModuloConexao.fecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizarContato(int id, Contato contato) {
        
        String sql = "UPDATE contatos SET nome = ? , " 
                + "email = ?"
                + "WHERE id = ?;";
        
        try {
            con = ModuloConexao.connectar();
            
            pst = con.prepareStatement(sql);
            pst.setString(1, contato.getNome());
            pst.setString(2, contato.getEmail());
            pst.setInt(3, id);
            
            pst.executeUpdate();
            
            ModuloConexao.fecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Contato> getContatos() {

        String sql = "SELECT nome, email FROM contatos;";
        
        List<Contato> contatos = new ArrayList<>();
        
        try {
            con = ModuloConexao.connectar();
            
            st = con.createStatement();
            
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                Contato c = new Contato();
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                
                contatos.add(c);
            }
            
            ModuloConexao.fecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return contatos;
    }
}
