package br.com.avaliacao.itau.core.utils;

import com.google.gson.*;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

class InstantTypeAdapter implements JsonSerializer<Instant>, JsonDeserializer<Instant> {
	
	DateTimeFormatter formatter = DateTimeFormatter
		    .ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX")
		    .withZone(ZoneOffset.UTC);
	
	@Override
	public JsonElement serialize(Instant instant, Type srcType, JsonSerializationContext context) {
		return new JsonPrimitive(formatter.format(instant));
	}

	@Override
	public Instant deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		if(StringUtils.isNotEmpty(json.getAsString())) {
			return Instant.parse(json.getAsString()).atZone(ZoneOffset.UTC).toInstant();	
		}
		return null;
		
	}
	
	
}
