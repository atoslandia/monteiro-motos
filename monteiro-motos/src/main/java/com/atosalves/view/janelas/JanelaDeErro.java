package com.atosalves.view.janelas;

import com.atosalves.view.componentes.componentesafactory.ComponentesFactory;
import java.awt.Component;
import java.awt.Dimension;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javax.swing.*;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class JanelaDeErro extends Janela {

	private ComponentesFactory fabrica;

	public JanelaDeErro(String menssagemDeErro) {
		super();
		fabrica = new ComponentesFactory();

		testeData();

		setLayout(null);
		setSize(350, 150);
		setTitle("ALGO DEU ERRADO");
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private void menssagemDeErro(String menssagemDeErro) {
		var texto = fabrica.criarTexto(menssagemDeErro);
		texto.setBounds(0, 0, 300, 100);
		add(texto);
	}

	private void testeData() {
		UtilDateModel model = new UtilDateModel();

		model.setDate(2000, Calendar.JANUARY, 1);
		model.setSelected(true);

		Properties properties = new Properties();
		properties.put("text.today", "HOJE");
		properties.put("text.month", "MÊS");
		properties.put("text.year", "ANO");

		JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
		datePanel.setSize(30, 40);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBounds(10, 10, 230, 100);

		Component comp = datePicker.getComponent(1);
		if (comp instanceof JButton) {
			JButton button = (JButton) comp;
			button.setPreferredSize(new Dimension(150, button.getPreferredSize().height));
			button.setText("DEFINIR DATA");
		}

		add(datePicker);
	}

	private static class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {

		private final String datePattern = "dd/MM/yyyy";
		private final SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

		@Override
		public Object stringToValue(String text) throws ParseException {
			return dateFormatter.parseObject(text);
		}

		@Override
		public String valueToString(Object value) throws ParseException {
			if (value == null) {
				return "";
			}

			if (value instanceof Calendar) {
				Date date = ((Calendar) value).getTime();
				return dateFormatter.format(date);
			} else if (value instanceof Date) {
				return dateFormatter.format((Date) value);
			} else {
				throw new IllegalArgumentException("Unsupported value type: " + value.getClass());
			}
		}
	}
}
