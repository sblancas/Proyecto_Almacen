/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacen;

import conexion.ConexionMysql;
import config.Utilidades;
import formularios.FormularioPrincipal;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    Utilidades fondo = new Utilidades("../imagenes/pass.png");

    public Frmlogin(JFrame parent) {
            this.setContentPane(fondo);

    initComponents();
    this.setLocationRelativeTo(null);
    this.setTitle("LOGIN");
    this.setResizable(false);
    progressBar.setVisible(false);

    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); // Esto hace que solo se cierre la ventana de login
 // Cargar y escalar la imagen
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/imagenes/login.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(
                jLabel1.getWidth(), 
                jLabel1.getHeight(), 
                Image.SCALE_SMOOTH);
                jLabel1.setIcon(new ImageIcon(scaledImage));
        Utilidades.setIcon(this, "/imagenes/login.png");

    

    
     txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
    public void keyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) { // Si se presiona Enter
            btnIniciarSesion.doClick();  // Simula el clic del botón
        }
    }
});

jContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
    public void keyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) { // Si se presiona Enter
            btnIniciarSesion.doClick();  // Simula el clic del botón
        }
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
        jContraseña = new javax.swing.JPasswordField();
        btnIniciarSesion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CONTRASEÑA:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, -1, -1));

        txtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUsuarioMousePressed(evt);
            }
        });
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 210, 32));

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("USUARIO:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 90, -1));

        jContraseña.setBorder(null);
        jContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jContraseñaMousePressed(evt);
            }
        });
        jPanel1.add(jContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 210, 32));

        btnIniciarSesion.setBackground(new java.awt.Color(255, 255, 255));
        btnIniciarSesion.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        btnIniciarSesion.setText("INICIAR SESION");
        btnIniciarSesion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 210, 30));

        jLabel1.setBackground(new java.awt.Color(255, 204, 204));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 140, 130));
        jPanel1.add(progressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 210, -1));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 550, 380));

        jLabel4.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
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

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
   String usuario = txtUsuario.getText();
    String contrasena = jContraseña.getText();

    if (!usuario.equals("") && !contrasena.equals("")) {
        // Mostrar la barra de progreso en su ubicación original
        progressBar.setVisible(true); 
        progressBar.setValue(0); // Empezamos desde 0
        progressBar.setStringPainted(true); // Mostrar el porcentaje
        // Cambiar el color de la barra de progreso a verde
        progressBar.setForeground(Color.black); 
        progressBar.setBackground(Color.gray);
        

        // Crear un nuevo hilo para simular el proceso de inicio de sesión
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Simulamos el progreso mientras se realiza el inicio de sesión
                    for (int i = 0; i <= 100; i += 10) {
                        Thread.sleep(90); // Simula el tiempo que puede tomar la consulta a la base de datos
                        progressBar.setValue(i); // Actualiza el valor de la barra de progreso
                    }

                    // Realizar la validación de usuario y contraseña
                    String consulta = "SELECT rol FROM usuarios WHERE usuario=? AND pass=?";
                    try (PreparedStatement ps = conexionn.prepareStatement(consulta)) {
                        ps.setString(1, usuario);
                        ps.setString(2, contrasena);
                        ResultSet rs = ps.executeQuery();

                        if (rs.next()) {
                            String rol = rs.getString("rol");

                         
                       FormularioPrincipal formularioPrincipal = new FormularioPrincipal(rol, usuario);
                       formularioPrincipal.setVisible(true);
                       dispose();  // Cierra el formulario de login

                        } else {
                            // Si la validación falla, mostrar un mensaje de error
                            JOptionPane.showMessageDialog(null, 
                                "CONTRASEÑA O NOMBRE DE USUARIO INCORRECTO", 
                                "Error", 
                                JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // Al terminar, ocultar la barra de progreso
                    progressBar.setVisible(false);
                }
            }
        }).start(); // Inicia el hilo para el proceso en segundo plano
    } else {
        // Si los campos están vacíos, mostrar un mensaje de advertencia
        JOptionPane.showMessageDialog(null, 
            "DEBES LLENAR TODOS LOS CAMPOS", 
            "Advertencia", 
            JOptionPane.ERROR_MESSAGE);
    }


    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void jContraseñaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jContraseñaMousePressed
        jContraseña.setBackground(Color.lightGray);
    }//GEN-LAST:event_jContraseñaMousePressed

    private void txtUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMousePressed
        txtUsuario.setBackground(Color.lightGray);
    }//GEN-LAST:event_txtUsuarioMousePressed
       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JPasswordField jContraseña;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables


}
