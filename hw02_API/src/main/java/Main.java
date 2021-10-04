import api.VkClient;
import api.VkNewsfeedManager;

import java.time.Instant;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var c = new VkNewsfeedManager(new VkClient());
        List<Long> res = c.getHashtagStatistics("hello", Instant.now(), 24);
        System.out.println(res);
    }
}
