package Desktop;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

// Revised HelloWorld application that uses the JavaFX base class
// The main method is optional in this case!

public class Window extends Application {

    // The main method is optional with Application classes.
    // Use launch() to cause the other methods to be run in sequence.
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        System.out.println("Entering start method");
        // A stage is the application window automatically created by the framework
        // The scene holds the content to be displayed, which is stored as tree
        Label label = new Label("Hello JavaFX");
        Scene scene = new Scene(new StackPane(label), 640, 480);

        // We can have multiple scenes. Setup this one, and tell the stage to show it.
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("Entering init method");
    }
}
