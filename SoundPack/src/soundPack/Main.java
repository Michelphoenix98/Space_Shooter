
package soundPack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import javax.swing.Timer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * A sample that demonstrates the basics of AudioClips.
 *
 * @see javafx.scene.media.AudioClip
 * @resource Note1.wav
 * @resource Note2.wav
 * @resource Note3.wav
 * @resource Note4.wav
 * @resource Note5.wav
 * @resource Note6.wav
 * @resource Note7.wav
 * @resource Note8.wav
 */
public final class Main extends Application /*implements ActionListener*/  {
  // Timer timer=new Timer(1000,this);
   
//    @Override public void start(Stage primaryStage) throws Exception {
//        
//     
//    }
//    public void actionPerformed(ActionEvent e){
//        
//        System.exit(0);
//       timer.stop();
//    }

    /**
     * The main() method is ignored in correctly deployed JavaFX 
     * application. main() serves only as fallback in case the 
     * application can not be launched through deployment artifacts,
     * e.g., in IDEs with limited FX support. NetBeans ignores main().
     * @param args the command line arguments
     */
    int menu=1;
    AudioClip Menu;
    public void start(int soundCode){
//                Scanner sc=new Scanner(System.in);
//        String soundCode=sc.nextLine();
        
     
        switch((soundCode)){
            case 1:      
       
            new AudioClip(Main.class.getResource("ItemChange.wav").toString()).play();
       
      // timer.start();
       break;
        
                
            case 2:
        new AudioClip(Main.class.getResource("ButtonClick.wav").toString()).play();
      
     //  timer.start();
       break;
                
        
        }
    }
    public static void main(String[] args) {
        launch(args);
      
   
           
      
    }

    @Override
    public void start(Stage stage) throws Exception {
      //   Menu= new AudioClip(Main.class.getResource("Menu.mp3").toString());
        AudioClip shoot1=new AudioClip(Main.class.getResource("shoot1.wav").toString());;
        AudioClip shoot2 = new AudioClip(Main.class.getResource("shoot2.wav").toString());
        AudioClip Item =new AudioClip(Main.class.getResource("Item.wav").toString());;
        AudioClip explosion= new AudioClip(Main.class.getResource("explosion.wav").toString());
        AudioClip invaderkilled=  new AudioClip(Main.class.getResource("invaderkilled.wav").toString());
        AudioClip Rocket= new AudioClip(Main.class.getResource("Rocket.wav").toString());
        AudioClip Nuke= new AudioClip(Main.class.getResource("Nuke.wav").toString());
        AudioClip NewLevel=new AudioClip(Main.class.getResource("newLevel.wav").toString());
        AudioClip Menu=new AudioClip(Main.class.getResource("Menu_1.wav").toString());
        AudioClip GO=new AudioClip(Main.class.getResource("GO.wav").toString());
        AudioClip UFO=new AudioClip(Main.class.getResource("ufo_lowpitch.wav").toString());
        AudioClip shoot3=new AudioClip(Main.class.getResource("fastinvader2.wav").toString());
        UFO.setVolume(0.1);
        Scanner sc=new Scanner(System.in);
        for(;;){
                     
        String soundCode=sc.nextLine();
        
     
        switch(Integer.parseInt(soundCode.trim())){
            case 1:      
//       new AudioClip("shoot1.wav").play();
         shoot1.play();
       
    //   timer.start();
       break;
        
            case 12:
           shoot1.stop();
       
    //   timer.start();
       break;
          
                
            case 2:
      shoot2.play();
//        new AudioClip("shoot2.wav").play();
      
    //   timer.start();
       break;
            case 23:
                 shoot2.stop();
//        new AudioClip("shoot2.wav").play();
      
    //   timer.start();
       break;
            case 3:
                
//           new AudioClip("Item.wav").play();
                
           Item.setVolume(100);
           Item.play();
            
              break; 
            case 34:
               Item.stop();
            
              break;  
                
           
            case 4:
                
//            new AudioClip("explosion.wav").play();    
                explosion.play();
                break;
                
            case 45:
               explosion.stop();
                break;
                
            case 5:
                
                 // new AudioClip("invaderkilled.wav").play();
                invaderkilled.play();
                break;
            case 56:
              invaderkilled.stop();
                break;
                
                
            case 6:
                  //
                //new AudioClip("rocket.wav").play();
                 Rocket.play();
                break; 
            case 67:
                Rocket.stop();
                break; 
            case 7:
               // new AudioClip("Nuke.wav").play();
                 Nuke.play();
                break;
                
            case 78:
                Nuke.stop();
                break;
          case 8:
                Menu.play();
                break;
           case 9:
                Menu.stop();
                break;
            case 10:
               new AudioClip(Main.class.getResource("newLevel.wav").toString()).play();
                break; 
                case 11:
                    GO.play();
                    break;
                case 1011:
                    GO.stop();
                    break;
                    
                case 13:
                    UFO.play();
                    break;
                case 1314:
                   UFO.stop();
                    break;
                case 15 :
                    shoot3.play();
                    break;
                case 1516:
                    shoot3.stop();
                    break;
        
        }   
    }
    }
}
