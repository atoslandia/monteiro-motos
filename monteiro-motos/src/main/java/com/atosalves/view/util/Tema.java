package com.atosalves.view.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Tema {

	public static final Font TEXTO_FONTE = new Font("Arial", Font.BOLD, 12);

	public static final Font TEXTO_FONTE_FORTE = new Font(
		"Helvetica",
		Font.BOLD | Font.ITALIC,
		20
	);

	public static final Font TEXTO_FONTE_MUITO_FORTE = new Font(
		"Cocogoose Pro Italic",
		Font.BOLD | Font.ITALIC,
		40
	);

	public static final Color BOTAO_COR = new Color(255, 205, 0);
	public static final Color BOTAO_FUNDO_COR = new Color(220, 170, 0);

	public static final Color TEXTO_COR = new Color(48, 48, 48);

	public static final Image IMAGE_DE_FUNDO = new ImageIcon(
		"C:\\Users\\Atos\\Desktop\\projetos faculdade\\2projetopp\\monteiro-motos-remake\\monteiro-motos\\src\\main\\resources\\fundo-padrao.png"
	)
		.getImage();
}
