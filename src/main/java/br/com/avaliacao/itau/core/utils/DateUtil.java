package br.com.avaliacao.itau.core.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

	private DateUtil() {

	}

	public static final DateTimeFormatter formatterIso = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
	public static final DateTimeFormatter formatterPadrao = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public static LocalDateTime convertStringToLocalDateTime(String data) {
		return convertStringToLocalDateTime(data, formatterIso);
	}
	
	public static LocalDateTime convertStringToLocalDateTimePadrao(String data) {
		return convertStringToLocalDateTime(data, formatterPadrao);
	}

	public static LocalDateTime convertStringToLocalDateTime(String data, DateTimeFormatter format) {
		if (data.length() >= 19) {
			return LocalDateTime.parse(data.substring(0, 19), format);
		}
			return null;
	}

	public static String convertLocalDateTimeToString(LocalDateTime data, DateTimeFormatter formato) {

		if (data != null) {
			return data.format(formato);
		}
		return null;
	}


	
	public static String convertLocalDateTimeToStringPadrao(LocalDateTime data) {
		return convertLocalDateTimeToString(data, formatterPadrao);
	}

}
