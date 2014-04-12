import static java.lang.System.out;


public class Batalha {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[] coluna = { 'A', 'B', 'C', 'D', 'E','F','G','H','I','J'};
		
		String[][] mapa = new String[10][10];
		
		 out.println("Batalha Naval");
		 
		 
	     String linha = "";
		 for (int l = 0; l < mapa.length; l++) {
			 
			 //out.print(l + "  ");
			 
			 linha = l + " ";
			 
			 for (int c = 0; c < coluna.length; c++) {
			 
				 linha += coluna[c] + "  ";				 
			}
			 out.println(linha);
			 
		 }
		 
		
		

	}
	
	
	
	

}
