package search;

import java.util.List;

public record Response(Engine engine, List<String> results) {
}
