package graph;

import drawing.DrawingApi;
import drawing.Point;

public abstract class Graph {

    private static final int MARGIN = 40;
    private final DrawingApi drawingApi;

    public Graph(DrawingApi drawingApi) {
        this.drawingApi = drawingApi;
    }

    public void drawGraph() {
        doDrawGraph();
        drawingApi.visualize();
    }

    protected abstract void doDrawGraph();

    public abstract int size();

    protected void drawVertex(int i) {
        drawingApi.drawCircle(getVertexPosition(i), 15);
    }

    protected void drawEdge(int a, int b) {
        drawingApi.drawLine(getVertexPosition(a), getVertexPosition(b));
    }

    private Point getVertexPosition(int i) {
        double t = 2 * Math.PI * i / size();
        int x = mapTrigToBoundWithMargin(Math.sin(t), drawingApi.getDrawingAreaWidth(), MARGIN);
        int y = mapTrigToBoundWithMargin(Math.cos(t), drawingApi.getDrawingAreaHeight(), MARGIN);
        return new Point(x, y);
    }

    private int mapTrigToBoundWithMargin(double trig, int bound, int margin) {
        return (int) map(trig, -1, 1, margin, bound - margin);
    }

    private double map(double value, double inStart, double inEnd, double outStart, double outEnd) {
        return (value - inStart) / (inEnd - inStart) * (outEnd - outStart) + outStart;
    }
}
