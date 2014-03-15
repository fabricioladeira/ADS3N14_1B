
import ListaEncadeada.ListaEncadeada;
import mvc.controller.PessoaController;
import mvc.view.CompactView;
import mvc.view.ExtendedView;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PessoaController controller = new PessoaController();
		controller.criarContato();
		
		controller.exibirContato(new ExtendedView());
		controller.exibirContato(new CompactView());
		
	}

}
