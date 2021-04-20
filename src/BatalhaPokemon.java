public class BatalhaPokemon {

	private Pokemon pokemon;

	private String[] listaPokemon = { "Bulbasaur", "Ivysaur", "Venusaur", "Charmander", "Charmeleon", "Charizard",
			"Squirtle", "Wartortle", "Blastoise", "Caterpie", "Metapod", "Butterfree", "Weedle", "Kakuna", "Beedrill",
			"Pidgey", "Pidgeotto", "Pidgeot", "Rattata", "Raticate", "Spearow", "Fearow", "Ekans", "Arbok", "Pikachu",
			"Raichu", "Sandshrew", "Sandslash", "NidoranF", "Nidorina", "Nidoqueen", "NidoranM", "Nidorino", "Nidoking",
			"Clefairy", "Clefable", "Vulpix", "Ninetales", "Jigglypuff", "Wigglytuff", "Zubat", "Golbat", "Oddish",
			"Gloom", "Vileplume", "Paras", "Parasect", "Venonat", "Venomoth", "Diglett" };

	private String[] listaTipos = { "Planta/Venenoso", "Planta/Venenoso", "Planta/Venenoso", "Fogo", "Fogo",
			"Fogo/Voador", "Água", "Água", "Água", "Inseto", "Inseto", "Inseto", "Inseto", "Inseto", "Inseto/Voador",
			"Voador", "Voador", "Voador", "Normal", "Normal", "Voador", "Voador", "Venenoso", "Venenoso", "Elétrico",
			"Elétrico", "Terra", "Terra", "Normal", "Normal", "Normal", "Normal", "Normal", "Normal", "Fada", "Fada",
			"Fogo", "Fogo", "Normal/Fada", "Normal/Fada", "Venenoso/Voador", "Venenoso/Voador", "Grama/Venenoso",
			"Grama/Venenoso", "Grama/Venenoso", "Inseto/Grama", "Inseto/Grama", "Inseto/Venenoso", "Inseto/Venenoso",
			"Terra" };

	private boolean procurarPokemon() {

		if (Utils.valorAleatorio(0, 6) > 4) {
			System.out.println("=============== NENHUM POKéMON ===============");
			this.pokemon = null;
			return false;
		} else {
			System.out.println("=============== VOCÊ ENCONTROU UM POKéMON ===============");
			int rand = Utils.valorAleatorio(0, listaPokemon.length - 1);
			Pokemon pk = new Pokemon();
			pk.ativo = 'S';
			pk.nome = listaPokemon[rand];
			pk.tipo = listaTipos[rand];
			pk.nivel = Utils.valorAleatorio(2, 40);

			System.out.println(pk.mostrarDadosPokemon());

			this.pokemon = pk;
			return true;
		}
	}

	public Pokemon tentarCapturar() {

		if (procurarPokemon()) {

			return capturarPokemon();
		} else {
			return null;
		}

	}

	public void batalhaPokemon(Pokemon p1, Pokemon p2) {
		int power1 = Utils.valorAleatorio(0, p1.nivel);
		int power2 = Utils.valorAleatorio(0, p2.nivel);

		if (power1 > power2) {
			System.out.println(p1.nome + " nível: " + p1.nivel + " VENCEU!");
			System.out.println(p2.nome + " nível: " + p2.nivel + " PERDEU!");
		} else {
			System.out.println(p1.nome + " nível: " + p1.nivel + " PERDEU!");
			System.out.println(p2.nome + " nível: " + p2.nivel + " VENCEU!");
		}
	}

	private Pokemon capturarPokemon() {

		if (this.pokemon != null) {
			if (Utils.valorAleatorio(0, 7) > 2) {
				System.out.println("=============== CAPTURADO ===============");
				return this.pokemon;
			} else {
				System.out.println("=============== FALHOU ===============");
				return null;
			}
		}
		return null;
	}

	public static void hello() {
		System.out.println("                                ,'\\\r\n"
				+ "    _.----.        ____         ,'  _\\   ___    ___     ____\r\n"
				+ "_,-'       `.     |    |  /`.   \\,-'    |   \\  /   |   |    \\  |`.\r\n"
				+ "\\      __    \\    '-.  | /   `.  ___    |    \\/    |   '-.   \\ |  |\r\n"
				+ " \\.    \\ \\   |  __  |  |/    ,','_  `.  |          | __  |    \\|  |\r\n"
				+ "   \\    \\/   /,' _`.|      ,' / / / /   |          ,' _`.|     |  |\r\n"
				+ "    \\     ,-'/  /   \\    ,'   | \\/ / ,`.|         /  /   \\  |     |\r\n"
				+ "     \\    \\ |   \\_/  |   `-.  \\    `'  /|  |    ||   \\_/  | |\\    |\r\n"
				+ "      \\    \\ \\      /       `-.`.___,-' |  |\\  /| \\      /  | |   |\r\n"
				+ "       \\    \\ `.__,'|  |`-._    `|      |__| \\/ |  `.__,'|  | |   |\r\n"
				+ "        \\_.-'       |__|    `-._ |              '-.|     '-.| |   |\r\n"
				+ "                                `'                            '-._|");
	}

}
