package com.example.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class Rectangle implements Shape {

    private final double length;
    private final double width;
    protected Color color;

    public Rectangle(double length, double width, Color color) {
        this.color = color;
        this.length = length;
        this.width = width;
    }

    @Override
    public void draw(double x, double y, GraphicsContext gr) {
        gr.setFill(color);
        gr.fillRect(x, y, length, width);
        gr.save();
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Rectangle color is " + color;
    }

}