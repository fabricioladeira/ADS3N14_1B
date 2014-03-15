package mvc.controller;

import java.util.Scanner;

import ListaEncadeada.ListaEncadeada;
import ListaEncadeada.Nodo;
import mvc.model.Pessoa;
import mvc.view.ContatoView;
import mvc.view.MenuHelpView;

import java.io.Console;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import static java.lang.System.out;

public class PessoaController {

	public ListaEncadeada<Pessoa> lista = new ListaEncadeada<Pessoa>();
	private Pessoa contato;
	
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
	
	
	
	//Exibe menu de opções
	public void exibirMenuOpcoes()
	{
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
							//pega dados da largura altura e tipo de cor
							
							break;
		
						case "LISTAR":												
							//Implementar rotina de salvar						
							
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
		System.out.println("Parâmetro invalido...");	
	
	}
	
}