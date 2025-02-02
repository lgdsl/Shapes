package com.example.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public interface Shape {

    void draw(double x, double y, GraphicsContext gr);

    Color getColor();

}