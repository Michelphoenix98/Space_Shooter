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

//start from level completion message,once the first level completes get the next level ready
//convert the entire procedural style to Object Oriented Format the uidesigners,level completers
//this class should control the other objects

package ui;


import IO.Text.Saver;
import IO.Text.Loader;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Michel Thomas
 */
public class main extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form main
     */
    static int fps;
    int score=0;
    static main obj;
    Bullet bullet;
     Graphics g; 
     Timer timer;
     Timer timerForStartButton;
    Timer timerForTwinkler;
    Timer lifeBarFlasher;
        int plaX;
        int plaY;
    Player player;
    Enemy enemies[];
    public int heightOfPanel;
    public int widthOfPanel;
    int level;
   JLabel restart;
   Timer tlb;
    int startFlag=0;
    Timer dispCont;
    int lstate=1;
  JLabel disp;
  JLabel pamm;
  JLabel semm;
  JLabel numm;
  JLabel seperator; 
  JLabel scorDisp;
  JLabel ven[];
  Timer bulletInd;
  Timer bulletInd2;
  Timer stars;
  Timer musicPlayer;
  int no=0;
  int no2;
  int timerSpeed;
  int timerSpeed2;
  JLabel lb=new JLabel();
  Graphics g1;
  String invX;
  EnemyEquipment ee;
  int sx1,sy1,flagS;
  int sx11[],sy11[],c1[];
  int flagM=0;
  Ratio ratio;
  String cheatCode;
    public main() throws IOException {
       cheatCode="";
        initSett();
        level=1;
       int x,y;
       sx11=new int[250];
       sy11=new int[250];
       c1=new int[250];
       initComponents();
    
       Dimension dim= Toolkit.getDefaultToolkit().getScreenSize();
       int w=this.getSize().width;
       int h=this.getSize().height;
       ratio=new Ratio(w,h);
       ImageIcon im=new ImageIcon("Planet.png");
       Image i=im.getImage();
       this.setIconImage(i);
        x=(dim.width-w)/2;
        y=(dim.height-h)/2;
        JLabel j=new JLabel();
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 25));
          jLabel2.setFont(new java.awt.Font("Impact", 1, 105)); // NOI18N

jLabel2.setForeground(Color.green);

jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/Planet.png"))); // NOI18N

jLabel2.setText("Space Shooter 2D");
//System.out.println("getX()="+jLabel2.getX());
//System.out.println("getY()="+jLabel2.getY());
//System.out.println("simX="+ratio.getSimilarXcoordinate(jLabel2.getX()));
//System.out.println("simy="+ratio.getSimilarYcoordinate(jLabel2.getY()));
       mainPanel.add(jLabel2);
//       System.out.println("old Width="+jLabel2.getWidth());
//       
//       System.out.println("New Width="+(int)(Math.sqrt(Math.pow(ratio.getSimilarXcoordinate(jLabel2.getX()+jLabel2.getWidth())-ratio.getSimilarXcoordinate(jLabel2.getX()),2))));
//       
//       System.out.println("Old height="+jLabel2.getHeight());
//       System.out.println("New Height="+(int)(Math.sqrt(Math.pow(ratio.getSimilarYcoordinate(jLabel2.getY()+jLabel2.getHeight())-ratio.getSimilarYcoordinate(jLabel2.getY()),2))));
          jLabel2.setSize((int)(Math.sqrt(Math.pow(ratio.getSimilarXcoordinate(jLabel2.getX()+jLabel2.getWidth())-ratio.getSimilarXcoordinate(jLabel2.getX()),2))),(int)(Math.sqrt(Math.pow(ratio.getSimilarYcoordinate(jLabel2.getY()+jLabel2.getHeight())-ratio.getSimilarYcoordinate(jLabel2.getY()),2))));
       jLabel2.setLocation(ratio.getSimilarXcoordinate(jLabel2.getX()),ratio.getSimilarYcoordinate(jLabel2.getY()));
    
    jLabel2.setVisible(true);
       jLabel2.repaint();
       
       
       start.setFont(new java.awt.Font("Consolas", 1, 45)); // NOI18N

start.setForeground(new java.awt.Color(255, 255, 255));

start.setText("Press any button to start game");
     mainPanel.add(start);
     
     
    start.setSize((int)(Math.sqrt(Math.pow(ratio.getSimilarXcoordinate(start.getX()+start.getWidth())-ratio.getSimilarXcoordinate(start.getX()),2))),(int)(Math.sqrt(Math.pow(ratio.getSimilarYcoordinate(start.getY()+start.getHeight())-ratio.getSimilarYcoordinate(start.getY()),2))));
       start.setLocation(ratio.getSimilarXcoordinate(start.getX()),ratio.getSimilarYcoordinate(start.getY()));
    
    start.setVisible(true);
       start.repaint();  
     mainPanel.add(star5);
       
       star5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

star5.setForeground(new java.awt.Color(255, 255, 255));

star5.setText(".");

  star5.setSize((int)(Math.sqrt(Math.pow(ratio.getSimilarXcoordinate(star5.getX()+star5.getWidth())-ratio.getSimilarXcoordinate(star5.getX()),2))),(int)(Math.sqrt(Math.pow(ratio.getSimilarYcoordinate(star5.getY()+star5.getHeight())-ratio.getSimilarYcoordinate(star5.getY()),2))));
       star5.setLocation(ratio.getSimilarXcoordinate(star5.getX()),ratio.getSimilarYcoordinate(star5.getY()));
    
    star5.setVisible(true);
       star5.repaint();  
       mainPanel.add(star9);
       star9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

star9.setForeground(new java.awt.Color(255, 255, 255));

star9.setText(".");

  star9.setSize((int)(Math.sqrt(Math.pow(ratio.getSimilarXcoordinate(star9.getX()+star9.getWidth())-ratio.getSimilarXcoordinate(star9.getX()),2))),(int)(Math.sqrt(Math.pow(ratio.getSimilarYcoordinate(star9.getY()+star9.getHeight())-ratio.getSimilarYcoordinate(star9.getY()),2))));
       star9.setLocation(ratio.getSimilarXcoordinate(star9.getX()),ratio.getSimilarYcoordinate(star9.getY()));
    
    star9.setVisible(true);
       star9.repaint(); 
       
       mainPanel.add(star1);
       star1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

