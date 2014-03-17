package mvc.controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import ListaEncadeada.ListaEncadeada;
import ListaEncadeada.ListaOrdenada;
import ListaEncadeada.Nodo;
import mvc.model.Pessoa;
import mvc.view.ContatoView;
import mvc.view.ListBuscaView;

public class PessoaController {
	
	private ListaOrdenada<Pessoa> lista;
	
	public PessoaController(ListaOrdenada<Pessoa> value)
	{
		lista = value;	
	}
	
	public void criarContatos()
	{						
		
		//Pega o diretorio da app
		String workingDir = System.getProperty("user.dir");
		
		//Abre arquivo
		File file = new File(workingDir + "\\src\\dados.txt");
		BufferedReader reader = null;	
		
		try {
		    reader = new BufferedReader(new FileReader(file));
		    String text = null;

		    while ((text = reader.readLine()) != null) {		    	
		    	
		    	String[] linha = text.split("\\|");
		    	
		    	Pessoa p = new Pessoa();
				p.setNome(linha[0]);
				p.setTelefone(linha[1]);
				
				
				InserirContato(p);
		        
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        if (reader != null) {
		            reader.close();
		        }
		    } catch (IOException e) {
		    }
		}		
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
	
	/*
	 * Retorna pessoa Anterior
	 */
	public Nodo<Pessoa> getAnterior(Nodo<Pessoa> pessoa)
	{
		Nodo<Pessoa> inicio = lista.getHead();
		Nodo<Pessoa> anterior = null;
		
		while (inicio != pessoa) {
			anterior = 	inicio;		
		    inicio = inicio.getNext();
		}
		
		return anterior;
	}
	
	/*
	 * Bunsca por nome
	 */
	public void findPessoa(String palavrachave)
	{
		ListBuscaView viewBusca = new ListBuscaView();
		viewBusca.findPessoa(palavrachave, lista);		
		
	}
	
	
	/*
	 * Remove uma determinada pessoa da lista
	 */
	public void removePessoa(String nome)
	{
		Nodo<Pessoa> inicio = lista.getHead();		
	
		while (inicio != lista.getTail()) {		
		
		   int cmp = inicio.getData().getNome().toUpperCase().compareTo(nome.toUpperCase());
		   if(cmp == 0)
		   {
			   lista.remove(inicio);
			   break;
		   }		   
		   inicio = inicio.getNext();
		}		
		
	}
	
}