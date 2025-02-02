package com.example.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

abstract class Shape {

    //параметры фигуры - приватные поля

    protected Color color;

    protected double x, y;

    // объявление абстрактных методов

    abstract double area();

    abstract void draw(GraphicsContext gr);

    // конструктор

    public Shape(Color color) {

        this.color = color;

    }



    // реализация методов

    public void setColor(Color color) {
        this.color=color;
    }

}