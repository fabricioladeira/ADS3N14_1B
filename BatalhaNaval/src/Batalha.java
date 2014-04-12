import static java.lang.System.out;

import java.util.Random;

public class Batalha {

	public static char[] cabecalho = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
			'I', 'J' };
	public static int pontos = 15;
	public static String[][] mapa = new String[10][10];
	public static Navio[][] navios = new Navio[5][5];

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		out.println("Batalha Naval");

		InicializaNavios(1);
		MontaMapa();

	}

	/**
	 * @param numeroTotalNavios
	 */
	private static void InicializaNavios(int numeroTotalNavios) {

		Random sorteio = new Random();
		for (int i = 0; i < numeroTotalNavios; i++) {
			
//			Sorteia o tipo do Navio a ser usado
//			1. 1 “porta-aviões” com 5 unidades de tamanho.!
//			2. 2 “destroyers” com 4 unidades de tamanho.!
//			3. 2 “fragatas” com 3 unidades de tamanho.!
//			4. 3 “torpedeiros” com 2 unidades de tamanho.!
//			5. 5 submarinos, com 1 unidade de tamanho.!
			int t = sorteio.nextInt(5); 
						
			// Sorteia a posição x inicial do navio
			int x = 3; //sorteio.nextInt(10); 
			
			// Sorteia a posição y inicial do navio
			int y = 2; //sorteio.nextInt(10); 
			
			//Sorteia a direção que o navio vai fica 1=Vertical ou 2 = Horizontal
			int direcao = 1;//sorteio.nextInt(2);
			
			//Cria Navio
			Navio nav = new Navio(t,x,y);
			
			//Verifica direcao = Vertical
			if(direcao == 1){
				
				int totalCasasPreencher = nav.getTamanho() + y; 
				while (totalCasasPreencher > mapa.length)
				{
					y -=1;
					totalCasasPreencher = nav.getTamanho() + y; 					
				}
				
				//Atualiza posição inicial
				nav.setY(y);
				
				//Coloca navio na posição dele.
				navios[x][y] = nav;
			}
			
			
			
		}
		
		
		
	}

	private static void MontaMapa() {
		// Monta cabeçalho colunas
		for (int c = 0; c < cabecalho.length; c++) {

			out.print("   " + cabecalho[c]);
		}
		out.println("");

		// Monta tabuleiro
		String linha = "";
		for (int l = 0; l < mapa.length; l++) {

			// out.print(l + "  ");
			linha = l + " ";

			for (int c = 0; c < mapa.length; c++) {

				GetNavio(l,c);
				
				linha += " .  ";

			}

			out.println(linha);

		}

	}
	
	// Verifica se tem um navio na posição e retorna ele.
	private Navio GetNavio(int l, int c)
	{
		
		
	}
	}

}
