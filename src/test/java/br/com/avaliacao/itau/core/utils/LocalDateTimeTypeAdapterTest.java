package br.com.avaliacao.itau.core.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class LocalDateTimeTypeAdapterTest {

	@Test
	void testSerialize() {
		LocalDateTimeTypeAdapter ldt = new LocalDateTimeTypeAdapter();
		assertNotNull(ldt.serialize(LocalDateTime.now(), null, null));
	}

	@Test
	void testDeserialize() {
		LocalDateTimeTypeAdapter ldt = new LocalDateTimeTypeAdapter();

		JsonElement json = JsonParser.parseString("{\"data\":\"2023-06-19T11:00:48.000Z\"}");
		JsonObject rootObject = json.getAsJsonObject();

		assertNotNull(ldt.deserialize(rootObject.get("data"), null, null));
	}

}
