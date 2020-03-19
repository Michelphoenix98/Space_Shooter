/*
 * Utils- an easy-to-use library with a lot of useful classes.
    Copyright (C) 2014 Michel Thomas

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

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *This class has functions that create a file and writes data to it with ease(in character form),
 *just specify the output directory and the data to be written 
 */
public class Saver {
      String path;
    public Saver(String path){
        this.path=path;
    }
    /**
     * This method saves the provided data on the hard-disk
     * @param script the data provided in an array
     * @param apndVal sets whether to append the file or not
     * @throws IOException 
     */
    public void save(String[] script,boolean apndVal) throws IOException{
           FileWriter fw=new FileWriter(path,apndVal);
                BufferedWriter br=new BufferedWriter(fw);
                PrintWriter pr=new PrintWriter(br);
                
                for(int i=0;i<script.length;i++){
                    pr.println(script[i]);
                }
                pr.close();
                br.close();
                fw.close();
    }
     /**
     * This method saves the provided data on the hard-disk
     * @param string the data is provided in a string variable 
     * @param apndVal sets whether to append the file or not
     * @throws IOException 
     */
    public void save(String string,boolean apndVal ) throws IOException{
     FileWriter fw=new FileWriter(path,apndVal);
     BufferedWriter br=new BufferedWriter(fw);
     PrintWriter pr=new PrintWriter(br);
      pr.println(string);
                
     pr.close();
     br.close();
     fw.close();
    }
}
