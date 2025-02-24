package gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameStartMenuPane extends StackPane {
    public GameStartMenuPane(Stage primaryStage, Runnable onStartGame) {
        // พื้นหลัง
        ImageView background = new ImageView(new Image("file:src/imagesrc/background.jpg"));
        background.setFitWidth(1360);
        background.setFitHeight(768);

        // ปุ่มต่างๆ
        Button startButton = createStyledButton("StartGame");
        Button tutorialButton = createStyledButton("Tutorial");
        Button exitButton = createStyledButton("Exit");

        startButton.setOnAction(e -> onStartGame.run());
        tutorialButton.setOnAction(e -> System.out.println("Show tutorial"));
        exitButton.setOnAction(e -> primaryStage.close());

        // ปุ่มเครดิต
        Button infoButton = new Button();
        ImageView creditImage = new ImageView(new Image("file:src/imagesrc/Credits.png"));

        creditImage.setFitWidth(100);  
        creditImage.setPreserveRatio(true);

        infoButton.setGraphic(creditImage);
        infoButton.setStyle("-fx-background-color: transparent; -fx-padding: 0; -fx-border-width: 0;");

        infoButton.setOnAction(e -> showCredits());

        // ตำแหน่งของปุ่มเครดิต
        infoButton.setTranslateX(600);
        infoButton.setTranslateY(320);

        // เอฟเฟกต์ Hover
        addHoverEffect(startButton);
        addHoverEffect(tutorialButton);
        addHoverEffect(exitButton);

        VBox menuBox = new VBox(1, startButton, tutorialButton, exitButton);
        menuBox.setAlignment(Pos.CENTER_LEFT);
        menuBox.setTranslateX(70);

        getChildren().addAll(background, menuBox, infoButton);
    }

    private Button createStyledButton(String text) {
        Button button = new Button(text);
        ImageView buttonImage = new ImageView(new Image("file:src/imagesrc/Button.png"));
        
        buttonImage.setFitWidth(350);
        buttonImage.setPreserveRatio(true);
        
        button.setGraphic(buttonImage);
        button.setStyle(
            "-fx-background-color: transparent;" +
            "-fx-text-fill: black;" +
            "-fx-font-weight: bold;" +
            "-fx-font-size: 24px;" +
            "-fx-alignment: center;" +
            "-fx-content-display: center;"
        );

        button.setMinWidth(350);
        button.setPrefHeight(100);
        button.setGraphicTextGap(-10);
        return button;
    }

    private void addHoverEffect(Button button) {
        button.setOnMouseEntered(e -> button.setTranslateY(-5));
        button.setOnMouseExited(e -> button.setTranslateY(0));
    }

    private void showCredits() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Credits");
        alert.setHeaderText("🎮 ผู้พัฒนาเกม 🎮");

        // GridPane สำหรับข้อมูลผู้พัฒนา
        GridPane grid = new GridPane();
        grid.setHgap(30);
        grid.setVgap(20);
        grid.setAlignment(Pos.CENTER);

        // ข้อมูลผู้พัฒนา
        Developer[] developers = {
            new Developer("Pula - kun", "-", "Developer", "file:src/imagesrc/exsax.png"),
            new Developer("Tong - kun", "-", "Developer", "file:src/imagesrc/exsax.png"),
            new Developer("Yodsaran Chaipakdee", "6733213721", "Developer", "file:src/imagesrc/exsax.png")
        };

        // เพิ่มข้อมูลผู้พัฒนาเข้า GridPane
        for (int i = 0; i < developers.length; i++) {
            Developer dev = developers[i];

            ImageView imageView = new ImageView(new Image(dev.imagePath));
            imageView.setFitWidth(80);
            imageView.setPreserveRatio(true);

            Label nameLabel = new Label("Name: " + dev.name);
            Label idLabel = new Label("StudentID: " + dev.studentID);
            Label roleLabel = new Label("Role: " + dev.role);

            VBox devBox = new VBox(5, imageView, nameLabel, idLabel, roleLabel);
            devBox.setAlignment(Pos.CENTER);
            
            grid.add(devBox, i, 0);
        }

        alert.getDialogPane().setContent(grid);
        alert.showAndWait();
    }

    // คลาส Developer สำหรับเก็บข้อมูลผู้พัฒนา
    static class Developer {
        String name, studentID, role, imagePath;
        Developer(String name, String studentID, String role, String imagePath) {
            this.name = name;
            this.studentID = studentID;
            this.role = role;
            this.imagePath = imagePath;
        }
    }
}
