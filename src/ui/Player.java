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
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Michel Thomas
 */
public class Player extends javax.swing.JLabel implements ActionListener{
   private int x;
   private int y;
   private int life;
   private static int score=0;
   int pBll;
   int sBll;
   int nBll;
   int CDP=0;
   int numberOfTimes=5;
   Timer flicker;
   Timer CDPT;
   Timer deathClip;
   Timer damageInd;
   Timer iA;
   Timer shield;
   Timer fadinfo;
   Timer fadinfo2;
   main obj;
   int colorno=255;
   int frameChange=0;
    public Player(main obj) {
      
      setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/playerIcon.png")));
      life=100;
      score=0;
       CDPT=new Timer(2000,this);
        flicker=new Timer(100,this);
        iA=new Timer(200,this);//to show that items been acquired
        this.obj=obj;
        pBll=10;
        sBll=2;
        nBll=0;
        setFont(new java.awt.Font("OCR A EXTENDED", 3, 14));
        setForeground(Color.white);
        damageInd=new Timer(100,this);
        shield=new Timer(5000,this);
        
        fadinfo2=new Timer(100,this);
      
     
    }
    public void resetLife(){
        life=100;
    }
    public void acquireItem(int no){
         System.out.println("3");
          this.setSize(this.getWidth()+150,this.getHeight() );
//        System.out.println("Item no."+no+" acquired");
          if(no==1){
             //setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/ac.png")));
              pBll=pBll+5;
              obj.displayRemainingBullets(1, pBll);
              obj.bulletInd.stop();
              obj.pamm.setForeground(Color.white);
              
              this.setText("PLASMA x5");
             
              fadinfo2.start();
              if(fadinfo2.isRunning());
//                  System.out.println("fadinfo2 is  running");
             
                  }
        else if(no==2){
            // setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/mc.png")));
            sBll=sBll+1;
            
               obj.displayRemainingBullets(2, sBll);
                obj.bulletInd2.stop();
              obj.semm.setForeground(Color.white);
              this.setText("MISSILE x1");
               fadinfo2.start();
        }
        else if(no==3){
            // setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/nc.png")));
            nBll=nBll+1;
               obj.displayRemainingBullets(3, nBll);
                this.setText("NUKE x1");
                 fadinfo2.start();
        }
        else if(no==4){
            // setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/hc.png")));
            life=100;
            obj.setLife();
             setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/Recovering.png")));
            iA.start();
            this.setText("HEALTH x1");
             fadinfo2.start();
        }
        else {
           //  setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/sc.png")));
              CDP=1;
         setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/pp.png"))); 
            shield.start();
             this.setText("SHIELD x1");
              fadinfo2.start();
       
        }
    }
    public int getBullets(int i){
        if(i==1)
            return pBll;
        else if(i==2)
            return sBll;
        else 
            return nBll;
    }
    public static void addScore(int a){
        score=score+a;
        
    }
    int flag=0;
    int flag2=0;
    public void actionPerformed(ActionEvent evt){
       
        if((Timer)evt.getSource()==CDPT){
            if(flag2==0){
            CDPT.stop();
            flicker.stop();
            flag2=1;
            CDP=0;
              setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/playerIcon.png")));
        }
        }
        else if((Timer)evt.getSource()==shield){
         shield.stop();
         CDP=0;
         setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/playerIcon.png")));
        }
        else if((Timer)evt.getSource()==damageInd){
            damageInd.stop();
               setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/dp.png")));
        flicker.start();
        CDPT.start();
        }
        else if((Timer)evt.getSource()==iA){
            iA.stop();
             setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/playerIcon.png")));
        }
        
        else if((Timer)evt.getSource()==fadinfo2){
//            System.out.println("COLOR MODDED! CODE WORKING");
            if(colorno==0){
              colorno=255;
               setForeground(new Color(colorno,colorno,colorno));
               repaint();
           //   this.setSize(this.getWidth()-150,this.getHeight() );
               this.setText(null);
               fadinfo2.stop();
             
           }
           else {
               colorno-=15;
//               System.out.println("COLOR MODDED! CODE WORKING");
               setForeground(new Color(colorno,colorno,colorno));
               repaint();
               
           
       }
        }
        else if((Timer)evt.getSource()==flicker){if(flag2==0){
            if(flag==0){
                flag=1;
                setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/dd0.png")));
                repaint();
                obj.repaint();
            }
            else{
             flag=0;
              setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/playerIcon.png")));
              repaint();
              obj.repaint();
            }
        }
        }
        else{
            if(numberOfTimes<=0){
                 System.out.println("4");
           deathClip.stop();
           setVisible(false);
              obj.g.setColor(Color.red);
              obj.g.drawString("MISSION FAILED!", obj.widthOfPanel/2,obj.heightOfPanel/2 );
         int sx=(int)(Math.random()*obj.widthOfPanel+1),sy=0;
         for(int i=0;i<1000000;i++){
             sx=(int)(Math.random()*obj.widthOfPanel+1);
             sy=(int)(Math.random()*obj.heightOfPanel+1);
              obj.g.drawLine(sx,sy , sx+1, sy+1);
         }
         
           obj.showGameOver();
          }else{
                if(frameChange==0){
                    frameChange=1;
                 setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/dp.png")));
                  repaint();
            }
                else{
//            System.out.println("[Anim Clip]NumberOFtimes="+numberOfTimes);
          setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/dd"+(numberOfTimes==5?50:numberOfTimes)+".png")));
          repaint();
          numberOfTimes--;}
         } 
        }
         
    }
    public void consecutiveDamageProtection(){
        CDP=1;
        flag2=0;
       
     damageInd.start();
    }
    public int getXofPlayer(){
        return x;
    }
    public int getYofPlayer(){
        return y;
    }
    public static int getScore(){
     return score;   
    }
    public int getLife(){
        return life;
    }
    public void setCoordinates(int x,int y){
         setLocation(x,y);
       this.x=x;
       this.y=y;
    }
    
    public void setY(int y){
        setLocation(x,y);
    }
    
    public void damage(int bulletType){
        if(bulletType==0){
            life=life-25;
            //main.obj
           
            obj.setLife();
        }
        else if(bulletType==1){
            life=life-50;
             System.out.println("4");
             obj.setLife();
        }
        else{
            System.out.println("7");
            life=-1;
             obj.setLife();
        }
        
        if(life<0){
         obj.setLife();
         this.die();
        }
        else{
          consecutiveDamageProtection();   
        }
        if(life<50){
         obj.flashLifeBar(1);
        }
//        else if(life<50){
//         ;//life bar should flash   
//        }
    }
    
    private void die(){
     deathClip=new Timer(100, this);
     deathClip.start();
    }
}
