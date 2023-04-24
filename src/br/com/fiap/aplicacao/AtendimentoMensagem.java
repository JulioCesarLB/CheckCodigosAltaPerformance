package br.com.fiap.aplicacao;

import java.util.Scanner;

import br.com.fiap.entidades.Mensagem;
import br.com.fiap.filas.FilaMensagens;

/* Julio Cesar Lopes Batista  RM:94543
 * Lucca de Freitas           RM:94267
 * Gregory Cedraz             RM:94404
 * Victor Mori                RM:93121
 */
public class AtendimentoMensagem {

	static FilaMensagens filaReclamacao = new FilaMensagens(10);
	static FilaMensagens filaSugestao = new FilaMensagens(10);
	static FilaMensagens filaResolucao = new FilaMensagens(10);
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		int opcao = 0;

		do {
			System.out.println("============= MENU =============");
			System.out.println("0. Encerrar o programa");
			System.out.println("1. Recebimento de mensagem");
			System.out.println("2. Atendimento de mensagem");
			System.out.println("3. Recebimento e Encaminhamento de resolucao");
			System.out.print("---> Digite a opcao desejada: ");
			opcao = in.nextInt();

			switch (opcao) {

			case 1:
				System.out.println("============= RECEBIMENTO DE MENSAGEM =============");
				System.out.println("Deseja informar seu nome? ");
				System.out.println("1. Sim");
				System.out.println("2. Nao");
				System.out.print("---> Digite a opcao desejada: ");
				int opcaoNome = in.nextInt();

				if (opcaoNome == 1) {
					Mensagem msg = new Mensagem(null, null, null, 0);
					System.out.print("---> Digite seu nome: ");
					String nome = in.next();
					msg.setNome(nome);

					// chamando metodo com o menu do recebimento de mensagem
					menuRecebimento();

				} else if (opcaoNome == 2) {

					// chamando metodo com o menu do recebimento de mensagem
					menuRecebimento();

				} else {
					System.out.println(" ! Opcao invalida ! ");
				}

				break;

			case 2:
				System.out.println("============= ATENDIMENTO DE MENSAGEM =============");
				System.out.println("Tipo de mensagem que deseja atendimento: ");
				System.out.println("1. Reclamacao");
				System.out.println("2. Sugestao");
				System.out.print("---> Digite a opcao desejada: ");
				int tipoContato = in.nextInt();

				if (!filaReclamacao.isEmpty() && tipoContato == 1) {
					Mensagem msgAtendimento = filaReclamacao.dequeue();
					System.out.println("Mensagem selecionada: " + msgAtendimento.getDescricao());
					System.out.println("Como deseja receber a resposta?");
					System.out.println("1. Resolucao automatica");
					System.out.println("2. Encaminhar para o setor analisar");
					System.out.print("---> Digite a opcao desejada: ");
					int tipoResolucao = in.nextInt();

					if (tipoResolucao == 1)
						System.out.println(
								"Enviada resposta para cliente: sua solicitacao ja foi resolvida. Obrigado!!!"); // simulacao
																													// de
																													// mensagem
					else if (tipoResolucao == 2) {
						filaResolucao.enqueue(msgAtendimento);
					} else
						System.out.println(" ! Opcao invalida ! ");
				} else if (!filaSugestao.isEmpty() && tipoContato == 2) {
					Mensagem msgAtendimento = filaSugestao.dequeue();
					System.out.println("Mensagem selecionada: " + msgAtendimento.getDescricao());
					System.out.println("Como deseja tratar a resposta?");
					System.out.println("1. Resolucao automatica");
					System.out.println("2. Encaminhar para o setor analisar");
					System.out.print("---> Digite a opcao desejada: ");
					int tipoResolucao = in.nextInt();

					if (tipoResolucao == 1)
						System.out.println(
								"Enviada resposta para cliente: sua solicitacao ja foi resolvida. Obrigado!!!"); // simulacao
																													// de
																													// mensagem
					else if (tipoResolucao == 2) {
						filaResolucao.enqueue(msgAtendimento);
					} else
						System.out.println(" ! Opcao invalida ! ");
				} else
					System.out.println(" ! Opcao invalida ! ");

				break;
			case 3:
				if (!filaResolucao.isEmpty()) {
					System.out.println("============= RECEBIMENTO E ENCAMINHAMENTO DE RESOLUCAO =============");
					Mensagem msgResolucao = filaResolucao.dequeue();
					System.out.println("Mensagem pendente: " + msgResolucao.getDescricao());
					System.out.println(
							"Enviada resposta para cliente: sua solicitacao ja foi resolvida pelo setor responsavel. Obrigado!!!");
				} else {
					System.out.println("Nenhuma Mensagem pendente! ");
				}
			
			}
			if(opcao==0 && (!filaResolucao.isEmpty() || !filaSugestao.isEmpty() || !filaReclamacao.isEmpty())) {
				System.out.println("Para finalizar o programa, todas as filas precisam estar vazias");
				opcao=-1;
			}
		} while (opcao != 0 ); // !filaReclamacao.isEmpty() && !filaResolucao.isEmpty() &&
								// !filaSugestao.isEmpty()
								// --- > oque eu tentei juliao (talvez seja necessario olhar o metodo)
		System.out.println("Programa Encerrado!");

	}

	public static void menuRecebimento() {
		Mensagem msg = new Mensagem(null, null, 0);

		System.out.println("Escolha entre Email ou Telefone: ");
		System.out.println("1. Email");
		System.out.println("2. Telefone");
		System.out.print("---> Digite a opcao desejada: ");
		int identificador = in.nextInt();

		in.nextLine();

		if (identificador == 1) {
			System.out.println("---> Informe seu Email: ");
			String email = in.next();
			msg.setIndentificador(email);
		} else {
			System.out.println("---> Informe seu Telefone: ");
			String tel = in.next();
			tel = String.valueOf(tel);
			msg.setIndentificador(tel);
		}

		System.out.println("Motivo do contato: ");
		System.out.println("1. Reclamacao");
		System.out.println("2. Sugestao");
		System.out.print("---> Digite a opcao desejada: ");
		int contato = in.nextInt();
		msg.setMotivoContato(contato);

		in.nextLine();

		if (contato == 1) {
			filaReclamacao.enqueue(msg);
			System.out.print("---> Mensagem: ");
			String mensagem = in.nextLine();
			System.out.println("---> Reclamacao adicionada a fila.");
			msg.setDescricao(mensagem);
		} else if (contato == 2) {
			filaSugestao.enqueue(msg);
			System.out.print("---> Mensagem: ");
			String mensagem = in.nextLine();
			System.out.println("---> Sugestao adicionada a fila.");
			msg.setDescricao(mensagem);
		} else
			System.out.println(" ! Opcao invalida ! ");

	}

}
