package edu.miracosta.cs112.lab07;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloApplication extends Application implements EventHandler<ActionEvent> {

    private Label label1;
    private Label label2;
    private Button button1;
    private Button button2;
    private TextField textField;

    private int count = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello GUI: Nathan Renner");
        StackPane layout = new StackPane();
        Scene scene = new Scene(layout, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        label1 = new Label("Hello GUI World");
        label2 = new Label("Left Corner Label");
        button1 = new Button("Update Text");
        button2 = new Button("Count (+1)");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setTopAnchor(label1, 0.0);
        anchorPane.setRightAnchor(label1, 0.0);

        anchorPane.setTopAnchor(label2, 0.0);
        anchorPane.setLeftAnchor(label2, 0.0);

        button1.setOnAction(this);
        anchorPane.setBottomAnchor(button1, 0.0);
        anchorPane.setRightAnchor(button1, 0.0);

        button2.setOnAction(this);
        anchorPane.setBottomAnchor(button2, 0.0);
        anchorPane.setLeftAnchor(button2, 0.0);

        textField = new TextField();
        anchorPane.getChildren().addAll(label1, label2, button1, button2);
        layout.getChildren().addAll(anchorPane, textField);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == button1) {
            label1.setText(textField.getText());
        } else if (actionEvent.getSource() == button2) {
            count++;
            label2.setText("Pressed: " + count);
        }
    }
}
