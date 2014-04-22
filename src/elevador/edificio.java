/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package elevador;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JApplet;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.net.URL;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import sun.audio.*;
import java.io.*;

//imagenes en botones



/**
 *
 * @author Wilman
 */
public class edificio extends JApplet implements java.lang.Runnable ,MouseListener,MouseMotionListener/*implements MouseListener, MouseMotionListener */{


//implements java.lang.Runnable

    nivel nivel1[];
    puerta puerta1[];
    puerta2 puerta2[];
    persona pers[];
    String Sub[],Baj[];
    int iseteanivel;
    int Xniv;
    int PosPuertax3[],PosPuertay3[],PosPuertaw3[],PosPuertah3[];
    int PosPuertax4[],PosPuertay4[],PosPuertaw4[],PosPuertah4[];
    int PosPuertax[],PosPuertay[],PosPuertaw[],PosPuertah[];
    int PosPuertax2[],PosPuertay2[],PosPuertaw2[],PosPuertah2[];
    int p1=0,p2=1,p3=2,p4=3,p5=4,p6=5,p7=6;
    java.lang.Thread t;
    int inivel;
    int inivelB;
    String snivel,snivelB;
    JButton btnNiv1,btnNiv2,btnNiv2b,btnNiv3,btnNiv3b,btnNiv4,btnNiv4b,btnNiv5,btnNiv5b,btnNiv6,btnNiv6b,btnNiv7,btnNiv7b;
    sonidos sonido;
    int icont;




    /**
     * Initialization method that will be called after the applet is loaded
     * into the browser.
     */

