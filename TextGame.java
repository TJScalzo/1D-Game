import java.util.Scanner;

public class TextGame {
    private LightRow gameRow;
    private int numLights;
    private int numMoves;

    public void startGame() {
        System.out.println("How many lights do you want in the row?");
        Scanner input1 = new Scanner(System.in);
        numLights = input1.nextInt();
        if (numLights > 15)
            numLights = 15;
        else if (numLights < 3)
            numLights = 3;
        gameRow = new LightRow(numLights);
        while (gameRow.checkIfCleared()) //makes sure the game doesn't start already solved
            gameRow.randomize();
        
        numMoves = 0;
        displayBoard();

        System.out.println();
        System.out.println("Now it's time to play!");
        this.playGame();
    }

    private void displayBoard() {
        System.out.println();
        System.out.println();
        System.out.println("MOVE " + numMoves);
        String printNumbers = "";
        String numberSpacing = "  ";
        String printLights = "";
        for (int i = 0; i < gameRow.length(); i++) {
            int num = i+1; // This is so the first number isn't 0
            if (num >= 10)
                numberSpacing = " ";
            printNumbers += numberSpacing + num + " ";
            char status = gameRow.returnRow()[i].getStatus();
            printLights += " [" + status + "]";
        }
        System.out.println(printNumbers);
        System.out.println(printLights);
    }

    private void playGame()
    {
        while (!gameRow.checkIfCleared()) {
            Scanner input2 = new Scanner(System.in);
            System.out.println("Which light would you like to toggle?");
            int light = input2.nextInt();
            if (light < 1 && light > gameRow.length()) {
                System.out.println("That's an invalid number. Please enter a new one.");
            } else {
                numMoves++;
                int index = light-1; // This is so that it'll match the index, not the label
                gameRow.toggleNeighbors(index);
                displayBoard();
            }
        }
        System.out.println();
        System.out.println("You did it! All the lights are off!");
    }
}
