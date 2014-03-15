package mvc.model;

public class Pessoa implements Comparable<Pessoa> {
	
	private String nome;
	private String telefone;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
		
	@Override
	public int compareTo(Pessoa pessoa) {  
        // TODO Auto-generated method stub  
        return this.nome.compareTo(pessoa.getNome());  
    }  
	
	
	/*
	public int compareTo(int n1, int n2) {      
        if (n1 < n2) return -1; //n1 vem primeiro na ordenação  
        if (n1 == n2) return 0; //ambos sao equivalentes na ordenação  
        return 1;         //n1 vem depois de n2 na ordenação  
     }   
     */
	
}