import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Treinador {
	public char ativo;
	public int id;
	public String nome;
	public int numInsigneas;
	public char sexo;
	public Pokemon pokedex[];

	public Treinador() {
		this.ativo = 'S';
		this.id = 0;
		this.nome = "";
		this.numInsigneas = 0;
		this.sexo = ' ';
		this.pokedex = new Pokemon[6];
	}
	
	public Treinador(String nome, char sexo) {
		this.ativo = 'S';
		this.id = Treinador.idAutoIncremento();
		this.nome = nome;
		this.numInsigneas = 0;
		this.sexo = sexo;
		this.pokedex = new Pokemon[6];
	}

	public String mostrarDadosTreinador() {
		String dados = "\nId      : " + this.id + "\nNome      : " + this.nome + "\nInsigneas : " + this.numInsigneas + "\nSexo      : "
				+ this.sexo + "\nTotal PK  : " + totalPokemonsCapturado();
		return dados;
	}

	public int totalPokemonsCapturado() {
		int totalPokemons = 0;

		for (int i = 0; i < this.pokedex.length; i++) {
			if (this.pokedex[i] != null) {
				totalPokemons++;
			}
		}

		return totalPokemons;
	}

	public int buscaSlotVazio() {
		for (int i = 0; i < this.pokedex.length; i++) {
			if (this.pokedex[i] == null) {
				return i;
			}
		}
		return -1;
	}

	public void mostrarListaPokemon() {
		for (int i = 0; i < totalPokemonsCapturado(); i++) {
			System.out.println(this.pokedex[i].mostrarDadosPokemon());
		}
	}

	public void salvarTreinador() {
		try {
			RandomAccessFile arqTreinador = new RandomAccessFile("TREINADOR.POKEMON", "rw");
			arqTreinador.seek(arqTreinador.length());
			arqTreinador.writeChar(this.ativo);
			arqTreinador.writeInt(this.id);
			arqTreinador.writeUTF(this.nome);
			arqTreinador.writeInt(this.numInsigneas);
			arqTreinador.writeChar(this.sexo);
			
			arqTreinador.close();
			System.out.println("Salvou com sucesso!");
			
			//this.pokedex = new Pokemon[6];

		} catch (IOException e) {
			System.out.println("Erro ao abrir o arquivo!");
			System.exit(0);
		}
	}

	private static int idAutoIncremento() {
		Treinador t = new Treinador();			
		
		try {
			RandomAccessFile arqTreinador = new RandomAccessFile("TREINADOR.POKEMON", "rw");
			arqTreinador.seek(0);
			
			while (true) {
				t.ativo        = arqTreinador.readChar();
				t.id           = arqTreinador.readInt();
				t.nome         = arqTreinador.readUTF();
				t.numInsigneas = arqTreinador.readInt();
				t.sexo         = arqTreinador.readChar();
			}
			
		} catch (EOFException e) {
			
			return ++t.id;
		} catch (IOException e) {
			System.out.println("Erro ao abrir o arquivo!");
			System.exit(0);
		}
		return 1;
	}
	
	public static void listarTodosTreinadoresCadastrados() {
		try {
			Treinador t = new Treinador();			
			RandomAccessFile arqTreinador = new RandomAccessFile("TREINADOR.POKEMON", "rw");
			arqTreinador.seek(0);
			
			while (true) {
				t.ativo        = arqTreinador.readChar();
				t.id           = arqTreinador.readInt();
				t.nome         = arqTreinador.readUTF();
				t.numInsigneas = arqTreinador.readInt();
				t.sexo         = arqTreinador.readChar();
				System.out.println(t.mostrarDadosTreinador());
			}
			
			//this.pokedex = new Pokemon[6];

		} catch (EOFException e) {
			
			System.out.println("Nenhum treinador cadastrado!");			
		} catch (IOException e) {
			System.out.println("Erro ao abrir o arquivo!");
			System.exit(0);
		}
	}
	
	/*public static Treinador carregarTreinador() {
		
	}*/
}
