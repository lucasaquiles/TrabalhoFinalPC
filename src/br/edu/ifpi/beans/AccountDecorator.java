/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpi.beans;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author lucasaquiles
 */
@Entity
public class AccountDecorator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany//(mappedBy="id")
    Set<Grupo> grupos = new HashSet<Grupo>();

    @OneToMany//(mappedBy="id")
    Set<Categoria> categorias = new HashSet<Categoria>();
}
