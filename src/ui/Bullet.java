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
	
	
//death count error occurs level finishes before all the enemies are shot
package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Michel Thomas
 */
public class Bullet extends JLabel implements ActionListener{
    int x;
    int y;
    int heightOfPanel;
    Timer playerToEnemy;
    Timer enemyToPlayer;
    int targetHit=0;
    int missed=0;
    String enemyClass;
    int blastRadius;
    Enemy enemies[];
    Player player;
    main obj;
    Timer BulletAnim;
    Timer nuclearShockWave;
    Timer nuclearSWT;
    int heightNSW=0;
    int widthNSW=0;
    int heightRSW=0;
    int widthRSW=0;
    Timer rocketShockWave;
    int BulletType;
    int flagB=0;
    int currentNo=0;
    Graphics g;
    public Bullet(int x,int y,int heightOfPanel,Enemy[] enemies,main obj,int BulletType,Player player,int timerSpeed){
       if(BulletType==0)
        setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/bullet.png")));
       else if(BulletType==1)
            setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/bullet.png")));
       else if(BulletType==2)
            setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/mc2.png")));
       else if(BulletType==3){
           setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/nm.png")));
           
       }
          this.x=x;
          this.y=y-10;
          this.obj=obj;
          this.heightOfPanel=heightOfPanel;
          this.enemies=enemies;
             playerToEnemy=new Timer(timerSpeed,this);  
        //  System.out.println("Enemy size "+enemies.length);
       this.BulletType=BulletType;
       this.player=player;
       BulletAnim=new Timer(50,this);
       nuclearShockWave=new Timer(25,this);
       rocketShockWave=new Timer(50,this);
       nuclearSWT=new Timer(11000,this);
    }
    public Bullet(int x,int y,int heightOfPanel,Player player,String enemyClass,main obj,int timerSpeed,int Btype){
setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/bullet.png")));
                if(enemyClass.equalsIgnoreCase("Drones")){
                    if(Btype==1){
        setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/bullet.png")));
        setSize(6,40);}
                    else{
                        setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/mc22.png")));
        setSize(10,21);
                    }
        }
        else if(enemyClass.equalsIgnoreCase("Bombers")){
             setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/bullet2.png")));
             setSize(12,15);
        }
           else if(enemyClass.equalsIgnoreCase("Juggernauts")){
             setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/nm2.png")));
             setSize(11,23);
        }
                  else if(enemyClass.equalsIgnoreCase("Boss")){
             setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/bs.png")));
             setSize(6,40);
        }
           
          this.x=x;
          this.y=y+30;
          this.obj=obj;
          this.heightOfPanel=heightOfPanel;
          this.player=player;
          this.enemyClass=enemyClass;
          enemyToPlayer=new Timer(timerSpeed,this);
       this.BulletType=Btype;
          
    }
    public void start(){
     if(enemyToPlayer==null){
        playerToEnemy.start();
        if(BulletType==2){
            BulletAnim.start();
        }
        else
            playerToEnemy.start();
     }
     else{
      enemyToPlayer.start();
     }
        
         
    }
    public void stop(int i){
        if(i==1){
           playerToEnemy.stop(); 
        }
        else{
             enemyToPlayer.stop(); 
        }
    }
    public void actionPerformed(ActionEvent evt){
      
           if((Timer)evt.getSource()==playerToEnemy){
            
            if(y<=0){
                 playerToEnemy.stop();
                 missed=1;
               targetHit=0;
             //    System.out.println("Missed!");
                 BulletAnim.stop();
                 setIcon(null);
                 repaint();
             }
             else {
                  for(int i=0;i<enemies.length;i++){
                         
              if(x<=enemies[i].x+40&&x>=enemies[i].x&&enemies[i].getLife()!=0){//if it doesnt work try x+40
               
                  if(y>=enemies[i].y&&y<=enemies[i].y+41){//here
                    if(targetHit!=1){
                        if(enemies[i].CDP==0){
                      playerToEnemy.stop();
                      targetHit=1;
                      missed=0;
                      if(BulletType==0)
                      enemies[i].damage(0);
                      else if(BulletType==1)
                         enemies[i].damage(1);
                      else if(BulletType==2){
                          rocketShockWave.start();
                          blastRadius=100;
                           enemies[i].damage(2);
                           currentNo=i;
                              for(int j=0;j<enemies.length;j++){
                                 //System.out.println ("RADIUS==="+Math.sqrt((Math.pow(enemies[j].getX()-this.getX(), 2))+(Math.pow(enemies[j].getY()-this.getY(),2))));
                                  if(Math.sqrt((Math.pow(enemies[j].getX()-this.getX(), 2))+(Math.pow(enemies[j].getY()-this.getY(),2)))<=blastRadius&&enemies[j].getLife()!=0&&j!=currentNo){
                                       enemies[j].damage(2);
                                  }
                              }
                      }
                      else {
                          nuclearSWT.start();
                           nuclearShockWave.start();
                            blastRadius=300;
                           enemies[i].damage(3);
                           currentNo=i;
                              for(int j=0;j<enemies.length;j++){
                               //  System.out.println ("RADIUS==="+Math.sqrt((Math.pow(enemies[j].getX()-this.getX(), 2))+(Math.pow(enemies[j].getY()-this.getY(),2))));
                                  if(Math.sqrt((Math.pow(enemies[j].getX()-this.getX(), 2))+(Math.pow(enemies[j].getY()-this.getY(),2)))<=blastRadius&&enemies[j].getLife()!=0&&j!=currentNo){
                                       enemies[j].damage(3);
                                  }
                              }
                           
                      }
                        int k=0;
      
                        if(obj.level<=3){
                        for(int j=0;j<25;j++){
             if(enemies[j].getLife()==0){
                 k++;
             }
                        }
                          if(k==25){
             //level complete
            
                 obj.levelInitializer(++obj.level);
             
           
                
           
         }
         }else{
                      for(int j=0;j<7;j++){
             if(enemies[j].getLife()==0){
                 k++;
             }
                        }
                          if(k==7){
             //level complete
            
                 obj.levelInitializer(++obj.level);
             
           
                
           
         }         
                        }
                        BulletAnim.stop();
                   //   System.out.println("Target at "+enemies[i].x+" "+enemies[i].y+" is hit!");
                  setIcon(null);
                 repaint();}
                        
                    }
                    }
              }
              //here
                   
          }
             }
            if(targetHit!=1&&missed==0){
                  if(x<=obj.ee.x+30&&x>=obj.ee.x&&obj.ee.life!=0||x>=obj.ee.x-30&&x<=obj.ee.x&&obj.ee.life!=0){
                      if(y>=obj.ee.y&&y<=obj.ee.y+49){
                           playerToEnemy.stop();
                      targetHit=1;
                      missed=0;
                          obj.ee.damage(BulletType);
                          BulletAnim.stop();
                          
//                      System.out.println("Enemy Equipment at "+obj.x+" "+obj.y+" is hit!");
                  setIcon(null);                 //PROBLEM WITH THE ENTIRE CODE BLOCK 
                                                  //ENEMIES DISAPPEAR DESTRUCTION ANIMATION OF COMMPOST BUG
                 repaint();}                       //MINOR BUGS
                       else{
            setLocation(x,y-=10);
            repaint(); }
                        }
                  else{
            setLocation(x,y-=10);
            repaint(); } }
             
        }
           else if((Timer)evt.getSource()==nuclearShockWave){
             
               
               this.g=obj.getGraphics();
               this.g.setColor(Color.white);
               this.g.drawOval(this.getX()-widthNSW/2, this.getY()-heightNSW/2, widthNSW+=25 ,heightNSW+=25 );
               if(widthNSW==blastRadius){
                   widthNSW=0;
                   heightNSW=0;
               }
                
           }
           else if((Timer)evt.getSource()==nuclearSWT){
               nuclearSWT.stop();
               nuclearShockWave.stop();
           }
           else if((Timer)evt.getSource()==rocketShockWave){
               this.g=obj.getGraphics();
               this.g.setColor(Color.white);
               this.g.drawOval(this.getX()-widthRSW/2, this.getY()-heightRSW/2, widthRSW+=25 ,heightRSW+=25 );
               if(widthRSW==blastRadius){
                   rocketShockWave.stop();
               }
           }
           else if((Timer)evt.getSource()==BulletAnim){
            if(flagB==0){ 
                setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/mc2.png")));
                flagB=1;
            }
            else if(flagB==1){
                setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/mc2#1.png")));
                flagB=2;
            }
            else{
                setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/mc2#3.png")));
                flagB=0;
                
            }
           }
        else {
         if(y>=heightOfPanel){   
               enemyToPlayer.stop();
                 missed=1;
//                 System.out.println("You escaped");
                 setIcon(null);
                 repaint();
         }
         else{
                if(x<=player.getXofPlayer()+40&&x>=player.getXofPlayer()&&!(player.getLife()<0)){
                     if(y>=player.getYofPlayer()&&y<=player.getYofPlayer()+41){
                      enemyToPlayer.stop();
                      targetHit=1;
//                      System.out.println("Your Hit!");
                 if(player.CDP==0){
                      if(enemyClass.equalsIgnoreCase("Drones")){
                      player.damage(BulletType-1);
                      }
                      else if(enemyClass.equalsIgnoreCase("Bombers")){
                         player.damage(BulletType);
                      }
                      else if(enemyClass.equalsIgnoreCase("Juggernauts")||enemyClass.equalsIgnoreCase("Juggernaut")) {
                          player.damage(BulletType+1);
                      }
                      else{
                           player.damage(BulletType-1);
                      }
                      
                 }
                 else{
                     ;
                 }
                   setIcon(null);
                 repaint();
                     }
                }
         }
           setLocation(x,y+=10);
            repaint();  
        }
    }
    
    
    
}
