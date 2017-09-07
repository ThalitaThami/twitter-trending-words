/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scanner;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 *
 * @author temp
 */
public class scannerfile {
    private long USERID;
    private long TWEETID;
    private String TWEET;
    private String DATE;
    
    
    
    public boolean procuraLinha(int linhadesejada) throws FileNotFoundException, IOException{
        
              
        Scanner file = new Scanner(new File("training_set_tweets.txt"));
        int temp=1;
        try {
            while(temp!=linhadesejada){
                if(!file.hasNext()){  //CASO NÃO HAJA PROXIMA LINHA
                    System.out.println("FIM DE LINHA: "+temp);
                    return false;
                }
                String s = file.nextLine();
                temp++;
            }
         String[] split = file.nextLine().split("\t");
            System.out.println("LINHA: " +temp);
            this.USERID = Long.parseLong(split[0]);
            this.TWEETID = Long.parseLong(split[1]);
            this.TWEET = split[2];
            this.DATE = split[3];
            return true;
        }catch(ArrayIndexOutOfBoundsException a){
            System.out.println("****Out OF BOUNDS*****");
            return false;
        }catch(NumberFormatException e){
            System.out.println("****Number EXCEPTION*****");
            return false;
        }
    }
             
     public long getUserID(){
        return this.USERID;
    }
    public long getTweetID(){
        return this.TWEETID;
    }
    public String getTweet(){
        return this.TWEET;
    }
    public String getDate(){
        return this.DATE;
    }
                
            } //FIM DA CLASSE
    
   
    
    


          /*  Scanner file = new Scanner(new File("inputexts.txt"));
            int line = 0;
            try{
             while(line!= linhadesejada - 1){
                file.nextLine();
                }
             String[] split = file.nextLine().split("\t");
                    this.USERID = Long.parseLong(split[0]);
                    this.TWEETID = Long.parseLong(split[1]);
                    this.TWEET = split[2];
                    this.DATE = split[3];
                    return true;
             
            }catch (NumberFormatException e) {
                return false;
                    
            }*/