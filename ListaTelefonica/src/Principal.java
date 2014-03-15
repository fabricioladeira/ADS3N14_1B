
import ListaEncadeada.ListaEncadeada;
import mvc.controller.PessoaController;
import mvc.view.CompactView;
import mvc.view.ExtendedView;
import mvc.view.MenuHelpView;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Cria o obj de controle de pessoa
		PessoaController controller = new PessoaController();
		
		
		//Cria e carrega a lista de contatos a primeira vez
		controller.criarContato();	
		controller.exibirMenuOpcoes();
		
		
		
		//controller.exibirContato(new ExtendedView());
		//controller.exibirContato(new CompactView());		
		
		
	}

}
