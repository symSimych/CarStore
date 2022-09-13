package jsonparser;

import com.google.gson.Gson;

import java.util.List;

public class ParserJSON<T> {

    public ParserJSON() {
    }

    public T parseJSON(List<String> list, Class<T> tClass){
        Gson gson = new Gson();
        StringBuilder stringJson = new StringBuilder();
        for (String s: list) {
            stringJson.append(s);
        }
        return gson.fromJson(String.valueOf(stringJson), tClass);
    }
}
