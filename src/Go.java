
public class Go {

	public static void main(String[] args) {

		BatalhaPokemon.hello();
		BatalhaPokemon bp = new BatalhaPokemon();
		Treinador t1 = null;
		Treinador t2 = null;
		Treinador tSelecionado = null;

		int opcao;

		do {
			opcao = menu();
			switch (opcao) {
			case 1:
				System.out.println("=> Dados TREINADOR 1:");
				Utils.limparBuffer();
				t1 = new Treinador(Utils.recebeString("Nome: "), Utils.recebeChar("Sexo: "));
				t1.salvarTreinador();
				
				System.out.println("=> Dados TREINADOR 2:");
				Utils.limparBuffer();
				t2 = new Treinador(Utils.recebeString("Nome: "), Utils.recebeChar("Sexo: "));
				t2.salvarTreinador();
				
				break;

			case 2:
				if (tSelecionado != null) {
					System.out.println(tSelecionado.mostrarDadosTreinador());
				} else {
					System.out.println("Nenhum treinador selecionado!");
				}

				break;

			case 3:

				if (Utils.recebeInt("Deseja selecionar qual treinador (1 ou 2)? ") == 1) {
					tSelecionado = t1;
				} else {
					tSelecionado = t2;
				}
				System.out.println("Selecionado: \n" + tSelecionado.mostrarDadosTreinador());

				break;

			case 4:
				if (tSelecionado != null) {
					int index = tSelecionado.buscaSlotVazio();

					if (index != -1) {
						tSelecionado.pokedex[index] = bp.tentarCapturar();
					} else {
						System.out.println("Slots já preenchidos!");
					}
				} else {
					System.out.println("Nenhum treinador selecionado!");
				}

				break;
				
			case 5:
				if (tSelecionado != null) {
					tSelecionado.mostrarListaPokemon();
				} else {
					System.out.println("Nenhum treinador selecionado!");
				}

				break;
				
			case 6:
				if (tSelecionado != null) {
					tSelecionado.salvarTreinador();
				} else {
					System.out.println("Nenhum treinador selecionado!");
				}

				break;
				
			case 7:
				Treinador.listarTodosTreinadoresCadastrados();

				break;

			case 0:
				System.out.println("Obrigado por jogar POKEMON LTPII");
				break;

			default:
				System.err.println("Opção Inválida!");
				break;
			}
		} while (opcao != 0);

	}

	public static int menu() {
		int opcao;

		do {
			System.out.println("===== MENU =====");
			System.out.println("  1 - Inscrever Treinadores");
			System.out.println("  2 - Mostrar Dados Treinador");
			System.out.println("  3 - Selecionar Treinador");
			System.out.println("  4 - Capturar Pokemon");
			System.out.println("  5 - Listar Pokemons Capturados");
			System.out.println("  6 - Salvar Treinador");
			System.out.println("  7 - Listar Todos Treinadores Cadastrados");
			System.out.println("  0 - SAIR");
			opcao = Utils.recebeInt("Opção: ");

		} while (opcao < 0);

		return opcao;

	}
}
