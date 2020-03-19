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
import java.util.Random;
import javax.swing.Timer;

/**
 *
 * @author Michel Thomas
 */
public class Enemy extends javax.swing.JLabel implements ActionListener{
    private int life;
    String enemyClass;
    int x;
    int y;
    Timer timer;
    Timer deathClip;
    Timer shoot;
    Timer shield;
    Timer iA;
    Bullet bullet;
    Random rand;
    Random rand2;
    main obj;
    int sr;
    Timer flicker;
   Timer CDPT;
   Timer damageInd;
   Timer movement;
   Timer TFJ;
   int CDP=0;
   int flag2=0;
   int flag01=0;
    Item item;
    int timerSpeed;
    int moveValue=0;
    int dbc;//death bullet class
    public Enemy(String enemyClass,int x,int y,main obj,int sr,int timerSpeed){
        setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/"+enemyClass+".png")));
        this.enemyClass=enemyClass;
        this.x=x;
        this.y=y;
        this.obj=obj;
        life=100;
        rand=new Random();
        rand2=new Random();
        rorient=rand.nextInt(1);
        this.sr=sr;
        CDPT=new Timer(2000,this);
        flicker=new Timer(100,this);
        damageInd=new Timer(100,this);
        this.timerSpeed=timerSpeed;
         shield=new Timer(5000,this);
         iA=new Timer(200,this);
         movement=new Timer(10,this);
        
    }
    public void start(){
       
      timer=new Timer(100,this);   
      timer.start();
        movement.start();
      shoot=new Timer(2000,this);
      shoot.start();
    }
    public void regenerateHealth(){
        iA.start();
        setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/"+enemyClass+"r.png")));
     life=life+25;   
    }
    public void shield(){
        CDP=1;
          CDP=1;
          setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/"+enemyClass+"pp.png"))); 
            shield.start();
    }
    public int getLife(){
        return life;
    }
    int rorient=0;
    int flag=0;
    int numberOfTimes=6;
    short frameChange=0;
    public void actionPerformed(ActionEvent e){
        if((Timer)e.getSource()==timer){
            if(rorient==1){   
            if(flag==0){
          setLocation(x+1, y);
          repaint();
          flag=1;
          }
          else if(flag==1){
              setLocation(x-1, y);
              repaint();
              flag=2;
          }
          else if(flag==2){
             setLocation(x-1, y);
             repaint();
              flag=0; 
          }
        }
            else{
                  if(flag==0){
          setLocation(x+1, y);
          repaint();
          flag=1;
          }
          else if(flag==1){
              setLocation(x-1, y);
              repaint();
              flag=2;
          }
          else if(flag==2){
             setLocation(x-1, y);
             repaint();
              flag=0; 
          }
            }
        }
        else if((Timer)e.getSource()==movement){
                if(moveValue==0){
               if(this.getX()>=obj.getWidth()){
                   moveValue=1;
                   
               }
               else{
                   if(this.enemyClass.equals("Drones"))
                   this.setLocation(x+=10,y);
                   else if(this.enemyClass.equals("Bombers"))
                        this.setLocation(x+=5,y);
                   else 
                         this.setLocation(x+=1,y);
               }
           }
           else{
                if(this.getX()<=0){
                   moveValue=0;
                   
               }
               else{
                   if(this.enemyClass.equals("Drones"))
                   this.setLocation(x-=10,y);
                   else if(this.enemyClass.equals("Bombers"))
                        this.setLocation(x-=5,y);
                   else 
                         this.setLocation(x-=1,y);
               }
           }
        }
        else if((Timer)e.getSource()==shield){
         shield.stop();
         CDP=0;
        setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/"+enemyClass+".png"))); 
        }
        else if((Timer)e.getSource()==damageInd){
          damageInd.stop();
          if(enemyClass.equalsIgnoreCase("Bombers"))
          setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/Bombers_1.png")));
          else if(enemyClass.equalsIgnoreCase("Drones"))
             setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/dd6.png")));
          else{
              setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/Juggernauts_1.png")));
          }
         flicker.start();
        CDPT.start();
        }
        else if((Timer)e.getSource()==deathClip){
            
             if(numberOfTimes<=0){
                 // System.out.println("5");
           deathClip.stop();
           setVisible(false);
          }else{
//            System.out.println("[Anim Clip]NumberOFtimes="+numberOfTimes);
            if(enemyClass.equalsIgnoreCase("Drones")){
                if(dbc==0);
                else if(dbc==1);
                else if(dbc==2){
                     ;
                }
                else{
                 //nuclear blast   
                }
          setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/dd"+numberOfTimes+".png")));
            
            }
            else if(enemyClass.equalsIgnoreCase("Bombers")){
                if(frameChange==0){
                    frameChange=1;
                 setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/Bombers_1.png")));
            }
                else if(frameChange==1){
                       frameChange=2;
                 setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/ddB.png")));
                }
                else{
                      if(dbc==0);
                else if(dbc==1);
                else if(dbc==2){
                     setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/rdb.png")));
                }
                else{
                    //nuclear blast
                }
          setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/dd"+numberOfTimes+".png")));
                    numberOfTimes--;
                    setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/dd"+numberOfTimes+".png")));
                }
            }
            else{
                  if(frameChange==0){
                    frameChange=1;
                 setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/Juggernauts_1.png")));
            }
                else if(frameChange==1){
                       frameChange=2;
                 setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/jdd.png")));
                }
                else{
                      if(dbc==0);
                else if(dbc==1);
                else if(dbc==2){
                     ;//Rocket blast
                }
                else{
                    //nuclear blast
                }
          setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/dd"+numberOfTimes+".png")));
                    numberOfTimes--;
                    setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/dd"+numberOfTimes+".png")));
                }
            }
          numberOfTimes--;
             }
        }
        else if((Timer)e.getSource()==shoot){
            if(rand.nextInt(100)>50){
                if(rand2.nextInt(100)<50){
       if(enemyClass.equalsIgnoreCase("Drones"))  { 
           
           if(rand.nextInt(100)>50){ 
               System.out.println("1");
       bullet=new Bullet(x+18,y,obj.heightOfPanel,obj.player,enemyClass,obj,timerSpeed,1);}
           else
               bullet=new Bullet(x+18,y,obj.heightOfPanel,obj.player,enemyClass,obj,timerSpeed,2);
            System.out.println("1");
           }
                }
            }
       else if(enemyClass.equals("Bombers")){
             System.out.println("15");
            bullet=new Bullet(x+10,y,obj.heightOfPanel,obj.player,enemyClass,obj,timerSpeed,1);
        obj.mainPanel.add(bullet);
    
       bullet.setVisible(true);
       bullet.start();   
                }
        
            else{
              bullet=new Bullet(x+10,y,obj.heightOfPanel,obj.player,enemyClass,obj,timerSpeed,1);
        obj.mainPanel.add(bullet);
      System.out.println("1");
       bullet.setVisible(true);
       bullet.start();    
            }
        }
         else if((Timer)e.getSource()==CDPT){
            if(flag2==0){
            CDPT.stop();
            flicker.stop();
            flag2=1;
            CDP=0;
            if(enemyClass.equalsIgnoreCase("Bombers"))
              setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/Bombers.png")));
            else if(enemyClass.equalsIgnoreCase("Drones")){
                 setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/Drones.png")));
            }
            else{
                 setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/Juggernauts.png")));
            }
        }
        }
          else if((Timer)e.getSource()==iA){
            iA.stop();
             setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/"+enemyClass+".png")));
        }
        else if((Timer)e.getSource()==flicker){
          System.out.println("4");
            if(flag2==0){
            if(flag==0){
                flag01=1;
                setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/dd0.png")));
                repaint();
               // obj.repaint();
            }
            else{
             flag01=0;
              if(enemyClass.equalsIgnoreCase("Bombers"))
              setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/Bombers.png")));
              else if(enemyClass.equalsIgnoreCase("Drones"))
                  setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/Drones.png"))); 
            else{
                 setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/Juggernauts.png"))); 
            }
              repaint();
              //obj.repaint();
            }
        }
        }
    }
      public void consecutiveDamageProtection(){
        CDP=1;
        flag2=0;
       damageInd.start();
      
    }
    public void damage(int bType){
        System.out.println("67");
        //System.out.println("78");
        if(enemyClass.equalsIgnoreCase("Drones")){
             System.out.println("5");
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
        else if(enemyClass.equalsIgnoreCase("Bombers")){
          if(bType==1){ 
              life=life-50;
              System.out.println("4");
          }
          else if(bType==2){
              life=0;
              System.out.println("4");
              
          }
          else if(bType==0){
           life=life-25;
          
          }
          else {
           life=0;  
            System.out.println("7");
          }
         if(life>0)
           consecutiveDamageProtection();
        }
        else{
             if(bType==1){ 
              life=life-25;
              System.out.println("4");
          }
          else if(bType==2){
              life=life-25;
              System.out.println("4");
             
          }
          else if(bType==0){
           life=life-25;
           System.out.println("4");
          }
          else {
           life=0;  
            System.out.println("7");
          }
         if(life>0)
           consecutiveDamageProtection();
        
        }
        dbc=bType;
         if(life<=0){
             if(enemyClass.equalsIgnoreCase("Drones")){
                   obj.setScore(100);
             }
             else if(enemyClass.equalsIgnoreCase("Bombers")){
                  obj.setScore(250);   
             }
             else{
                obj.setScore(300);   
             }
                this.die();
                
                 
            }
    }
    
    public void die(int a){
        shoot.stop();
        movement.stop();
    }
    public void die(){
    movement.stop();
        if(enemyClass.equalsIgnoreCase("Drones")){
         deathClip=new Timer(100, this);
         deathClip.start();
         shoot.stop();
         
         //Player.addScore(100);
        // obj.enemyDead(sr);   
      
     
     }
     else if(enemyClass.equalsIgnoreCase("Bombers")){
         deathClip=new Timer(100, this);
         deathClip.start();
         shoot.stop();
        
     }
     else{
        deathClip=new Timer(100, this);
         deathClip.start();
         shoot.stop(); 
     }
    if(rand.nextInt(2)==1){
     if(obj.player.getLife()<=25){
     item=new Item(4,obj.player,obj,x,y,enemyClass);
    
    }
     else if(obj.player.pBll<=2){
       item=new Item(1,obj.player,obj,x,y,enemyClass);
    
     }
     else if(obj.player.sBll==0){
          item=new Item(2,obj.player,obj,x,y,enemyClass);
     }
     else if(obj.player.nBll==0&&obj.level==3){
          item=new Item(3,obj.player,obj,x,y,enemyClass);
     }
     else {
         //shield
          item=new Item(5,obj.player,obj,x,y,enemyClass);
     }
     item.start();
     obj.mainPanel.add(item);
    }
     }
        
    }
  