star1.setForeground(new java.awt.Color(255, 255, 255));

star1.setText(".");

star1.setSize((int)(Math.sqrt(Math.pow(ratio.getSimilarXcoordinate(star1.getX()+star1.getWidth())-ratio.getSimilarXcoordinate(star1.getX()),2))),(int)(Math.sqrt(Math.pow(ratio.getSimilarYcoordinate(star1.getY()+star1.getHeight())-ratio.getSimilarYcoordinate(star1.getY()),2))));
       star1.setLocation(ratio.getSimilarXcoordinate(star1.getX()),ratio.getSimilarYcoordinate(star1.getY()));
    
    star1.setVisible(true);
       star1.repaint(); 
       
       mainPanel.add(star12);
 star12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

star12.setForeground(new java.awt.Color(255, 255, 255));

star12.setText(".");

star12.setSize((int)(Math.sqrt(Math.pow(ratio.getSimilarXcoordinate(star12.getX()+star12.getWidth())-ratio.getSimilarXcoordinate(star12.getX()),2))),(int)(Math.sqrt(Math.pow(ratio.getSimilarYcoordinate(star12.getY()+star12.getHeight())-ratio.getSimilarYcoordinate(star12.getY()),2))));
       star12.setLocation(ratio.getSimilarXcoordinate(star12.getX()),ratio.getSimilarYcoordinate(star12.getY()));
    
    star12.setVisible(true);
       star12.repaint(); 
       
       mainPanel.add(star4);
       
       star4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

star4.setForeground(new java.awt.Color(255, 255, 255));

star4.setText(".");

star4.setSize((int)(Math.sqrt(Math.pow(ratio.getSimilarXcoordinate(star4.getX()+star4.getWidth())-ratio.getSimilarXcoordinate(star4.getX()),2))),(int)(Math.sqrt(Math.pow(ratio.getSimilarYcoordinate(star4.getY()+star4.getHeight())-ratio.getSimilarYcoordinate(star4.getY()),2))));
       star4.setLocation(ratio.getSimilarXcoordinate(star4.getX()),ratio.getSimilarYcoordinate(star4.getY()));
    
    star4.setVisible(true);
       star4.repaint(); 
      
       mainPanel.add(star2);
       
       star2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

star2.setForeground(new java.awt.Color(255, 255, 255));

star2.setText(".");

star2.setSize((int)(Math.sqrt(Math.pow(ratio.getSimilarXcoordinate(star2.getX()+star2.getWidth())-ratio.getSimilarXcoordinate(star2.getX()),2))),(int)(Math.sqrt(Math.pow(ratio.getSimilarYcoordinate(star2.getY()+star2.getHeight())-ratio.getSimilarYcoordinate(star2.getY()),2))));
       star2.setLocation(ratio.getSimilarXcoordinate(star2.getX()),ratio.getSimilarYcoordinate(star2.getY()));
    
    star2.setVisible(true);
       star2.repaint(); 

       mainPanel.add(jLabel12);
       jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/playerIcon.png")));
        jLabel12.setLocation(ratio.getSimilarXcoordinate(jLabel12.getX()),ratio.getSimilarYcoordinate(jLabel12.getY()));
    
    jLabel12.setVisible(true);
       jLabel12.repaint(); 
       // NOI18N
       
       
        this.getGraphicsConfiguration().getDevice().setFullScreenWindow(this);
        
        
       this.setLocation(x,y);
      heightOfPanel=mainPanel.getSize().height;
      widthOfPanel=mainPanel.getSize().width;
       plaX=(widthOfPanel)/2-20;
       this.x=plaX;
         plaY=(heightOfPanel-90);
       this.y=plaY;
      player=new Player(this);
      musicPlayer=new Timer(70000,this);
      //System.out.println( this.getGraphics().toString());
      g=mainPanel.getGraphics();
      timer=new Timer(3000,this);
      timerForStartButton=new Timer(100,this);
      timerForStartButton.start();
       lifeBarFlasher=new Timer(100,this);
       bulletInd=new Timer(100,this);
       bulletInd2=new Timer(100,this);
       stars=new Timer(20,this);
       tlb=new Timer(500,this);
       dispCont=new Timer(7000,this);
       int flagM=0;
     //  mainPanel.setSize(1366, 768);
     
    
       
