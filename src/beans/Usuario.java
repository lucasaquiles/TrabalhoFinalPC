/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luciano
 */
public class Usuario {

    private long id;
    private String username;
    private String password;
    private boolean status;

    private List<Contato> contatos;
    private List<Compromisso> compromissos;
}
