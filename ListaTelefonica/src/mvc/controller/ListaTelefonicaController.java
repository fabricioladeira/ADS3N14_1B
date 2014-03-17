package mvc.controller;

import java.util.Scanner;

import ListaEncadeada.ListaEncadeada;
import ListaEncadeada.ListaOrdenada;
import ListaEncadeada.Nodo;
import mvc.model.Pessoa;
import mvc.view.ContatoView;
import mvc.view.ExtendedView;
import mvc.view.ListView;
import mvc.view.MenuHelpView;


public class ListaTelefonicaController {

	public ListaOrdenada<Pessoa> lista;
	private Pessoa contato;	
	private PessoaController controller;
	
	public ListaTelefonicaController(ListaOrdenada<Pessoa> value)
	{
		lista = value;	
		
		//Cria o obj de controle de pessoa
		controller = new PessoaController(lista);	
		
		//Cria e carrega a lista de contatos a primeira vez		
		controller.criarContatos();		
		
	}
	
	
		
	//Insere contato na lista
	public void InserirContato(Pessoa contato)
	{		
		Nodo<Pessoa> pessoa = new Nodo<Pessoa>(contato);
		lista.insert(pessoa);		
	}
	
	public void exibirContato( ContatoView view )
	{
		view.printContato(contato.getNome(), contato.getTelefone());
	}	
	
	
	
	//Exibe menu de opções
	public void exibirMenuOpcoes()
	{
		//Inicializa varial da view do contato
		ContatoView viewContato = null;
		
		//Pega primeira pessoa na posição para fazer a navegação
		Nodo<Pessoa> pessoa = lista.getHead();
		
		Scanner entrada = new Scanner(System.in); // Já consigo separara a linha e pegar o tipo não precisa
		
		String comand = "";	
		
		while (comand.toUpperCase() != "SAIR") {
			
			//Pega comando
			comand = entrada.next(); // Pega so o string do commando Só pegando o retirar  next line e pegar o tipo que eu quero direto.
			
		
			try{
			
				if(comand != "SAIR")
				{
					switch (comand.toUpperCase()) 
					{
						case "INCLUIR":
							//Pega proximos dados e inclui a pessoa na lista encadeada
							Pessoa contato = new Pessoa();
							contato.setNome(entrada.next());
							contato.setTelefone(entrada.next());
							
							controller.InserirContato(contato);
							controller.exibirContato(new ExtendedView(), contato);							
							break;
							
						case "BUSCAR":
							//Listar digitando um nome							
							controller.findPessoa(entrada.next());							
							break;
		
						case "REMOVER":
							controller.removePessoa(entrada.next());							
							break;
							
						case "LISTAR":												
							//Implementar rotina de salvar						
							ListView listView = new ListView();
							listView.printContatos(lista);
								
							break;		
												
						case "PROXIMO":
							viewContato = new ExtendedView();
							if(pessoa.getNext() != null)								
								pessoa = pessoa.getNext();
							
							viewContato.printContato(pessoa.getData().getNome(), pessoa.getData().getNome());							
							break;
							
						case "ANTERIOR":
							viewContato = new ExtendedView();	
							if(pessoa != lista.getHead())
								pessoa = controller.getAnterior(pessoa);
							
							viewContato.printContato(pessoa.getData().getNome(), pessoa.getData().getNome());		
							
							break;
							
						case "HELP": // HELP
							MenuHelpView viewHelp = new MenuHelpView();
							viewHelp.Exibir();								
							break;			
													
						default:				
							
							
							System.out.println("Comando invalido digite HELP...");
							break;
					}
					
					System.out.println("OK...");
				
				}	
			
			}
			catch(Exception ex)
			{								
				MessageErro();	
			}
			
			
		}
	
		
		System.out.println("Fim");
	}

	public static void MessageErro()
	{
		System.out.println("Parâmetro invalido...");	
	
	}
	
}