    public  void init() {
         //setTitle("Elevador Creado por Wilman Garcia De Leon 0910-06-849  Seccion B ");
        String Sniv;
        int Ypos,Yposp,ypersona =510;
        //inicializo la cancion de los Simpson
        sonido = new sonidos();
       
            //agrego las imagenes
            pers = new persona[7];
            
            pers[0] = new persona();
            this.setLayout(null);
            pers[0].setImagen("/resources/images/bart1.png");
            pers[0].setLocation(10, ypersona +10);
            pers[0].setSize(20, 45);
            this.add(pers[0]);
            ypersona = ypersona-75;
            pers[1] = new persona();
            this.setLayout(null);
            pers[1].setImagen("/resources/images/lisa1.png");
            pers[1].setLocation(10,ypersona +10);
            pers[1].setSize(20, 45);
            this.add(pers[1]);
            ypersona = ypersona-75;
            pers[2] = new persona();
            this.setLayout(null);
            pers[2].setImagen("/resources/images/maggi1.png");
            pers[2].setLocation(10, ypersona + 25);
            pers[2].setSize(20, 30);
            this.add(pers[2]);
            ypersona = ypersona-75;
            pers[3] = new persona();
            this.setLayout(null);
            pers[3].setImagen("/resources/images/marsh1.png");
            pers[3].setLocation(10, ypersona-5);
            pers[3].setSize(25, 60);
            this.add(pers[3]);
            ypersona = ypersona-75;
            pers[4] = new persona();
            this.setLayout(null);
            pers[4].setImagen("/resources/images/omero.png");
            pers[4].setLocation(10, ypersona-5);
            pers[4].setSize(25, 60);
            this.add(pers[4]);
            ypersona = ypersona-75;
            pers[5] = new persona();
            this.setLayout(null);
            pers[5].setImagen("/resources/images/marsh1.png");
            pers[5].setLocation(10, ypersona-5);
            pers[5].setSize(25, 60);
            this.add(pers[5]);
            ypersona = ypersona-75;
            pers[6] = new persona();
            this.setLayout(null);
            pers[6].setImagen("/resources/images/omero.png");
            pers[6].setLocation(10, ypersona-5);
            pers[6].setSize(25, 60);
            this.add(pers[6]);


            Ypos=500;
            Yposp=500;
            this.setSize(410, 630);

            try{
            Sniv = JOptionPane.showInputDialog("Ingresar de cuenatos niveles desea el Elevador de 2 a 7");
            Xniv = Integer.parseInt(Sniv);
            if (Xniv <= 1 || Xniv >=8){
                JOptionPane.showMessageDialog(rootPane, "Favor ingresar un numero de 2 a 7 ");
                    Sniv = JOptionPane.showInputDialog("Ingresar de cuenatos niveles desea el Elevador de 2 a 7");
                    Xniv = Integer.parseInt(Sniv);
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(rootPane, "Favor ingresar un numero");
            }
             sonido.setsonido("themesong.wav");
                sonido.Tplay();
            PosPuertax4=new int[Xniv];
            PosPuertay4=new int[Xniv];
            PosPuertaw4=new int[Xniv];
            PosPuertah4=new int[Xniv];

            PosPuertax3=new int[Xniv];
            PosPuertay3=new int[Xniv];
            PosPuertaw3=new int[Xniv];
            PosPuertah3=new int[Xniv];

            PosPuertax2=new int[Xniv];
            PosPuertay2=new int[Xniv];
            PosPuertaw2=new int[Xniv];
            PosPuertah2=new int[Xniv];

            PosPuertax=new int[Xniv];
            PosPuertay=new int[Xniv];
            PosPuertaw=new int[Xniv];
            PosPuertah=new int[Xniv];


            nivel1 = new nivel[Xniv];
            puerta1 = new puerta[Xniv];
            puerta2 = new puerta2[Xniv];
            Sub = new String[Xniv];
            Baj = new String[Xniv];
            for (int x=0;x<Xniv;x++)
            {
                    //nivel
                    nivel1[x]=new nivel();
                    this.setLayout(null);
                    nivel1[x].setLocation(5, Ypos);
                    nivel1[x].setSize(340, 100);
                    if(x==0)
                    nivel1[x].setearcolor(true);
                    if(x==0)
                         nivel1[x].setparam(true);
                    this.add(nivel1[x]);
                    //nivel
                    //puerta 1 de elevador
                    puerta1[x] = new puerta();
                    this.setLayout(null);
                    puerta1[x].setLocation(342,Yposp);
                    puerta1[x].setSize(30, 100);
                    this.add(puerta1[x]);

                    //puerta 2 de elevador
                    puerta2[x] = new puerta2();
                    this.setLayout(null);
                    puerta2[x].setLocation(373,Yposp);
                    puerta2[x].setSize(28, 100);
                    this.add(puerta2[x]);

                    //puerta de elevador
                     Ypos = Ypos -75;
                     Yposp =Yposp -75;

                     t = new java.lang.Thread(this);
                     t.start();
                      botones();
                      btn_control_case();
                      }
          


             for(int w=0;w<Xniv;w++){
                            PosPuertax3[w] = puerta1[w].getX();
                            PosPuertay3[w] = puerta1[w].getY();
                            PosPuertaw3[w] = puerta1[w].getWidth();
                            PosPuertah3[w] = puerta1[w].getHeight();

                            PosPuertax4[w] = puerta2[w].getX();
                            PosPuertay4[w] = puerta2[w].getY();
                            PosPuertaw4[w] = puerta2[w].getWidth();
                            PosPuertah4[w] = puerta2[w].getHeight();
                    }
            addMouseListener(this);
            addMouseMotionListener(this);
    }

public void btn_control_case(){

 //agrego botones de elevador a cada nivel


      switch (Xniv){

          case 2:
              pers[0].setVisible(true);
              pers[1].setVisible(true);
              btnNiv1.setVisible(true);
             // btnNiv2.setVisible(true);
              btnNiv2b.setVisible(true);
                break;
          case 3:
              pers[0].setVisible(true);
              pers[1].setVisible(true);
              pers[2].setVisible(true);
              btnNiv1.setVisible(true);
              btnNiv2.setVisible(true);
              btnNiv2b.setVisible(true);
             // btnNiv3.setVisible(true);
              btnNiv3b.setVisible(true);
              break;
          case 4:
              pers[0].setVisible(true);
              pers[1].setVisible(true);
              pers[2].setVisible(true);
              pers[3].setVisible(true);
              btnNiv1.setVisible(true);
              btnNiv2.setVisible(true);
              btnNiv2b.setVisible(true);
              btnNiv3.setVisible(true);
              btnNiv3b.setVisible(true);
             // btnNiv4.setVisible(true);
              btnNiv4b.setVisible(true);

              break;
          case 5:
              pers[0].setVisible(true);
              pers[1].setVisible(true);
              pers[2].setVisible(true);
              pers[3].setVisible(true);
              pers[4].setVisible(true);
              btnNiv1.setVisible(true);
              btnNiv2.setVisible(true);
              btnNiv2b.setVisible(true);
              btnNiv3.setVisible(true);
              btnNiv3b.setVisible(true);
              btnNiv4.setVisible(true);
              btnNiv4b.setVisible(true);
             // btnNiv5.setVisible(true);
              btnNiv5b.setVisible(true);

              break;
          case 6:
              pers[0].setVisible(true);
              pers[1].setVisible(true);
              pers[2].setVisible(true);
              pers[3].setVisible(true);
              pers[4].setVisible(true);
              pers[5].setVisible(true);
              btnNiv1.setVisible(true);
              btnNiv2.setVisible(true);
              btnNiv2b.setVisible(true);
              btnNiv3.setVisible(true);
              btnNiv3b.setVisible(true);
              btnNiv4.setVisible(true);
              btnNiv4b.setVisible(true);
              btnNiv5.setVisible(true);
              btnNiv5b.setVisible(true);
            //  btnNiv6.setVisible(true);
              btnNiv6b.setVisible(true);

              break;
          case 7:
              pers[0].setVisible(true);
              pers[1].setVisible(true);
              pers[2].setVisible(true);
              pers[3].setVisible(true);
              pers[4].setVisible(true);
              pers[5].setVisible(true);
              pers[6].setVisible(true);
              btnNiv1.setVisible(true);
              btnNiv2.setVisible(true);
              btnNiv2b.setVisible(true);
              btnNiv3.setVisible(true);
              btnNiv3b.setVisible(true);
              btnNiv4.setVisible(true);
              btnNiv4b.setVisible(true);
              btnNiv5.setVisible(true);
              btnNiv5b.setVisible(true);
              btnNiv6.setVisible(true);
              btnNiv6b.setVisible(true);
              btnNiv7b.setVisible(true);
              break;
          default:
              JOptionPane.showMessageDialog(rootPane,"Asiganaciones de bonoes incorrecta");
      }
    }

public  void botones(){

                        btnNiv1 = new JButton();
                        btnNiv1.reshape(335, 535, 10, 10);
                        this.add(btnNiv1);


          btnNiv2 = new  javax.swing.JButton();
                      //  btnNiv1.setSize(10, 10);
                       // btnNiv1.setLocation(335, 550);
                        btnNiv2.reshape(335, 455, 10, 10);
                        this.add(btnNiv2);

          btnNiv2b = new  javax.swing.JButton();
                      //  btnNiv1.setSize(10, 10);
                       // btnNiv1.setLocation(335, 550);
                        btnNiv2b.reshape(335, 465, 10, 10);
                        this.add(btnNiv2b);

              btnNiv3 = new  javax.swing.JButton();
                          //  btnNiv1.setSize(10, 10);
                           // btnNiv1.setLocation(335, 550);
                            btnNiv3.reshape(335, 380, 10, 10);
                            this.add(btnNiv3);

              btnNiv3b = new  javax.swing.JButton();
                          //  btnNiv1.setSize(10, 10);
                           // btnNiv1.setLocation(335, 550);
                            btnNiv3b.reshape(335, 390, 10, 10);
                            this.add(btnNiv3b);


              btnNiv4 = new  javax.swing.JButton();
                          //  btnNiv1.setSize(10, 10);
                           // btnNiv1.setLocation(335, 550);
                            btnNiv4.reshape(335, 305, 10, 10);
                            this.add(btnNiv4);
              btnNiv4b = new  javax.swing.JButton();
                          //  btnNiv1.setSize(10, 10);
                           // btnNiv1.setLocation(335, 550);
                            btnNiv4b.reshape(335, 315, 10, 10);
                            this.add(btnNiv4b);


              btnNiv5 = new  javax.swing.JButton();
                          //  btnNiv1.setSize(10, 10);
                           // btnNiv1.setLocation(335, 550);
                            btnNiv5.reshape(335, 230, 10, 10);
                            this.add(btnNiv5);

              btnNiv5b = new  javax.swing.JButton();
                          //  btnNiv1.setSize(10, 10);
                           // btnNiv1.setLocation(335, 550);
                            btnNiv5b.reshape(335, 240, 10, 10);
                            this.add(btnNiv5b);

              btnNiv6 = new  javax.swing.JButton();
                          //  btnNiv1.setSize(10, 10);
                           // btnNiv1.setLocation(335, 550);
                            btnNiv6.reshape(335, 155, 10, 10);
                            this.add(btnNiv6);

	      btnNiv6b = new  javax.swing.JButton();
                          //  btnNiv1.setSize(10, 10);
                           // btnNiv1.setLocation(335, 550);
                            btnNiv6b.reshape(335, 165, 10, 10);
                            this.add(btnNiv6b);

              btnNiv7b = new  javax.swing.JButton();
                          //  btnNiv1.setSize(10, 10);
                           // btnNiv1.setLocation(335, 550);
                            btnNiv7b.reshape(335, 90, 10, 10);
                            this.add(btnNiv7b);

              btnNiv2.setVisible(false);
              btnNiv2b.setVisible(false);
              btnNiv3.setVisible(false);
              btnNiv3b.setVisible(false);
              btnNiv4.setVisible(false);
              btnNiv4b.setVisible(false);
              btnNiv5.setVisible(false);
              btnNiv5b.setVisible(false);
              btnNiv6.setVisible(false);
              btnNiv6b.setVisible(false);
              btnNiv7b.setVisible(false);

              pers[0].setVisible(false);
              pers[1].setVisible(false);
              pers[2].setVisible(false);
              pers[3].setVisible(false);
              pers[4].setVisible(false);
              pers[5].setVisible(false);
              pers[6].setVisible(false);

              sub_asigna_evetos();


}
public void sub_asigna_evetos(){
        btnNiv1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                    btnNiv1subir(evt);
            }});

        btnNiv2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                    btnNiv2subir(evt);
            }});
        btnNiv2b.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    btnNiv2bajar(evt);
                }});
        btnNiv3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                    btnNiv3subir(evt);
            }});
        btnNiv3b.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    btnNiv3bajar(evt);
                }});
        btnNiv4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                    btnNiv4subir(evt);
            }});
        btnNiv4b.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    btnNiv4bajar(evt);
                }});
        btnNiv5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                    btnNiv5subir(evt);
            }});
        btnNiv5b.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    btnNiv5bajar(evt);
                }});
        btnNiv6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                    btnNiv6subir(evt);
            }});
        btnNiv6b.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    btnNiv6bajar(evt);
                }});

        btnNiv7b.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    btnNiv7bajar(evt);
                }});
}



