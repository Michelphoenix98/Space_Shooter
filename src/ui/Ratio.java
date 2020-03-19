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

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

/**
 *
 * @author Michel Thomas
 */
public class Ratio {
    int X,x,Y,y;
   private int lowest_x_ratio,lowest_X_ratio;
   private int lowest_y_ratio,lowest_Y_ratio;
   public  Ratio(int widthOfWindow,int heightOfWindow){
        Dimension dim= Toolkit.getDefaultToolkit().getScreenSize();
         X=dim.width;
         Y=dim.height;
         x=widthOfWindow;
         y=heightOfWindow;
        
         lowestFractionForXcoordinates();
         lowestFractionForYcoordinates();
        
         
         
   }
 public int getSimilarXcoordinate(float x){
     
     return (int)(this.lowest_X_ratio*((float)(x/this.lowest_x_ratio)));
     
 }
 public int getSimilarYcoordinate(float y){
     
      return (int)(this.lowest_Y_ratio*((float)(y/this.lowest_y_ratio)));
     
 }
 
     private void lowestFractionForXcoordinates(){
      int i=0;
       ArrayList primes=new ArrayList();
       if(X%x==0){
          
           lowest_X_ratio=X/x;
           lowest_x_ratio=1;
       }
       else{
           primes=primeNumbers(x/2);
           
           //debugging 
         //  System.out.println("Array size outside loop="+primes.size());
//           for(int defcon=0;defcon<primes.size();defcon++){
//              System.out.println("primes["+defcon+"]="+primes.get(defcon));
//           }
           primeloop:  for(;i<primes.size();){
              if(X%(Integer)primes.get(i)==0&&x%(Integer)primes.get(i)==0){
                  
                  X/=(Integer)primes.get(i);
                  x/=(Integer)(primes.get(i));
                  
                  primes=primeNumbers(x/2);
                  //  System.out.println("Array size inside loop="+primes.size());
//           for(int defcon=0;defcon<primes.size();defcon++){
//              System.out.println("primes["+defcon+"]="+primes.get(defcon));
//           }
                  
                  i=0;
                  continue primeloop;
                  
              }
              i++;
           }
           lowest_x_ratio=x;
           lowest_X_ratio=X;
       }
   }
     private static boolean isPrime(int n){
       int ctr=0;
      for(int i=2;i<=(n/2);i++){
          if(n%i==0){
                ctr++;
                break;
          }
            
      }
      if(ctr>0)
         return false;
      else
         return true;
   }
       private ArrayList primeNumbers(int no){
       ArrayList primes;
       int noOfPrimes=0;
//       for(int i=2;i<=no;i++){
//           if(isPrime(i))
//               noOfPrimes++;
//               
//       }
       primes=new ArrayList();
       
       for(int i=2;i<=no;i++){
           if(isPrime(i))
               primes.add(i);
       }
       return primes;
   }


   private void lowestFractionForYcoordinates(){
          int i=0;
       ArrayList primes=new ArrayList();
       if(Y%y==0){
          
           lowest_Y_ratio=Y/y;
           lowest_y_ratio=1;
       }
       else{
           primes=primeNumbers(y/2);
           
           //debugging 
         //  System.out.println("Array size outside loop="+primes.size());
//           for(int defcon=0;defcon<primes.size();defcon++){
//              System.out.println("primes["+defcon+"]="+primes.get(defcon));
//           }
           primeloop:  for(;i<primes.size();){
              if(Y%(Integer)primes.get(i)==0&&y%(Integer)primes.get(i)==0){
                  
                  Y/=(Integer)primes.get(i);
                  y/=(Integer)(primes.get(i));
                  
                  primes=primeNumbers(y/2);
//                    System.out.println("Array size inside loop="+primes.size());
//           for(int defcon=0;defcon<primes.size();defcon++){
//              System.out.println("primes["+defcon+"]="+primes.get(defcon));
//           }
                  
                  i=0;
                  continue primeloop;
                  
              }
              i++;
           }
           lowest_y_ratio=y;
           lowest_Y_ratio=Y;
       }
   }
}