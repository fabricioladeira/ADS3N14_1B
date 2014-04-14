
public class Principal {

	
	public static int totComparacaoQuickSort = 0;
	public static int totTrocaQuickSort = 0;
	
	public static int totComparacaoInsertionSort = 0;
	public static int totTrocaInsertionSort = 0;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int[] valores = { 8, 2, 5, 4, 3, 1, 9, 7, 6 };

		// Imprime desordenado
		System.out.println("----- Array desordenado \n");
		for (int i : valores) {
			System.out.println(i);
		}

		
		System.out.println("----- Quick Sort \n");
		
		quick_sort(valores, 0, 8);
		
		// Imprime ordenado
		for (int i : valores) {
			System.out.println(i);
		}
		
		
		
		
		System.out.println("----- Insertion  Sort \n");
		
		int[] valores2 = { 8, 2, 5, 4, 3, 1, 9, 7, 6 };
		
		int[] result = ordenarCrescente(valores2);
		
		// Imprime ordenado
		for (int i : result) {
			System.out.println(i);
		}
		
		
		
				
		
		System.out.println("----- Resultados  Sort \n");
		
		System.out.println("Quick Sort número trocas:"+ totTrocaQuickSort +"   - número de comparações: "+ totComparacaoQuickSort + " \n");
		System.out.println("Insertion Sort número trocas:"+ totTrocaInsertionSort +"   - número de comparações: "+ totComparacaoInsertionSort + " \n");
		
		System.out.println("----- Resultados  Sort \n");

	}
	
	//Quick Sort
	public static void quick_sort(int[] v, int ini, int fim) {
		int meio;

		totComparacaoQuickSort++;
		if (ini < fim) {			
			meio = divisao(v, ini, fim);
			quick_sort(v, ini, meio);
			quick_sort(v, meio + 1, fim);
		}
	}

	public static int divisao(int[] v, int ini, int fim) {
		int pivo, topo, i;
		pivo = v[ini];
		topo = ini;

		for (i = ini + 1; i <= fim; i++) {		
			
			totComparacaoQuickSort = totComparacaoQuickSort + 2;			
			if (v[i] < pivo) {
				totTrocaQuickSort++;
				v[topo] = v[i];				
				
				totTrocaQuickSort++;
				v[i] = v[topo + 1];
				topo++;
			}
		}
		
		totTrocaQuickSort++;
		v[topo] = pivo;
		return topo;
	}

	
	
	// Insertion Sort
	public static int[] ordenarCrescente(int[] array) {

		for (int fixo = 1; fixo <= array.length; fixo++) {
			totComparacaoInsertionSort++;
			
			int x = fixo - 1;
			int y = fixo;

			while (y != 0 && y != array.length && array[x] > array[y]) {
				totComparacaoInsertionSort = totComparacaoInsertionSort + 3;
								
				int a = array[x];
				
				totTrocaInsertionSort++;
				array[x] = array[y];
				
				totTrocaInsertionSort++;
				array[y] = a;
				x--;
				y--;

			}
		}

		return array;

	}

}
