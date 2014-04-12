
public class Navio {
	
	// Tipo do Navio
	private int id; 
	
	//Tamanho do Navio
	private int tamanho;
	
	//Posicao Inicial X
	private int X;
	
	//Posicao inical Y;
	private int Y;

	
	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}
	
	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Navio(int id, int x, int y)
	{
		switch (id) {
		case 1:
			this.setTamanho(5);		
			break;
		
		case 2:
			this.setTamanho(4);		
			break;
			
		case 3:
			this.setTamanho(3);		
			break;
			
		case 4:
			this.setTamanho(2);		
			break;
			
		case 5:
			this.setTamanho(1);		
			break;

		default:
			break;
		}
		
	}



}