//      timerForTwinkler=new Timer(100,new Twinkler());
//      timerForTwinkler.start();
    }
    public void initSett() throws IOException{
        //problems with loader not able to load the values from config.ini or config.txt
        //fidget in the enemy class was x-1 and x+1 its now x+4 and x-4 change it back
        File file=new File("c:/users/"+System.getProperty("user.name").toString()+"/SS2D");
        if(file.exists()){
            
            ;
        }
        else 
            file.mkdir();
      Loader loader=new Loader();
      String[] data=new String[3];
      Saver save=new Saver("c:/users/"+System.getProperty("user.name").toString()+"/SS2D/Config.ini");
        try {
            data=loader.loadStringArray("c:/users/"+System.getProperty("user.name").toString()+"/SS2D/Config.ini");
            
            
            
          timerSpeed=Integer.parseInt(data[0].substring(7));
//          System.out.println("timerSpeed2="+data[1]);
          timerSpeed2= Integer.parseInt(data[1].substring(7));     
          invX=(data[2].substring(15));  
            
        } catch (FileNotFoundException ex) {
//            System.out.println("Config.ini file is missing");
//              System.out.println("Creating Config.ini...");
              data[0]="Timer1 10";
              data[1]="Timer2 10";
              data[2]="Invert X-axis false";
              save.save(data,false);
              timerSpeed=10;
              timerSpeed2=10;
              invX="false";
        }
      
    }
    public void setScore(int a){
        score=score+a;
        scorDisp.setText("SCORE "+score);
    }
   public void setLife(){
      
       disp.setText("LIFE "+player.getLife());
       if(player.getLife()==100){
        lifeBarFlasher.stop();
       }
       disp.setForeground(Color.green);
       
   }
   public void displayRemainingBullets(int category,int nOB){
   if(category==1)
       pamm.setText("-"+nOB);
   else if(category==2)
       semm.setText("-"+nOB);
   
   else
       numm.setText("-"+nOB);
       }
   public void flashLifeBar(int opt){
       
       if(opt==1){
           lifeBarFlasher.start();
       }
       else{
           lifeBarFlasher.stop();
       }
   }
   public void showGameOver(){
       System.out.println("11");
       System.out.println("78");
       System.out.println("1314");
       System.out.println("1314");
       System.out.println("1314");
       System.out.println("1314");
       System.out.println("1314");
       System.out.println("1314");
       System.out.println("1314");
       mainPanel.removeAll();
        mainPanel.repaint();
        startFlag=0;
        level=1;
        lifeBarFlasher.stop();
        player.pBll=10;
        player.sBll=2;
        player.nBll=0;
        for(int k=0;k<enemies.length;k++){
         enemies[k].die(1);
        }
        player.resetLife();
       start =new JLabel();
       start.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 50));
       start.setForeground(new java.awt.Color(255, 255, 255));
       int x=(widthOfPanel-575)/2;
        int y=(heightOfPanel-100);
        mainPanel.add(start);
        start.setLocation(x, y); 
        start.setVisible(true);
        start.setText("Press any button to continue");
        start.setSize(800, 53);
         JLabel disp=new JLabel();//[363, 53]
        disp.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 100));
        disp.setForeground(new java.awt.Color(255, 255, 255));
        disp.setText("GAME OVER");
        disp.setSize(600, 100);
        x=(widthOfPanel-550)/2;
        y=(heightOfPanel-70)/2;
        mainPanel.add(disp);
        disp.setLocation(x, y); 
        disp.setVisible(true);
        mainPanel.repaint();
        timerForStartButton.start();
   }
   
    @Override
   public void repaint(){
       ;
   }
    private void arrangeEnemies(){
        int x=0,y=0,i=0;
//        System.out.println("Height of panel="+heightOfPanel);
//        System.out.println("Width of panel="+widthOfPanel);
        if(level==1){ Random rand=new Random(heightOfPanel);
        Random rand2=new Random(widthOfPanel);
            enemies=new Enemy[25];
            while(i<25){
            // seperator.setLocation(0, heightOfPanel-60);
            while(true){
         
             y=Math.abs(rand.nextInt(heightOfPanel));
            if(y>=heightOfPanel||y<=0||y>heightOfPanel-200){
                ;
            }
            else {
             break;   
            }
            }
            while(true){
           
             x=Math.abs(rand2.nextInt(widthOfPanel));
            if(y>=widthOfPanel||y<=0){
                ;
            }
            else {
             break;   
            }
            }
           
             enemies[i]=new Enemy("Drones",x,y,this,i,timerSpeed);
             i++;
            }
             
         
            ee=new EnemyEquipment(1,enemies,widthOfPanel/2-200,heightOfPanel/2-150,this);
            ee.setLocation(widthOfPanel/2-200, heightOfPanel/2-150);
            
            displayEnemies();
        }
        else if(level==2){
            Random enemyRandomizer=new Random();
            Random rand=new Random(heightOfPanel);
        Random rand2=new Random(widthOfPanel);
            enemies=new Enemy[25];
            while(i<25){
            // seperator.setLocation(0, heightOfPanel-60);
            while(true){
         
             y=Math.abs(rand.nextInt(heightOfPanel));
            if(y>=heightOfPanel||y<=0||y>heightOfPanel-200){
                ;
            }
            else {
             break;   
            }
            }
            while(true){
           
             x=Math.abs(rand2.nextInt(widthOfPanel));
            if(y>=widthOfPanel||y<=0){
                ;
            }
            else {
             break;   
            }
            }
            
             if(enemyRandomizer.nextInt(3)==2)       
             enemies[i]=new Enemy("Drones",x,y,this,i,timerSpeed);
             else
             enemies[i]=new Enemy("Bombers",x,y,this,i,timerSpeed);    
             i++;
            }
               ee=new EnemyEquipment(1,enemies,widthOfPanel/2-200,heightOfPanel/2-150,this);
            ee.setLocation(widthOfPanel/2-200, heightOfPanel/2-150);
            displayEnemies();
        }
        else if(level==3){
             Random rand=new Random(heightOfPanel);
        Random rand2=new Random(widthOfPanel);
            enemies=new Enemy[25];
            while(i<25){
            // seperator.setLocation(0, heightOfPanel-60);
            while(true){
         
             y=Math.abs(rand.nextInt(heightOfPanel));
            if(y>=heightOfPanel||y<=0||y>heightOfPanel-200){
                ;
            }
            else {
             break;   
            }
            }
            while(true){
           
             x=Math.abs(rand2.nextInt(widthOfPanel));
            if(y>=widthOfPanel||y<=0){
                ;
            }
            else {
             break;   
            }
            }
            
             if((int)(Math.random()*3+1)==2)       
             enemies[i]=new Enemy("Drones",x,y,this,i,timerSpeed);
             else if((int)(Math.random()*4+1)==3||(int)(Math.random()*4+1)==4)
                  enemies[i]=new Enemy("Juggernauts",x,y,this,i,timerSpeed);   
                 else
             enemies[i]=new Enemy("Bombers",x,y,this,i,timerSpeed);   
             
             i++;
            }
               ee=new EnemyEquipment(1,enemies,widthOfPanel/2-200,heightOfPanel/2-150,this);
            ee.setLocation(widthOfPanel/2-200, heightOfPanel/2-150);
            displayEnemies();
        }
        else{
               Boss boss=new Boss(this);
            mainPanel.add(boss);
          boss.setSize(355,114);
          boss.setLocation((this.getWidth()-boss.getWidth())/2,(this.getHeight()-boss.getHeight())/2);
          boss.setVisible(true);
            boss.start();
            Random rand=new Random(heightOfPanel);
        Random rand2=new Random(widthOfPanel);
            enemies=new Enemy[7];
            while(i<7){
            // seperator.setLocation(0, heightOfPanel-60);
            while(true){
         
             y=Math.abs(rand.nextInt(heightOfPanel));
            if(y>=heightOfPanel||y<=0||y>heightOfPanel-200||(y<=boss.getY()+boss.getHeight()&&(y+41)>=boss.getY())){
                ;
            }
            else {
             break;   
            }
            }
            while(true){
           
             x=Math.abs(rand2.nextInt(widthOfPanel));
            if(y>=widthOfPanel||y<=0){
                ;
            }
            else {
             break;   
            }
            }
            
             if((int)(Math.random()*3+1)==2)       
             enemies[i]=new Enemy("Drones",x,y,this,i,timerSpeed);
             else if((int)(Math.random()*4+1)==3||(int)(Math.random()*4+1)==4)
                  enemies[i]=new Enemy("Juggernauts",x,y,this,i,timerSpeed);   
                 else
             enemies[i]=new Enemy("Bombers",x,y,this,i,timerSpeed);   
             
             i++;
            }
               ee=new EnemyEquipment(1,enemies,widthOfPanel/2-200,heightOfPanel/2-150,this);
            ee.setLocation(widthOfPanel/2-200, heightOfPanel/2-150);
            displayEnemies();
         
        }
    }
    private void displayEnemies(){
      int noE=enemies.length;
      //ven=new JLabel[noE];
      
      for(int i=0;i<noE;i++){
          enemies[i].setSize(40, 41);
          mainPanel.add(enemies[i]);
          enemies[i].setLocation(enemies[i].x, enemies[i].y);
          enemies[i].setVisible(true);
          enemies[i].start();
      }
      mainPanel.add(ee);
      ee.setVisible(true);
      ee.setSize(30,49);
      ee.start();
    }
    int enemyDead=0;
