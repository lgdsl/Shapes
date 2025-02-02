package com.example.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Straight extends Shape {

    double length;

    public Straight(double length, Color color) {
        super(color);
        this.length = length;
    }

    @Override
    double area() {
        return 0;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(5);
        gc.strokeLine(x, y, x + length, y);
    }

}