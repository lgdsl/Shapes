package com.example.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Shape {

    private final double sideA;
    private final double sideB;
    private final double sideC;
    protected Color color;

    public Triangle(double sideA, double sideB, double sideC) {
        if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA) {
            throw new IllegalArgumentException("Sides do not form a valid triangle");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public void draw(GraphicsContext gr) {
        var peakX = x + ((sideA * sideA - sideB * sideB) / (2 * sideC)) + sideC / 2;
        var peakY = y - Math.sqrt(Math.max(0, sideA * sideA - Math.pow(peakX - x, 2)));
        gr.setFill(color);
        gr.fillPolygon(
                new double[] {x, x + sideC, peakX},
                new double[] {y, y, peakY},
                3
        );
        gr.save();
    }

    @Override
    public String toString() {
        return "Triangle";
    }

}
