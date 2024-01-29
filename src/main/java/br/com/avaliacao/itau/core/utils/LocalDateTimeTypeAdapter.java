package br.com.avaliacao.itau.core.utils;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDateTime;


public class LocalDateTimeTypeAdapter implements JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {


	@Override
	public JsonElement serialize(final LocalDateTime date, final Type typeOfSrc,
			final JsonSerializationContext context) {
		return new JsonPrimitive(date.format(DateUtil.formatterIso));
	}

	@Override
	public LocalDateTime deserialize(final JsonElement json, final Type typeOfT,
			final JsonDeserializationContext context) throws JsonParseException {
		
		return DateUtil.convertStringToLocalDateTime(json.getAsString());
		
	}
}
