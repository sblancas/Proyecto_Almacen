/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacen;

import conexion.ConexionMysql;
import formularios.FormularioAdministrador;
import formularios.FormularioEmpleado;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author sergi
 */
public class Frmlogin extends javax.swing.JFrame {
//CREACION DE CONEXION INSTANCIA 
ConexionMysql conexion = new ConexionMysql();
Connection conexionn=conexion.conectar();
    /**
     * Creates new form Frmlogin
     */
    public Frmlogin(JFrame parent) {
    
    initComponents();
    this.setLocationRelativeTo(null);
    this.setTitle("LOGIN");
    this.setResizable(false);
    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); // Esto hace que solo se cierre la ventana de login
 // Cargar y escalar la imagen
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/imagenes/login.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(
                jLabel1.getWidth(), 
                jLabel1.getHeight(), 
                Image.SCALE_SMOOTH);
                jLabel1.setIcon(new ImageIcon(scaledImage));

    // Al cerrar la ventana de login, mostrar la ventana principal nuevamente
    this.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            parent.setVisible(true);  // Muestra la ventana principal
        }
    });
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CONTRASEÑA:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, -1, -1));

        txtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUsuarioMousePressed(evt);
            }
        });
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 210, 32));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("EMAIL:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 70, -1));

        jPassword.setBorder(null);
        jPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPasswordMousePressed(evt);
            }
        });
        jPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(jPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 210, 32));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setText("INICIAR SESION");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 210, 30));

        jLabel1.setBackground(new java.awt.Color(255, 204, 204));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 140, 130));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 550, 380));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("  BIENVENIDO AL SISTEMA DE MÓVIL PLUS");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String usuario=txtUsuario.getText();
        String contrasena=jPassword.getText();
        if(!usuario.equals("")&& !contrasena.equals("")){
            try {
                String consulta="Select rol from usuarios where email='"+usuario+"' and pass='"+contrasena+"'";
                PreparedStatement ps = conexionn.prepareStatement(consulta);
                ResultSet rs=ps.executeQuery();
                if(rs.next()){

                    String tiponivel=rs.getString("rol");

                    if(tiponivel.equalsIgnoreCase("administrador")){
                        dispose();

                        FormularioAdministrador admin=new FormularioAdministrador();
                        admin.setVisible(true);
                    }else if(tiponivel.equalsIgnoreCase("empleado")){
                        dispose();

                        FormularioEmpleado empled=new FormularioEmpleado();
                        empled.setVisible(true);
                    }
                }else{
                    String errorDetails = "CONTRASEÑA O CORREO ELECTRONICO INCORRECTOS";
                    JOptionPane.showMessageDialog(null, errorDetails, "", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"ERROR AL INICIAR SESION"+e,"",JOptionPane.ERROR_MESSAGE);
            }
        }else{

            JOptionPane.showMessageDialog(null,"DEBES LLENAR TODOS LOS CAMPOS","",JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMousePressed
    txtUsuario.setBackground(Color.lightGray);

    }//GEN-LAST:event_txtUsuarioMousePressed

    private void jPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordMousePressed
    jPassword.setBackground(Color.lightGray);
    }//GEN-LAST:event_jPasswordMousePressed

    private void jPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordActionPerformed
       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables


}
