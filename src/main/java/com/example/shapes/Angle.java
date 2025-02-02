package com.example.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Angle extends Shape {

    public Angle() {

    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(color);
        gc.setLineWidth(10);
        gc.strokePolygon(new double[]{x, x + 200}, new double[]{y, y}, 2);
        gc.strokePolygon(new double[]{x, x}, new double[]{y, y + 200}, 2);
    }

    @Override
    public String toString() {
        return "Angle";
    }

}