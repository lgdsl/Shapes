package com.example.shapes;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HelloController {

    @FXML
    private Canvas canvas;

    @FXML
    private FlowPane radioButtonContainer;

    @FXML
    private TextField quantityInput;

    private final Random random = new Random();
    private final ShapeFactory shapeFactory = new ShapeFactory();
    private final ToggleGroup shapeToggleGroup = new ToggleGroup();
    private final Map<RadioButton, Shape> shapeButtonMap = new HashMap<>();


    public HelloController() {

    }

    @FXML
    public void initialize() {

    }

    @FXML
    public void onDrawButtonClick() {
        var quantity = Integer.parseInt(quantityInput.getText());
        var shape = shapeFactory.createShape(quantity, CreateRandomColor());
        AddShape(shape);
    }

    private Color CreateRandomColor() {
        return Color.color(random.nextDouble(), random.nextDouble(), random.nextDouble());
    }

    private void AddShape(Shape shape) {
        if (shape == null) { return; }
        var radioButton = new RadioButton(shape.getClass().getSimpleName());
        var shapeColor = shape.getColor();
        var colorAsRgb = String.format("rgb(%d, %d, %d)",
                (int) (shapeColor.getRed() * 255),
                (int) (shapeColor.getGreen() * 255),
                (int) (shapeColor.getBlue() * 255)
        );
        radioButton.setStyle("-fx-text-fill: " + colorAsRgb + ";");
        radioButton.setToggleGroup(shapeToggleGroup);
        radioButtonContainer.getChildren().add(radioButton);
        shapeButtonMap.put(radioButton, shape);
    }

    public Shape getSelectedShape() {
        var selectedRadioButton = (RadioButton) shapeToggleGroup.getSelectedToggle();
        if (selectedRadioButton != null && shapeButtonMap.containsKey(selectedRadioButton)) {
            return shapeButtonMap.get(selectedRadioButton);
        }
        return null;
    }


    @FXML
    public void onCanvasClick(MouseEvent actionEvent) {
        var selectedShape = getSelectedShape();
        if (selectedShape == null) { return; }
        selectedShape.draw(actionEvent.getX(), actionEvent.getY(), canvas.getGraphicsContext2D());
    }

}

