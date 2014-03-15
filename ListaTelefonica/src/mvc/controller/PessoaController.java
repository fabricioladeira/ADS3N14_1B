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

public class PessoaController {
	
	private ListaOrdenada<Pessoa> lista;
	
	public PessoaController(ListaOrdenada<Pessoa> value)
	{
		lista = value;	
	}
	
	public void criarContato()
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
	
	
}