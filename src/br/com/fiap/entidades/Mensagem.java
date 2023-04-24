package br.com.fiap.entidades;

/* Julio Cesar Lopes Batista
 * Lucca de Freitas
 * Gregory Cedraz 
 * Victor Mori
 */

public class Mensagem {
	// O nome no main deve ser opcional
	String nome;
	String descricao;

	// Utilizar essa variavel para atribuir o identificador, no main definir quando
	// será telefone ou email
	String indentificador;

	// (1-reclamação/ 2-sugestão)
	int motivoContato;

	// Usar esse construstor quando não for necessário usar o nome
	public Mensagem(String descricao, String indentificador, int motivoContato) {
		this.descricao = descricao;
		this.indentificador = indentificador;
		this.motivoContato = motivoContato;
	}
	// Usar esse construstor quando for necessário usar o nome
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
		return getClass().getName() + "@" + Integer.toHexString(hashCode());
		}
	
	/*public String toString() {
		return "Nome: "+nome+"\nMensagem: "+descricao+"\n Identificador: "+indentificador+" \n Motivo de contato: "+motivoContato;
		}*/
	
}
