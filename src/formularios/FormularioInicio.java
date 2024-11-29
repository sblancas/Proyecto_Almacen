/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import almacen.FormularioRegistro;
import almacen.Frmlogin;
import config.Utilidades;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author sergi
 */
public class FormularioInicio extends javax.swing.JFrame {

    /**
     * Creates new form FormularioPanelControl
     */
// Crear panel de fondo con imagen específica para el Formulario 1
    Utilidades fondo = new Utilidades("../imagenes/panel.jpg");

    public FormularioInicio() {
        this.setContentPane(fondo);

        initComponents();
        this.setLocationRelativeTo(null);
        this.setSize(720, 560);
        this.setTitle("FORMULARIO INICIO");
        this.setResizable(false); // Para no permitir reajuste
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Asegúrate de que se cierre todo al salir
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/login.png")).getImage());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jIniciarSesion = new javax.swing.JMenuItem();
        jregistrarUsuario = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu5.setText("File");
        jMenuBar2.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar2.add(jMenu6);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Inicio");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jIniciarSesion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jIniciarSesion.setText("Iniciar Sesion");
        jIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIniciarSesionActionPerformed(evt);
            }
        });
        jMenu3.add(jIniciarSesion);

        jregistrarUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jregistrarUsuario.setText("Registrar Usuario");
        jregistrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jregistrarUsuarioActionPerformed(evt);
            }
        });
        jMenu3.add(jregistrarUsuario);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIniciarSesionActionPerformed
    Frmlogin login = new Frmlogin(this);
    this.setVisible(false);
    login.setVisible(true);
    login.setLocationRelativeTo(null);
    }//GEN-LAST:event_jIniciarSesionActionPerformed

    private void jregistrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jregistrarUsuarioActionPerformed
    FormularioRegistro registro = new  FormularioRegistro(this,true);
    this.setVisible(false);
    registro.setVisible(true);
    registro.setLocationRelativeTo(null);
    
    }//GEN-LAST:event_jregistrarUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        // Ejecuta la aplicación
        java.awt.EventQueue.invokeLater(() -> new FormularioInicio().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jIniciarSesion;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JMenuItem jregistrarUsuario;
    // End of variables declaration//GEN-END:variables
}