//    public void enemyDead(int srn){
//        enemyDead++;
//      
//        if(level==1){
//         if(enemyDead==6){
//             levelInitializer(2);
//         }   
//        }
//        else if(level==2){
//            
//        }
//        else{
//            
//        }
//    }
    public void levelInitializer(int i){
         System.out.println("1314"); 
        System.out.println("9");
         musicPlayer.stop();
        if(i==1){
        mainPanel.removeAll();
        mainPanel.repaint();
        System.out.println("10");
        JLabel disp=new JLabel();//[363, 53]
        disp.setFont(new java.awt.Font("Consolas", 3, 48));
        disp.setForeground(Color.green);
        disp.setText("Level "+i);
        disp.setSize(363, 53);
        int x=(widthOfPanel-170)/2;
        int y=(heightOfPanel-70)/2;
        mainPanel.add(disp);
        disp.setLocation(x, y); 
        disp.setVisible(true);
        mainPanel.repaint();
        startFlag=1;
       
        timer.start();   
        }
        else if(i==2){
            System.out.println("12");
            System.out.println("23");
            System.out.println("34");
            System.out.println("45");
            System.out.println("56");
             System.out.println("10");
             System.out.println("78");
        mainPanel.removeAll();
        mainPanel.repaint();
        flagS=0;
         JLabel disp1=new JLabel();//[363, 53]
        disp1.setFont(new java.awt.Font("Consolas", 3, 35));
       
        disp1.setForeground(Color.green);
        
        disp1.setText("Level "+(i-1)+" Completed");
        disp1.setSize(473, 53);
          int x=(widthOfPanel-350)/2;
        int y=(heightOfPanel-70)/2;
        mainPanel.add(disp1);
        disp1.setLocation(x, y); 
        disp1.setVisible(true);
        mainPanel.repaint();
        startFlag=1;
       //level=2;
        timer.start(); 
        
        }
        
        else {
            System.out.println("12");
            System.out.println("23");
            System.out.println("34");
            System.out.println("45");
            System.out.println("56");
             System.out.println("10");
             System.out.println("78");
            mainPanel.removeAll();
        mainPanel.repaint();
        flagS=0;
         JLabel disp1=new JLabel();//[363, 53]
        disp1.setFont(new java.awt.Font("Consolas", 3, 35));
       
        disp1.setForeground(Color.green);
        System.out.println("10");
        disp1.setText("Level "+(i-1)+" Completed");
        disp1.setSize(473, 53);
          int x=(widthOfPanel-350)/2;
        int y=(heightOfPanel-70)/2;
        mainPanel.add(disp1);
        disp1.setLocation(x, y); 
        disp1.setVisible(true);
        mainPanel.repaint();
        startFlag=1;
       //level++;
        timer.start(); 
           
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        start = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        star5 = new javax.swing.JLabel();
        star9 = new javax.swing.JLabel();
        star1 = new javax.swing.JLabel();
        star12 = new javax.swing.JLabel();
        star4 = new javax.swing.JLabel();
        star2 = new javax.swing.JLabel();
        star6 = new javax.swing.JLabel();
        star8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        star3 = new javax.swing.JLabel();
        star11 = new javax.swing.JLabel();
        star7 = new javax.swing.JLabel();
        star10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Space Shooter 2D");
        setUndecorated(true);
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        mainPanel.setBackground(new java.awt.Color(0,0,0)/*4, 48, 114*/);
        mainPanel.setDoubleBuffered(false);

        start.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        start.setForeground(new java.awt.Color(255, 255, 255));
        start.setText("Press any button to start game");

        jLabel2.setFont(new java.awt.Font("Impact", 1, 36)); // NOI18N
        jLabel2.setForeground(Color.green);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/Planet.png"))); // NOI18N
        jLabel2.setText("Space Shooter 2D");

        star5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        star5.setForeground(new java.awt.Color(255, 255, 255));
        star5.setText(".");

        star9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        star9.setForeground(new java.awt.Color(255, 255, 255));
        star9.setText(".");

        star1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        star1.setForeground(new java.awt.Color(255, 255, 255));
        star1.setText(".");

        star12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        star12.setForeground(new java.awt.Color(255, 255, 255));
        star12.setText(".");

        star4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        star4.setForeground(new java.awt.Color(255, 255, 255));
        star4.setText(".");

        star2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        star2.setForeground(new java.awt.Color(255, 255, 255));
        star2.setText(".");

        star6.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        star6.setForeground(new java.awt.Color(255, 255, 255));
        star6.setText(".");

        star8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        star8.setForeground(new java.awt.Color(255, 255, 255));
        star8.setText(".");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/playerIcon.png"))); // NOI18N

        star3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        star3.setForeground(new java.awt.Color(255, 255, 255));
        star3.setText(".");

        star11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        star11.setForeground(new java.awt.Color(255, 255, 255));
        star11.setText(".");

        star7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        star7.setForeground(new java.awt.Color(255, 255, 255));
        star7.setText(".");

        star10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        star10.setForeground(new java.awt.Color(255, 255, 255));
        star10.setText(".");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(Color.green);
        jLabel1.setText(" Copyright (C) 2015  Michel Thomas   ");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/Bombers.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/Drones.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/Drones.png"))); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(star3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(star1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(star2)
                        .addGap(56, 56, 56))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(star10)
                        .addGap(62, 62, 62)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(star9)
                        .addGap(141, 141, 141)
                        .addComponent(jLabel3)
                        .addGap(37, 37, 37)))
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(star5)
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(star8)
                        .addGap(40, 40, 40)
                        .addComponent(star7)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(star11)
                        .addGap(193, 193, 193)
                        .addComponent(jLabel12)
                        .addGap(252, 252, 252))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(star6)
                        .addGap(20, 20, 20))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(star12)
                        .addGap(244, 244, 244)
                        .addComponent(star4))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(start)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(star8)
                            .addComponent(star7)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(star10)
                            .addComponent(star9)))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel5)))
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(star5))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(star1)
                                    .addComponent(star3)))
                            .addComponent(star2)
                            .addComponent(jLabel4))
                        .addGap(15, 15, 15))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(star6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(star4)
                        .addGap(35, 35, 35)
                        .addComponent(star11)
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(star12)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
  
        if(startFlag==0){   
       timerForStartButton.stop();
        System.out.println("1011");
      
      // timerForTwinkler.stop();
     // levelInitializer(1);
       mainPanel.removeAll();
        mainPanel.repaint();
      System.out.println("1");
       JLabel Head=new JLabel();
      
       mainPanel.add(Head);
       Head.setFont(new java.awt.Font("Consolas", 3, 60));
       
        Head.setForeground(Color.green);
        
        Head.setText("Controls");
        Head.setSize(473, 53);
         Head.setLocation(150, 10);
        //mainPanel.add(Head);
          Head.setLocation(ratio.getSimilarXcoordinate(Head.getX()),ratio.getSimilarYcoordinate(Head.getY()));
      
        JLabel shoot1=new JLabel();
        mainPanel.add(shoot1);
        shoot1.setSize((int)(Math.sqrt(Math.pow(ratio.getSimilarXcoordinate(shoot1.getX()+shoot1.getWidth())-ratio.getSimilarXcoordinate(shoot1.getX()),2))),(int)(Math.sqrt(Math.pow(ratio.getSimilarYcoordinate(shoot1.getY()+shoot1.getHeight())-ratio.getSimilarYcoordinate(shoot1.getY()),2))));
        shoot1.setText("(Primary weapon)Shoot [SPACE]");
        shoot1.setSize(473, 53);
        shoot1.setFont(new java.awt.Font("Consolas", 3, 25));
         shoot1.setLocation(10,60 );
          shoot1.setLocation(ratio.getSimilarXcoordinate(shoot1.getX()),ratio.getSimilarYcoordinate(shoot1.getY()));
       
        shoot1.setForeground(Color.green);
        
        JLabel move=new JLabel();
        mainPanel.add(move);
        move.setSize((int)(Math.sqrt(Math.pow(ratio.getSimilarXcoordinate(move.getX()+move.getWidth())-ratio.getSimilarXcoordinate(move.getX()),2))),(int)(Math.sqrt(Math.pow(ratio.getSimilarYcoordinate(move.getY()+move.getHeight())-ratio.getSimilarYcoordinate(move.getY()),2))));
        move.setText("Move [<] [>] or drag mouse ");
         move.setSize(473, 53);
          move.setFont(new java.awt.Font("Consolas", 3, 25));
       
        move.setForeground(Color.green);
          move.setLocation(10,240);
          move.setLocation(ratio.getSimilarXcoordinate(move.getX()),ratio.getSimilarYcoordinate(move.getY()));
        JLabel shoot2=new JLabel();
        mainPanel.add(shoot2);
        shoot2.setSize((int)(Math.sqrt(Math.pow(ratio.getSimilarXcoordinate(shoot2.getX()+shoot2.getWidth())-ratio.getSimilarXcoordinate(shoot2.getX()),2))),(int)(Math.sqrt(Math.pow(ratio.getSimilarYcoordinate(shoot2.getY()+shoot2.getHeight())-ratio.getSimilarYcoordinate(shoot2.getY()),2))));
        shoot2.setText("(Secondary weapon)Shoot [S]");
         shoot2.setSize(473, 53);
          shoot2.setFont(new java.awt.Font("Consolas", 3, 25));
       
        shoot2.setForeground(Color.green);
           shoot2.setLocation(10, 120);
              shoot2.setLocation(ratio.getSimilarXcoordinate(shoot2.getX()),ratio.getSimilarYcoordinate(shoot2.getY()));
           
        JLabel shoot3=new JLabel();
        mainPanel.add(shoot3);
        shoot3.setSize((int)(Math.sqrt(Math.pow(ratio.getSimilarXcoordinate(shoot3.getX()+shoot3.getWidth())-ratio.getSimilarXcoordinate(shoot3.getX()),2))),(int)(Math.sqrt(Math.pow(ratio.getSimilarYcoordinate(shoot3.getY()+shoot3.getHeight())-ratio.getSimilarYcoordinate(shoot3.getY()),2))));
         shoot3.setText("(Tertiary weapon)Shoot [N]");
         shoot3.setSize(473, 53);
          shoot3.setFont(new java.awt.Font("Consolas", 3, 25));
       
        shoot3.setForeground(Color.green);
        
          shoot3.setLocation(10, 180);
          shoot3.setLocation(ratio.getSimilarXcoordinate(shoot3.getX()),ratio.getSimilarYcoordinate(shoot3.getY()));
        mainPanel.add(lb);
          lb.setText("Loading ");
         
         lb.setSize(473, 53);
         lb.setFont(new java.awt.Font("Consolas", 1, 50));
       
        lb.setForeground(Color.green);
        
         lb.setLocation(340,290);
       
        lb.setLocation(ratio.getSimilarXcoordinate(lb.getX()),ratio.getSimilarYcoordinate(lb.getY()));
       
     
      
      
       
        tlb.start();
      dispCont.start();
         
      
       
   }
        else if(evt.getKeyChar()=='n'||evt.getKeyChar()=='N'){
            
           System.out.println("6");  
            if(player.nBll>0){ bullet=new Bullet(x+18,y,heightOfPanel,enemies,this,3,player,timerSpeed);
       bullet.setSize(11, 23);
       mainPanel.add(bullet);
       bullet.setVisible(true);
       bullet.start();
     
                 obj.displayRemainingBullets(3,--player.nBll) ;
               
      }
        }
        else if(evt.isShiftDown()){
            cheatCode=cheatCode+evt.getKeyChar();
            
            switch(cheatCode){
                case "d":
                case "D":
                    cheatCode="";
                    player.damage(3);
                    break;
                case "ED":
                case "ed":
                    for(int i=0;i<enemies.length;i++){
                        enemies[i].damage(3);
                      
                    }
                    ee.damage(3);
                     System.out.println("1314");
                      obj.levelInitializer(++obj.level);
                        cheatCode="";
                    break;
                    
                case "P":
                case "p":
                    player.acquireItem(1);
                    cheatCode="";
                    break;
                case "M":
                case "m":
                    player.acquireItem(2);
                    cheatCode=""; 
                    break;
                case "A":
                case "a":
                      player.acquireItem(3);
                    cheatCode=""; 
                    break;
                case "H":
                case "h":
                      player.acquireItem(4);
                    cheatCode=""; 
                    break;
                case "S":
                case "s":
                      player.acquireItem(5);
                    cheatCode=""; 
                    break;
                    
                                        
            }
        }
            else if(evt.getKeyChar()=='b'){
                cheatCode="";
            
        }
        else if(evt.getKeyChar()=='s'||evt.getKeyChar()=='S'){
              if(player.sBll>0){
               System.out.println("6");  
       bullet=new Bullet(x+18,y,heightOfPanel,enemies,this,2,player,timerSpeed);
       bullet.setSize(10, 32);
       mainPanel.add(bullet);
       bullet.setVisible(true);
       bullet.start();
     
                 obj.displayRemainingBullets(2,--player.sBll) ;
                 if(player.sBll<=0){
                     bulletInd2.start();
                 }
                  
                 
      }
    
        }
   else if(evt.getExtendedKeyCode()==0){
      if(player.pBll>0){ 
          System.out.println("1");
          bullet=new Bullet(x+18,y,heightOfPanel,enemies,this,1,player,timerSpeed);
       bullet.setSize(5, 29);
       mainPanel.add(bullet);
       bullet.setVisible(true);
       bullet.start();
     
                 obj.displayRemainingBullets(1,--player.pBll) ;
                 if(player.pBll<=0){
                     bulletInd.start();
                 }
      }
      else {
          //mini bullet
           System.out.println("2");
       bullet=new Bullet(x+18,y,heightOfPanel,enemies,this,0,player,timerSpeed);
       bullet.setSize(5, 10);
       mainPanel.add(bullet);
       bullet.setVisible(true);
       bullet.start();
      }
   }
//   System.out.println("Key code for 's' Rockets="+evt.getKeyCode());
    }//GEN-LAST:event_formKeyTyped
    
