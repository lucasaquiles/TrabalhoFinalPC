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
import java.util.List;
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
    public static boolean disponiblidade(Usuario u, GregorianCalendar gc) {

        boolean estaDisponivel = false;

        if (u.getCompromissos().size() > 0) {

            for (Compromisso c : u.getCompromissos()) {

                if (c.getDataInicio().equals(gc)) {

                    estaDisponivel = false;

                    System.out.println("-------------------------------------------------------------");
                    System.out.println("não ta disponível");
                    System.out.println("-------------------------------------------------------------");
                }
            }
        } else {

            estaDisponivel = true;
        }

        return estaDisponivel;
    }

    public static void main(String[] args) {
        // TODO code application logic here

        Session session = HibernateUtil.getSession();

        // cria um usuário
//
        Usuario us = new Usuario();
        us.setUsername("mock5");
        us.setPassword("123456");

        session.beginTransaction();
        session.save(us);
        session.getTransaction().commit();
        
        // verifica a disponibilidade de horários do usuário
        
        Compromisso c1 = new Compromisso();
        c1.setTitulo("Reunião de tr00s test de horário");

        c1.setDataInicio(new GregorianCalendar(2011, 06, 1));
        //c1.setDataInicio(new GregorianCalendar(2011, 06, 2));

        c1.getParticipantes().add((Usuario) session.load(Usuario.class, 9L));
//        c1.getParticipantes().add((Usuario) session.load(Usuario.class, 2L));
//        c1.getParticipantes().add((Usuario) session.load(Usuario.class, 4L));

        Set<Usuario> usuarioNaoDisponiveis = new HashSet<Usuario>();


        session.beginTransaction();
        session.save(c1);
        session.getTransaction().commit();

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("salvou e gerou essa id: " + c1.getId());
        System.out.println("-------------------------------------------------------------------------------------");

        for (Usuario u : c1.getParticipantes()) {

            if (Main.disponiblidade(u, c1.getDataInicio())) {

                System.out.println("disponbilidade do usuário: " + u.getUsername() + " " + disponiblidade(u, c1.getDataInicio()));

                c1.setId(c1.getId());
                u.getCompromissos().add(c1);

                u.setCompromissos(u.getCompromissos());

                session.beginTransaction();
                session.merge(u);

                System.out.println("compromissos do "+ u.getUsername() +"-------------------------> "+u.getCompromissos().size());

                session.getTransaction().commit();
                //session.flush();

            }
                else {
                usuarioNaoDisponiveis.add(u);

                c1.getParticipantes().remove(u);
            }
        }

        System.out.println("usuários disponíveis: " + c1.getParticipantes().size());




        System.out.println("quantidade de compromissos: "+((Usuario) session.load(Usuario.class, 9L)).getCompromissos().size());

//         System.out.println("usuário está disponivel: "+Main.disponiblidade((Usuario) session.load(Usuario.class, 1L), c1.getDataInicio()));
//         System.out.println("usuário está disponivel: "+Main.disponiblidade((Usuario) session.load(Usuario.class, 2L), c1.getDataInicio()));
//         System.out.println("usuário está disponivel: "+Main.disponiblidade((Usuario) session.load(Usuario.class, 3L), c1.getDataInicio()));
//        System.out.println("usuário está disponivel: " + Main.disponiblidade((Usuario) session.load(Usuario.class, 4L), c1.getDataInicio()));

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
