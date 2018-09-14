/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hydrocom.controledocumentos.main;

import br.com.hydrocom.controledocumentos.dao.ContatoDAOImpl;
import br.com.hydrocom.controledocumentos.model.Contato;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luis.assulfi
 */
public class Main {
    
    private static List<Contato> contatos = new ArrayList<>();
    
    //Teste da conexão com o banco de dados
    public static void main(String[] args) {
        
        //Teste acrescentar contato no db
        ContatoDAOImpl c = ContatoDAOImpl.getInstance();
        
        //c.excluirTabela();
        
        Contato c1 = c.criarContato("Asbrubal Ferreira", "asdrubal.ferreira@hydrocom.com.br");
        Contato c2 = c.criarContato("Zezé de Camargo", "zeze.camargo@hydrocom.com.br");
        Contato c3 = c.criarContato("Abgail Abigado", "abigail.abigado@hydrocom.com.br");
        
        c.adicionarContato(c1);
        c.adicionarContato(c2);
        c.adicionarContato(c3);
        
        //faz a validação do método para recurar a lista de contatos
        System.out.println(" -- Adicionar contatos --");
        contatos = c.getContatos();
        for(Contato contato : contatos){
            System.out.println(contato.getNome() + " - " + contato.getEmail()); 
        }
        
        //Teste de atualizar o contato
        c2.setNome("Zuleica de Camargo");
        c2.setEmail("zuleica.camargo@hydrocom.com.br");
        
        c.atualizarContato(2, c2);
        
        System.out.println(" -- Atualizar contatos --");
        contatos = null;
        contatos = c.getContatos();
        for(Contato contato : contatos){
            System.out.println(contato.getNome() + " - " + contato.getEmail()); 
        }
        
        //Teste de excluir contato
        c.removerContato(1);
        
        System.out.println(" -- Remover contatos --");
        contatos = null;
        contatos = c.getContatos();
        for(Contato contato : contatos){
            System.out.println(contato.getNome() + " - " + contato.getEmail()); 
        }
        
    }
}
