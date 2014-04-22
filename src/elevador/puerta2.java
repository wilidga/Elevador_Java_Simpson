/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package elevador;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Image;
/**
/**
 *
 * @author Wilman
 */
public class puerta2 extends JPanel {
 boolean cerrar=false;

public void Set_Cerrar (boolean a){
        cerrar = a;
}
public boolean Get_Cerrar (){
        return cerrar;
}

      public void paint (Graphics g){
       Dimension tamanio = getSize();
             ImageIcon fondo = new ImageIcon(getClass().getResource("/resources/images/Elevadorp1.gif"));
             g.drawImage(fondo.getImage(), 0,0, tamanio.width, tamanio.height-20, null);
            setOpaque(false);
            super.paintComponent(g);

          }
    }
