
public class Navio {
	
	private int id;
	private int tamanho;

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
	
	public Navio(int id, int tamanho)
	{
		this.setId(id);
		this.setTamanho(tamanho);		
	}

}
