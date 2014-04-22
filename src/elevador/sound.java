/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package elevador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import sun.audio.*;
import java.io.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Ingris
 */
public class sound {
    String file;
    boolean sonido;

 public void setAudio (String a) {
     file = a;
  }
public void setEnc_Apa (boolean b){
        sonido = b;
}


    public void music() {

        AudioPlayer Mp = AudioPlayer.player;
        AudioStream Mm;
        AudioData MD;
        ContinuousAudioDataStream loop = null;


        try{
            Mm = new AudioStream(new FileInputStream(file));
            MD = Mm.getData();
            loop = new ContinuousAudioDataStream(MD);
            Mp.start(loop);
                    for(int i=0;i<1500;i++){
                                          }
             Mp.stop(loop);
        }
        catch(IOException error){
            JOptionPane.showMessageDialog(null, "Error Accesando Audio");

        }




    }



    }


