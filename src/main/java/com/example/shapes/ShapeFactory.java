package com.example.shapes;

import javafx.scene.paint.Color;

public class ShapeFactory {

    public Shape createShape(int numberOfSides, Color color) {
        if (numberOfSides == 5) {
            return new Pentagon(color);
        } else if (numberOfSides == 4) {
            return new Rectangle(Math.random() * 100, Math.random() * 100, color);
        } else if (numberOfSides == 3) {
            return new Triangle(Math.random() * 79, 40.0, 40.0, color);
        } else if (numberOfSides == 2) {
            return new Angle(color);
        } else if (numberOfSides == 1) {
            return new Straight(color);
        } else if (numberOfSides == 0) {
            return new Circle(Math.random() * 50, color);
        } else {
            return null;
        }
    }

}
