/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweeter;

/**
 *
 * @author temp
 */
public class teste {
    private long USERID;
    private long TWEETID;
    private String TWEET;
    private String DATE;
    private int chave;
    
    public void setUserID(long UID){
        this.USERID = UID;
    }
    public void setTweetID(long TID){
        this.TWEETID = TID;
    }
    public void setTweet(String T){
        this.TWEET = T;
    }
    public void setDate(String D){
        this.DATE = D;
    }
    public void setChave(int k){
        this.chave = k;
    }
    public int getChave(){
        return this.chave;
    }
}
