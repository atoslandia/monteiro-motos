package projeto_poo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import projeto_poo.janelas.JanelaConfirmarEmail;
import projeto_poo.janelas.JanelaCriarConta;
import projeto_poo.janelas.JanelaEsqueciMinhaSenha;
import projeto_poo.janelas.JanelaLogin;

public class Programa {

	public static void main(String[] args) {
		
		new JanelaLogin();

//		Scanner leitor = new Scanner(System.in);
//		Persistencia persistencia = new Persistencia();
//		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("d/M/y");
//		CentralDeInformacoes recuperarCdi = persistencia.recuperarCentral("backup.xml");
//		
//		boolean sair = false; 
//		
//		while(!sair) {
//
//			System.out.println("opcoes:\n1. criar novo passageiro\n"
//					+ "2. listar todos os passageiros\n"
//					+ "3.exibir informacoes de um passageiro especifico"
//					+ "\n4. nova corrida\n5. listar todas corridas"
//					+ "\n6. listar corridas de um passageiro"
//					+ "\n7. gerar relatorio de solicitacoes de corridas"
//					+ "\n8. enviar historico de corridas"
//					+ "\ns. sair");
//			String opcao = leitor.nextLine();
//			
//			switch (opcao) {
//			case "1":
//				System.out.println("nome:"); String nome = leitor.nextLine();
//				System.out.println("sexo:"); Sexo sexo = Sexo.valueOf(leitor.nextLine());
//				System.out.println("dia de nascimento:"); int dia =  Integer.parseInt(leitor.nextLine());
//				System.out.println("mes de nascimento:"); int mes =  Integer.parseInt(leitor.nextLine());
//				System.out.println("ano de nascimento:"); int ano =  Integer.parseInt(leitor.nextLine());
//				System.out.println("email:"); String email = leitor.nextLine();
//				
//				Passageiro passageiro = new Passageiro(nome, sexo, LocalDate.of(ano, mes, dia), email);
//				if(recuperarCdi.adicionarPassageiro(passageiro))
//					System.out.println("deu certo");
//				else
//					System.out.println("nao deu certo");
//				persistencia.salvarCentral(recuperarCdi, "backup.xml");
//				break;
//			case "2":
//					System.out.println("dados dos passageiros:");
//					System.out.println(recuperarCdi.getTodosOsPassageiros());
//				break;
//			case "3":
//				System.out.println("email do passageiro:");
//				String emailEspecifico = leitor.nextLine();
//				System.out.println("nome: "+recuperarCdi.recuperarPassageiroPeloEmail(emailEspecifico).getNome());
//				System.out.println("sexo: "+recuperarCdi.recuperarPassageiroPeloEmail(emailEspecifico).getSexo());
//				System.out.println("data de nascimento: "+(recuperarCdi.recuperarPassageiroPeloEmail(emailEspecifico).getDataNascimento().format(formatador)));
//				System.out.println("email: "+recuperarCdi.recuperarPassageiroPeloEmail(emailEspecifico).getEmail()+"\n");
//				break;
//			case "4":
//				System.out.println("endereco:");
//				String endereco = leitor.nextLine();
//				System.out.println("destino:");
//				String destino = leitor.nextLine();
//				System.out.println("email do passageiro:");
//				emailEspecifico = leitor.nextLine();
//				Corrida corrida = new Corrida(endereco, destino, recuperarCdi.recuperarPassageiroPeloEmail(emailEspecifico));
//				if(recuperarCdi.adicionarCorrida(corrida))
//					System.out.println("deu certo");
//				else
//					System.out.println("nao deu certo");
//				persistencia.salvarCentral(recuperarCdi, "backup.xml");
//				break;
//			case "5":
//				System.out.println("dados das corridas:");
//				System.out.println(recuperarCdi.getTodasAsCorridas());
//				break;
//			case "6":
//				System.out.println("email do passageiro:");
//				emailEspecifico = leitor.nextLine();
//				System.out.println(recuperarCdi.recuperarCorridasDeUmPassageiro(emailEspecifico));
//				break;
//			case "7":
//				GeradorDeRelatorios.obterSolicitacoesDeCorrida();
//				break;
//			case "8":
//				System.out.println("email do passageiro:");
//				emailEspecifico = leitor.nextLine();
//				Mensageiro.enviarHistoricoCorridas(recuperarCdi.recuperarPassageiroPeloEmail(emailEspecifico));
//				break;
//			case "s":
//				sair = true;
//				break;
//			}
//		}
//	leitor.close();
	}
}
