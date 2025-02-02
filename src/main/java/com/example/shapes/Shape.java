package com.example.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape implements Cloneable {

    protected Color color;
    protected double x;
    protected double y;

    abstract void draw(GraphicsContext gr);

    Color getColor() { return color; }

    public void SetColor(Color color) { this.color = color;}

    public void SetXY(double x, double y) { this.x = x; this.y = y; }

    public abstract String toString();

    @Override
    public Shape clone() {
        Shape clone = null;
        try {
            clone = (Shape) super.clone();
        } catch (
                CloneNotSupportedException e) {
            throw new AssertionError();
        }
        return clone;
    }

}