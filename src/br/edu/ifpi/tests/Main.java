/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpi.tests;

import br.edu.ifpi.beans.Categoria;
import br.edu.ifpi.beans.Compromisso;
import br.edu.ifpi.beans.Contato;
import br.edu.ifpi.beans.Endereco;
import br.edu.ifpi.beans.Grupo;
import br.edu.ifpi.beans.Usuario;
import br.edu.ifpi.dao.ContatoDao;
import br.edu.ifpi.dao.GrupoDao;
import br.edu.ifpi.factory.DaoFactory;
import br.edu.ifpi.util.HibernateUtil;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;

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
//
//        // cria um usuário
////
//        Usuario us = new Usuario();
//        us.setUsername("mock5");
//        us.setPassword("123456");
//
//        session.beginTransaction();
//        session.save(us);
//        session.getTransaction().commit();
//
//        // verifica a disponibilidade de horários do usuário
//
//        Compromisso c1 = new Compromisso();
//        c1.setTitulo("Reunião de tr00s test de horário");
//
//        c1.setDataInicio(new GregorianCalendar(2011, 06, 1));
//        //c1.setDataInicio(new GregorianCalendar(2011, 06, 2));
//
//        c1.getParticipantes().add((Usuario) session.load(Usuario.class, 9L));
////        c1.getParticipantes().add((Usuario) session.load(Usuario.class, 2L));
////        c1.getParticipantes().add((Usuario) session.load(Usuario.class, 4L));
//
//        Set<Usuario> usuarioNaoDisponiveis = new HashSet<Usuario>();
//
//
//        session.beginTransaction();
//        session.save(c1);
//        session.getTransaction().commit();
//
//        System.out.println("-------------------------------------------------------------------------------------");
//        System.out.println("salvou e gerou essa id: " + c1.getId());
//        System.out.println("-------------------------------------------------------------------------------------");
//
//        for (Usuario u : c1.getParticipantes()) {
//
//            if (Main.disponiblidade(u, c1.getDataInicio())) {
//
//                System.out.println("disponbilidade do usuário: " + u.getUsername() + " " + disponiblidade(u, c1.getDataInicio()));
//
//                c1.setId(c1.getId());
//                u.getCompromissos().add(c1);
//
//                u.setCompromissos(u.getCompromissos());
//
//                session.beginTransaction();
//                session.merge(u);
//
//                System.out.println("compromissos do "+ u.getUsername() +"-------------------------> "+u.getCompromissos().size());
//
//                session.getTransaction().commit();
//                //session.flush();
//
//            }
//                else {
//                usuarioNaoDisponiveis.add(u);
//
//                c1.getParticipantes().remove(u);
//            }
//        }
//
//        System.out.println("usuários disponíveis: " + c1.getParticipantes().size());
//
//
//
//
//        System.out.println("quantidade de compromissos: "+((Usuario) session.load(Usuario.class, 9L)).getCompromissos().size());


//        Grupo g = new Grupo();
//        g.setNome("quengas");

//
//        Categoria c = new Categoria();
//        c.setNome("trollagem");
//


//         System.out.println("usuário está disponivel: "+Main.disponiblidade((Usuario) session.load(Usuario.class, 1L), c1.getDataInicio()));
//         System.out.println("usuário está disponivel: "+Main.disponiblidade((Usuario) session.load(Usuario.class, 2L), c1.getDataInicio()));
//         System.out.println("usuário está disponivel: "+Main.disponiblidade((Usuario) session.load(Usuario.class, 3L), c1.getDataInicio()));
//        System.out.println("usuário está disponivel: " + Main.disponiblidade((Usuario) session.load(Usuario.class, 4L), c1.getDataInicio()));

//

//        Contato c = new Contato();
//
//        c.setDataNascimento(null);
//        c.setNome("contato");
//        c.setEmail("email@tr00host.com");
//        c.setTelefone("33333333");

//

//
//        Usuario u = new Usuario();
//        u.setUsername("user");
//        u.setPassword("password");

//
        DaoFactory df = new DaoFactory();
//        Contato c = new Contato();
//
//        c.setNome("contato mock");
//
//
//        ContatoDao cDao = df.buildContatoDao();
//
//
//
//
        Usuario u = (Usuario) session.load(Usuario.class, 11L);
//
//        u.getContatos().add(c);
//        u.setContatos(u.getContatos());
//
//        df.buildUsuarioDao().update(u);
//



        Contato c = new Contato();

        c.setNome("teeeeeesssssstttteeeeeee");

        GrupoDao gDao = df.buildGrupoDao();
        Grupo g = gDao.getById(5L);

        Set<Grupo> gs = new HashSet<Grupo>();

        gs.add(g);

        System.out.println("added um grupo a lista de grupos");

        c.setGrupos(c.getGrupos());

        df.buildContatoDao().save(c);

        System.out.println("salvou o contato: " + gs.size());

        u.getContatos().add(c);

        u.setContatos(u.getContatos());

        System.out.println("contatos do usuário: " + u.getUsername() + " = " + u.getContatos().size());


        session.beginTransaction();
        session.merge(u);
        System.out.println("salvou");

        session.getTransaction().commit();
        //df.buildContatoDao().save(c);
//
//
//        u.getContatos().add((Contato) session.load(Contato.class, 2L));
//      u.getContatos().add((Contato) session.load(Contato.class, 3L));
//      u.getContatos().add((Contato) session.load(Contato.class, 4L));
//        u.setContatos(u.getContatos());
//
//        session.beginTransaction();
//        session.save(u);
//        session.getTransaction().commit();


//        Usuario u = (Usuario) session.load(Usuario.class, 6L);
//        for(Contato c : u.getContatos()){
//            System.out.println("c: "+c.getNome());
//        }


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
