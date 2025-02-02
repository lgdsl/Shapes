package com.example.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Straight implements Shape {

    protected Color color;

    public Straight(Color color) {
        this.color = color;
    }

    @Override
    public void draw(double x, double y, GraphicsContext gc) {
        gc.setStroke(color);
        gc.setLineWidth(5);
        gc.strokeLine(x, y, x + 200, y);
    }

    @Override
    public Color getColor() {
        return color;
    }

}