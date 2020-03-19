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

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;

/**
 *
 * @author Michel Thomas
 */

public class EnemyEquipment extends javax.swing.JLabel implements ActionListener {
    int numberOfTimes=4;
    Timer funcFreq;
    Timer anim;
    Timer movement;
    Timer deathClip;
    Timer damageInd;
    Timer flicker;
    Timer ufoPitch;
   Timer CDPT;
  int CDP=0;
  int flag01=0;
  int moveValue=0;
    int missileJam=0;
    Enemy[] enemies;
    short flag=0;
    int life;
    int flag2=0;
    Random rand=new Random();
    int x,y;
    main obj;
    
    public EnemyEquipment(int cat,Enemy[] enemies,int x,int y,main obj) {
       
        if(cat==1){
          //  System.out.print("EAR complete...");
          setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/eAr.png")));
          missileJam=1;
         
        }
        else if(cat==2){
             setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/bullet.png")));
        }
        else if(cat==3){
             setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/bullet.png")));
        }
        this.x=x;
        this.y=y;
     this.enemies=enemies;
        funcFreq=new Timer(1000,this);
        anim=new Timer(50,this);
        damageInd=new Timer(100,this);
        this.obj=obj;
        flicker=new Timer(100,this);
         flicker.setCoalesce(false);
          CDPT=new Timer(2000,this);
          movement=new Timer(10,this);
          ufoPitch=new Timer(2000,this);
          life=100;
    }
    
    public void start(){
     funcFreq.start();
     ufoPitch.start();
     anim.start();
      movement.start();
    //  System.out.println("13");
    }
      public void consecutiveDamageProtection(){
        CDP=1;
        flag2=0;
       damageInd.start();
       anim.stop();
      
    }
    public void damage(int a){
        if(a==0){
            life=life-25;
      
        }
        else if(a==1){
            life=life-50;
            
        }
        else
            life=life-life;
        
        if(life<=0)
            this.destroy();
        
       else    consecutiveDamageProtection();
    }
    public void destroy(){
         ufoPitch.stop();
        System.out.println("1314");
      funcFreq.stop();
      movement.stop();
     anim.stop();
        deathClip=new Timer(100, this);
         deathClip.start();
         this.setSize(40,49);
           }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if((Timer)e.getSource()==funcFreq){
            if(rand.nextInt(100)>50){
                if(rand.nextInt(100)<50){
                   for(int i=0;i<enemies.length;i++){
                    if(enemies[i].getLife()!=0)
                         enemies[i].shield();
                        
                    }
                }
            }
            else{
                   if(rand.nextInt(100)>50){
                  
                
                  for(int i=0;i<enemies.length;i++){
                     if(enemies[i].getLife()<=50&&enemies[i].getLife()>0){
                         enemies[i].regenerateHealth();
                     }   
                    }
                   }
            }
        }
        
        else if((Timer)e.getSource()==ufoPitch){
            System.out.println("13");
        }
        else if((Timer)e.getSource()==movement){
           if(moveValue==0){
               if(this.getX()>=obj.getWidth()){
                   moveValue=1;
                   
               }
               else{
                   this.setLocation(x+=5,y);
               }
           }
           else{
                if(this.getX()<=0){
                   moveValue=0;
                   
               }
               else{
                   this.setLocation(x-=5,y);
               }
           }
        } 
        else if((Timer)e.getSource()==damageInd){
         
          
             if(flag2==0){
         setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/eArd.png")));
         flag2=1;
             }
             else{ 
                 setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/eAr.png")));
       
            damageInd.stop();
             }
                 
      
        }
        else if((Timer)e.getSource()==deathClip){
              if(numberOfTimes<=0){
           deathClip.stop();
           setVisible(false);
        
           setIcon(null);
          }else{
               
//            System.out.println("[Anim Clip]NumberOFtimes="+numberOfTimes);
           
          setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/dd"+numberOfTimes+".png")));
    }
           numberOfTimes--;
        }
        else if((Timer)e.getSource()==anim){
            if(flag==0){
               setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/eAr.png")));
               flag=1;
            }
            else if(flag==1){
                   setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/eAr2.png")));
                   flag=2;
            }
            else{
                setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/eAr3.png")));
                   flag=0;
            } 
        }
    }
}
    


