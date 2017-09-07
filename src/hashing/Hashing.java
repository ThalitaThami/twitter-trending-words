/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashing;

/**
 *
 * @author user
 */
public class Hashing {
    
    private int m;
    private int numColisoes = 0;
    private int numColisoestrat = 0;
    
    public Hashing(int x){
        this.m = x;
    }
    public int hashingDivisao(long chave){
        int temp = (int) (chave%m);
        return temp; 
    }
    
    public int hashingEnlacamento(int chave){
        String chaveStr = Integer.toString(chave);
        int enlacamento = 0;        
        for (int i = 0; i < chaveStr.length(); i++){
            enlacamento += Integer.parseInt(chaveStr.substring(i, i+1));
        }
        return enlacamento%m;
    }
    public int tratamentoSondQuad(long chave, int col){
        System.out.println("\n\n\nErro ao inserir chave: " +chave);
        int novapos = ( hashingDivisao(chave) + col*col ) % m; //calcula nova posicao baseada na chave e no numero de colisoes existentes         
        return novapos;
    }
    
    public int getNumColisoes(){
        return numColisoes;
    }
    
}
