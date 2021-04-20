
public class Pokemon {
	public char ativo;
	public String nome;
	public int nivel;
	public String tipo;
	
	public String mostrarDadosPokemon() {
		String dados =  "\nNome    : "+this.nome+
			     		"\nNível   : "+this.nivel+
			     		"\nTipo    : "+this.tipo;
		return dados;
	}

}
