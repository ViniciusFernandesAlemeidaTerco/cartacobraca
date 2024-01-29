package br.com.avaliacao.itau.core.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonUtil {

    private static final GsonBuilder gsonBuilder;

    static {
        gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter());
        gsonBuilder.registerTypeAdapter(Instant.class, new InstantTypeAdapter());
    }

    public static String toJson(Object o) {
        Gson gson = gsonBuilder.create();
        return gson.toJson(o);
    }

    public static String toJson(Object o, String dateFormat) {
        Gson gson = gsonBuilder.setDateFormat(dateFormat).create();
        return gson.toJson(o);
    }

    public static <T> T fromJson(String valor, Class<T> clazz) {
        Gson gson = gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX").create();
        return gson.fromJson(valor, clazz);
    }

    public static <T> T fromJson(String valor, Class<T> clazz, String dateFormat) {
        Gson gson = gsonBuilder.setDateFormat(dateFormat).create();
        return gson.fromJson(valor, clazz);
    }

}
