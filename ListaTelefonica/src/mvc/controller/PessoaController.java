package mvc.controller;
import ListaEncadeada.ListaEncadeada;
import ListaEncadeada.ListaOrdenada;
import ListaEncadeada.Nodo;
import mvc.model.Pessoa;
import mvc.view.ContatoView;

public class PessoaController {
	
	private ListaOrdenada<Pessoa> lista;
	
	public PessoaController(ListaOrdenada<Pessoa> value)
	{
		lista = value;	
	}
	
	public void criarContato()
	{	
		Pessoa contato = new Pessoa();
		contato.setNome("Rafael");
		contato.setTelefone("555-1234");
		
		
		Pessoa contato2 = new Pessoa();
		contato2.setNome("Adriana");
		contato2.setTelefone("212-2121");
		
		
		Pessoa contato3 = new Pessoa();
		contato3.setNome("Zé");
		contato3.setTelefone("12-1212");
		
		
		InserirContato(contato);
		InserirContato(contato2);
		InserirContato(contato3);
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