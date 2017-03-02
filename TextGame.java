import java.util.Scanner;

public class TextGame {
    private LightRow gameRow;
    private int numLights;

    public void startGame() {
        System.out.println("How many lights do you want in the row?");
        Scanner input1 = new Scanner(System.in);
        numLights = input1.nextInt();
        if (numLights > 15)
            numLights = 15;
        else if (numLights < 3)
            numLights = 3;
        gameRow = new LightRow(numLights);
        gameRow.randomize();
        displayBoard();

        System.out.println();
        System.out.println("Now it's time to play!");
        this.playGame();
    }

    private void displayBoard() {
        String printNumbers = "";
        String numberSpacing = "  ";
        String printLights = "";
        for (int i = 0; i < gameRow.length(); i++) {
            int num = i+1; // This is so the first number isn't 0
            if (num >= 10)
                numberSpacing = " ";
            printNumbers += numberSpacing + num + " ";
            char status = '~';
            if (gameRow.returnRow()[i].returnIsOn())
                status = '*';//on
            else
                status = '•'; //off
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
                int index = light-1; // This is so that it'll match the index, not the label
                gameRow.toggleNeighbors(index);
                displayBoard();
            }
        }
    }
}
