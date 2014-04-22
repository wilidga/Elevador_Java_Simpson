/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package elevador;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;

public class sonidos {

  AudioFormat audioFormat;
  AudioInputStream audioInputStream;
  SourceDataLine sourceDataLine;
  boolean stopPlayback = false;
  String Sfile;
 

public void setsonido(String a){
        Sfile=a;
}



  public void Tplay(){

          playAudio();

    }

   public void Sstop(){
          stopPlayback = true;
        }




  private void playAudio() {
    try{
      File soundFile =
                   new File(Sfile);
      audioInputStream = AudioSystem.
                  getAudioInputStream(soundFile);
      audioFormat = audioInputStream.getFormat();
      //System.out.println(audioFormat);

      DataLine.Info dataLineInfo =
                          new DataLine.Info(
                            SourceDataLine.class,
                                    audioFormat);

      sourceDataLine =
             (SourceDataLine)AudioSystem.getLine(
                                   dataLineInfo);


      new PlayThread().start();
    }catch (Exception e) {
      e.printStackTrace();
      System.exit(0);
    }//end catch
  }//end playAudio


//=============================================//
//Inner class to play back the data from the
// audio file.
class PlayThread extends Thread{
  byte tempBuffer[] = new byte[10000];

  public void run(){
    try{
      sourceDataLine.open(audioFormat);
      sourceDataLine.start();

      int cnt;
      //Keep looping until the input read method
      // returns -1 for empty stream or the
      // user clicks the Stop button causing
      // stopPlayback to switch from false to
      // true.
      while((cnt = audioInputStream.read(
           tempBuffer,0,tempBuffer.length)) != -1
                       && stopPlayback == false){
        if(cnt > 0){

          sourceDataLine.write(
                             tempBuffer, 0, cnt);
        }
      }

      sourceDataLine.drain();
      sourceDataLine.close();


      stopPlayback = false;
    }catch (Exception e) {
      e.printStackTrace();
      System.exit(0);
    }
  }
}


}




