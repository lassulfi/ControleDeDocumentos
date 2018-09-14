/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hydrocom.controledocumentos.dao;

import br.com.hydrocom.controledocumentos.model.Contato;
import java.util.List;

/**
 *
 * @author luis.assulfi
 */
public interface ContatoDAO {
    
    public void adicionarContato(Contato contato);
    public Contato getContato(int id);
    public void removerContato(int id);
    public void atualizarContato(int id, Contato contato);
    public List<Contato> getContatos();
}
