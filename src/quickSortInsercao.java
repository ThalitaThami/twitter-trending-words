
public class quickSortInsercao {
	 private int[] vetor; //vetor a ser ordenado
     private int n; //tamnho do vetor 
     private int copias;
     private int comparacoes;
     private long tempo;
	
		public quickSortInsercao(){
	}
	
	//Função que chama a função de ordenação pelo método quicksort Inserção
	public  void sort(int[] vetor, int k){
		this.copias = 0;
		this.comparacoes = 0;
		this.vetor = vetor;
		this.n = vetor.length;		
		long tempoInicial = System.currentTimeMillis();//inicia o cronometro
        quicksortInsercao(0,vetor.length - 1, k);
        long tempoFinal = System.currentTimeMillis(); // para o cronometro
        this.tempo = tempoFinal - tempoInicial; //calcula o tempo em ms
	}
	
	 /****
	 Função que ordena o vetor utilizando o quicksort Recursivo, mas qnuando vetor tem tamnho
	 menor que k é ordenado pelo método de inserção(insertionsort)
	 ****/
	  public  void quicksortInsercao(int esq, int dir,int k)
    {
        /****
		esq = "ponteiro" que aponta para o inicio do vetor e percorre o mesmo da esquerda para direita
        dir = "ponteiro" que aponta para o fim do vetor e percorre o mesmo da direita para esquerda
        ****/
        
        //Se o tamnho do vetor for menor ou igual que k, chama - se o método de inserção 
        if(dir - esq <= k)
        {
        	insercao();
        }
        
        // Se não, o vetor é ordenado pelo quicksort Recursivo
        else if(esq < dir && dir - esq > k)
        {
            // o pivo é obitido através do método de partição
            int pivo = particiona( esq, dir);
            
 			//Chama a função recursivamente
            if(pivo > 1)
                quicksortInsercao(esq, pivo - 1, k);
 
            if(pivo + 1 < dir)
                quicksortInsercao(pivo + 1, dir, k);
        }
    }
	
	public int particiona(int esq, int dir)
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
    
    
    //método que ordena o vetor com o insertionsort
    public void insercao()
    { 
      int j;
	    for (int i = 1 ; i < vetor.length; i++)
	    {
	      int pivo = vetor[i];
	      for ( j = i - 1; (j >= 0) && (vetor[j] > pivo); j--)
	      {
	         vetor[j + 1] = vetor[j];
	         this.comparacoes++;
	      }
	      vetor[j + 1] = pivo;
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
