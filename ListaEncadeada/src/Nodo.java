public class Nodo {
	
	private int  dado;
	private Nodo next;

	public Nodo()
	{
		dado = 0;
	}
	
	public Nodo(int i)
	{
		dado = i;
		next = null;
	}
	
	public void setData(int i)
	{
		dado = i;
		next = null;
	}
	
	public int getData()
	{
		return dado;
	}

	public void setNext(Nodo next)
	{
		this.next = next;
	}
	
	public Nodo getNext()
	{
		return next;
	}
		
}
