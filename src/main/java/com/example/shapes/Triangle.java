package com.example.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Shape {

    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC, Color color) {
        super(color);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    double area() {
        var halfPerimeter = (sideA + sideB + sideC) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC));
    }

    @Override
    void draw(GraphicsContext gr) {
        if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA) {
            throw new IllegalArgumentException("Sides do not form a valid triangle");
        }
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

}
