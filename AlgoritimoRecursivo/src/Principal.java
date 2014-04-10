import static java.lang.System.*;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int valor = 40;

		//fatorial recursivo
		long t = currentTimeMillis();
		
		out.println(recFatorial(valor));
		out.println(currentTimeMillis() - t);
		
		//Fatorial interno
		long t2 = currentTimeMillis();
		
		out.println(iterFatorial(valor));
		out.println(currentTimeMillis() - t2);
		
		
		//Fibonato recursivo
		long t3 = currentTimeMillis();
		
		out.println(recFibonati(valor));
		out.println(currentTimeMillis() - t3);
		
		//Fibonato recursivo
		long t4 = currentTimeMillis();
		
		out.println(interFibonati(valor));
		out.println(currentTimeMillis() - t4);
		
		
		
	}
	
	
	///Fatorial Recursivo
	private static double recFatorial(int n)
	{
		if(n < 1) return 0; 
		if(n==1) return 1;
		
		return n * recFatorial(n - 1);
		
	}
	
	
	///Fatorial normal
	private static double iterFatorial(int n)
	{
		double res = 1;
		
		for (int i = 2; i <= n; i++) {
			res *= i;
		}
		return res;
		
	}
	
	
	//Algoritimo de fibonati Recursivo
	//Numero de fibonati é a soma dos dois numeros anteriores
	//perimeiro numero = 1 
	//segundo = 1
	//terceiro = 2
	//quarto = 3
	//cinco = 5
	//
	private static double recFibonati(int n)
	{
		if(n < 1) return 0;
		if(n == 1) return 1;
		
		return recFibonati(n-1) + recFibonati(n-2);		
	}
	
	
	//Fibonati interativo não recursivo
	private static double interFibonati(int n)
	{		
		if(n<1) return 0;
		double result = 0;		
		double oldResult = 1;
		
		for (int i = 1; i <= n; i++) {
			
			double temp = result;
			result += oldResult;
			oldResult = temp;
		} 
		
		return result;
		
	}

}
