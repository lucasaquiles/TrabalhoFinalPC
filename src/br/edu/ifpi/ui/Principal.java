/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Principal.java
 *
 * Created on 30/05/2011, 17:12:18
 */
package br.edu.ifpi.ui;

import br.edu.ifpi.beans.Compromisso;
import br.edu.ifpi.beans.Usuario;
import br.edu.ifpi.beans.UsuarioLogado;
import br.edu.ifpi.jobs.AlertaCompromisso;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerUtils;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author Laerton
 */
public class Principal extends javax.swing.JFrame {

    UsuarioLogado usuarioLogado;
    DefaultTableModel model;

    /** Creates new form Principal */
    public Principal(Usuario u) {

        initComponents();

        this.usuarioLogado = new UsuarioLogado(u);
    }

    public Principal() {

        initComponents();
        setLocationRelativeTo(null);//centraliza a janela

        this.usuarioLogado = new UsuarioLogado();

        if (usuarioLogado.getUsuario() == null) {

            jMenuBar1.setEnabled(false);
            DialogAutenticUsuario autentica = new DialogAutenticUsuario(this, true, this);

            autentica.setVisible(true);
        } else {

            jMenuBar1.setEnabled(true);
        }

        try {

            jLabelUser.setText("Ola, " + usuarioLogado.getUsuario().getUsername() + "!");

            model = (DefaultTableModel) jTable1.getModel();
            mountTableCompromissos();
            
            int countCompromissos = model.getRowCount();

            if (countCompromissos > 1) {

                jLabelQntCompromissos.setText(" " + model.getRowCount() + " compromissos");
            } else if (countCompromissos == 1) {

                jLabelQntCompromissos.setText(" " + model.getRowCount() + " compromisso");
            } else {
                jLabelQntCompromissos.setText("você não tem compromissos marcados!");
            }
        } catch (Exception e) {
        }

    }

    public void mountTableCompromissos() {


        Vector v = null;

        if (usuarioLogado.getUsuario().getCompromissos().size() > 0) {

            for (Compromisso c : usuarioLogado.getUsuario().getCompromissos()) {

                v = new Vector();

                v.add(c);
                model.addRow(v);

                System.out.println("added: " + c);
            }
            jTable1.setModel(model);
        } else {

            System.out.println("nulo");
            v.add(new String("sem compromissos!"));
            model.addRow(v);
            jTable1.setModel(model);
        }
    }

    public void verificaCompromissos() {
        SchedulerFactory sf = new StdSchedulerFactory();
        try {

            Scheduler sched = sf.getScheduler();

            if (usuarioLogado.getUsuario().getCompromissos().size() > 0) {

                for (Compromisso c : usuarioLogado.getUsuario().getCompromissos()) {

                    if (GregorianCalendar.getInstance().equals(c.getDataFim())) {

                        JOptionPane.showMessageDialog(null, "Opa");
                    }
                }

            }
            JobDetail job = new JobDetail("alerta_compromisso", "compromisso", AlertaCompromisso.class);

            Trigger t = TriggerUtils.makeDailyTrigger(2, 37);
            t.setName("oopa");
            sched.scheduleJob(job, t);

            sched.start();
        } catch (SchedulerException ex) {
            System.out.println("e: " + ex);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabelUser = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelQntCompromissos = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuContatos = new javax.swing.JMenu();
        SubMenuCriarContato = new javax.swing.JMenuItem();
        SubMenuListarContato = new javax.swing.JMenuItem();
        SubMenuGrupo = new javax.swing.JMenuItem();
        MenuCompromissos = new javax.swing.JMenu();
        SubMenuCriarCompr = new javax.swing.JMenuItem();
        SubMenuListarCompr = new javax.swing.JMenuItem();
        SubMenuCateg = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        MenuSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda A3L");
        setResizable(false);

        jInternalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jInternalFrame1.setMaximizable(true);
        jInternalFrame1.setResizable(true);
        jInternalFrame1.setTitle("Meus compromissos");
        jInternalFrame1.setVisible(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Compromisso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setResizable(false);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabelUser.setFont(new java.awt.Font("DejaVu Sans", 0, 36));

        jLabel1.setText("você tem ");

        jLabelQntCompromissos.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelQntCompromissos, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(189, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelQntCompromissos))
                .addContainerGap())
        );

