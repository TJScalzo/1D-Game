import java.util.Scanner;

public class TextGame {
    public void startGame() {
        Scanner input = new Scanner(System.in); //creates scanner object
        String response = "";

        System.out.println("How many lights do you want in the row?");
        int numLights = input.nextInt();
        LightRow gameRow = new LightRow(numLights);
        for (int i = 0; i < gameRow.length(); i++) {
            
        }
    }
}
