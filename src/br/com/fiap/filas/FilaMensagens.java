package br.com.fiap.filas;

import br.com.fiap.entidades.Mensagem;

/* Julio Cesar Lopes Batista  RM:94543
 * Lucca de Freitas           RM:94267
 * Gregory Cedraz             RM:94404
 * Victor Mori                RM:93121
 */
public class FilaMensagens {
	
	private final int num;
	private Mensagem respostas[];
	private int ini,fim,cont;

	public FilaMensagens(int num) {
		this.num = num;
		respostas = new Mensagem[num];
		
	}

	public void init() {
		ini = fim= cont =0;
	}

	public boolean isEmpty() {
		return cont==0;
	}

	public boolean isFull() {
		return cont == num;

	}

	// throws exige que seja tratada
	public void enqueue(Mensagem mensagem) {
		respostas[fim] = mensagem;
		fim = (fim+1)% num;
		cont++;
	}

	public Mensagem dequeue() {
		Mensagem msg = respostas[ini];
		ini = (ini+1)% num;
		cont--;
		return msg;
	}

}
