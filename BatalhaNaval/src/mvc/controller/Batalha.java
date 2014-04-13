package mvc.controller;

import static java.lang.System.out;

import java.util.Random;

import mvc.model.Navio;

import mvc.view.MapaView;

public class Batalha {

	public static boolean debug = true;
	public static int pontos = 15;
	public static String[][] mapa = new String[10][10];
	public static Navio[][] navios = new Navio[10][10];

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		out.println("Batalha Naval");

		InicializaMapa();
		InicializaNavios(3);

		// Se o parâmetro de debug estiver ligado acima ele mostra uma matriz
		// com os navios colocados
		if (debug)
			MapaView.ImprimeMapa(mapa, pontos, true);

		MapaView.ImprimeMapa(mapa, pontos, false);

		MapaView.InputComandos(mapa, pontos);

	}

	/**
	 * @param numeroTotalNavios
	 */
	private static void InicializaNavios(int numeroTotalNavios) {

		Random sorteio = new Random();
		
		// Porta Aviões
		SortenadoNavios(sorteio, 1, 1);

		// destroyers
		SortenadoNavios(sorteio, 2, 2);

		// fragatas;
		SortenadoNavios(sorteio, 3, 2);

		// torpedeiros;
		SortenadoNavios(sorteio, 4, 3);

		// submarinos;
		SortenadoNavios(sorteio, 5, 5);
	}

	private static void SortenadoNavios(Random sorteio, int tipo, int total) {
		int contador = 0;
		while (contador != total) {
			Navio navioSorteado = SorteiaNavio(sorteio, tipo);

			if (!VerificaColisao(navioSorteado)) {
				navios[navioSorteado.getX()][navioSorteado.getY()] = navioSorteado;
				contador++;
			}
		}

	}

	private static boolean VerificaColisao(Navio navioSorteado) {
		// Verifica se não tem outro navio nessa posicao
		Navio navioColisao = null;

		try {
			navioColisao = GetNavio(navioSorteado.getY(), navioSorteado.getX());

			if (navioColisao != null)
				return true;

		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

		return false;

	}

	// Sorteia posicao inicial tipo e direcao do navio
	private static Navio SorteiaNavio(Random sorteio, int tipoNavio) {
		// Sorteia o tipo do Navio a ser usado
		// 1. 1 “porta-aviões” com 5 unidades de tamanho.!
		// 2. 2 “destroyers” com 4 unidades de tamanho.!
		// 3. 2 “fragatas” com 3 unidades de tamanho.!
		// 4. 3 “torpedeiros” com 2 unidades de tamanho.!
		// 5. 5 submarinos, com 1 unidade de tamanho.!
		int t = tipoNavio;// sorteio.nextInt(4);

		// Sorteia a posição x inicial do navio
		int x = sorteio.nextInt(10);

		// Sorteia a posição y inicial do navio
		int y = sorteio.nextInt(10);

		// Sorteia a direção que o navio vai fica 1=Vertical ou 2 =
		// Horizontal
		int direcao = sorteio.nextInt(2);

		// Cria Navio
		Navio nav = new Navio(t, x, y, direcao);

		// Verifica direcao = Vertical
		if (direcao == 1) {

			int totalCasasPreencher = nav.getTamanho() + y;
			while (totalCasasPreencher > mapa.length) {
				y -= 1;
				totalCasasPreencher = nav.getTamanho() + y;
			}

			// Atualiza posição inicial
			nav.setY(y);

		} else {
			// Coloca Navio posicionado da Horizontal
			int totalCasasPreencher = nav.getTamanho() + x;
			while (totalCasasPreencher > mapa.length) {
				x -= 1;
				totalCasasPreencher = nav.getTamanho() + x;
			}

			// Atualiza posição inicial
			nav.setX(x);

		}

		return nav;
	}

	// Zera Mapa e Incializa
	private static void InicializaMapa() {
		for (int l = 0; l < mapa.length; l++) {
			for (int c = 0; c < mapa.length; c++) {
				mapa[l][c] = " .  ";
			}
		}
	}

	// Verifica se tem um navio na posição e retorna ele.
	public static Navio GetNavio(int l, int c) {

		Navio navio = null;
		for (int il = 0; il < navios.length; il++) {
			for (int ic = 0; ic < navios.length; ic++) {

				if (navios[il][ic] != null) {
					// Pega Navio Atraves das cordenadas incial
					navio = navios[il][ic];

					// Verifica direção dele para validar colisão
					if (navio.getDirecao() == 1) {
						int destino = il + navio.getTamanho();
						for (int y = il; y < destino; y++) {
							if (l == y && c == ic)
								return navio;
						}
					} else {
						// Verifica Horizontal
						int destino = ic + navio.getTamanho();
						for (int x = ic; x < destino; x++) {
							if (l == il && c == x)
								return navio;
						}

					}

				}
				// return navios[il][ic];

			}
		}

		return null;
	}

	// Verifica se um determinado navio foi totalmente destruído
	public static boolean VerificaNavioDestruido(Navio navio) {
		boolean destruido = false;

		int linha = navio.getX();
		int coluna = navio.getY();
		int tamanho = navio.getTamanho();
		int direcao = navio.getDirecao(); // 1 = Vertical , 0 = Horizontal
		int contaAcerto = 0;

		for (int l = 0; l < mapa.length; l++) {
			for (int c = 0; c < mapa.length; c++) {

				if (l == linha && c == coluna) {
					// Verifica direção e valida se o navio já foi todo abatido
					if (direcao == 1) {
						int total = tamanho + linha;
						for (int li = linha; li < total; li++) {
							if (mapa[li][c].contains("O")) {
								contaAcerto++;
							}
						}
					} else {
						int total = tamanho + coluna;
						for (int ci = coluna; ci < total; ci++) {
							if (mapa[l][ci].contains("O")) {
								contaAcerto++;
							}
						}
					}

					break;
				}
			}
		}

		// Se o Total de acertos for do tamanho do navio ele foi destruido
		if (contaAcerto == tamanho)
			destruido = true;

		return destruido;
	}

}
