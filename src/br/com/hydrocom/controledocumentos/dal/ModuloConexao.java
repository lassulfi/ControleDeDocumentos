/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hydrocom.controledocumentos.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por realizar a conexão com o banco de dados SQLITE
 * @author luis.assulfi
 */
public class ModuloConexao {
    
    //Atributos
    private static String URL = "jdbc:sqlite:controledocumentos.db";
    
    private static Connection conexao = null;
    
    //Métodos
    
    /**
     * Método que realiza a conexão com o banco de dados
     */
    public static Connection connectar(){
        
        
        try{
            //String de conexão com o banco de dados
           
            //cria a conexão com o banco de dados
            conexao = DriverManager.getConnection(URL);           
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return conexao;
    }
    
    public static void fecharConexao() throws SQLException{
        if(conexao != null){
            conexao.close();
        }
    }
    
    /**
     * Retorna a URL de conexao com o banco de dados.
     * @return 
     */
    public static String getURL(){
        return URL;
    }
}
