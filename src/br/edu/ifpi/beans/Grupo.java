/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpi.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author luciano
 */
@Entity
public class Grupo {

    @Id @GeneratedValue
    
    private long id;
    private String nome;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return getNome();
    }    
}
