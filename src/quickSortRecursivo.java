
public class quickSortRecursivo {
	 private int[] vetor; //vetor a ser ordenado
     private int n; //tamnho do vetor 
     private int copias;
     private int comparacoes;
     private long tempo;
	
	public quickSortRecursivo(){
	}
	
	//Função que chama a função de ordenação pelo método quicksort Recursivo
	public  void sort(int[] vetor){
		this.copias =0;
		this.comparacoes = 0;
		this.vetor = vetor;
		this.n = vetor.length;		
		long tempoInicial = System.currentTimeMillis(); //inicia o cronometro
        quicksortRecursivo(0,n - 1);
        long tempoFinal = System.currentTimeMillis(); // para o cronometro
        this.tempo = tempoFinal - tempoInicial; //calcula o tempo em ms
        System.out.println("tempo =" +tempo);
	}
	
	//Ordena utilizando o quicksort Recursivo
	public void quicksortRecursivo(int esq, int dir)
    {
        if(esq < dir)
        {
            int pivo = particiona(esq, dir);
 			
 			//Chama a função recursivamente
            if(pivo > 1)
                quicksortRecursivo(esq, pivo - 1);
 
            if(pivo + 1 < dir)
                quicksortRecursivo(pivo + 1, dir);
        }
    }
	
	public  int particiona(int esq, int dir)
    {
    	/****  
    	esq = "ponteiro" que aponta para o inicio do vetor e percorre o mesmo da esquerda para direita
        dir = "ponteiro" que aponta para o fim do vetor e percorre o mesmo da direita para esquerda
        ****/
    	
        int pivo = vetor[esq];
        while (true)
        {
            while (vetor[esq] < pivo){
            	this.comparacoes++;
            	esq++;
            }
 
            while (vetor[dir] > pivo){
            	this.comparacoes++;
            	dir--;
            }
 
            if (esq < dir)
              {
                int temp = vetor[dir];
                vetor[dir] = vetor[esq];
                vetor[esq] = temp;
                this.copias++;
              }
              else
              {
                    return dir;
              }
        }
    }
    
    	public  long getTempo(){
    		return this.tempo;
    	}
    	
    	public  int getComparacoes(){
    		return this.comparacoes;
    	}
    	
    	public  int getCopias(){
    		return this.copias;
    	}
    	
    		
}
