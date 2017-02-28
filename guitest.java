// imports
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class guitest extends Application {
    @Override
        public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("App does nothing");
        
        Label label = new Label("Useless app.");
        Scene scene = new Scene(label, 400, 200);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
    
    public static void main(String[] args){
        Application.launch(args);
    }
}