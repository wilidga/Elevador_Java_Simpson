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
 *
 * @author Wilman
 */
public class puerta extends JPanel {
 boolean Abrir=false,bsubiendo=false,bajando=false;
 int nivElevadorSubir=0;
 int nivElevadorBajar=0;
 int nivElevadorSubir12=0;
 int nivElevadorBajar12=0;

public void Setsubiendo (boolean subir){
        bsubiendo=subir;
}
public boolean Getsubiendo (){
        return bsubiendo;
}
/*
public void Setbajando (boolean subir){
        bajando=subir;
}
public boolean Getbajando (){
        return bsubiendo;
}*/

public void SetNivelSubir(int niv){
    nivElevadorSubir = niv;

}
public int GetNivelSubir(){
    return nivElevadorSubir;
}
public void SetNivelBajar(int niv){
    nivElevadorBajar = niv;
}
public int GetNivelBajar(){
    return nivElevadorBajar;
}

public void SetAbrir_Cerrar (boolean a){
        Abrir = a;
}
public boolean GetAbrir_Cerrar (){
        return Abrir;
}

//propiedades para bajar en el elevador

public void SetNivelSubir12(int niv){
    nivElevadorSubir12 = niv;

}
public int GetNivelSubir12(){
    return nivElevadorSubir12;
}
public void SetNivelBajar12(int niv){
    nivElevadorBajar12 = niv;
}
public int GetNivelBajar12(){
    return nivElevadorBajar12;
}

      public void paint (Graphics g){
           Dimension tamanio = getSize();
             ImageIcon fondo = new ImageIcon(getClass().getResource("/resources/images/Elevadorp1.gif"));
             g.drawImage(fondo.getImage(), 0,0, tamanio.width, tamanio.height-20, null);
            setOpaque(false);
            super.paintComponent(g);


          }
    }
