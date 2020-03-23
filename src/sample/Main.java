package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.TextArea;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class Main extends Application {
    TaskThreadDemo taskTest = new TaskThreadDemo();

    @FXML
    public TextArea textArea = new javafx.scene.control.TextArea();



    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");


        Runnable printA = new PrintChar('a', 20);
        Runnable printB = new PrintChar('b', 20);
        Runnable print100 = new PrintNum(20);


        // Create threads
        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);


        // Start threads
        thread1.start();
        thread3.start();
        thread2.start();
        primaryStage.setScene(new Scene(textArea, 300, 275));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
