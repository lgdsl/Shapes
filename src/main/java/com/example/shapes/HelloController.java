package com.example.shapes;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public class HelloController {

    @FXML
    private Canvas canvas;

    @FXML
    private HBox radioButtonContainer;

    private final Map<Button, Shape> shapeButtonMap = new HashMap<>();

    public HelloController() {

    }

    @FXML
    public void initialize() {
        AddShape(new Straight(120, CreateRandomColor()));
        AddShape(new Angle(CreateRandomColor()));
        AddShape(new Triangle(20, 40, 40, CreateRandomColor()));
        AddShape(new Rectangle(70, 40, CreateRandomColor()));
        AddShape(new Pentagon(CreateRandomColor()));
        AddShape(new Circle(50, CreateRandomColor()));
    }

    private Color CreateRandomColor() {
        return Color.color(Math.random(), Math.random(), Math.random());
    }

    private void AddShape(Shape shape) {
        var butt = new Button(shape.getClass().getSimpleName());
        butt.setOnMouseClicked(this::onCanvasClick);
        shapeButtonMap.put(butt, shape);
        radioButtonContainer.getChildren().add(butt);
    }

    @FXML
    public void onCanvasClick(MouseEvent actionEvent) {
        var caller = actionEvent.getSource();
        if (caller == null || !shapeButtonMap.containsKey(caller)) {
            return;
        }
        var selectedShape = shapeButtonMap.get(caller);
        if (selectedShape == null) { return; }
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        selectedShape.x = canvas.getWidth() / 2;
        selectedShape.y = canvas.getHeight() / 2;
        selectedShape.draw(canvas.getGraphicsContext2D());
    }

}