        jMenuBar1.setEnabled(false);

        MenuContatos.setText("Contatos");

        SubMenuCriarContato.setText("Criar");
        SubMenuCriarContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuCriarContatoActionPerformed(evt);
            }
        });
        MenuContatos.add(SubMenuCriarContato);

        SubMenuListarContato.setText("Listar");
        SubMenuListarContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuListarContatoActionPerformed(evt);
            }
        });
        MenuContatos.add(SubMenuListarContato);

        SubMenuGrupo.setText("Grupo");
        SubMenuGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuGrupoActionPerformed(evt);
            }
        });
        MenuContatos.add(SubMenuGrupo);

        jMenuBar1.add(MenuContatos);

        MenuCompromissos.setText("Compromissos");

        SubMenuCriarCompr.setText("Criar");
        SubMenuCriarCompr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuCriarComprActionPerformed(evt);
            }
        });
        MenuCompromissos.add(SubMenuCriarCompr);

        SubMenuListarCompr.setText("Listar");
        SubMenuListarCompr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuListarComprActionPerformed(evt);
            }
        });
        MenuCompromissos.add(SubMenuListarCompr);

        SubMenuCateg.setText("Categoria");
        SubMenuCateg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuCategActionPerformed(evt);
            }
        });
        MenuCompromissos.add(SubMenuCateg);

        jMenuBar1.add(MenuCompromissos);

        jMenu1.setText("Sair");

        MenuSair.setText("Sair");
        MenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSairActionPerformed(evt);
            }
        });
        jMenu1.add(MenuSair);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(300, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SubMenuCriarContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuCriarContatoActionPerformed

        DialogContatos n = new DialogContatos(this, true);
        n.setVisible(true);
    }//GEN-LAST:event_SubMenuCriarContatoActionPerformed

    private void MenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_MenuSairActionPerformed

    private void SubMenuListarContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuListarContatoActionPerformed
        DialogListContatos m = new DialogListContatos(this, true);
        m.setVisible(true);
    }//GEN-LAST:event_SubMenuListarContatoActionPerformed

    private void SubMenuGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuGrupoActionPerformed
        DialogListarGrupos gs = new DialogListarGrupos(this, true);
        gs.setVisible(true);
    }//GEN-LAST:event_SubMenuGrupoActionPerformed

    private void SubMenuCriarComprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuCriarComprActionPerformed
        DialogCompromisso comp = new DialogCompromisso(this, true);
        comp.setVisible(true);
    }//GEN-LAST:event_SubMenuCriarComprActionPerformed

    private void SubMenuListarComprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuListarComprActionPerformed
        DialogListarCompr listComp = new DialogListarCompr(this, true);
        listComp.setVisible(true);
    }//GEN-LAST:event_SubMenuListarComprActionPerformed

    private void SubMenuCategActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuCategActionPerformed
        DialogListarCategorias listCateg = new DialogListarCategorias(this, true);
        listCateg.setVisible(true);
    }//GEN-LAST:event_SubMenuCategActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new Principal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuCompromissos;
    private javax.swing.JMenu MenuContatos;
    private javax.swing.JMenuItem MenuSair;
    private javax.swing.JMenuItem SubMenuCateg;
    private javax.swing.JMenuItem SubMenuCriarCompr;
    private javax.swing.JMenuItem SubMenuCriarContato;
    private javax.swing.JMenuItem SubMenuGrupo;
    private javax.swing.JMenuItem SubMenuListarCompr;
    private javax.swing.JMenuItem SubMenuListarContato;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelQntCompromissos;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}