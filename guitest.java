import javafx.stage.Stage;
import javafx.application.Application;

public class guitest extends Application {
    @Override
        public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("App does nothing");

        primaryStage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}