//    public void levelCompletionMessage(){
//         mainPanel.removeAll();
//        mainPanel.repaint();
//       level++;
//        JLabel disp=new JLabel();//[363, 53]
//        disp.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 48));
//        disp.setForeground(new java.awt.Color(255, 255, 255));
//        disp.setText("Level "+level);
//        disp.setSize(363, 53);
//        int x=(widthOfPanel-170)/2;
//        int y=(heightOfPanel-70)/2;
//        mainPanel.add(disp);
//        disp.setLocation(x, y); 
//        disp.setVisible(true);
//        mainPanel.repaint();
//        
//       
//        timer.start();
//      
//    }
    
    
    int x=plaX;
         int y=plaY;
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
         
//         System.out.println(x);
//         System.out.println(y);
      //  System.out.println("Key code for esc="+evt.getKeyCode());
       if(evt.getExtendedKeyCode()==39){
         if(x>=this.getWidth()){
             x=-30;
             player.setCoordinates(x,y);
                 mainPanel.repaint();
         }
         
         else{
           player.setCoordinates(x+=10,y);//uid.disp.setLocation(x=x+5,y);
           mainPanel.repaint();
         }
           
       }
       else if(evt.getKeyCode()==27){
           System.exit(0);
       }
       else if(evt.getExtendedKeyCode()==37){
        
       if(x<=-31){
           x=this.getWidth()-1;
             player.setCoordinates(x, y);// uid.disp.setLocation(x=x-5,y);
           mainPanel.repaint();
       }
       else{  player.setCoordinates(x-=10, y);// uid.disp.setLocation(x=x-5,y);
           mainPanel.repaint();
       }  
       }
    }//GEN-LAST:event_formKeyPressed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
  
       player.setCoordinates(x=evt.getX(), y);
        player.repaint();
    }//GEN-LAST:event_formMouseMoved

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
//       bullet=new Bullet(x+18,y,heightOfPanel,enemies,this,1,player);
//       bullet.setSize(5, 29);
//       mainPanel.add(bullet);
//       bullet.setVisible(true);
//       bullet.start();
        if(player.pBll>0){ 
             System.out.println("1");
            bullet=new Bullet(x+18,y,heightOfPanel,enemies,this,1,player,timerSpeed);
       bullet.setSize(5, 29);
       mainPanel.add(bullet);
       bullet.setVisible(true);
       bullet.start();
     
                 obj.displayRemainingBullets(1,--player.pBll) ;
                 if(player.pBll<=0){
                     bulletInd.start();
                 }
      }
      else {
          //mini bullet
             System.out.println("2");
       bullet=new Bullet(x+18,y,heightOfPanel,enemies,this,0,player,timerSpeed);
       bullet.setSize(5, 10);
       mainPanel.add(bullet);
       bullet.setVisible(true);
       bullet.start();
      }
    }//GEN-LAST:event_formMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    obj=new main();
                } catch (IOException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }
                obj.setVisible(true);
                System.out.println("8");
               obj. musicPlayer.start();
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JPanel mainPanel;
    private javax.swing.JLabel star1;
    private javax.swing.JLabel star10;
    private javax.swing.JLabel star11;
    private javax.swing.JLabel star12;
    private javax.swing.JLabel star2;
    private javax.swing.JLabel star3;
    private javax.swing.JLabel star4;
    private javax.swing.JLabel star5;
    private javax.swing.JLabel star6;
    private javax.swing.JLabel star7;
    private javax.swing.JLabel star8;
    private javax.swing.JLabel star9;
    private javax.swing.JLabel start;
    // End of variables declaration//GEN-END:variables

  int colorno=255;
    public void actionPerformed(ActionEvent evt) {
       if((Timer)evt.getSource()==timerForStartButton){
            if(colorno==0){
               colorno=255;
               start.setForeground(new Color(colorno,colorno,colorno));
               start.repaint();
             
           }
           else {
               colorno-=15;
               start.setForeground(new Color(colorno,colorno,colorno));
               start.repaint();
               
           
       }
      
       }
       else if((Timer)evt.getSource()==musicPlayer){
           System.out.println("9");
           System.out.println("8");
       }
       else if((Timer)evt.getSource()==tlb){
           if(lstate==0){
                lb.setText("Loading ");
            lb.repaint();
            lstate=1;
               
           }
       else if(lstate==1){   
            lb.setText("Loading .");
            lb.repaint();
            lstate=2;
        }
        else if(lstate==2){
            lb.setText("Loading ..");
            lb.repaint();
            lstate=3;
        }
        else{
            lb.setText("Loading ...");
            lb.repaint();
            lstate=0;
            
        }
       }
       else if((Timer)evt.getSource()==dispCont){
           dispCont.stop();
           tlb.stop();
           levelInitializer(1);
           
       }
       else if((Timer)evt.getSource()==lifeBarFlasher){
         
              if(colorno==0){
               colorno=255;
              disp.setForeground(new Color(colorno,colorno,colorno));
             disp.repaint();
           }
           else {
               colorno-=15;
                  disp.setForeground(new Color(colorno,colorno,colorno));
                  disp.repaint();
               
           
       }
       }
       else if((Timer)evt.getSource()==bulletInd2){
             if(colorno==0){
               colorno=255;
              semm.setForeground(new Color(colorno,colorno,colorno));
             semm.repaint();
           }
           else {
               colorno-=15;
                  semm.setForeground(new Color(colorno,colorno,colorno));
                  semm.repaint();
               
           
       }
           
       }
       else if((Timer)evt.getSource()==stars){
           int n=0;
           if(flagS==0){
               sx1=(int)(Math.random()*obj.widthOfPanel+1);sy1=0;
         for(int i=0;i<250;i++){
               int c=(int)(Math.random()*4+1);
               switch(c){
                   case 1:
                       g.setColor(Color.red);
                       break;
                   case 2:
                       g.setColor(Color.blue);
                       break; 
                   case 3:
                        g.setColor(Color.white);
                       break;
                   case 4:
                        g.setColor(Color.green);
                       break;
               }
             sx1=(int)(Math.random()*obj.widthOfPanel+1);
             sy1=(int)(Math.random()*obj.heightOfPanel+1);
             flagS=1;
             sx11[i]=sx1;
             sy11[i]=sy1;
             c1[i]=c;
             n++;
         }
         no=n;
        no2=no;
       } else{
               JLabel jl=new JLabel();
              
               switch(c1[no2-1]){
                   case 1:
                       g.setColor(Color.red);
                        jl.setForeground(Color.red);
                       break;
                   case 2:
                       g.setColor(Color.blue);
                        jl.setForeground(Color.blue);
                       break; 
                   case 3:
                        g.setColor(Color.white);
                         jl.setForeground(Color.white);
                       break;
                   case 4:
                        g.setColor(Color.green);
                         jl.setForeground(Color.green);
                       break;
                   default :
                       jl.setForeground(Color.white);
               }
            //to draw
               
             if((int)(Math.random()*3)==2||(int)(Math.random()*3)==1){
               jl.setText(".");
               if((int)(Math.random()*3+1)==1)
               jl.setFont(new java.awt.Font("verdana",3,5));
               else if((int)(Math.random()*3+1)==2)
                   jl.setFont(new java.awt.Font("verdana",3,2));
               else
                   jl.setFont(new java.awt.Font("verdana",3,10));}
             else
             {
                 if(flagM<=1){
                     flagM++; 
                     if(flagM==0)
                     jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/p2.png")));
                     else
                          jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/p1.png")));
                 }
            
                 
              else{
                     jl.setText(".");
               if((int)(Math.random()*3+1)==1)
               jl.setFont(new java.awt.Font("verdana",3,5));
               else if((int)(Math.random()*3+1)==2)
                   jl.setFont(new java.awt.Font("verdana",3,2));
               else
                   jl.setFont(new java.awt.Font("verdana",3,10));}
                 
                     
             }
            // System.out.println("Dep...");
               mainPanel.add(jl);
                 jl.setLocation(sx11[no2-1], sy11[no2-1]);
               jl.setVisible(true);
               jl.setSize(100,100);
               jl.repaint();
              no2--;
              if(no2<=0)
              {
                  stars.stop();
                  no2=no;
                  
              } 
            }
    }

    
       else if((Timer)evt.getSource()==bulletInd){
              if(colorno==0){
               colorno=255;
              pamm.setForeground(new Color(colorno,colorno,colorno));
             pamm.repaint();
           }
           else {
               colorno-=15;
                  pamm.setForeground(new Color(colorno,colorno,colorno));
                  pamm.repaint();
               
           
       }
       }
       else if((Timer)evt.getSource()==timer){
//           System.out.println("Level="+level);
             timer.stop();
             bulletInd.stop();
       mainPanel.removeAll();
       int playerX=(widthOfPanel)/2-20;
        int playerY=((heightOfPanel-90));//[363, 53]
//        System.out.println("Y="+playerY);
//        System.out.println("X="+playerX);
         disp=new JLabel();
         seperator=new JLabel();
         scorDisp=new JLabel();
         pamm=new JLabel();
         semm=new JLabel();
         numm=new JLabel();
         //disp=new JLabel();
         Graphics g1=(Graphics2D)mainPanel.getGraphics();
        int sx=(int)(Math.random()*obj.widthOfPanel+1),sy=0;
         for(int i=0;i<1000000;i++){
               int c=(int)(Math.random()*10+1);
              g1.setColor(new java.awt.Color(c,c,c));
             sx=(int)(Math.random()*obj.widthOfPanel+1);
             sy=(int)(Math.random()*obj.heightOfPanel+1);
              g1.drawLine(sx,sy , sx+1, sy+1);
         }
      
         player.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/playerIcon.png")));// disp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/playerIcon.png")));
          player.setSize(40,41);//disp.setSize(40, 41);
         mainPanel.add(player);//mainPanel.add(disp);
      
        player.setCoordinates(playerX, playerY);// disp.setLocation(playerX, playerY); 
        player.setVisible(true);//disp.setVisible(true);
        
        player.repaint();//disp.repaint();
        pamm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/ac2.png")));
        pamm.setSize(100,16);
        pamm.setForeground(new java.awt.Color(255, 255, 255));
        pamm.setFont(new java.awt.Font("Consolas", 0, 18));
        
       displayRemainingBullets(1,player.pBll);
       displayRemainingBullets(2,2);
       displayRemainingBullets(3,0);
        mainPanel.add(pamm);
        pamm.setLocation(widthOfPanel-350, heightOfPanel-25);
        pamm.setVisible(true);
         
        semm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/mc2#5.png")));
        semm.setSize(100,16);
        semm.setForeground(new java.awt.Color(255, 255, 255));
        semm.setFont(new java.awt.Font("Consolas", 0, 18));
        semm.setText("-"+player.sBll);
        mainPanel.add(semm);
        semm.setLocation(widthOfPanel-270, heightOfPanel-25);
        semm.setVisible(true);
        
        numm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/nc2.png")));
        numm.setSize(100,16);
        numm.setForeground(Color.green);
        numm.setFont(new java.awt.Font("Consolas", 0, 18));
        
        numm.setText("-"+player.nBll);
        mainPanel.add(numm);
        numm.setLocation(widthOfPanel-200, heightOfPanel-25);
        numm.setVisible(true);
        
        
        disp.setSize(125,41);
         disp.setFont(new java.awt.Font("Consolas", 0, 18));
         disp.setForeground(Color.green);
         disp.setText("LIFE "+player.getLife());
         mainPanel.add(disp);
         disp.setLocation(widthOfPanel-95, heightOfPanel-40);
         disp.setVisible(true);
