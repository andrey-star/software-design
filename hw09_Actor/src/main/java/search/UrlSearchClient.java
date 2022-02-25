package search;

import http.RawUrlReader;
import http.UrlReader;

import java.util.List;

public class UrlSearchClient implements SearchClient {

    private final UrlReader reader;
    private final ResponseParser parser;
    private final String host;

    public UrlSearchClient(String host) {
        this.host = host;
        reader = new RawUrlReader();
        parser = new ResponseParser();
    }

    @Override
    public Response search(Request request) {
        String engineString = request.engine().toString().toLowerCase();
        String response = reader.readAsText("%s/%s/%s".formatted(host, engineString, request.query()));
        return new Response(request.engine(), parser.parseResponse(response));
    }

}
