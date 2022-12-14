package com.opensource.proxyservice.model;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class CountryMapper {
    private static final Gson GSON = new Gson();
    public static Country getCountryFromJson(String json){
        JsonArray jsonArray = GSON.fromJson(json, JsonArray.class);
        JsonObject country = jsonArray.get(0).getAsJsonObject();
        String name = country.get("name").getAsJsonObject().get("official").getAsString();
        String capital = country.get("capital").getAsJsonArray().get(0).getAsString();
        List<String> continents = GSON.fromJson(country.get("continents").getAsJsonArray(), List.class);
        String currentTime = getCurrentTime();
        return new Country(name, capital, continents, currentTime);
    }

    private static String getCurrentTime(){
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
        df.setTimeZone(tz);
        return df.format(new Date());
    }
}
