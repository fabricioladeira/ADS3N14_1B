
public class ListaOrdenada extends CompareTo<Nodo> extends ListaEncadeada{

	public static void main(String[] args) {
		//criar lista
		ListaEncadeada lista = new ListaEncadeada();
		
		Nodo head = new Nodo(), novo;
		head.setData(2);
		
		novo = new Nodo(3);
		lista.insert(novo, head);
		
		novo = new Nodo(1);
		lista.insert(head, novo);
		
		head = novo;
		
		lista.print(head);
	}
	
	@Override
	public void append(Nodo novo)
	{
		insert(novo);	
	}
	
	@Override
	public void insert(Nodo novo)
	{
		Nodo anterior = procurarNodo(novo.getData());
	}

	private Nodo procurarNodo(int data) {
		// TODO Auto-generated method stub
		
		Nodo nodo = head;
		Nodo anterior = null;
		
		while(nodo != null)
		{
			int cmp = nodo.getData().compareTo(data);
			if(cmp == 0)
				return nodo;
			
			if(cmp > 0)
				return anterior;				
				
			anterior = nodo;
			nodo= nodo.getNext();		
		}
		return null;
	}
}
