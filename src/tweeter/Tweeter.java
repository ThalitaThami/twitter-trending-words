/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweeter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import tweeter.ordena.quickSort;
import scanner.scannerfile;
import hashing.Hashing;
import java.math.BigInteger;

/**
 *
 * @author temp
 */
public class Tweeter {
    
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
     
    int[] n = {1000, 5000, 10000, 50000, 100000, 500000, 1000000}; //TAMANHO DOS ELEMENTOS. A CADA ITERAÇÃO DO FOR, PASSA PARA UM ELEMENTO MAIOR QUE O ANTERIOR
    
       // for(int i=0; i<7; i++){ //A CADA INCREMENTO DE I, AUMENTA O TAMANHO DO ARRAY

            int x = 1;

            while(x <= 5){ //PARA CADA ITERAÇÃO, SÃO REALIZADOS 5 TESTES COM O MESMO NUMERO DE ELEMENTOS, MAS ELEMENTOS TOTALMENTE ALEATÓRIOS

                int execucoes = 1;
                int erros=0;          //CADA ERRO AUMENTA EM 1 O LAÇO

                teste objarray[] = new teste[ 1000 ]; //CRIA UM ARRAY DE N ELEMENTOS DE OBJETOS
                 Random rand = new Random(100); //GERADOR DE NUMEROS ALEATORIOS
                while( execucoes <= 1000 + erros ){
                    scannerfile file = new scannerfile(); //ESSA É A CLASSE QUE LÊ O ARQUIVO DE TEXTO

                   
                    int linhaqualquer = (int) rand.nextInt(1000); //COM ISSO, PROCURAREMOS UMA LINHA QUALQUER NO ARQUIVO DE TEXTO

                    if(file.procuraLinha(linhaqualquer)){   //FUNÇÃO RETORNA TRUE SE TIVER ENCONTRADO A LINHA ALEATÓRIA
                        
                        //AGORA QUE TEMOS TODAS AS INFORMAÇÕES DE UMA LINHA QUALQUER SEPARADA
                        //PODEMOS INSERIR NO ARRAY DE OBJETOS UTILIZANDO UMA FUNÇÃO HASH
                        int pos;
                        Hashing h = new Hashing(1000);
                        long temp = file.getTweetID();
                        pos = h.hashingDivisao( temp );
                        System.out.println("pos: "+pos);//O TWEET ID SERVIRÁ COMO CHAVE PARA A FUNÇÃO HASH;
                        //AGORA CHECAREMOS SE ESSA POSIÇÃO JA ESTÁ OCUPADA
                        //BigInteger i = (BigInteger) file.getTweetID();
                        if(objarray[pos]==null){
                            teste objetolocal = new teste();
                             //APÓS CALCULADA EM QUAL POSIÇÃO SERÁ INSERIDO O OBJETO
                            objetolocal.setUserID(file.getUserID());    //    ALOCA NA POSIÇÃO CALCULADA
                            objetolocal.setUserID(file.getTweetID());  //    AS INFORMAÇÕES OBTIDAS A PARTIR 
                            objetolocal.setTweet(file.getTweet());    //    DA LINHA ATUAL NO ARQUIVO  
                            objetolocal.setDate(file.getDate());         
                            objetolocal.setChave(pos); //ESSE ATRIBUTO SERVIRÁ COMO O "ÍNDICE DO OBJETO" DURANTE O QUICKSORT
                            objarray[pos] = objetolocal;
                        }else{ //HOUVE COLISÃO
                            
                            int col = 1;
                            int novapos;
                            while(col!=0){
                                
                                novapos = h.tratamentoSondQuad(pos, col);
                                
                                if(objarray[novapos]==null){ //SE A NOVA POSIÇÃO CALCULADA FOR VAZIA, INSERE
                                    teste objetolocal = new teste();
                                    //APÓS CALCULADA EM QUAL POSIÇÃO SERÁ INSERIDO O OBJETO
                                    objetolocal.setUserID(file.getUserID());    //    ALOCA NA POSIÇÃO CALCULADA
                                    objetolocal.setUserID(file.getTweetID());  //    AS INFORMAÇÕES OBTIDAS A PARTIR 
                                    objetolocal.setTweet(file.getTweet());    //    DA LINHA ATUAL NO ARQUIVO  
                                    objetolocal.setDate(file.getDate());         
                                    objetolocal.setChave(pos); //ESSE ATRIBUTO SERVIRÁ COMO O "ÍNDICE DO OBJETO" DURANTE O QUICKSORT
                                    objarray[pos] = objetolocal;
                                    col=0;
                                }
                                else{
                                    col++;
                                }
                            }
                            
                        }
                    }else{
                        erros++; //AUMENTA EM 1 A EXECUÇÃO 
                    }           //CASO A LINHA ALEATÓRIA NÃO TENHA SIDO ENCONTRADA
                 execucoes++;
                }
            ///AGORA O ARRAY INTEIRO JÁ FOI ALOCADO, PROSSEGUIREMOS PARA O QS.
            quickSort q = new quickSort();
            q.sort(objarray); //APLICA O QUICKSORT NO ARRAY DE OBJETOS
            q.salvarMetricas(x); //SALVA TODAS AS MÉTRICAS DA EXECUÇÃO
            x++; //APÓS A ORDENAÇÃO, REALIZAREMOS O MESMO PROCESSO ATÉ X=5
            }//FIM DO WHILE

    }//FIM DO MAIN
    
    
} //FIM DA CLASSE TWEETER
