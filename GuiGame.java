import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class GuiGame extends Application {
    private LightRow gameRow;
    private int numLights;
    private int numMoves;
    private Button[] buttonRow;
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Lights Out!");
        // add input
        numLights = 5;
        gameRow = new LightRow(numLights);
        buttonRow = new Button[numLights];
        GridPane gridPane = new GridPane();
        
        while (gameRow.checkIfCleared()) //makes sure the game doesn't start already solved
            gameRow.randomize();
        
        for(int i = 0; i < numLights; i++){
            buttonRow[i] = new Button(gameRow.returnRow()[i].getStatus());
            buttonRow[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event){
                    gameRow.toggleNeighbors(index);
                }
                
            });
            gridPane.add(buttonRow[i], i, 0, 1, 1);
        }
        
        
        
        /*
        Button button0 = new Button(gameRow.returnRow()[0].getStatus());
        Button button1 = new Button(gameRow.returnRow()[1].getStatus());
        Button button2 = new Button(gameRow.returnRow()[2].getStatus());
        Button button3 = new Button(gameRow.returnRow()[3].getStatus());
        Button button4 = new Button(gameRow.returnRow()[4].getStatus());
        */

        
        
        /* 
        gridPane.add(button0, 0, 0, 1, 1);
        gridPane.add(button1, 1, 0, 1, 1);
        gridPane.add(button2, 2, 0, 1, 1);
        gridPane.add(button3, 3, 0, 1, 1);
        gridPane.add(button4, 4, 0, 1, 1);
        */
        
        Scene scene = new Scene(gridPane, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        gridPane.setVgap(8);
        gridPane.setHgap(8);
        
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}