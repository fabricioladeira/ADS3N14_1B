package mvc.view;

import static java.lang.System.out;
import mvc.model.Pessoa;
import ListaEncadeada.ListaOrdenada;
import ListaEncadeada.Nodo;

public class ListBuscaView {

	
	public void findPessoa(String palavrachave, ListaOrdenada<Pessoa> lista)
	{
		Nodo<Pessoa> inicio = lista.getHead();		
		
		while (inicio != lista.getTail()) {		
		
		   boolean cmp = inicio.getData().getNome().toUpperCase().contains(palavrachave.toUpperCase());
		   if(cmp)
		   {
			   out.println(((Pessoa)inicio.getData()).getNome() + "  Telefone: " + ((Pessoa)inicio.getData()).getTelefone());			   
		   }		   
		   inicio = inicio.getNext();
		}		
		
		
	}
}
