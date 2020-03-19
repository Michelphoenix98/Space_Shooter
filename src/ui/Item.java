/*  Space Shooter 2D My own version of the Original Space Invaders 1978 by Tomohiro Nishikado
    Copyright (C) 2016  Michel Thomas

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA */
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Michel Thomas
 */
public class Item extends JLabel implements ActionListener {
Timer dt;
int x,y,missed,targetHit;
main obj;
Player player;
String enemyClass;
int no;
    public Item(int no,Player player,main obj,int x,int y,String enemyClass){
        if(no==1){
             setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/ac.png")));
        }
        else if(no==2){
             setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/mc.png")));
        }
        else if(no==3){
             setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/nc.png")));
        }
        else if(no==4){
             setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/hc.png")));
        }
        else {
             setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/sc.png")));
        }
        this.setSize(32,29);
        this.setVisible(true);
        this.x=x;
        this.y=y+30;
        this.obj=obj;
        this.player=player;
        this.enemyClass=enemyClass;
        this.no=no;
        dt=new Timer(20,this);
    }
    public void start(){
          dt.start();
    }
    public void stop(){
          dt.stop();
    }
    public void actionPerformed(ActionEvent e) {
      if((Timer)e.getSource()==dt){
            if(y>=obj.heightOfPanel){   
              dt.stop();
                 missed=1;
                 targetHit=0;
//                 System.out.println("Item lost!");
                 setIcon(null);
                 repaint();
         }
         else{
                if((x<=player.getXofPlayer()+40&&x>=player.getXofPlayer()||x>=player.getXofPlayer()-40&&x<=player.getXofPlayer())&&!(player.getLife()<0)){
                     if(y>=player.getYofPlayer()&&y<=player.getYofPlayer()+41){
                      dt.stop();
                      targetHit=1;
                      missed=0;
//                      System.out.println("Item!");
                    player.acquireItem(no);
                 
                
                   setIcon(null);
                 repaint();
                     }
                }
         }
            if(targetHit!=1&&missed==0){
           this.setLocation(x,y+=2);
            repaint();  }
      }
    }
    
}