public void btnNiv1subir(ActionEvent evt) {
    boolean Abrir_cerrar;
        //setear nivel a subir y/o bajar
    
     try{
            snivel = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
            inivel = Integer.parseInt(snivel);
            if (inivel <= 1 || inivel >Xniv){
                JOptionPane.showMessageDialog(rootPane, "Favor ingresar un numero de 1 a " + Xniv);
                    snivel = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
                    inivel = Integer.parseInt(snivel);
                }
               if(inivel-1 == p1){
                            JOptionPane.showMessageDialog(rootPane, "No se Puede Viajar al Mismo Nivel");
                             snivel = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
                             inivel = Integer.parseInt(snivel);
                     }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(rootPane, "Favor ingresar un numero");
            }
                pers[p1].setNivelsubir(p1);
                puerta1[p1].SetNivelSubir(p1);
                pers[p1].setNivelbajar(inivel-1);
                puerta1[p1].SetNivelBajar(inivel-1);
                puerta1[p1].Setsubiendo(true);
                iseteanivel=inivel-1;

        Abrir_cerrar = puerta1[p1].GetAbrir_Cerrar();
        if (Abrir_cerrar == false)
                puerta1[p1].SetAbrir_Cerrar(true);
      

}
public void btnNiv2subir(ActionEvent evt) {
     boolean Abrir_cerrar;
    
      try{
            snivel = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
            inivel = Integer.parseInt(snivel);
            if (inivel < 1 || inivel >Xniv){
                JOptionPane.showMessageDialog(rootPane, "Favor ingresar un numero de 1 a " + Xniv);
                    snivel = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
                    inivel = Integer.parseInt(snivel);
                }
               if(inivel-1 == p2){
                            JOptionPane.showMessageDialog(rootPane, "No se Puede Viajar al Mismo Nivel");
                             snivel = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
                             inivel = Integer.parseInt(snivel);
                     }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(rootPane, "Favor ingresar un numero");
            }
                pers[p2].setNivelsubir(p2);
                puerta1[p2].SetNivelSubir(p2);
                pers[p2].setNivelbajar(inivel-1);
                puerta1[p2].SetNivelBajar(inivel-1);
                puerta1[p2].Setsubiendo(true);


    Abrir_cerrar = puerta1[p2].GetAbrir_Cerrar();

        if (Abrir_cerrar == false)
                puerta1[p2].SetAbrir_Cerrar(true);
   

}
public void btnNiv2bajar(ActionEvent evt) {
     boolean Abrir_cerrar;
   

      try{
            snivelB = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
            inivelB = Integer.parseInt(snivelB);
            if (inivelB < 1 || inivelB >Xniv){
                JOptionPane.showMessageDialog(rootPane, "Favor ingresar un numero de 1 a " + Xniv);
                    snivelB = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
                    inivelB = Integer.parseInt(snivelB);
                }
               if(inivelB-1 == p2){
                            JOptionPane.showMessageDialog(rootPane, "No se Puede Viajar al Mismo Nivel");
                             snivelB = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
                             inivelB = Integer.parseInt(snivelB);
                     }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(rootPane, "Favor ingresar un numero");
            }
                pers[p2].setNivelsubir12(p2);
                puerta1[p2].SetNivelSubir12(p2);
                pers[p2].setNivelbajar12(inivelB-1);
                puerta1[p2].SetNivelBajar12(inivelB-1);
              puerta1[p2].Setsubiendo(false);

    Abrir_cerrar = puerta1[p2].GetAbrir_Cerrar();

        if (Abrir_cerrar == false)
                puerta1[p2].SetAbrir_Cerrar(true);
   

}
public void btnNiv3subir(ActionEvent evt) {
     boolean Abrir_cerrar;
    
      try{
            snivel = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
            inivel = Integer.parseInt(snivel);
            if (inivel <= 1 || inivel >Xniv){
                JOptionPane.showMessageDialog(rootPane, "Favor ingresar un numero de 1 a " + Xniv);
                    snivel = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
                    inivel = Integer.parseInt(snivel);
                }
               if(inivel-1 == p3){
                            JOptionPane.showMessageDialog(rootPane, "No se Puede Viajar al Mismo Nivel");
                             snivel = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
                             inivel = Integer.parseInt(snivel);
                     }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(rootPane, "Favor ingresar un numero");
            }
                
                pers[p3].setNivelsubir(p3);
                puerta1[p3].SetNivelSubir(p3);
                pers[p3].setNivelbajar(inivel-1);
                puerta1[p3].SetNivelBajar(inivel-1);
                 puerta1[p3].Setsubiendo(true);

    Abrir_cerrar = puerta1[p3].GetAbrir_Cerrar();

        if (Abrir_cerrar == false)
                puerta1[p3].SetAbrir_Cerrar(true);
    

}
public void btnNiv3bajar(ActionEvent evt) {
     boolean Abrir_cerrar;
   

     try{
            snivelB = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
            inivelB = Integer.parseInt(snivelB);
            if (inivelB < 1 || inivelB >Xniv){
                JOptionPane.showMessageDialog(rootPane, "Favor ingresar un numero de 1 a " + Xniv);
                    snivelB = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
                    inivelB = Integer.parseInt(snivelB);
                }
               if(inivelB-1 == p3){
                            JOptionPane.showMessageDialog(rootPane, "No se Puede Viajar al Mismo Nivel");
                             snivelB = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
                             inivelB = Integer.parseInt(snivelB);
                     }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(rootPane, "Favor ingresar un numero");
            }
                pers[p3].setNivelsubir12(p3);
                puerta1[p3].SetNivelSubir12(p3);
                pers[p3].setNivelbajar12(inivelB-1);
                puerta1[p3].SetNivelBajar12(inivelB-1);
                puerta1[p3].Setsubiendo(false);


    Abrir_cerrar = puerta1[p3].GetAbrir_Cerrar();

        if (Abrir_cerrar == false)
                puerta1[p3].SetAbrir_Cerrar(true);
  

}
public void btnNiv4subir(ActionEvent evt) {
     boolean Abrir_cerrar;
    

      try{
            snivel = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
            inivel = Integer.parseInt(snivel);
            if (inivel <= 1 || inivel >Xniv){
                JOptionPane.showMessageDialog(rootPane, "Favor ingresar un numero de 1 a " + Xniv);
                    snivel = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
                    inivel = Integer.parseInt(snivel);
                }
               if(inivel-1 == p4){
                            JOptionPane.showMessageDialog(rootPane, "No se Puede Viajar al Mismo Nivel");
                             snivel = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
                             inivel = Integer.parseInt(snivel);
                     }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(rootPane, "Favor ingresar un numero");
            }
                pers[p4].setNivelsubir(p4);
                puerta1[p4].SetNivelSubir(p4);
                pers[p4].setNivelbajar(inivel-1);
                puerta1[p4].SetNivelBajar(inivel-1);
                 puerta1[p4].Setsubiendo(true);

    Abrir_cerrar = puerta1[p4].GetAbrir_Cerrar();

        if (Abrir_cerrar == false)
                puerta1[p4].SetAbrir_Cerrar(true);
    

}
public void btnNiv4bajar(ActionEvent evt) {
     boolean Abrir_cerrar;
     
try{
            snivelB = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
            inivelB = Integer.parseInt(snivelB);
            if (inivelB < 1 || inivelB >Xniv){
                JOptionPane.showMessageDialog(rootPane, "Favor ingresar un numero de 1 a " + Xniv);
                    snivelB = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
                    inivelB = Integer.parseInt(snivelB);
                }
               if(inivelB-1 == p4){
                            JOptionPane.showMessageDialog(rootPane, "No se Puede Viajar al Mismo Nivel");
                             snivelB = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
                             inivelB = Integer.parseInt(snivelB);
                     }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(rootPane, "Favor ingresar un numero");
            }
                pers[p4].setNivelsubir12(p4);
                puerta1[p4].SetNivelSubir12(p4);
                pers[p4].setNivelbajar12(inivelB-1);
                puerta1[p4].SetNivelBajar12(inivelB-1);
             puerta1[p4].Setsubiendo(false);

    Abrir_cerrar = puerta1[p4].GetAbrir_Cerrar();

        if (Abrir_cerrar == false)
                puerta1[p4].SetAbrir_Cerrar(true);
   

}
public void btnNiv5subir(ActionEvent evt) {
     boolean Abrir_cerrar;
    
      try{
            snivel = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
            inivel = Integer.parseInt(snivel);
            if (inivel <= 1 || inivel >Xniv){
                JOptionPane.showMessageDialog(rootPane, "Favor ingresar un numero de 1 a " + Xniv);
                    snivel = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
                    inivel = Integer.parseInt(snivel);
                }
               if(inivel-1 == p5){
                            JOptionPane.showMessageDialog(rootPane, "No se Puede Viajar al Mismo Nivel");
                             snivel = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
                             inivel = Integer.parseInt(snivel);
                     }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(rootPane, "Favor ingresar un numero");
            }
                pers[p5].setNivelsubir(p5);
                puerta1[p5].SetNivelSubir(p5);
                pers[p5].setNivelbajar(inivel-1);
                puerta1[p5].SetNivelBajar(inivel-1);
                 puerta1[p5].Setsubiendo(true);


    Abrir_cerrar = puerta1[p5].GetAbrir_Cerrar();

        if (Abrir_cerrar == false)
                puerta1[p5].SetAbrir_Cerrar(true);
   

}
public void btnNiv5bajar(ActionEvent evt) {
     boolean Abrir_cerrar;
    
     try{
            snivelB = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
            inivelB = Integer.parseInt(snivelB);
            if (inivelB < 1 || inivelB >Xniv){
                JOptionPane.showMessageDialog(rootPane, "Favor ingresar un numero de 1 a " + Xniv);
                    snivelB = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
                    inivelB = Integer.parseInt(snivelB);
                }
               if(inivelB-1 == p5){
                            JOptionPane.showMessageDialog(rootPane, "No se Puede Viajar al Mismo Nivel");
                             snivelB = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
                             inivelB = Integer.parseInt(snivelB);
                     }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(rootPane, "Favor ingresar un numero");
            }

                pers[p5].setNivelsubir12(p5);
                puerta1[p5].SetNivelSubir12(p5);
                pers[p5].setNivelbajar12(inivelB-1) ;
                puerta1[p5].SetNivelBajar12(inivelB-1);
              puerta1[p5].Setsubiendo(false);


    Abrir_cerrar = puerta1[p5].GetAbrir_Cerrar();

        if (Abrir_cerrar == false)
                puerta1[p5].SetAbrir_Cerrar(true);
 

}
public void btnNiv6subir(ActionEvent evt) {
     boolean Abrir_cerrar;
    
     
      try{
            snivel = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
            inivel = Integer.parseInt(snivel);
            if (inivel <= 1 || inivel >Xniv){
                JOptionPane.showMessageDialog(rootPane, "Favor ingresar un numero de 1 a " + Xniv);
                    snivel = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
                    inivel = Integer.parseInt(snivel);
                }
               if(inivel-1 == p6){
                            JOptionPane.showMessageDialog(rootPane, "No se Puede Viajar al Mismo Nivel");
                             snivel = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
                             inivel = Integer.parseInt(snivel);
                     }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(rootPane, "Favor ingresar un numero");
            }
                pers[p6].setNivelsubir(p6);
                puerta1[p6].SetNivelSubir(p6);
                pers[p6].setNivelbajar(inivel-1);
                puerta1[p6].SetNivelBajar(inivel-1);
                puerta1[p6].Setsubiendo(true);


    Abrir_cerrar = puerta1[p6].GetAbrir_Cerrar();

        if (Abrir_cerrar == false)
                puerta1[p6].SetAbrir_Cerrar(true);
   

}
public void btnNiv6bajar(ActionEvent evt) {
     boolean Abrir_cerrar;
   
     try{
            snivelB = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
            inivelB = Integer.parseInt(snivelB);
            if (inivelB < 1 || inivelB >Xniv){
                JOptionPane.showMessageDialog(rootPane, "Favor ingresar un numero de 1 a " + Xniv);
                    snivelB = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
                    inivelB = Integer.parseInt(snivelB);
                }
               if(inivelB-1 == p6){
                            JOptionPane.showMessageDialog(rootPane, "No se Puede Viajar al Mismo Nivel");
                             snivelB = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
                             inivelB = Integer.parseInt(snivelB);
                     }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(rootPane, "Favor ingresar un numero");
            }
                pers[p6].setNivelsubir12(p6);
                puerta1[p6].SetNivelSubir12(p6);
                pers[p6].setNivelbajar12(inivelB-1);
                puerta1[p6].SetNivelBajar12(inivelB-1);
              puerta1[p6].Setsubiendo(false);


    Abrir_cerrar = puerta1[p6].GetAbrir_Cerrar();

        if (Abrir_cerrar == false)
                puerta1[p6].SetAbrir_Cerrar(true);
   

}

