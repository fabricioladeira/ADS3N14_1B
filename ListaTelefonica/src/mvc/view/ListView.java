package mvc.view;

import static java.lang.System.out;
import mvc.model.Pessoa;
import ListaEncadeada.ListaEncadeada;
import ListaEncadeada.Nodo;
public class ListView {
	
	public void printContatos(ListaEncadeada<Pessoa> value)
	{		
	
		Nodo<Pessoa> elem = value.getHead();
		do {
			out.println(((Pessoa)elem.getData()).getNome() + "  Telefone: " + ((Pessoa)elem.getData()).getTelefone());
			elem = elem.getNext();
		} while (elem != null);		
		
		
		//value.print();
	}
	
}
