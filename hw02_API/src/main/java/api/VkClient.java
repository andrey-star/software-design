package api;

import http.UrlReader;

import java.time.Instant;

public class VkClient {

    private static final String API_KEY = System.getenv("VK_API_KEY");
    private final VkNewsfeedSearchResponseParser parser;
    private final UrlReader reader;

    public VkClient() {
        this.parser = new VkNewsfeedSearchResponseParser();
        this.reader = new UrlReader();
    }

    public VkNewsfeedSearchResponse searchNewsfeed(String query, Instant start, Instant end) {
        String response = reader.readAsText(createUrl(query, start.getEpochSecond(), end.getEpochSecond()));
        return parser.parseResponse(response);
    }

    private String createUrl(String query, long start, long end) {
        return "https://api.vk.com/method/newsfeed.search?q=%s&start_time=%d&end_time=%d&access_token=%s&v=5.131"
                .formatted(query, start, end, API_KEY);
    }
}
