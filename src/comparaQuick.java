import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;
import java.nio.file.Files;




class comparaQuick {
	public  comparaQuick()throws FileNotFoundException, IOException{    	    	
    
    		Scanner ler = new Scanner(System.in);
	    	int n;
	    	System.out.printf("Informe o tamanho do vetor de inteiros ");
			n = ler.nextInt();// tamanho dos vetores informado pelo usuário
		for(int j = 0 ; j < 5; j++)
    	{
    		Random rand = new Random();
	    	Random randAux = new Random();
	    	int[] vetorR = new int[n]; // vetor que será ordenado pelo método de quicksort recursivo
	    	int[] vetorM = new int[n]; // vetor que será ordenado pelo método de quicksort mediana
	    	int[] vetorI = new int[n]; // vetor que será ordenado pelo método de quicksort inserção
	 	
	    	for(int i = 0; i < n; i++ ){
	    		int linha =  rand.nextInt(5);//indice aleatório da linha;
	    		int id = procuraLinha(linha); // valor de tweetId
	    		vetorR[i] = id;
	    		vetorM[i] = id;
	    		vetorI[i] = id;
	    	}
	            
	            System.out.println("QuickSort Recursivo");
	        quickSortRecursivo qR = new quickSortRecursivo();
	        qR.sort(vetorR);
	            for (int i = 0; i < n; i++)
	                  System.out.println(vetorR[i]);
	 
	            System.out.println();
	            
	           
	           System.out.println("QuickSort Inseção");
	        quickSortInsercao qI = new quickSortInsercao();
	        qI.sort(vetorI, 10);
	            for (int i = 0; i < n; i++)
	                  System.out.println(vetorI[i]);
	 
	            System.out.println();
	            
	        int k = 1;    
	        if( j == 0)
	        {
	        	Scanner lerM = new Scanner(System.in);
		    	System.out.printf("Informe um inteiro k maior que 3 para a mediana desses k elementos serem feitas ");
				k = ler.nextInt();// numero de elemenos aleatorios para o calculo da mediana 
	       } 
	        System.out.println("QuickSort Mediana");
		    quickSortMediana qM = new quickSortMediana();        
		    qM.sort(vetorM, k);
	        for (int i = 0; i < n; i++)
	            System.out.println(vetorM[i]);
	 
	            System.out.println();
	       
	       imprimeMetricas(qR, qI, qM );
    	}
    	
    }
    
    //procura a linha desejado do arquivo e retorna o twwetId da mesma 
    public static int procuraLinha(int linhadesejada) throws FileNotFoundException, IOException{
             
            Scanner file = new Scanner(new File("training_set_tweets.txt"));
        int temp=1;         
        
        try {
            Stream<String> lines = Files.lines(Paths.get("training_set_tweets.txt"));
            String linha = lines.skip(linhadesejada).findFirst().get();
            String[] split = linha.split("\t");
            long TWEETID = Long.parseLong(split[1]);
            int id = (int) TWEETID;
            return id;
        }catch(ArrayIndexOutOfBoundsException a){
            System.out.println("****Out OF BOUNDS*****");
            return 0;
        }catch(NumberFormatException e){
            System.out.println("****Number EXCEPTION*****");
            return 0;
        }
    }
    
    //imprime em um arquivo tempo de execução, numero de comparações e numero de copias de cada quicksort
    public void imprimeMetricas(quickSortRecursivo qR, quickSortInsercao qI,quickSortMediana qM ) throws FileNotFoundException, IOException {
    	
    	System.out.println("Imprimindo metricas no arquivo, metricas.txt");
    	
    	FileWriter arquivo = new FileWriter("metricas.txt");
	    PrintWriter gravarArquivo = new PrintWriter(arquivo);
	 
	   	gravarArquivo.printf("Métricas");
	    
	      gravarArquivo.printf("Quicksort Recursivo%n");	      
	      gravarArquivo.printf("tempo = ");
	      gravarArquivo.println(qR.getTempo());
	      gravarArquivo.printf("%n");
	      gravarArquivo.printf("numero de comparaçoes = ");
	      gravarArquivo.println(qR.getComparacoes());
	      gravarArquivo.printf("%n");
	      gravarArquivo.printf("numero de copias = ");
	      gravarArquivo.println(qR.getCopias());
	      gravarArquivo.printf("%n");
	      
	      gravarArquivo.printf("%n");
	      
	      gravarArquivo.printf("Quicksort Insercao%n");
	      gravarArquivo.printf("tempo = ");
	      gravarArquivo.println(qI.getTempo());
	      gravarArquivo.printf("%n");
	      gravarArquivo.printf("numero de comparaçoes = ");
	      gravarArquivo.println(qI.getComparacoes());
	      gravarArquivo.printf("%n");
	      gravarArquivo.printf("numero de copias = ");
	      gravarArquivo.println(qI.getCopias());
	      gravarArquivo.printf("%n");
	      
	      gravarArquivo.printf("%n");
	      
	      gravarArquivo.printf("Quicksort Mediana%n");
	      gravarArquivo.printf("tempo = ");
	      gravarArquivo.println(qM.getTempo());
	      gravarArquivo.printf("%n");
	      gravarArquivo.printf("numero de comparaçoes = ");
	      gravarArquivo.println(qM.getComparacoes());
	      gravarArquivo.printf("%n");
	      gravarArquivo.printf("numero de copias = ");
	      gravarArquivo.println(qM.getCopias());
	      gravarArquivo.printf("%n");
	  
	 
	    arquivo.close();
	    System.out.println("métricas impressas no arquivo metricasQuickSort.txt");
    }
}

