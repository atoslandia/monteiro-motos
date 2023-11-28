package com.atosalves.model.facadepattern;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;

class EmailService {

    public static void enviarEmailComAnexo(String destinatario, String assunto, String mensagem, String anexoPath) throws Exception {
        MultiPartEmail email = new MultiPartEmail();

        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator("pombomensageiro489@gmail.com", "orxk xuht bvlr unrd"));
        email.setSSLOnConnect(true);
        email.setSubject(assunto);

        email.setFrom("pombomensageiro489@gmail.com");

        email.addTo(destinatario);
        email.setMsg(mensagem);

        if (anexoPath != null) {
            EmailAttachment anexo = new EmailAttachment();
            anexo.setPath(anexoPath);
            anexo.setDisposition(EmailAttachment.ATTACHMENT);
            anexo.setName("boleto.pdf");
            email.attach(anexo);
        }

        email.send();
    }

    public static void enviarEmail(String destinatario, String assunto, String mensagem) throws Exception {
        enviarEmailComAnexo(destinatario, assunto, mensagem, null);
    }
}

