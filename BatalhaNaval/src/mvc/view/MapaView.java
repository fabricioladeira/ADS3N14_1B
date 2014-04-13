package mvc.view;

import static java.lang.System.out;

import java.util.Scanner;

import mvc.controller.Batalha;
import mvc.model.Navio;

public class MapaView {

	public static String[] cabecalho = { "A", "B", "C", "D", "E", "F", "G",
			"H", "I", "J" };

	public static void ImprimeMapa(String[][] mapa, int pontos, Boolean debug) {

		System.out.flush();
		out.println("Pontos:" + pontos);

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

				// Mostra Posicao
				if (debug) {
					Navio nav = null;
					try {
						nav = Batalha.GetNavio(l, c);

						// Acerto a navios
						if (nav != null)
							linha += " " + nav.getId() + "  ";
						else
							linha += " .  ";

					} catch (Exception ex) {
						linha += " .  ";
					}
				} else {

					linha += mapa[l][c];
				}

			}

			out.println(linha);

		}

		InputComandos(mapa, pontos);

	}

	public static void InputComandos(String[][] mapa, int pontos) {
		Scanner entrada = new Scanner(System.in); // Já consigo separara a linha
													// e pegar o tipo não
													// precisa

		String comand = "";

		while (pontos != 0) {

			try {
				out.println("Digite Linha Coluna (EX:L C)");
				int linha = entrada.nextInt();
				String coluna = entrada.next();

				
				
				Navio navio = null;

				try {

					int col = ConvertColunaToInt(coluna);

					if (col != -1) {

						navio = Batalha.GetNavio(linha, col);
						
						//Se acertou
						if (navio != null) {
							//Valida se já não foi acertado antes
							if (!mapa[linha][col].contains("O")) {
								out.println("Acertou !!!");

								mapa[linha][col] = " O  ";
								
								// Marca pontos
								if (Batalha.VerificaNavioDestruido(navio))
									pontos += 5;
								else
									pontos += 3;

								
							}

						} else {
							mapa[linha][col] = " -  ";
							pontos--;
						}
					}

					ImprimeMapa(mapa, pontos, false);

				} catch (Exception e) {
					// TODO: handle exception
				}

			} catch (Exception ex) {
				out.println("Error:");
			}

		}

		System.out.println("Fim");
	}

	// Retorna Coluna convertida em posição
	public static int ConvertColunaToInt(String coluna) {
		for (int i = 0; i < cabecalho.length; i++) {
			if (cabecalho[i].toString().toUpperCase()
					.equals(coluna.toUpperCase()))
				return i;
		}

		return -1;
	}

}
