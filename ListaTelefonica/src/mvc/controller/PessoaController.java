package mvc.controller;
import ListaEncadeada.ListaEncadeada;
import ListaEncadeada.Nodo;
import mvc.model.Pessoa;
import mvc.view.ContatoView;

public class PessoaController {
	
	ListaEncadeada<Pessoa> lista;
	
	public PessoaController(ListaEncadeada<Pessoa> value)
	{
		lista = value;	
	}
	
	public void criarContato()
	{	
		Pessoa contato = new Pessoa();
		contato.setNome("Rafael");
		contato.setTelefone("555-1234");
		
		InserirContato(contato);
	}
	
	//Insere contato na lista
	public void InserirContato(Pessoa contato)
	{		
		Nodo<Pessoa> pessoa = new Nodo<Pessoa>(contato);
		lista.insert(pessoa);		
	}
	
	//Exibe um contato
	public void exibirContato(ContatoView view , Pessoa contato)
	{
		view.printContato(contato.getNome(), contato.getTelefone());
	}	
	
	
}