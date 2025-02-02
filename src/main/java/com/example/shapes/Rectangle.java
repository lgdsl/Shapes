package com.example.shapes;

import javafx.scene.canvas.GraphicsContext;

class Rectangle extends Shape {

    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void draw(GraphicsContext gr) {
        gr.setFill(color);
        gr.fillRect(x, y, length, width);
        gr.save();
    }

    @Override
    public String toString() {
        return "Rectangle";
    }

}