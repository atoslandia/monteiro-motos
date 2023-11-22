package com.atosalves.view.componentes;

import java.util.Calendar;
import java.util.Properties;
import javax.swing.JFormattedTextField.AbstractFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class CaixaData extends JDatePickerImpl {

	UtilDateModel model = new UtilDateModel();

	protected CaixaData(JDatePanelImpl datePanel, AbstractFormatter formatter) {
		super(datePanel, formatter);
		//TODO Auto-generated constructor stub
		model.setDate(2000, Calendar.JANUARY, 1);
		model.setSelected(true);

		Properties properties = new Properties();
		properties.put("text.today", "HOJE");
		properties.put("text.month", "MÊS");
		properties.put("text.year", "ANO");
	}
}
