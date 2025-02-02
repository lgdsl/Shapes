package com.example.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Circle extends Shape {

    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw(GraphicsContext gr) {
        gr.setFill(color);
        gr.fillOval(x, y, radius, radius);
        gr.save();
    }

    @Override
    public String toString() {
        return "Circle";
    }

}