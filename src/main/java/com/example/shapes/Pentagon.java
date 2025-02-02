package com.example.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Pentagon implements Shape {

    protected Color color;

    public Pentagon(Color color) {
        this.color = color;
    }

    @Override
    public void draw(double x, double y, GraphicsContext gc) {
        gc.setStroke(color);
        gc.setLineWidth(5);
        gc.strokePolygon(new double[]{x + 150, x + 250, x + 200, x + 100, x + 50}, new double[]{y + 50, y + 150, y + 250, y + 250, y + 150}, 5);
    }

    @Override
    public Color getColor() {
        return color;
    }

}