package com.atosalves.view.componentes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javax.swing.JFormattedTextField;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class DataCaixa extends JDatePickerImpl {

	private UtilDateModel model;

	public DataCaixa() {
		super(new JDatePanelImpl(new UtilDateModel(), new Properties()), new DateLabelFormatter());
		this.model = (UtilDateModel) getModel();

		model.setDate(2000, Calendar.JANUARY, 1);
		model.setSelected(true);

		Properties properties = new Properties();
		properties.put("text.today", "HOJE");
		properties.put("text.month", "MÊS");
		properties.put("text.year", "ANO");

		getJFormattedTextField().setText("DEFINIR DATA");
	}

	public LocalDate pegarCampo() {
		Date selectedDate = (Date) model.getValue();
		return selectedDate != null
			? selectedDate
				.toInstant()
				.atZone(Calendar.getInstance().getTimeZone().toZoneId())
				.toLocalDate()
			: null;
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
