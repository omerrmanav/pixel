import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {

    private ColorPicker colorPicker;

    @Override
    public void start(Stage stage) {

        GridPane root = new GridPane();

        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                Button button = createEmptyButton();
                GridPane.setConstraints(button, i + 1, j + 1);
                root.getChildren().add(button);
            }
        }

        colorPicker = new ColorPicker();
        GridPane.setConstraints(colorPicker, 26, 1);
        root.getChildren().add(colorPicker);

        Button restartButton = new Button("Restart");
        GridPane.setConstraints(restartButton, 27, 1);
        root.getChildren().add(restartButton);
        restartButton.setCursor(Cursor.HAND);
        restartButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                start(stage);
            }

        });


        Scene scene = new Scene(root);
        stage.setTitle("Try");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public Button createEmptyButton() {
        Button button = new Button();
        button.setPrefSize(20, 20);
        button.setCursor(Cursor.HAND);
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Color selectedColor = colorPicker.getValue();
                button.setStyle("-fx-background-color: #" + selectedColor.toString().substring(2, 8));
            }

        });
        return button;
    }
}
