package ListaEncadeada;

import static java.lang.System.out;

import mvc.model.Pessoa;

public class ListaOrdenada<T extends Comparable<T>> extends ListaEncadeada<T> {

	private Nodo<T> procuraNodo(T data) {
		Nodo<T> nodo = head;
		Nodo<T> anterior = null;
		
		while (nodo != null) {
			int cmp = nodo.getData().compareTo(data);
			
			if (cmp == 0)
				return nodo;
			
			if (cmp > 0)
			{					
				return anterior;
			}
			anterior = nodo;
			nodo = nodo.getNext();
		}
		
		return nodo;
	}

	@Override
	public void insert(Nodo<T> novo)
	{
		Nodo<T> anterior = procuraNodo(novo.getData());
		
		if (anterior != null) 
		{
			novo.setNext(anterior.getNext());
			anterior.setNext(novo);
			
			if (anterior == tail)
				tail = novo;
			
			
		} else {
			if (tail != null) {
				tail.setNext(novo);
			} else {
				head = novo;
			}
			tail = novo;
		}
	}
	
	@Override
	public void insert(Nodo<T> novo, Nodo<T> anterior)
	{
		insert(novo);
	}
	
	@Override
	public void append(Nodo<T> novo) {
		insert(novo);
	}


}


