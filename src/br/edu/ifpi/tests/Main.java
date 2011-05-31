/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpi.tests;

import br.edu.ifpi.beans.Compromisso;
import br.edu.ifpi.beans.Contato;
import br.edu.ifpi.beans.Endereco;
import br.edu.ifpi.beans.Usuario;
import br.edu.ifpi.util.HibernateUtil;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;

/**
 *
 * @author luciano
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Session session = HibernateUtil.getSession();

        // cria um usuário

//        Usuario u = new Usuario();
//        u.setUsername("mock1");
//        u.setPassword("123456");
//
//        session.beginTransaction();
//        session.save(u);
//        session.getTransaction().commit();


//         Compromisso c1 = new Compromisso();
//         c1.setTitulo("Reunião de tr00s");
//
//         c1.setDataInicio(new GregorianCalendar(2011, 06, 1));
//         c1.setDataInicio(new GregorianCalendar(2011, 06, 2));
//
//         c1.getParticipantes().add((Usuario) session.load(Usuario.class, 1L));
//         c1.getParticipantes().add((Usuario) session.load(Usuario.class, 2L));
//         c1.getParticipantes().add((Usuario) session.load(Usuario.class, 3L));
//
//         session.beginTransaction();
//         session.save(c1);
//         session.getTransaction().commit();



//        Contato c3 = new Contato();
//        c3.setNome("contato tr00");
//        c3.setEmail("email2@tr00host.com");
//
//        c3.setEndereco(new Endereco("rua tr00", "00000000", 240, null));
//        c3.setTelefone("telefone 2");
//        c3.setGrupo(null);
//
//        session.beginTransaction();
//        session.save(c3);
//        session.getTransaction().commit();



//        Usuario u = (Usuario) session.load(Usuario.class, 1L);
//        Set<Contato> contatos = new HashSet<Contato>();
//        contatos.add((Contato) session.load(Contato.class, 2L));
//        u.setContatos(contatos);
//
//        session.beginTransaction();
//        session.merge(u);
//        session.getTransaction().commit();
    }
}
