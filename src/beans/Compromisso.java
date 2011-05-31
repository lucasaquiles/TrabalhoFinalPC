/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author luciano
 */
class Compromisso {
    private long id;

    private String titulo;
    private String descricao;
    
    private GregorianCalendar dataInicio;
    private GregorianCalendar dataFim;
//    private List<participantes> contatos;

    private Categoria categoria;
}
