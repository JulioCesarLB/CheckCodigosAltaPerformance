package br.com.fiap.entidades;

/* Julio Cesar Lopes Batista  RM:94543
 * Lucca de Freitas           RM:94267
 * Gregory Cedraz             RM:94404
 * Victor Mori                RM:93121
 */

public class Mensagem {
	// O nome no main deve ser opcional
	String nome;
	String descricao;

	// Utilizar essa variavel para atribuir o identificador, no main definir quando
	// ser� telefone ou email
	String indentificador;

	// (1-reclama��o/ 2-sugest�o)
	int motivoContato;

	// Usar esse construstor quando n�o for necess�rio usar o nome
	public Mensagem(String descricao, String indentificador, int motivoContato) {
		this.descricao = descricao;
		this.indentificador = indentificador;
		this.motivoContato = motivoContato;
	}
	// Usar esse construstor quando for necess�rio usar o nome
	public Mensagem(String nome, String descricao, String indentificador, int motivoContato) {
		this.nome = nome;
		this.descricao = descricao;
		this.indentificador = indentificador;
		this.motivoContato = motivoContato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getIndentificador() {
		return indentificador;
	}

	public void setIndentificador(String indentificador) {
		this.indentificador = indentificador;
	}

	public int getMotivoContato() {
		return motivoContato;
	}

	public void setMotivoContato(int motivoContato) {
		this.motivoContato = motivoContato;
	}

	public String toString() {
		return "Mensagem [nome=" + nome + ", descricao=" + descricao + ", indentificador=" + indentificador
				+ ", motivoContato=" + motivoContato + "]";
	}
	
	
	
}
