package com.example.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Angle implements Shape {

    protected Color color;

    public Angle(Color color) {
        this.color = color;
    }

    @Override
    public void draw(double x, double y, GraphicsContext gc) {
        gc.setStroke(color);
        gc.setLineWidth(10);
        gc.strokePolygon(new double[]{x, x + 200}, new double[]{y, y}, 2);
        gc.strokePolygon(new double[]{x, x}, new double[]{y, y + 200}, 2);
    }

    @Override
    public Color getColor() {
        return color;
    }

}