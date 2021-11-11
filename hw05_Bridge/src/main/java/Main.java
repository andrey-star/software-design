import drawing.AwtDrawing;
import drawing.DrawingApi;
import drawing.JavaFxDrawing;
import graph.AdjacencyListGraph;
import graph.Graph;
import graph.MatrixGraph;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args == null || args.length != 3 || Arrays.stream(args).anyMatch(Objects::isNull)) {
            System.out.println("Usage: Main <javafx|awt> <list|matrix> <path-to-graph>");
            return;
        }
        try {
            DrawingApi drawingApi = getDrawingApi(args[0]);
            Graph graph = getGraph(drawingApi, args[1], args[2]);
            graph.drawGraph();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static DrawingApi getDrawingApi(String graphicsApi) {
        DrawingApi drawingApi;
        if (graphicsApi.equals("javafx")) {
            drawingApi = new JavaFxDrawing();
        } else if (graphicsApi.equals("awt")) {
            drawingApi = new AwtDrawing();
        } else {
            throw new IllegalArgumentException("Invalid graphics API: " + graphicsApi);
        }
        return drawingApi;
    }

    private static Graph getGraph(DrawingApi drawingApi, String graphMode, String path) throws IOException {
        Graph graph;
        if (graphMode.equals("list")) {
            graph = new AdjacencyListGraph(drawingApi, Path.of(path));
        } else if (graphMode.equals("matrix")) {
            graph = new MatrixGraph(drawingApi, Path.of(path));
        } else {
            throw new IllegalArgumentException("Invalid graph mode: " + graphMode);
        }
        return graph;
    }

}
