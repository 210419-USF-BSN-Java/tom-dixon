package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import repository.models.User;

public class JsonConverter {

    private final Gson gson;

    public JsonConverter() {
        gson = new GsonBuilder().create();
    }

    public String convertToJson(User user) {
        return gson.toJson(user);
    }

}
