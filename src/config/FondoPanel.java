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
public class FondoPanel extends JPanel {
    private Image imagen;

  

    @Override
    public void paint(Graphics g) {
                 imagen = new ImageIcon(getClass().getResource("../imagenes/panel.jpg")).getImage(); // Ruta de la imagen

        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this); // Dibuja la imagen escalada
        setOpaque(false);
        super.paint(g);
    }

     // Método para establecer el icono en un JFrame
    public static void setIcon(JFrame frame, String iconPath) {
        // Asegúrate de que el icono exista en la ruta especificada
        ImageIcon icon = new ImageIcon(FondoPanel.class.getResource(iconPath));
        frame.setIconImage(icon.getImage());
    }
    
}