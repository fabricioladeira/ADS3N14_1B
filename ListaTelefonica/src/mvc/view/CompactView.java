package mvc.view;

import static java.lang.System.*;
import mvc.model.Pessoa;

public class CompactView extends ContatoView {

	@Override
	public void printContato(Pessoa contato) {
		out.println(String.format("Contato: %s - %s", contato.getNome(), contato.getTelefone()));
	}

}
