public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void quick_sort(int[] v, int ini, int fim) {
		int meio;

		if (ini < fim) {
			meio = partition(v, ini, fim);
			quick_sort(v, ini, meio);
			quick_sort(v, meio + 1, fim);
		}
	}

	public static int partition(int[] v, int ini, int fim) {
		int pivo, topo, i;
		pivo = v[ini];
		topo = ini;

		for (i = ini + 1; i <= fim; i++) {
			if (v[i] < pivo) {
				v[topo] = v[i];
				v[i] = v[topo + 1];
				topo++;
			}
		}
		v[topo] = pivo;
		return topo;
	}
	
	
	//Insertion Sort
	public Long[] ordenarCrescente(Long[] array){
		 
        for(int fixo = 1; fixo <= array.length; fixo++){
 
        int x = fixo - 1;
        int y = fixo;
 
           while(y != 0 && y != array.length && array[x] > array[y]){
 
               Long a = array[x];
               array[x] = array[y];
               array[y] = a;
               x--;
               y--;
 
           }
        }
 
 
        return array;
 
    }

}
