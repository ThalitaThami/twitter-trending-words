
import java.util.Random;

public class quickSortMediana {

     private int n; //tamnho do vetor 
     private int copias;
     private int comparacoes;
     private long tempo;
	
	public quickSortMediana(){
	}
	//Fun��o que chama a fun��o de ordena��o pelo m�todo quicksort Mediana	
	public  void sort(int[] vetor, int k){
		
		this.copias = 0;
		this.comparacoes = 0;
		this.n = vetor.length;		
		long tempoInicial = System.currentTimeMillis(); //inicia o cronometro
        quicksortMediana(vetor, 0, n-1 , k);
        long tempoFinal = System.currentTimeMillis(); // para o cronometro
        this.tempo = tempoFinal - tempoInicial; //calcula o tempo em ms
	}
	
	//Ordena utilizando o quicksort Recursivo, mas o pivo � a mediana de k elementos aleat�rios do vetor
    public void quicksortMediana(int[] vetor, int esq, int dir,int k)
    {
        if(dir - esq < k)
        		insercao(vetor);
        else if(esq < dir)
        {
            int pivo = particiona(vetor, esq, dir, k);
 			
 			//Chama a fun��o recursivamente
            if(pivo > 1)
                quicksortMediana(vetor, esq, pivo - 1, k);
 
            if(pivo + 1 < dir)
                quicksortMediana(vetor, pivo + 1, dir, k);
        }
    }
	
	public int particiona(int[] vetor, int esq, int dir, int k)
	{
	   	/***** 
	   	esq = "ponteiro" que aponta para o inicio do vetor e percorre o mesmo da esquerda para direita
       	dir = "ponteiro" que aponta para o fim do vetor e percorre o mesmo da direita para esquerda
	   	k = n�meros de elementos alea�torios para o c�lculo da mediana
	   	*****/	   	
	   	 
	    int pivo = mediana(vetor,k); //pivo recebe a mediana
        while (true)
        {
            while (vetor[esq] < pivo && esq <= this.n){
            	this.comparacoes++;
            	esq++;
            }
 
            while (vetor[dir] > pivo && dir >= 0){
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
    
    // Calcula e retorna a  mediana entre k elementos aleat�rios do vetor
    public int mediana(int[]vetor, int k)
    { 
    	Random rand = new Random();
    	int[] aux = new int[k]; //vetor auxiliar com os k elementos aleat�rios
    	for(int i = 0; i < k; i++ ){
    		aux[i] = vetor[rand.nextInt(vetor.length)];
    		/****
    		 a cada inteira��o � adicionado um inteiro alet�rio pertencente ao vetor a ser ordenado
    		 ao vetor auxiliar para o calculo da mediana
    		****/
    	}
    	
    	int mediana;
    
    	if( k%2 == 0 ){
    		mediana = ( vetor[k/2] + vetor[ (k/2)+1 ] )/2;
    	}
    	else{
    		mediana = vetor[k/2];
    	}
    	return mediana;	
    }
    
    //ordena pelo m�todo da inser��o
    public void insercao(int[]vetor)
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
	
		public long getTempo(){
    		return this.tempo;
    	}
    	
    	public int getComparacoes(){
    		return this.comparacoes;
    	}
    	
    	public int getCopias(){
    		return this.copias;
    	}
}
