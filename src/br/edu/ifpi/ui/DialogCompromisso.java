/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DialogCompromisso.java
 *
 * Created on 01/06/2011, 17:01:51
 */
package br.edu.ifpi.ui;

import br.edu.ifpi.beans.*;
import br.edu.ifpi.dao.CategoriaDao;
import br.edu.ifpi.dao.CompromissoDao;
import br.edu.ifpi.dao.UsuarioDao;
import br.edu.ifpi.factory.DaoFactory;
import br.edu.ifpi.util.ComboboxUtil;
import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Laerton
 */
public class DialogCompromisso extends javax.swing.JDialog {

    private MaskFormatter mascara;
    private int tipo;
    UsuarioLogado usuarioLogado;
    private Compromisso compromisso;
    private DaoFactory daoFactory;
    private CategoriaDao categoriaDao;
    private CompromissoDao compromissoDao;
    boolean updated = false;
    DefaultTableModel tableModel;
    DefaultListModel listModelConvidados;

    /** Creates new form DialogCompromisso */
    public DialogCompromisso(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        setTipo(0);
        setLocationRelativeTo(null);
        usuarioLogado = new UsuarioLogado();

        daoFactory = new DaoFactory();
        categoriaDao = daoFactory.buildCateoriaDao();
        compromissoDao = daoFactory.buildCompromissoDao();
        mountComboboxCategorias();
    }

    DialogCompromisso(java.awt.Frame parent, boolean modal, CompromissoDao compromissoDao, Compromisso compromisso,
            DefaultTableModel defaultTableModel, DefaultListModel listModelConvidados) {
        super(parent, modal);
        initComponents();

        usuarioLogado = new UsuarioLogado();
        daoFactory = new DaoFactory();

        categoriaDao = daoFactory.buildCateoriaDao();
        compromissoDao = daoFactory.buildCompromissoDao();

        this.compromisso = compromisso;
        this.compromissoDao = compromissoDao;

        CampoTitulo.setText(compromisso.toString());
        CaixaTextoDescr.setText(compromisso.getDescricao());

        this.tableModel = defaultTableModel;
        this.listModelConvidados = listModelConvidados;

        mountListParticipantes();

        if (compromisso.getDataFim() != null) {

            DataFim.setText(DateFormat.getInstance().format(compromisso.getDataFim().getTime()));
        }
        if (compromisso.getDataInicio() != null) {

            DataInicio.setText(DateFormat.getInstance().format(compromisso.getDataInicio().getTime()));
        }

        mountComboboxCategorias();
        mountListAndSelectedCategoria();

        updated = true;
    }

