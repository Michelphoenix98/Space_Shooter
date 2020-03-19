/*
 *  Utils- an easy-to-use library with a lot of useful classes.
    Copyright (C) 2014  Michel Thomas

    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU Lesser General Public
    License as published by the Free Software Foundation; either
    version 2.1 of the License, or (at your option) any later version.

    This library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */
package IO.Text;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Michel Thomas
 */
public class Loader {
    public  String[] loadStringArray(String path) throws FileNotFoundException, IOException{
      FileReader fr=new FileReader(path); 
      BufferedReader br=new BufferedReader(fr);
      String[] data;
      int nol=0;
      while(br.readLine()!=null){
          nol++;
         
      }
    //  System.out.println(nol);
      data=new String[nol];
      nol=0;
      br.close();
      fr.close();
        fr=new FileReader(path); 
      br=new BufferedReader(fr);
      while((data[nol]=br.readLine())!=null){
        // System.out.println("Data Read:-"+data[nol]);
         nol++;
         if(nol==data.length)
             break;
      }
      
      fr.close();
      br.close();
      return data;
    }
    public String loadString(){
        return "";
    }
}