public void btnNiv7bajar(ActionEvent evt) {
     boolean Abrir_cerrar;
    

     try{
            snivelB = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
            inivelB = Integer.parseInt(snivelB);
            if (inivelB < 1 || inivelB >Xniv){
                JOptionPane.showMessageDialog(rootPane, "Favor ingresar un numero de 1 a " + Xniv);
                    snivelB = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
                    inivelB = Integer.parseInt(snivelB);
                }
               if(inivelB-1 == p7){
                            JOptionPane.showMessageDialog(rootPane, "No se Puede Viajar al Mismo Nivel");
                             snivelB = JOptionPane.showInputDialog("A que Nivel desea Subir y/o Bajar ingresar valores de 1 a " + Xniv);
                             inivelB = Integer.parseInt(snivelB);
                     }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(rootPane, "Favor ingresar un numero");
            }
               pers[p7].setNivelsubir12(p7);
                puerta1[p7].SetNivelSubir12(p7);
                pers[p7].setNivelbajar12(inivelB-1);
                puerta1[p7].SetNivelBajar12(inivelB-1);
               puerta1[p7].Setsubiendo(false);


    Abrir_cerrar = puerta1[p7].GetAbrir_Cerrar();


        if (Abrir_cerrar == false)
                puerta1[p7].SetAbrir_Cerrar(true);
   

}



