package projeto_poo;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

public class Mensageiro{
	
	public static void enviarHistoricoCorridas(Passageiro destinatario) {
		SimpleEmail simpleEmail = new SimpleEmail();
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes recuperarCdi = persistencia.recuperarCentral("backup.xml");
		simpleEmail.setHostName("smtp.gmail.com");
		simpleEmail.setSmtpPort(587);
		simpleEmail.setAuthenticator(new DefaultAuthenticator("projeto.poo.ads@gmail.com", "risagyuofykwmikh"));
		simpleEmail.setSSLOnConnect(true);
		simpleEmail.setSubject("HISTORICO DE CORRIDAS");
		try {
			simpleEmail.setFrom("projeto.poo.ads@gmail.com");
			String mensagem = "historico de corridas de: "+destinatario.getNome()+"\n";
			for(Corrida m: recuperarCdi.recuperarCorridasDeUmPassageiro(destinatario.getEmail()))
				mensagem += "de: "+m.getEndereco()+", para: "+m.getDestino()+"\n";
			simpleEmail.setMsg(mensagem);
			simpleEmail.addTo(destinatario.getEmail());
			simpleEmail.send();
		} catch (Exception e) {e.printStackTrace();}
	}

}

