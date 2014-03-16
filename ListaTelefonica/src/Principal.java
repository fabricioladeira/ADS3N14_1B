
import ListaEncadeada.ListaEncadeada;
import ListaEncadeada.ListaOrdenada;
import mvc.controller.ListaTelefonicaController;
import mvc.controller.PessoaController;
import mvc.model.Pessoa;
import mvc.view.CompactView;
import mvc.view.ExtendedView;
import mvc.view.MenuHelpView;

public class Principal {
	
	private static ListaOrdenada<Pessoa> lista = new ListaOrdenada<Pessoa>();
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		//Exibe Help
				MenuHelpView view = new MenuHelpView();
				view.Exibir();
		
		//Cria controler da Lista Telefonica
		ListaTelefonicaController controller = new ListaTelefonicaController(lista);
		controller.exibirMenuOpcoes();
		
		
		
		
		//controller.exibirContato(new ExtendedView());
		//controller.exibirContato(new CompactView());		
		
		
	}

}
