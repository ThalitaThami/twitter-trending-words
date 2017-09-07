/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweeter.ordena;
import java.io.FileNotFoundException;
import java.io.IOException;
import write.write;
import tweeter.teste;
/**
 *
 * @author temp
 */
public class quickSort {
     private teste[] vetor;
     private int n;
     private int copias = 0;
     private int comparacoes = 0;
     private long tempo;
     static final String[] teste = new String[6];
     write output = new write();
    
     public void sort(teste[] vetor) { //recebe um vetor como parâmetro
        // Checa se o array esta vazio
        if (vetor ==null || vetor.length==0){
            return;
        }
        this.vetor = vetor; //vetor local recebe o que foi passado por parâmetro
        n = vetor.length; 
         final long startTime = System.currentTimeMillis(); //INICIALIZA O CRONÔMETRO
        quicksort(0, n - 1);
         final long endTime = System.currentTimeMillis(); // PARA O CRONÔMETRO
         tempo = endTime - startTime; //CALCULA QUANTO TEMPO EM MS
    }
     
     private void quicksort(int ini, int fim) {
        int i = ini,  //indice esquerda pra direita
            j = fim; //indice direita pra esquerda
        
        // Seleciona o pivô como o elemento mais a direita
        int pivo = vetor[vetor.length - 1].getChave();

        // Divide o vetor em 2
        while (i <= j) {
            
            //Enquanto o elemento lista esquerda for menor que o pivô
            //avança um indice
            while (vetor[i].getChave() < pivo) {
                this.comparacoes++;
                i++;
            }
            // Enquanto o elemento da lista direita for maior que o pivô
            //avança um indice
            while (vetor[j].getChave() > pivo) {
                this.comparacoes++;
                j--;
            }

            //Se foi achado um valor da lista esquerda MAIOR que o pivô
            //E um elemento da lista direita MENOR que o pivô
            //É realizada a troca desses 2 elementos
            //Após a troca, os indices continuam a andar
            if (i <= j) {
                troca(i, j);
                i++;
                j--;
            }
        }
        // Recursão
        if (ini < j)
            quicksort(ini, j);
        if (i < fim)
            quicksort(i, fim);
    }
     
     private void troca(int i, int j) {
        teste aux[] = new teste[1];
        aux[0] = vetor[i];
        this.copias++;
        vetor[i] = vetor[j];
        vetor[j] = aux[0];
    }
     
     public void salvarMetricas(int x) throws FileNotFoundException, IOException{
        quickSort.teste[x] = "\n\n\n Metricas Quantidade de elementos: " +this.vetor.length +"Execução numero: " +x +" Numero de comparações:  " +this.comparacoes +" Numero de copias de registro: " +this.copias +" Tempo de execução QS: " +this.tempo +" ms";
        
        if(x==5) output.write("metricasvet"+vetor.length+x ,quickSort.teste);
}

    
}



    

    

 