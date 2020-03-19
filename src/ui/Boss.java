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
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 *
 * @author Michel Thomas
 */
public class Boss extends JLabel implements ActionListener {
    Timer movement;
    Timer lights;
    Timer shootGun;
    Timer shootCannon;
    int life;
    int phase=1;
    int x,y;
    int moveValue;
    int fLights=0;
    main obj;
    Bullet bullet1;
    Bullet bullet2;
    int CDP;
    int flag2;
    Timer damageInd;
    int dbc;
    public Boss(main obj){
        this.obj=obj;
        setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/Drones_1.png")));
       damageInd=new Timer(50,this); 
        lights=new Timer(50,this);
        movement=new Timer(10,this);
        shootCannon=new Timer(5000,this);
        shootGun=new Timer(10,this);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if((Timer)e.getSource()==movement){
         if(moveValue==0){
               if(this.getX()>=obj.getWidth()-this.getWidth()){
                   moveValue=1;
                   
               }
               else{
                  
                         this.setLocation(x+=5,this.getY());
               }
           }
           else{
                if(this.getX()<=0){
                   moveValue=0;
                   
               }
               else{
                   this.setLocation(x-=5,this.getY());
               }
           }   
        }
        else if((Timer)e.getSource()==shootGun){
             setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/BossMainCannon.png")));
             bullet1=new Bullet(this.getX()+(this.getWidth()/2-5),this.getY(),obj.heightOfPanel,obj.player,"Boss",obj,obj.timerSpeed,2);
             bullet2=new Bullet(this.getX()+this.getWidth()/2+5,this.getY(),obj.heightOfPanel,obj.player,"Boss",obj,obj.timerSpeed,2);
              bullet1.setSize(5, 29);
      obj. mainPanel.add(bullet1);
       bullet1.setVisible(true);
       bullet1.start();
          //   bullet1.start();
             bullet2.setSize(5, 29);
       obj.mainPanel.add(bullet2);
       bullet2.setVisible(true);
       bullet2.start();
             
        }
        else if((Timer)e.getSource()==shootCannon){
            if(!shootGun.isRunning())
             shootGun.start();
            else
               shootGun.stop();  
              
        }
        else if((Timer)e.getSource()==lights){
            if(fLights==0){
         setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/Boss"+phase+".png")));
         phase++;
          if(phase==7){
             fLights=1;
             phase=6;
         }
            }else {
                setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/Boss"+phase+".png")));
         phase--; 
         if(phase==1){
             fLights=0;
         }
            }
            
        
            
              }
}
     public void consecutiveDamageProtection(){
        CDP=1;
        flag2=0;
       damageInd.start();
      
    }
     
    public void die(){
    movement.stop();
       shootCannon.stop(); 
       lights.stop();
     
     }
    public void damage(int bType)
    {
        System.out.println("67");
      
           if(bType>=1){ life=0;
          // System.out.println("6");
            this.die();
            dbc=bType;
           }
           else {
              // System.out.println("4");
               life=life-50;
           }
             if(life>0)
           consecutiveDamageProtection();
    }
    public void start(){
        lights.start();
        movement.start();
        shootCannon.start();
    }
}
