package br.com.avaliacao.itau.core.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class DateUtilTest {

	@Test
	void testNull() {
		assertNull(DateUtil.convertStringToLocalDateTime("", null));
	}
	
	
	@Test
	void testNull2() {
		assertNull(DateUtil.convertLocalDateTimeToString(null, null));
	}
	
	
	@Test
	void testNull3() {
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");

		assertNotNull(DateUtil.convertLocalDateTimeToString(LocalDateTime.now(), formatter));
	}
	
	
}
