package com.example.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Angle extends Shape {

    public Angle(Color color) {
        super(color);
    }

    @Override
    double area() {
        return 0;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(Color.GRAY);
        gc.setLineWidth(10);
        gc.strokePolygon(new double[]{x, x + 200}, new double[]{y, y}, 2);
        gc.strokePolygon(new double[]{x, x}, new double[]{y, y + 200}, 2);
    }

}