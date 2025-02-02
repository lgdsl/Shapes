package com.example.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Pentagon extends Shape {

    public Pentagon(Color color) {
        super(color);
    }

    @Override
    double area() {
        return 123;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(Color.ORANGE);
        gc.setLineWidth(5);
        gc.strokePolygon(new double[]{x + 150, x + 250, x + 200, x + 100, x + 50}, new double[]{y + 50, y + 150, y + 250, y + 250, y + 150}, 5);
    }

}