//         g.setColor(new java.awt.Color(255, 255, 255));
//         g.drawLine(0, heightOfPanel-50, widthOfPanel,  heightOfPanel-50);
         //g.dispose();
         seperator.setSize(widthOfPanel+20,41);
         seperator.setForeground(new java.awt.Color(255, 255, 255));
       
         String text="";
         for(int i=0;i<widthOfPanel;i++){
             text=text+"_";
         }
         seperator.setText(text);
         mainPanel.add(seperator);
           seperator.setLocation(0, heightOfPanel-60);
           
            scorDisp.setSize(200,41);
         scorDisp.setFont(new java.awt.Font("Consolas", 0, 18));
         scorDisp.setForeground(new java.awt.Color(255, 255, 255));
         scorDisp.setText("SCORE "+score);
         mainPanel.add(scorDisp);
          scorDisp.setLocation(10, heightOfPanel-40);
         scorDisp.setVisible(true);
           arrangeEnemies();
          disp.repaint(); 
          
          mainPanel.repaint();
          
            
            
//              java.awt.EventQueue.invokeLater(new Runnable() {
//                
//            public void run() {
//                  stars.start();
//       
//        }
//              });
              stars.start();
//         while(true){
//             if(stars.isRunning()==true){
//              ;   
//             }
//             else 
//                 break;
//             
//         }
      
       }
    }

   
    
