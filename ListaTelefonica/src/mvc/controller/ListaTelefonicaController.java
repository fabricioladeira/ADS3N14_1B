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

import java.io.Console;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import static java.lang.System.out;

public class ListaTelefonicaController {

	public ListaEncadeada<Pessoa> lista;
	private Pessoa contato;	
	private PessoaController controller;
	
	public ListaTelefonicaController(ListaEncadeada<Pessoa> value)
	{
		lista = value;	
		
		//Cria o obj de controle de pessoa
		controller = new PessoaController(lista);	
		
		//Cria e carrega a lista de contatos a primeira vez		
		controller.criarContato();		
		
	}
	
	
	public void criarContato()
	{	
		contato = new Pessoa();
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
	
	public void exibirContato( ContatoView view )
	{
		view.printContato(contato.getNome(), contato.getTelefone());
	}	
	
	
	
	//Exibe menu de op��es
	public void exibirMenuOpcoes()
	{
		Scanner entrada = new Scanner(System.in); // J� consigo separara a linha e pegar o tipo n�o precisa
		
		String comand = "";	
		
		while (comand.toUpperCase() != "SAIR") {
			
			//Pega comando
			comand = entrada.next(); // Pega so o string do commando S� pegando o retirar  next line e pegar o tipo que eu quero direto.
			
		
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
		
						case "LISTAR":												
							//Implementar rotina de salvar						
							ListView listView = new ListView();
							listView.printContatos(lista);
								
							break;		
							
						
							
						case "HELP": // HELP
							MenuHelpView view = new MenuHelpView();
							view.Exibir();
								
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
		System.out.println("Par�metro invalido...");	
	
	}
	
}