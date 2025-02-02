package com.example.shapes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.Random;

public class HelloController {

    @FXML
    private Canvas canvas;

    @FXML
    private ListView<Shape> listview;

    @FXML
    private ColorPicker colorPicker;

    private ObservableList<Shape> content;
    private final Random random = new Random();


    @FXML
    public void initialize() {
        var straight = new Straight();
        var angle = new Angle();
        var triangle = new Triangle(random.nextDouble() * 79, 40, 40);
        var rectangle = new Rectangle(random.nextDouble() * 50, random.nextDouble() * 80);
        var pentagon = new Pentagon();
        var circle = new Circle(random.nextDouble() * 50);

        content = FXCollections.observableArrayList(straight, angle, triangle, rectangle, pentagon, circle);
        listview.setItems(content);
        listview.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    private Color CreateRandomColor() {
        return Color.color(random.nextDouble(), random.nextDouble(), random.nextDouble());
    }

    public Shape getSelectedShape() {
        var index = listview.getSelectionModel().getSelectedIndex();
        var shape = content.get(index).clone();
        shape.SetColor(colorPicker.getValue());
        return shape;
    }


    @FXML
    public void onCanvasClick(MouseEvent actionEvent) {
        var selectedShape = getSelectedShape();
        if (selectedShape == null) {
            return;
        }
        selectedShape.SetXY(actionEvent.getX(), actionEvent.getY());
        selectedShape.draw(canvas.getGraphicsContext2D());
    }

}

