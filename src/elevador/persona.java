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
public class persona extends javax.swing.JPanel {
    boolean bcamina,bSubeBaja,bsubio = false;
    int Nivelsub,NivelBaj;
    int Nivelsub12,NivelBaj12;

      Dimension tamanio = getSize();
      String urlimagen;//"/resources/images/Elevadorp1.gif"

      public void setImagen (String url){
            urlimagen=url;
      }
      public void setCamina(boolean w){
            bcamina=w;
      }
      public boolean getCamina(){
            return bcamina;
      }
      public void setNivelsubir(int Niv){
                Nivelsub=Niv;
      }
      public int getNivelsubir(){
                return Nivelsub;
      }
      public void setNivelbajar(int Niv){
                NivelBaj=Niv;
      }
      public int getNivelbajar(){
                return NivelBaj;
      }
      public void setSubir_bajar(boolean bSB){
                bSubeBaja=bSB;
      }
       public boolean getSubir_bajar(){
                return bSubeBaja;
      }
       public void SetSubio (boolean sub){
                bsubio=sub;
       }
       public boolean GetSubio (){
                return bsubio;
       }

       ///PROPIEDADES PARA BAJAR
       public void setNivelsubir12(int Niv){
                Nivelsub12=Niv;
      }
      public int getNivelsubir12(){
                return Nivelsub12;
      }
      public void setNivelbajar12(int Niv){
                NivelBaj12=Niv;
      }
      public int getNivelbajar12(){
                return NivelBaj12;
      }



    public void paint (Graphics g){

        Dimension tamanio = getSize();
        ImageIcon fondo = new ImageIcon(getClass().getResource(urlimagen));
        g.drawImage(fondo.getImage(), 0,0, tamanio.width, tamanio.height, null);
        setOpaque(false);
        super.paintComponent(g);
}

    }