    public void mountListAndSelectedCategoria() {

        System.out.println("montou os convidados");

        try {

            comboBoxOpcaoCateg.setSelectedItem(compromisso.getCategoria());

            jListConvidados.setModel(listModelConvidados);
            
        } catch (Exception e) {
            if (compromisso.getParticipantes().size() > 0 || compromisso.getParticipantes().size() != -1) {
                DefaultListModel listModel = new DefaultListModel();
                for (Usuario u : compromisso.getParticipantes()) {

                    System.out.println("botou nos participantes: " + u);

                    listModel.addElement(u);

                    u = null;
                }

                jListConvidados.setModel(listModel);
            }
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

        jLabel1 = new javax.swing.JLabel();
        CampoTitulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CaixaTextoDescr = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListParticipantes = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListConvidados = new javax.swing.JList();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        comboBoxOpcaoCateg = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        BotaoSalvar = new javax.swing.JButton();
        BotaoCancelar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        DataInicio = new javax.swing.JTextField();
        DataFim = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Compromisso");

        jLabel1.setText("Título:");

        jLabel2.setText("Descrição:");

        CaixaTextoDescr.setColumns(20);
        CaixaTextoDescr.setRows(5);
        jScrollPane1.setViewportView(CaixaTextoDescr);

        jLabel3.setText("Data de início:");

        jLabel4.setText("Data de Término:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Participantes"));
        jPanel1.setEnabled(false);

        jScrollPane2.setViewportView(jListParticipantes);

        jScrollPane3.setViewportView(jListConvidados);

        jButton3.setText("add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("remover");

        jButton5.setText("add todos");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("remover todos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2)
                        .addComponent(jScrollPane3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6))))
        );

        jLabel9.setText("Selecionar Categoria:");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        BotaoSalvar.setText("Salvar");
        BotaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSalvarActionPerformed(evt);
            }
        });

        BotaoCancelar.setText("Cancelar");
        BotaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(874, Short.MAX_VALUE)
                .addComponent(BotaoSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotaoCancelar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoCancelar)
                    .addComponent(BotaoSalvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("atualizar");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton7.setText("add participantes");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CampoTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(DataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(195, 195, 195)
                                        .addComponent(jLabel9)
                                        .addGap(10, 10, 10)
                                        .addComponent(comboBoxOpcaoCateg, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CampoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(DataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxOpcaoCateg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jButton1)
                            .addComponent(jButton2)))
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-1111)/2, (screenSize.height-503)/2, 1111, 503);
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_BotaoCancelarActionPerformed

    private void BotaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSalvarActionPerformed
        if (getTipo() == 1) {
            if ((JOptionPane.showConfirmDialog(null, "Deseja confirmar alteração?", "Confirmar Alteração", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE)) == 0) {
                atualizarClasse();

                dispose();
            } else {

                dispose();
            }
        } else if (getTipo() == 0) {
            if ((JOptionPane.showConfirmDialog(null, "Deseja confirmar inclusão?", "Confirmar Inclusão", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE)) == 0) {

                atualizarClasse();
                dispose();
            } else {

                dispose();
            }

        }
    }//GEN-LAST:event_BotaoSalvarActionPerformed

    public void mountListParticipantes() {

        DefaultListModel listModel = new DefaultListModel();

        Usuario u = usuarioLogado.getUsuario();

        ArrayList<Usuario> usuarios = daoFactory.buildUsuarioDao().list();
        if (usuarios.size() > 0) {

            for (Usuario us : usuarios) {

                listModel.addElement(us);
            }

        } else {

            listModel.addElement(new String("sem participantes"));
        }
        jListParticipantes.setModel(listModel);

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        mountComboboxCategorias();
        jButton2.setEnabled(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        DialogCategoria dialogCategoria = new DialogCategoria(null, true, categoriaDao);

        dialogCategoria.setVisible(true);
        jButton2.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed


        jPanel1.setEnabled(true);

        mountListParticipantes();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        DefaultListModel listModel = new DefaultListModel();

        Object[] c = jListParticipantes.getSelectedValues();

        Object[] objs = c;

        for (int i = 0; i < c.length; i++) {

            listModel.add(i, c[i]);

            jListConvidados.setModel(listModel);
        }
        jListConvidados.setModel(listModel);


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        jListConvidados.setModel(jListParticipantes.getModel());
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                DialogCompromisso dialog = new DialogCompromisso(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoCancelar;
    private javax.swing.JButton BotaoSalvar;
    private javax.swing.JTextArea CaixaTextoDescr;
    private javax.swing.JTextField CampoTitulo;
    private javax.swing.JFormattedTextField DataFim;
    private javax.swing.JTextField DataInicio;
    private javax.swing.JComboBox comboBoxOpcaoCateg;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jListConvidados;
    private javax.swing.JList jListParticipantes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    private void atualizarTela() {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        CampoTitulo.setText(compromisso.getTitulo());
        CaixaTextoDescr.setText(compromisso.getDescricao());
        DataInicio.setText(df.format(compromisso.getDataInicio()));
        DataFim.setText(df.format(compromisso.getDataFim()));
        comboBoxOpcaoCateg.setSelectedItem(compromisso.getCategoria().getNome());
    }

    public void mountComboboxCategorias() {

        DefaultComboBoxModel comboBoxModel = ComboboxUtil.mountComboBoxCategorias((DefaultComboBoxModel) comboBoxOpcaoCateg.getModel(), categoriaDao);
        comboBoxOpcaoCateg.setModel(comboBoxModel);
    }

    private void atualizarClasse() {
        Categoria c;

        try {

            c = (Categoria) comboBoxOpcaoCateg.getSelectedItem();

        } catch (Exception e) {
            c = null;
        }
        Set<Usuario> participantes = null;

        Object[] usuarios = jListConvidados.getSelectedValues();


        if (!updated) {

            compromisso = new Compromisso();

            if (usuarios.length > 0) {

                participantes = new HashSet<Usuario>();

                for (int i = 0; i < usuarios.length; i++) {

                    participantes.add((Usuario) usuarios[i]);
                }
            }
        } else {

            participantes = compromisso.getParticipantes();
        }

        try {

            if (!DataInicio.getText().equals("") && !DataFim.getText().equals("")) {

                GregorianCalendar gc = new GregorianCalendar();
                GregorianCalendar gcFim = new GregorianCalendar();

                SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");

                Date d = sf.parse(DataInicio.getText());
                Date dataFim = sf.parse(DataInicio.getText());

                gc.setTime(d);
                gcFim.setTime(dataFim);

                compromisso.setDataInicio(gc);
                compromisso.setDataFim(gcFim);

                DateFormat df = DateFormat.getInstance();

                JOptionPane.showMessageDialog(null, "data " + DateFormat.getInstance().format(d));
            } else {
                //compromisso.setDataInicio(new Date(System.currentTimeMillis()));
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "digite um formáto de data válido. (dd/mm/yyyy)");
        }

        compromisso.setCategoria(c);
        compromisso.setDescricao(CaixaTextoDescr.getText());
        compromisso.setTitulo(CampoTitulo.getText());

        String label = "";

        if (!updated) {

            compromissoDao.save(compromisso);
            label = "salvou >> ";
        } else {

            label = "atualizou >> ";
            compromissoDao.update(compromisso);
        }

        System.out.println(label + compromisso.getId());

        if (participantes != null && participantes.size() > 0) {

            addParticipanteToCompromisso(compromisso.getId(), participantes);
        } else {

            JOptionPane.showMessageDialog(null, "Compromisso " + compromisso.getId() + " adicionado");
            addCompromissoToUsuario(compromisso);
        }

        Vector v = new Vector();
        v.add(compromisso);
        tableModel.addRow(v);
    }

    public boolean addParticipanteToCompromisso(long id, Set<Usuario> participantes) {

        System.out.println("pegou o pro compromisso: " + id);
        boolean saved = false;

        if (participantes.size() > 0) {

            Compromisso c = compromissoDao.getById(id);

            for (Usuario u : participantes) {

                c.getParticipantes().add(u);
                System.out.println("adicionou: " + u);
            }

            c.setParticipantes(c.getParticipantes());

            compromissoDao.update(c);
            System.out.println("atualizou: " + compromisso.getId());

            addCompromissoToUsuario(c);
        }

        return saved;
    }

    public void addCompromissoToUsuario(Compromisso c) {

        usuarioLogado.getUsuario().getCompromissos().add(c);

        usuarioLogado.getUsuario().setCompromissos(usuarioLogado.getUsuario().getCompromissos());

        UsuarioDao uDao = daoFactory.buildUsuarioDao();

        uDao.update(usuarioLogado.getUsuario());
        System.out.println("atualizou compromissos pro usuário");
    }
}
