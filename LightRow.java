public class LightRow
{
    private Light[] row;
    private boolean isClear = false;
    
    public LightRow(int numLights)
    {
        row = new Light[numLights];
        for (int i = 0; i < row.length; i++) {
            row[i] = new Light();
        }
    }
    
    public Light[] returnRow()
    {
        return row;
    }
    
    public void randomize()
    {
       for (int i = 0; i < row.length; i++) {
           if (Math.random() < 0.5)
               row[i].set(false);
           else
               row[i].set(true);
       }
    }
    
    public boolean checkIfCleared()
    {
        //This method can be used to see if the row is clear/all one state
        int lightsOn = 0;
        for (int i = 0; i< row.length; i++) {
            if (row[i].returnIsOn())
                lightsOn++;
        }
        isClear = lightsOn == 0;
        return isClear;
    }
}