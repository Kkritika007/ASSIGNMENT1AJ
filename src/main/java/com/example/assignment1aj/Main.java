//
//
//

package com.example.assignment1aj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public Main() {
    }


    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene((Parent)fxmlLoader.load());
        stage.setTitle("Restaurant Data");
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/main/resources/com/example/assignment1aj/clogo.jpg"));
        stage.show();
    }

    public static void main(String[] args) {
        launch(new String[0]);
    }
}
