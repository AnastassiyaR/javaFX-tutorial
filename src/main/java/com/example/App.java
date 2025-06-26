// This is a Maven command that:
// 1. Cleans the project (deletes previous build artifacts)
// 2. Runs the JavaFX application using the javafx-maven-plugin
// mvn clean javafx:run
package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main class for the JavaFX application.
 * Extends javafx.application.Application which is the entry point for JavaFX
 * apps.
 */
public class App extends Application {

    // The main scene of the application, shared across different views
    private static Scene scene;

    /**
     * The main entry point for the JavaFX application.
     * 
     * @param stage The primary stage (window) for this application
     * @throws IOException if the FXML file cannot be loaded
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Create a new scene with the content loaded from "primary.fxml"
        // The scene has dimensions of 640x480 pixels
        scene = new Scene(loadFXML("primary"), 640, 480);

        // Set the scene on the primary stage
        stage.setScene(scene);

        // Display the primary stage
        stage.show();
    }

    /**
     * Changes the root node of the scene to the content loaded from the specified
     * FXML file.
     * 
     * @param fxml The name of the FXML file (without .fxml extension)
     * @throws IOException if the FXML file cannot be loaded
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Loads an FXML file and returns its content as a Parent node.
     * 
     * @param fxml The name of the FXML file (without .fxml extension)
     * @return The root node of the loaded FXML hierarchy
     * @throws IOException if the FXML file cannot be loaded
     */
    private static Parent loadFXML(String fxml) throws IOException {
        // Create a new FXMLLoader for the specified FXML file
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));

        // Load and return the FXML content
        return fxmlLoader.load();
    }

    /**
     * The main method that launches the JavaFX application.
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        // Launch the JavaFX application
        launch();
    }
}
