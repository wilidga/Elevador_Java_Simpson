/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package elevador;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JCheckBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Wilman
 */
public class nivel  extends JPanel{
boolean col = false;
Polygon p;
boolean c1,c2;
boolean bparan = false;
//javax.swing.JCheckBox ch1,ch2;

    public void setearcolor(boolean a){
        col=a;
    }
    public boolean getearcolor(){
            return col;
    }


public void setparam (boolean t){
        bparan = true;
}
public void SetcolArr (boolean i){
        c1 = i;
    }
public boolean GetcolArr (){
       return c1;
    }
public void Setcolaba (boolean i){
        c2 = i;
    }
public boolean Getcolaba (){
       return c2;
    }
/*
 public boolean action(Event e, Object o){
      if (o instanceof String){
            if(o.equals("U"))
             ch1.setBackground(Color.red);
            if(o.equals("D"))
             ch2.setBackground(Color.red);



    }
      return false;
   }
*/
    public void paint (Graphics g){
        p = new Polygon();
        g.setColor(Color.white);
        g.fillRect(0, 0, 340, 70);
        g.setColor(Color.black);
        g.drawRect(0, 0, 340, 70);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,60 ,400, 20);
        /*if (col == true){
            g.setColor(Color.GREEN);
            g.fillOval(330, 8, 10,10);
            }
         else {
            g.setColor(Color.red);
             g.fillOval(330, 8, 10,10);
          }*/
        //ch1 = new javax.swing.JCheckBox("U");
       // ch2 = new javax.swing.JCheckBox("D");
       // add(ch1);
       // add(ch2);
        /* if (bparan==true){
            ch1.reshape(330, 38, 10, 10);
        }
        else
        {
            ch1.reshape(330, 38, 10, 10);
            ch2.reshape(330, 53, 10, 10);
        }*/

/*ch1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent evt) {
		arriba (evt);
	}

            private void arriba(ActionEvent evt) {


            }
        });

ch2.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent evt) {
		abajo (evt);

	}

            private void abajo(ActionEvent evt) {


            }
        });*/


    }


    }




