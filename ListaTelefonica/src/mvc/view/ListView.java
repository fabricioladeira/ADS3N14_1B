package mvc.view;

import static java.lang.System.out;
import mvc.model.Pessoa;
import ListaEncadeada.ListaOrdenada;
import ListaEncadeada.Nodo;
public class ListView {
	
	public void printContatos(ListaOrdenada<Pessoa> value)
	{		
	
		Nodo<Pessoa> elem = value.getHead();
		do {
			out.println(((Pessoa)elem.getData()).getNome() + "  Telefone: " + ((Pessoa)elem.getData()).getTelefone());
			elem = elem.getNext();
		} while (elem != null);		
		
		
		//value.print();
	}
	
}
