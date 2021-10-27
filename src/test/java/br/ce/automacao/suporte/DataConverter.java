package br.ce.automacao.suporte;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataConverter {

	public Date transform(String value) {
		DateFormat format = new SimpleDateFormat("MM/dd/yyyy");

		try {
			Date retorno = format.parse(value);
			return retorno;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

	}

}
