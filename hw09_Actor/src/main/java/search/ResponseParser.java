package search;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ResponseParser {

    public List<String> parseResponse(String json) {
        JsonArray array = (JsonArray) new JsonParser().parse(json);
        Iterator<JsonElement> iterator = array.iterator();
        List<String> results = new ArrayList<>();
        while (iterator.hasNext()) {
            results.add(iterator.next().getAsString());
        }
        return results;
    }

}
