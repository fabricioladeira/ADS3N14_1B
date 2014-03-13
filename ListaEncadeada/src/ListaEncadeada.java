import static java.lang.System.out;

public class ListaEncadeada {

	private Nodo head;
	private Nodo tail;
	
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
	
		
	public void print(Nodo head2) {
		// TODO Auto-generated method stub
		Nodo elem = head;
		do {
			out.println(elem.getData());
			elem = elem.getNext();
		} while (elem != null);
	}


	public void insert(Nodo novo)
	{
		novo.setNext(head);
		head = novo;		
	}	
	public void insert(Nodo novo, Nodo anterior)
	{
		novo.setNext(anterior.getNext());
		anterior.setNext(novo);	
	}	
	
	public void append(Nodo novo)
	{
		if(tail != null)
			tail.setNext(novo);
		else
			head = novo;
	}	
}