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
				return anterior;
			anterior = nodo;
			nodo = nodo.getNext();
		}
		
		return nodo;
	}

	@Override
	public void insert(Nodo<T> novo)
	{
		Nodo<T> anterior = procuraNodo(novo.getData());
		
		if (anterior != null) {
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
	
	public static void main(String[] args) {
		
		
		// criar lista
		ListaOrdenada<Pessoa> lista = new ListaOrdenada<Pessoa>();
				
		Pessoa p1 = new Pessoa();
		p1.setNome("Ze");
		p1.setTelefone("2323");
		Nodo<Pessoa> novo1 = new Nodo<Pessoa>(p1);
		
		Pessoa p2 = new Pessoa();
		p2.setNome("Adriana");
		p2.setTelefone("76128712");
		Nodo<Pessoa> novo2 = new Nodo<Pessoa>(p2);
		
		Pessoa p3 = new Pessoa();
		p3.setNome("Fabricio");
		p3.setTelefone("76128712");
		Nodo<Pessoa> novo3 = new Nodo<Pessoa>(p3);
		
		
		lista.append(novo1);
		lista.append(novo2);
		lista.append(novo3);
		
		Nodo<Pessoa> elem = lista.getHead();
		do {
			out.println(((Pessoa)elem.getData()).getNome() + "  Telefone: " + ((Pessoa)elem.getData()).getTelefone());
			elem = elem.getNext();
		} while (elem != null);		
		
	
		
		
	/*
		
		// criar lista
		ListaOrdenada<Integer> lista = new ListaOrdenada<Integer>();
		
		Nodo<Integer> novo = new Nodo<Integer>(1);
		lista.append(novo);		
		lista.append(new Nodo<Integer>(3));
		lista.append(new Nodo<Integer>(2));		
		lista.append(new Nodo<Integer>(4));
		
		lista.print();
		
		*/
		
		
		
		
	}

}


