package com.example.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle implements Shape {

    private final double radius;
    protected Color color;

    public Circle(double radius, Color color) {
        this.color = color;
        this.radius = radius;
    }

    @Override
    public void draw(double x, double y, GraphicsContext gr) {
        gr.setFill(color);
        gr.fillOval(x, y, radius, radius);
        gr.save();
    }

    @Override
    public Color getColor() {
        return color;
    }

}