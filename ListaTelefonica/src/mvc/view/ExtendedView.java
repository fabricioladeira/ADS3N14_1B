package mvc.view;

import static java.lang.System.out;
import mvc.model.Pessoa;

public class ExtendedView extends ContatoView {

	public void printContato(Pessoa contato)
	{
		out.println("Nome: " + contato.getNome());
		out.println("Telefone: " + contato.getTelefone());
	}
	
}
