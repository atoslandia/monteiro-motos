package com.atosalves.model.facadepattern;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

import com.atosalves.dto.PassageiroBoletoDTO;
import com.atosalves.dto.UsuarioDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import com.atosalves.dto.PassageiroBoletoDTO;

public class MensageiroFacade {

    public static void enviarBoletoPorEmail(PassageiroBoletoDTO passageiro, float valor) {
        try {
            String pdfPath = GeradorPDF.gerarBoletoPDF(passageiro, valor);
            EmailService.enviarEmailComAnexo(passageiro.email(), "BOLETO", "Enviamos seu boleto, Obrigado pela compra sr. " + passageiro.nome(), pdfPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void enviarCodigoPorEmail(String destinatario, String corpo) {
        try {
            EmailService.enviarEmail(destinatario, "CONFIRME SEU EMAIL", "Seu código é " + corpo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

