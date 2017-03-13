import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;

public class GuiGame extends Application {
    private LightRow gameRow;
    private int numLights = 5;
    private int numMoves = 0;
    private Button[] buttonRow;
    private GridPane gridPane = new GridPane();
    private Text winMessage;
    private Text numLightsLabel;
    private boolean won = false;
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Lights Out!");
        
        Button decrementDifficulty = new Button("-");
        decrementDifficulty.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                if (numLights > 3)
                    numLights--;
                numLightsLabel.setText(Integer.toString(returnNumLights()));
            }
        });
        gridPane.add(decrementDifficulty, 0, 1, 1, 1);
        
        numLightsLabel = new Text(Integer.toString(returnNumLights()));
        gridPane.add(numLightsLabel, 1, 1, 1, 1);
        
        Button incrementDifficulty = new Button("+");
        incrementDifficulty.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                if (numLights < 15)
                    numLights++;
                numLightsLabel.setText(Integer.toString(returnNumLights()));
            }
        });
        gridPane.add(incrementDifficulty, 2, 1, 1, 1);
        
        gamePlay(numLights);
        
        Scene scene = new Scene(gridPane, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
        
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
                    if (!gameRow.checkIfCleared()) {
                        gameRow.toggleNeighbors(gameRow.returnRow()[index].index);
                        numMoves++;
                        refresh();
                    }
                    
                    if (gameRow.checkIfCleared() && !won) {
                        String plural = "";
                        if(numMoves > 1)
                            plural = "s";
                        winMessage = new Text("You completed the game in " + numMoves + " move" + plural + "!");
                        gridPane.add(winMessage, numLights+1, 0, 1, 1);
                        won = true;
                    }
                }
                
            });
            /*
            Font buttonFont = new Font("Consolas");
            buttonRow[i].setFont(buttonFont);
            */
            gridPane.add(buttonRow[i], i, 0, 1, 1);
        }
        
        Button restart = new Button("Restart");
        restart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                gridPane.getChildren().remove(winMessage);
                for (int i = 0; i < numLights; i++)
                    gridPane.getChildren().remove(buttonRow[i]);
                gridPane.getChildren().remove(restart);
                numMoves = 0;
                won = false;
                gamePlay(returnNumLights());
            }
        });
        gridPane.add(restart, numLights, 0, 1, 1);
    }

    private void refresh()
    {
        for(int i = 0; i < numLights; i++)
        {
            buttonRow[i].setText(gameRow.returnRow()[i].getStatus());
        }
    }
    
    public int returnNumLights()
    {
        return numLights;
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}