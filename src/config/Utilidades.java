/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author SHARK
 */
 public class Utilidades extends JPanel {
   private Image imagen;

    // Constructor que recibe la ruta de la imagen
    public Utilidades(String imagePath) {
        // Carga la imagen de fondo
        this.imagen = new ImageIcon(getClass().getResource(imagePath)).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibuja la imagen de fondo escalada al tamaño del panel
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    }//checo la ratona


     // Método para establecer el icono en un JFrame
    public static void setIcon(JFrame frame, String iconPath) {
        // Asegúrate de que el icono exista en la ruta especificada
        ImageIcon icon = new ImageIcon(Utilidades.class.getResource(iconPath));
        frame.setIconImage(icon.getImage());
    }
    
    
    
}