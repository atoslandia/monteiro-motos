package com.atosalves.view.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Tema {

	public static final Font FONTE_NORMAL = new Font("Arial", Font.BOLD, 12);

	public static final Font FONTE_FORTE = new Font(
		"Helvetica",
		Font.BOLD | Font.ITALIC,
		20
	);

	public static final Font FONTE_MUITO_FORTE = new Font(
		"Cocogoose Pro Italic",
		Font.BOLD | Font.ITALIC,
		40
	);

	public static final Font FONTE_AMARELA = new Font(
		"Cocogoose Pro Italic",
		Font.BOLD | Font.ITALIC,
		40
	);
	public static final Color AMARELO = new Color(255, 205, 0);
	public static final Color AMARELO_ESCURO = new Color(220, 170, 0);
	public static final Color PRETO = new Color(48, 48, 48);
	public static final Color CINZA = new Color(204, 204, 204);

	public static final Image FUNDO_CINZA = new ImageIcon(
		"C:\\Users\\Atos\\Desktop\\projetos faculdade\\2projetopp\\monteiro-motos-remake\\monteiro-motos\\src\\main\\resources\\fundo-padrao.png"
	)
		.getImage();
	public static final Image FUNDO_LOGIN = new ImageIcon(
		"C:\\Users\\Atos\\Desktop\\projetos faculdade\\2projetopp\\monteiro-motos-remake\\monteiro-motos\\src\\main\\resources\\fundo-login.png"
	)
		.getImage();
}