public void run(){
 boolean b=true;

 String a;
        while(b==true){
try {


     for(int t2=0;t2<1;t2++){
                        //Camina hacia botones
   for(int wil1=0;wil1<Xniv;wil1++){
              if (pers[wil1].getCamina()){
                  int persX;
                        sonido.setsonido("walk.wav");
                         sonido.Tplay();
                         persX = pers[wil1].getX();
                     for(int x=0;x<150;x++){
                             persX= persX+1;
                              if (persX >=300) {
                                      persX =300;
                                   pers[wil1].setCamina(false);
                                 }
                               pers[wil1].setLocation(persX ,pers[wil1].getY());
                                  t.sleep(10);
                            }
                    }
                    }

//  if (puerta1[0].Getsubiendo() && puerta1[1].Getsubiendo()==false)
//  {
         for(int wil2=0;wil2<Xniv;wil2++){
      //simula subir el elevador

                for(int iSubir=0;iSubir<Xniv;iSubir++){

                     if (pers[wil2].getNivelsubir() == puerta1[iSubir].GetNivelSubir()){
                                pers[wil2].setSubir_bajar(true);

                                        PosPuertax[wil2] = puerta1[wil2].getX();
                                        PosPuertay[wil2] = puerta1[wil2].getY();
                                        PosPuertaw[wil2] = puerta1[wil2].getWidth();
                                        PosPuertah[wil2] = puerta1[wil2].getHeight();
                                        PosPuertax2[wil2] = puerta2[wil2].getX();
                                        PosPuertay2[wil2] = puerta2[wil2].getY();
                                        PosPuertaw2[wil2] = puerta2[wil2].getWidth();
                                        PosPuertah2[wil2] = puerta2[wil2].getHeight();
                                        if(puerta1[wil2].GetAbrir_Cerrar()&& puerta1[wil2].Getsubiendo()){
                                                 sonido.setsonido("doorOpen.wav");
                                                        sonido.Tplay();
                                                for(int x=0;x<20;x++){
                                                    icont=0;                                                    
                                                     PosPuertaw[wil2] =PosPuertaw[wil2]-1;
                                                     PosPuertax2[wil2]=PosPuertax2[wil2]+1;
                                                     PosPuertaw2[wil2]=PosPuertaw2[wil2]-1;
                                                     puerta1[wil2].setLocation(PosPuertax[wil2],PosPuertay[wil2]);
                                                     puerta1[wil2].setSize(PosPuertaw[wil2], PosPuertah[wil2]);
                                                     puerta2[wil2].setLocation(PosPuertax2[wil2],PosPuertay2[wil2]);
                                                     puerta2[wil2].setSize(PosPuertaw2[wil2], PosPuertah2[wil2]);
                                                   t.sleep(175);
                                                }
                                                     for(int i=0;i<2;i++){
                                                         int persX;
                                                          persX = pers[wil2].getX();
                                                                if(pers[wil2].getSubir_bajar()&& puerta1[wil2].Getsubiendo()){
                                                                     for(int x=0;x<75;x++){
                                                                             persX= persX+1;
                                                                              if (persX >=375) {
                                                                                      persX =370;                                                                                   
                                                                                 }
                                                                               pers[wil2].setLocation(persX ,pers[wil2].getY());
                                                                               t.sleep(35);
                                                                            }
                                                                   pers[wil2].setVisible(false);
                                                                   //puerta1[pers[wil2].getNivelbajar()].SetNivelBajar(pers[wil2].getNivelbajar());
                                                                   iseteanivel=pers[wil2].getNivelbajar();
                                                                    pers[wil2].SetSubio(true);
                                                                } 
                                                            t.sleep(75); 
                                                        }
                                                        puerta2[wil2].Set_Cerrar(false);
                                                        puerta1[wil2].SetAbrir_Cerrar(false);
                                                       
                                                                sonido.setsonido("doorClose.wav");
                                                                sonido.Tplay();
                                                        for(int z=0;z<20;z++){
                                                             icont=0;
                                                             
                                                                 PosPuertaw[wil2] =PosPuertaw[wil2]+1;
                                                                 PosPuertax2[wil2]=PosPuertax2[wil2]-1;
                                                                 PosPuertaw2[wil2]=PosPuertaw2[wil2]+1;
                                                                 puerta1[wil2].setLocation(PosPuertax[wil2],PosPuertay[wil2]);
                                                                 puerta1[wil2].setSize(PosPuertaw[wil2], PosPuertah[wil2]);
                                                                 puerta2[wil2].setLocation(PosPuertax2[wil2],PosPuertay2[wil2]);
                                                                 puerta2[wil2].setSize(PosPuertaw2[wil2], PosPuertah2[wil2]);
                                                                  t.sleep(100);
                                                            }
                                                                 puerta1[wil2].setLocation(PosPuertax3[wil2],PosPuertay3[wil2]);
                                                                 puerta1[wil2].setSize(PosPuertaw3[wil2], PosPuertah3[wil2]);
                                                                 puerta2[wil2].setLocation(PosPuertax4[wil2],PosPuertay4[wil2]);
                                                                 puerta2[wil2].setSize(PosPuertaw4[wil2], PosPuertah4[wil2]);
                                                }
                    }//si el valor que ingreso la persona es igual al del elevador
                  t.sleep(80);  //sleep de subir
                }
           } //fin de subir de nivel y al elevador
//inicio de subir de nivel y bajar del elevador
// for(int wil=0;iSubir1<wil;wil++){
     
    for(int iSubir1=0;iSubir1<Xniv;iSubir1++){
        

                     if (pers[iSubir1].getNivelbajar() == puerta1[iSubir1].GetNivelBajar() && pers[iSubir1].GetSubio()==true ){
                        
                                pers[iSubir1].setSubir_bajar(false);
                               if   (pers[iSubir1].GetSubio()){
                                       pers[0].setImagen("/resources/images/bart.png");                                     
                                       puerta2[pers[iSubir1].getNivelbajar()].Set_Cerrar(true);
                                       puerta1[pers[iSubir1].getNivelbajar()].SetAbrir_Cerrar(true);
                               }
                                if   (pers[iSubir1].GetSubio()){
                                       pers[1].setImagen("/resources/images/lisa.png");
                                       puerta2[pers[iSubir1].getNivelbajar()].Set_Cerrar(true);
                                       puerta1[pers[iSubir1].getNivelbajar()].SetAbrir_Cerrar(true);
                               }
                                if   (pers[iSubir1].GetSubio()){
                                       pers[2].setImagen("/resources/images/maggi.png");
                                       puerta2[pers[iSubir1].getNivelbajar()].Set_Cerrar(true);
                                       puerta1[pers[iSubir1].getNivelbajar()].SetAbrir_Cerrar(true);
                               }
                                if   (pers[iSubir1].GetSubio()){
                                       pers[3].setImagen("/resources/images/marsh.png");
                                       puerta2[pers[iSubir1].getNivelbajar()].Set_Cerrar(true);
                                       puerta1[pers[iSubir1].getNivelbajar()].SetAbrir_Cerrar(true);
                               }
                                if   (pers[iSubir1].GetSubio()){
                                       pers[4].setImagen("/resources/images/omero1.png");
                                       puerta2[pers[iSubir1].getNivelbajar()].Set_Cerrar(true);
                                       puerta1[pers[iSubir1].getNivelbajar()].SetAbrir_Cerrar(true);
                               }
                                if   (pers[iSubir1].GetSubio()){
                                       pers[5].setImagen("/resources/images/marsh.png");
                                       puerta2[pers[iSubir1].getNivelbajar()].Set_Cerrar(true);
                                       puerta1[pers[iSubir1].getNivelbajar()].SetAbrir_Cerrar(true);
                               }
                                if   (pers[iSubir1].GetSubio()){
                                       pers[6].setImagen("/resources/images/omero1.png");
                                       puerta2[pers[iSubir1].getNivelbajar()].Set_Cerrar(true);
                                       puerta1[pers[iSubir1].getNivelbajar()].SetAbrir_Cerrar(true);
                               }


                                        PosPuertax[iSubir1] = puerta1[iSubir1].getX();
                                        PosPuertay[iSubir1] = puerta1[iSubir1].getY();
                                        PosPuertaw[iSubir1] = puerta1[iSubir1].getWidth();
                                        PosPuertah[iSubir1] = puerta1[iSubir1].getHeight();
                                        PosPuertax2[iSubir1] = puerta2[iSubir1].getX();
                                        PosPuertay2[iSubir1] = puerta2[iSubir1].getY();
                                        PosPuertaw2[iSubir1] = puerta2[iSubir1].getWidth();
                                        PosPuertah2[iSubir1] = puerta2[iSubir1].getHeight();
                                        if(puerta1[pers[iSubir1].getNivelbajar()].GetAbrir_Cerrar() && puerta1[iSubir1].Getsubiendo()){
                                                 sonido.setsonido("doorOpen.wav");
                                                        sonido.Tplay();
                                                for(int x=0;x<20;x++){
                                                    icont=0;
                                                     PosPuertaw[pers[iSubir1].getNivelbajar()] =PosPuertaw[pers[iSubir1].getNivelbajar()]-1;
                                                     PosPuertax2[pers[iSubir1].getNivelbajar()]=PosPuertax2[pers[iSubir1].getNivelbajar()]+1;
                                                     PosPuertaw2[pers[iSubir1].getNivelbajar()]=PosPuertaw2[pers[iSubir1].getNivelbajar()]-1;
                                                     puerta1[pers[iSubir1].getNivelbajar()].setLocation(PosPuertax[pers[iSubir1].getNivelbajar()],PosPuertay[pers[iSubir1].getNivelbajar()]);
                                                     puerta1[pers[iSubir1].getNivelbajar()].setSize(PosPuertaw[pers[iSubir1].getNivelbajar()], PosPuertah[pers[iSubir1].getNivelbajar()]);
                                                     puerta2[pers[iSubir1].getNivelbajar()].setLocation(PosPuertax2[pers[iSubir1].getNivelbajar()],PosPuertay2[pers[iSubir1].getNivelbajar()]);
                                                     puerta2[pers[iSubir1].getNivelbajar()].setSize(PosPuertaw2[pers[iSubir1].getNivelbajar()], PosPuertah2[pers[iSubir1].getNivelbajar()]);
                                                   t.sleep(175);
                                                }
                                              for(int i=0;i<1;i++){
                                                         int persX;
                                                          persX = pers[iSubir1].getX();
                                                          //baja la primera persona
                                                                if(pers[iSubir1].getSubir_bajar()==false){

                                                                     pers[iSubir1].setVisible(true);
                                                                     for(int x=0;x<415;x++){
                                                                             persX= persX-1;
                                                                              if (persX <=-15) {
                                                                                      persX =-15;
                                                                                 }
                                                                               pers[iSubir1].setLocation(persX ,nivel1[pers[iSubir1].getNivelbajar()].getY()+20);
                                                                               t.sleep(35);
                                                                            }
                                                                     pers[pers[iSubir1].getNivelbajar()].setNivelsubir(-1);
                                                                     puerta1[pers[iSubir1].getNivelbajar()].SetNivelSubir(-1);
                                                                  
                                                                }
                                                                 if(pers[iSubir1].GetSubio())
                                                                        pers[iSubir1].SetSubio(false);
                                                                  

                                                            t.sleep(35);
                                                        }
                                                     //verifica si no hay mas personas a bajar en el mismo nivel   
                                                        for(int wil=0;wil<Xniv;wil++){     
                                                             //for(int iSubir2=0;iSubir2<Xniv;iSubir2++){
                                                       if (pers[wil].GetSubio()==true){
                                                                                for(int i=0;i<1;i++){
                                                                 int persX;
                                                                  persX = pers[wil].getX();
                                                                  //baja las demas personas
                                                                  pers[wil].setSubir_bajar(false);
                                                                        if(pers[wil].getSubir_bajar()==false){
                                                                              pers[wil].setVisible(true);
                                                                               for(int x=0;x<400;x++){
                                                                                     persX= persX-1;
                                                                                          if (persX <=-15) {
                                                                                                 persX =-15;
                                                                                                }
                                                                                   pers[wil].setLocation(persX ,nivel1[pers[iSubir1].getNivelbajar()].getY()+20);
                                                                                 t.sleep(35);
                                                                               }
                                                                             pers[wil].setNivelsubir(-1);
                                                                             puerta1[wil].SetNivelSubir(-1);
                                                                                }
                                                                        if(pers[wil].GetSubio())
                                                                            pers[wil].SetSubio(false);
                                                                            t.sleep(75);
                                                                        }
                                                                  }
                                                              //}
                                            }
                                                        puerta2[iSubir1].Set_Cerrar(false);
                                                        puerta1[iSubir1].SetAbrir_Cerrar(false);
                                                        puerta2[pers[iSubir1].getNivelbajar()].Set_Cerrar(false);
                                                        puerta1[pers[iSubir1].getNivelbajar()].SetAbrir_Cerrar(false);
                                                        puerta1[pers[iSubir1].getNivelbajar()].Setsubiendo(false);
                                                                sonido.setsonido("doorClose.wav");
                                                                sonido.Tplay();
                                                        for(int z=0;z<20;z++){
                                                             icont=0;

                                                                 PosPuertaw[pers[iSubir1].getNivelbajar()] =PosPuertaw[pers[iSubir1].getNivelbajar()]+1;
                                                                 PosPuertax2[pers[iSubir1].getNivelbajar()]=PosPuertax2[pers[iSubir1].getNivelbajar()]-1;
                                                                 PosPuertaw2[pers[iSubir1].getNivelbajar()]=PosPuertaw2[pers[iSubir1].getNivelbajar()]+1;
                                                                 puerta1[pers[iSubir1].getNivelbajar()].setLocation(PosPuertax[pers[iSubir1].getNivelbajar()],PosPuertay[pers[iSubir1].getNivelbajar()]);
                                                                 puerta1[pers[iSubir1].getNivelbajar()].setSize(PosPuertaw[pers[iSubir1].getNivelbajar()], PosPuertah[pers[iSubir1].getNivelbajar()]);
                                                                 puerta2[pers[iSubir1].getNivelbajar()].setLocation(PosPuertax2[pers[iSubir1].getNivelbajar()],PosPuertay2[pers[iSubir1].getNivelbajar()]);
                                                                 puerta2[pers[iSubir1].getNivelbajar()].setSize(PosPuertaw2[pers[iSubir1].getNivelbajar()], PosPuertah2[pers[iSubir1].getNivelbajar()]);
                                                                  t.sleep(100);
                                                            }
                                                                 puerta1[pers[iSubir1].getNivelbajar()].setLocation(PosPuertax3[pers[iSubir1].getNivelbajar()],PosPuertay3[pers[iSubir1].getNivelbajar()]);
                                                                 puerta1[pers[iSubir1].getNivelbajar()].setSize(PosPuertaw3[pers[iSubir1].getNivelbajar()], PosPuertah3[pers[iSubir1].getNivelbajar()]);
                                                                 puerta2[pers[iSubir1].getNivelbajar()].setLocation(PosPuertax4[pers[iSubir1].getNivelbajar()],PosPuertay4[pers[iSubir1].getNivelbajar()]);
                                                                 puerta2[pers[iSubir1].getNivelbajar()].setSize(PosPuertaw4[pers[iSubir1].getNivelbajar()], PosPuertah4[pers[iSubir1].getNivelbajar()]);
                                                }
                    }//si el valor que ingreso la persona es igual al del elevador
                  t.sleep(80);  //sleep de subir
               // }for  //inicio de subir de nivel y bajar del elevador
                    
                    t.sleep(10);
    }
   // }
      
            }


//  if (puerta1[1].Getsubiendo()==true && puerta1[0].Getsubiendo()==false)
 // {
  ///funciones para bajar de piso segun nivel***********************bajar
   //  for(int til2=0;til2<Xniv;til2++){
       for(int til2=Xniv -1 ;til2>0;til2--){
         

      //simula subir el elevador

                for(int iSubir=0;iSubir<Xniv;iSubir++){

                     if (pers[til2].getNivelsubir12() == puerta1[iSubir].GetNivelSubir12()){
                                pers[til2].setSubir_bajar(true);

                                        PosPuertax[til2] = puerta1[til2].getX();
                                        PosPuertay[til2] = puerta1[til2].getY();
                                        PosPuertaw[til2] = puerta1[til2].getWidth();
                                        PosPuertah[til2] = puerta1[til2].getHeight();
                                        PosPuertax2[til2] = puerta2[til2].getX();
                                        PosPuertay2[til2] = puerta2[til2].getY();
                                        PosPuertaw2[til2] = puerta2[til2].getWidth();
                                        PosPuertah2[til2] = puerta2[til2].getHeight();
                                        if(puerta1[til2].GetAbrir_Cerrar() && puerta1[til2].Getsubiendo()==false){
                                                 sonido.setsonido("doorOpen.wav");
                                                        sonido.Tplay();
                                                for(int x=0;x<20;x++){
                                                    icont=0;
                                                     PosPuertaw[til2] =PosPuertaw[til2]-1;
                                                     PosPuertax2[til2]=PosPuertax2[til2]+1;
                                                     PosPuertaw2[til2]=PosPuertaw2[til2]-1;
                                                     puerta1[til2].setLocation(PosPuertax[til2],PosPuertay[til2]);
                                                     puerta1[til2].setSize(PosPuertaw[til2], PosPuertah[til2]);
                                                     puerta2[til2].setLocation(PosPuertax2[til2],PosPuertay2[til2]);
                                                     puerta2[til2].setSize(PosPuertaw2[til2], PosPuertah2[til2]);
                                                   t.sleep(175);
                                                }
                                                     for(int i=0;i<2;i++){
                                                         int persX;
                                                          persX = pers[til2].getX();
                                                                if(pers[til2].getSubir_bajar() && puerta1[til2].Getsubiendo()==false){
                                                                     for(int x=0;x<75;x++){
                                                                             persX= persX+1;
                                                                              if (persX >=375) {
                                                                                      persX =370;
                                                                                 }
                                                                               pers[til2].setLocation(persX ,pers[til2].getY());
                                                                               t.sleep(35);
                                                                            }
                                                                   pers[til2].setVisible(false);
                                                                   //puerta1[pers[wil2].getNivelbajar12()].SetNivelBajar(pers[wil2].getNivelbaja12());
                                                                   iseteanivel=pers[til2].getNivelbajar12();
                                                                    pers[til2].SetSubio(true);
                                                                }
                                                            t.sleep(75);
                                                        }
                                                        puerta2[til2].Set_Cerrar(false);
                                                        puerta1[til2].SetAbrir_Cerrar(false);

                                                                sonido.setsonido("doorClose.wav");
                                                                sonido.Tplay();
                                                        for(int z=0;z<20;z++){
                                                             icont=0;

                                                                 PosPuertaw[til2] =PosPuertaw[til2]+1;
                                                                 PosPuertax2[til2]=PosPuertax2[til2]-1;
                                                                 PosPuertaw2[til2]=PosPuertaw2[til2]+1;
                                                                 puerta1[til2].setLocation(PosPuertax[til2],PosPuertay[til2]);
                                                                 puerta1[til2].setSize(PosPuertaw[til2], PosPuertah[til2]);
                                                                 puerta2[til2].setLocation(PosPuertax2[til2],PosPuertay2[til2]);
                                                                 puerta2[til2].setSize(PosPuertaw2[til2], PosPuertah2[til2]);
                                                                  t.sleep(100);
                                                            }
                                                                 puerta1[til2].setLocation(PosPuertax3[til2],PosPuertay3[til2]);
                                                                 puerta1[til2].setSize(PosPuertaw3[til2], PosPuertah3[til2]);
                                                                 puerta2[til2].setLocation(PosPuertax4[til2],PosPuertay4[til2]);
                                                                 puerta2[til2].setSize(PosPuertaw4[til2], PosPuertah4[til2]);
                                                }
                    }//si el valor que ingreso la persona es igual al del elevador
                  t.sleep(80);  //sleep de subir
                }
 
           } //fin de subir de nivel y al elevador
//inicio de subir de nivel y bajar del elevador
// for(int wil=0;iSubir1<wil;wil++){

 //   for(int tiSubir1=0;tiSubir1<Xniv;tiSubir1++){
   for(int tiSubir1=Xniv-1;tiSubir1>0;tiSubir1--){


                     if (pers[tiSubir1].getNivelbajar12() == puerta1[tiSubir1].GetNivelBajar12() && pers[tiSubir1].GetSubio()==true ){

                                pers[tiSubir1].setSubir_bajar(false);
                               if   (pers[tiSubir1].GetSubio()){
                                       pers[0].setImagen("/resources/images/bart.png");
                                       puerta2[pers[tiSubir1].getNivelbajar12()].Set_Cerrar(true);
                                       puerta1[pers[tiSubir1].getNivelbajar12()].SetAbrir_Cerrar(true);
                               }
                                if   (pers[tiSubir1].GetSubio()){
                                       pers[1].setImagen("/resources/images/lisa.png");
                                       puerta2[pers[tiSubir1].getNivelbajar12()].Set_Cerrar(true);
                                       puerta1[pers[tiSubir1].getNivelbajar12()].SetAbrir_Cerrar(true);
                               }
                                if   (pers[tiSubir1].GetSubio()){
                                       pers[2].setImagen("/resources/images/maggi.png");
                                       puerta2[pers[tiSubir1].getNivelbajar12()].Set_Cerrar(true);
                                       puerta1[pers[tiSubir1].getNivelbajar12()].SetAbrir_Cerrar(true);
                               }
                                if   (pers[tiSubir1].GetSubio()){
                                       pers[3].setImagen("/resources/images/marsh.png");
                                       puerta2[pers[tiSubir1].getNivelbajar12()].Set_Cerrar(true);
                                       puerta1[pers[tiSubir1].getNivelbajar12()].SetAbrir_Cerrar(true);
                               }
                                if   (pers[tiSubir1].GetSubio()){
                                       pers[4].setImagen("/resources/images/omero1.png");
                                       puerta2[pers[tiSubir1].getNivelbajar12()].Set_Cerrar(true);
                                       puerta1[pers[tiSubir1].getNivelbajar12()].SetAbrir_Cerrar(true);
                               }
                                if   (pers[tiSubir1].GetSubio()){
                                       pers[5].setImagen("/resources/images/marsh.png");
                                       puerta2[pers[tiSubir1].getNivelbajar12()].Set_Cerrar(true);
                                       puerta1[pers[tiSubir1].getNivelbajar12()].SetAbrir_Cerrar(true);
                               }
                                if   (pers[tiSubir1].GetSubio()){
                                       pers[6].setImagen("/resources/images/omero1.png");
                                       puerta2[pers[tiSubir1].getNivelbajar12()].Set_Cerrar(true);
                                       puerta1[pers[tiSubir1].getNivelbajar12()].SetAbrir_Cerrar(true);
                               }


                                        PosPuertax[tiSubir1] = puerta1[tiSubir1].getX();
                                        PosPuertay[tiSubir1] = puerta1[tiSubir1].getY();
                                        PosPuertaw[tiSubir1] = puerta1[tiSubir1].getWidth();
                                        PosPuertah[tiSubir1] = puerta1[tiSubir1].getHeight();
                                        PosPuertax2[tiSubir1] = puerta2[tiSubir1].getX();
                                        PosPuertay2[tiSubir1] = puerta2[tiSubir1].getY();
                                        PosPuertaw2[tiSubir1] = puerta2[tiSubir1].getWidth();
                                        PosPuertah2[tiSubir1] = puerta2[tiSubir1].getHeight();
                                        if(puerta1[pers[tiSubir1].getNivelbajar12()].GetAbrir_Cerrar()&&  puerta1[tiSubir1].Getsubiendo()==false){
                                                 sonido.setsonido("doorOpen.wav");
                                                        sonido.Tplay();
                                                for(int x=0;x<20;x++){
                                                    icont=0;
                                                     PosPuertaw[pers[tiSubir1].getNivelbajar12()] =PosPuertaw[pers[tiSubir1].getNivelbajar12()]-1;
                                                     PosPuertax2[pers[tiSubir1].getNivelbajar12()]=PosPuertax2[pers[tiSubir1].getNivelbajar12()]+1;
                                                     PosPuertaw2[pers[tiSubir1].getNivelbajar12()]=PosPuertaw2[pers[tiSubir1].getNivelbajar12()]-1;
                                                     puerta1[pers[tiSubir1].getNivelbajar12()].setLocation(PosPuertax[pers[tiSubir1].getNivelbajar12()],PosPuertay[pers[tiSubir1].getNivelbajar12()]);
                                                     puerta1[pers[tiSubir1].getNivelbajar12()].setSize(PosPuertaw[pers[tiSubir1].getNivelbajar12()], PosPuertah[pers[tiSubir1].getNivelbajar12()]);
                                                     puerta2[pers[tiSubir1].getNivelbajar12()].setLocation(PosPuertax2[pers[tiSubir1].getNivelbajar12()],PosPuertay2[pers[tiSubir1].getNivelbajar12()]);
                                                     puerta2[pers[tiSubir1].getNivelbajar12()].setSize(PosPuertaw2[pers[tiSubir1].getNivelbajar12()], PosPuertah2[pers[tiSubir1].getNivelbajar12()]);
                                                   t.sleep(175);
                                                }
                                              for(int i=0;i<1;i++){
                                                         int persX;
                                                          persX = pers[tiSubir1].getX();
                                                          //baja la primera persona
                                                                if(pers[tiSubir1].getSubir_bajar()==false){

                                                                     pers[tiSubir1].setVisible(true);
                                                                     for(int x=0;x<415;x++){
                                                                             persX= persX-1;
                                                                              if (persX <=-15) {
                                                                                      persX =-15;
                                                                                 }
                                                                               pers[tiSubir1].setLocation(persX ,nivel1[pers[tiSubir1].getNivelbajar12()].getY()+20);

                                                                               t.sleep(35);
                                                                            }
                                                                     pers[pers[tiSubir1].getNivelbajar12()].setNivelsubir12(-1);
                                                                     puerta1[pers[tiSubir1].getNivelbajar12()].SetNivelSubir12(-1);

                                                                }
                                                                 if(pers[tiSubir1].GetSubio())
                                                                        pers[tiSubir1].SetSubio(false);


                                                            t.sleep(35);
                                                        }
                                                     //verifica si no hay mas personas a bajar en el mismo nivel
                                                        for(int twil=0;twil<Xniv;twil++){
                                                             //for(int iSubir2=0;iSubir2<Xniv;iSubir2++){
                                                       if (pers[twil].GetSubio()==true){
                                                                                for(int i=0;i<1;i++){
                                                                 int persX;
                                                                  persX = pers[twil].getX();
                                                                  //baja las demas personas
                                                                  pers[twil].setSubir_bajar(false);
                                                                        if(pers[twil].getSubir_bajar()==false){
                                                                              pers[twil].setVisible(true);
                                                                               for(int x=0;x<400;x++){
                                                                                     persX= persX-1;
                                                                                          if (persX <=-15) {
                                                                                                 persX =-15;
                                                                                                }
                                                                                   pers[twil].setLocation(persX ,nivel1[pers[tiSubir1].getNivelbajar12()].getY()+20);
                                                                                 t.sleep(35);
                                                                               }
                                                                             pers[twil].setNivelsubir12(-1);
                                                                             puerta1[twil].SetNivelSubir12(-1);
                                                                                }
                                                                        if(pers[twil].GetSubio())
                                                                            pers[twil].SetSubio(false);
                                                                            t.sleep(75);
                                                                        }
                                                                  }
                                                              //}
                                            }
                                                        puerta2[tiSubir1].Set_Cerrar(false);
                                                        puerta1[tiSubir1].SetAbrir_Cerrar(false);
                                                        puerta2[pers[tiSubir1].getNivelbajar12()].Set_Cerrar(false);
                                                        puerta1[pers[tiSubir1].getNivelbajar12()].SetAbrir_Cerrar(false);
                                                        puerta1[1].Setsubiendo(false);
                                                                sonido.setsonido("doorClose.wav");
                                                                sonido.Tplay();
                                                        for(int z=0;z<20;z++){
                                                             icont=0;

                                                                 PosPuertaw[pers[tiSubir1].getNivelbajar12()] =PosPuertaw[pers[tiSubir1].getNivelbajar12()]+1;
                                                                 PosPuertax2[pers[tiSubir1].getNivelbajar12()]=PosPuertax2[pers[tiSubir1].getNivelbajar12()]-1;
                                                                 PosPuertaw2[pers[tiSubir1].getNivelbajar12()]=PosPuertaw2[pers[tiSubir1].getNivelbajar12()]+1;
                                                                 puerta1[pers[tiSubir1].getNivelbajar12()].setLocation(PosPuertax[pers[tiSubir1].getNivelbajar12()],PosPuertay[pers[tiSubir1].getNivelbajar12()]);
                                                                 puerta1[pers[tiSubir1].getNivelbajar12()].setSize(PosPuertaw[pers[tiSubir1].getNivelbajar12()], PosPuertah[pers[tiSubir1].getNivelbajar12()]);
                                                                 puerta2[pers[tiSubir1].getNivelbajar12()].setLocation(PosPuertax2[pers[tiSubir1].getNivelbajar12()],PosPuertay2[pers[tiSubir1].getNivelbajar12()]);
                                                                 puerta2[pers[tiSubir1].getNivelbajar12()].setSize(PosPuertaw2[pers[tiSubir1].getNivelbajar12()], PosPuertah2[pers[tiSubir1].getNivelbajar12()]);
                                                                  t.sleep(100);
                                                            }
                                                                 puerta1[pers[tiSubir1].getNivelbajar12()].setLocation(PosPuertax3[pers[tiSubir1].getNivelbajar12()],PosPuertay3[pers[tiSubir1].getNivelbajar12()]);
                                                                 puerta1[pers[tiSubir1].getNivelbajar12()].setSize(PosPuertaw3[pers[tiSubir1].getNivelbajar12()], PosPuertah3[pers[tiSubir1].getNivelbajar12()]);
                                                                 puerta2[pers[tiSubir1].getNivelbajar12()].setLocation(PosPuertax4[pers[tiSubir1].getNivelbajar12()],PosPuertay4[pers[tiSubir1].getNivelbajar12()]);
                                                                 puerta2[pers[tiSubir1].getNivelbajar12()].setSize(PosPuertaw4[pers[tiSubir1].getNivelbajar12()], PosPuertah4[pers[tiSubir1].getNivelbajar12()]);
                                                }
                    }//si el valor que ingreso la persona es igual al del elevador
                  t.sleep(80);  //sleep de subir
               // }for  //inicio de subir de nivel y bajar del elevador

                    t.sleep(10);
    }
  //  }//verifica si esta subiendo
   
            }

  ////funciones para bajar de piso segun nivel

                                 catch (InterruptedException ex) {
                                    Logger.getLogger(edificio.class.getName()).log(Level.SEVERE, null, ex);
                                }
            
        }
}
/*
 public static void main(String[] arg){
edificio obj = new edificio();
obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
obj.setVisible(true);
obj.show();
}*/

    public void mouseClicked(MouseEvent e) {
        sonido.Sstop();
        if( e.getX() < pers[0].getX() + pers[0].getWidth() & e.getX() > pers[0].getX()){

                if( e.getY() <= pers[0].getY() + pers[0].getHeight() & e.getY() > pers[0].getY()){
                   // if (pers[0].getCamina()==true)
                            pers[0].setCamina(true);
                            pers[0].setImagen("/resources/images/bart1.png");
                }
           }
         if( e.getX() < pers[1].getX() + pers[1].getWidth() & e.getX() > pers[1].getX()){
                if( e.getY() < pers[1].getY() + pers[1].getHeight() & e.getY() > pers[1].getY()){
                    //if (pers[1].getCamina()==true)
                        pers[1].setCamina(true);
                        pers[1].setImagen("/resources/images/lisa1.png");
                }
        }
        if( e.getX() < pers[2].getX() + pers[2].getWidth() & e.getX() > pers[2].getX()){
                if( e.getY() < pers[2].getY() + pers[2].getHeight()& e.getY() > pers[2].getY()){
                    //if (pers[2].getCamina()==true)
                        pers[2].setCamina(true);
                        pers[2].setImagen("/resources/images/maggi1.png");
                }
        }
        if( e.getX() < pers[3].getX() + pers[3].getWidth() & e.getX() > pers[3].getX()){
                if( e.getY() < pers[3].getY() + pers[3].getHeight()& e.getY() > pers[3].getY()){
                    //if (pers[3].getCamina()==true)
                        pers[3].setCamina(true);
                        pers[3].setImagen("/resources/images/marsh1.png");
                }
        }
        if( e.getX() < pers[4].getX() + pers[4].getWidth() & e.getX() > pers[4].getX()){
                if( e.getY() < pers[4].getY() + pers[4].getHeight() & e.getY() > pers[4].getY()){
                   // if (pers[4].getCamina()==true)
                        pers[4].setCamina(true);
                        pers[4].setImagen("/resources/images/omero.png");
                }
        }
        if( e.getX() < pers[5].getX() + pers[5].getWidth() & e.getX() > pers[5].getX()){
                if( e.getY() < pers[5].getY() + pers[5].getHeight() & e.getY() > pers[5].getY()){
                   // if (pers[5].getCamina()==true)
                        pers[5].setCamina(true);
                        pers[5].setImagen("/resources/images/marsh1.png");
                }
        }
        if( e.getX() < pers[6].getX() + pers[6].getWidth() & e.getX() > pers[6].getX()){
                if( e.getY() < pers[6].getY() + pers[6].getHeight() & e.getY() > pers[6].getY()){
                   // if (pers[6].getCamina()==true)
                        pers[6].setCamina(true);
                        pers[6].setImagen("/resources/images/omero.png");
                }
        }
        
    }
    public void mousePressed(MouseEvent e) {
      
    }
    public void mouseReleased(MouseEvent e) {
   
    }
    public void mouseEntered(MouseEvent e) {
   
    }
    public void mouseExited(MouseEvent e) {
   
    }
    public void mouseDragged(MouseEvent e) {
   
    }
    public void mouseMoved(MouseEvent e) {
   
    }
}
