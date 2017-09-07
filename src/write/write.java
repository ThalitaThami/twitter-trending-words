/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package write;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 *
 * @author temp
 */
public class write {
    
    public void write(String filename, String[] s) throws FileNotFoundException{
        String nomedoarquivo = filename+".txt";
        try (PrintWriter outputStream = new PrintWriter(nomedoarquivo)) {
            outputStream.println(Arrays.toString(s));
            outputStream.close();
        }
    }
    
    
}

   