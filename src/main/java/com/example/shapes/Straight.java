package com.example.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Straight extends Shape {

    public Straight() {

    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(color);
        gc.setLineWidth(5);
        gc.strokeLine(x, y, x + 200, y);
    }

    @Override
    public String toString() {
        return "Line";
    }

}