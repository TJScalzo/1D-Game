import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class GuiGame extends Application {
    private LightRow gameRow;
    private int numLights;
    private int numMoves;
    private Button[] buttonRow;
    private GridPane gridPane = new GridPane();
    private Text winMessage;
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Lights Out!");
        // add input
        numLights = 5;

        
        gamePlay(numLights);
        
        
        Button restart = new Button("Restart");
        restart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                gamePlay(numLights);
                gridPane.getChildren().remove(winMessage);
            }
            
        });
        gridPane.add(restart, numLights, 0, 1, 1);
        
        Scene scene = new Scene(gridPane, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        Button decrementDifficulty = new Button("-");
        Button incrementDifficulty = new Button("+");
        
        
        
        
        gridPane.setVgap(8);
        gridPane.setHgap(8);
    }
    
    public void gamePlay(int numLights)
    {
        gameRow = new LightRow(numLights);
        buttonRow = new Button[numLights];
        
        while (gameRow.checkIfCleared()) //makes sure the game doesn't start already solved
            gameRow.randomize();
        
        for(int i = 0; i < numLights; i++){
            buttonRow[i] = new Button(gameRow.returnRow()[i].getStatus());
            int index = i;
            buttonRow[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event){
                    gameRow.toggleNeighbors(gameRow.returnRow()[index].index);
                    numMoves++;
                    refresh();
                    if(gameRow.checkIfCleared())
                    {
                        String plural = "";
                        if(numMoves > 1)
                            plural = "s";
                        winMessage = new Text("You completed the game in " + numMoves + " move" + plural + "!");
                        gridPane.add(winMessage, numLights+1, 0, 1, 1);
                    }
                }
                
            });
            gridPane.add(buttonRow[i], i, 0, 1, 1);
        }
    }

    private void refresh()
    {
        for(int i = 0; i < numLights; i++)
        {
            buttonRow[i].setText(gameRow.returnRow()[i].getStatus());
        }
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}