//    class Twinkler implements ActionListener{
//
//         int colorno=255;
//        public void actionPerformed(ActionEvent e) {
//              if(colorno==0){
//               colorno=255;
//               star1.setForeground(new Color(colorno,colorno,colorno));
//               star1.repaint();
//               star2.setForeground(new Color(colorno,colorno,colorno));
//               star2.repaint();
//               star3.setForeground(new Color(colorno,colorno,colorno));
//               star3.repaint();
//               star4.setForeground(new Color(colorno,colorno,colorno));
//               star4.repaint();
//               star5.setForeground(new Color(colorno,colorno,colorno));
//               star5.repaint();
//               star6.setForeground(new Color(colorno,colorno,colorno));
//               star6.repaint();
//               star7.setForeground(new Color(colorno,colorno,colorno));
//               star7.repaint();
//               star8.setForeground(new Color(colorno,colorno,colorno));
//               star8.repaint();
//               star9.setForeground(new Color(colorno,colorno,colorno));
//               star9.repaint();
//               star10.setForeground(new Color(colorno,colorno,colorno));
//               star10.repaint();
//               star11.setForeground(new Color(colorno,colorno,colorno));
//               star11.repaint();
//               star12.setForeground(new Color(colorno,colorno,colorno));
//               star12.repaint();
//             
//           }
//           else {
//               colorno-=5;
//             
//               star1.setForeground(new Color(colorno,colorno,colorno));
//               star1.repaint();
//               star2.setForeground(new Color(colorno,colorno,colorno));
//               star2.repaint();
//               star3.setForeground(new Color(colorno,colorno,colorno));
//               star3.repaint();
//               star4.setForeground(new Color(colorno,colorno,colorno));
//               star4.repaint();
//               star5.setForeground(new Color(colorno,colorno,colorno));
//               star5.repaint();
//               star6.setForeground(new Color(colorno,colorno,colorno));
//               star6.repaint();
//               star7.setForeground(new Color(colorno,colorno,colorno));
//               star7.repaint();
//               star8.setForeground(new Color(colorno,colorno,colorno));
//               star8.repaint();
//               star9.setForeground(new Color(colorno,colorno,colorno));
//               star9.repaint();
//               star10.setForeground(new Color(colorno,colorno,colorno));
//               star10.repaint();
//               star11.setForeground(new Color(colorno,colorno,colorno));
//               star11.repaint();
//               star12.setForeground(new Color(colorno,colorno,colorno));
//               star12.repaint();
//           }
//       }
        
//}
}
