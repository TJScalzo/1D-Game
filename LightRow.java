public class LightRow
{
    private Light[] row;
    static boolean isClear = false;
    
    public LightRow(int numLights)
    {
        row = new Light[numLights];
    }
    
    public Light[] returnRow()
    {
        return row;
    }
    
    public void randomize()
    {
        //This method will be called by the GUI to randomize a row
    }
    
    public boolean checkIfCleared()
    {
        //This method can be used to see if the row is clear/all one state
        int lightsOn = 1; //This is just so BlueJ stops complainin
        isClear = lightsOn == 0;
        return isClear;
    }
}