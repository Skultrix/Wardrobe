package com.aabdalla.wardrobe;

import com.aabdalla.wardrobe.controllers.BaseUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Wardrobe extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Wardrobe.class.getResource("fxml/base.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root, 1000, 600);

        stage.getIcons().add(new Image(Wardrobe.class.getResourceAsStream("img/logo_icon.png")));
        stage.setTitle("FitStack");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}