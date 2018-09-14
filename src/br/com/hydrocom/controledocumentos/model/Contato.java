/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hydrocom.controledocumentos.model;

/**
 * Classe contato
 * 
 * Armazena as informações sobre os contatos cadastrados no sistema
 * 
 * @author luis.assulfi
 */
public class Contato {
    
    //Atributos
    private String nome;
    private String email;

    public Contato() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
