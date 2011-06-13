/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpi.beans;

/**
 *
 * @author lucasaquiles
 */
public final class UsuarioLogado {

    static Usuario usuario;

    public UsuarioLogado(Usuario u){
        UsuarioLogado.usuario= u;
    }


    public UsuarioLogado(){
        
    }

    public Usuario getUsuario(){

        return usuario;
    }

    public void setUsuario(Usuario u){
        this.usuario = u;
    }

    
}
