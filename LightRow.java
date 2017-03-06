public class LightRow
{
    private Light[] row;

    public LightRow()
    {
        row = new Light[5];
        for (int i = 0; i < row.length; i++) {
            row[i] = new Light();
            row[i].index = i;
        }
    }

    public LightRow(int numLights)
    {
        row = new Light[numLights];
        for (int i = 0; i < row.length; i++) {
            row[i] = new Light();
            row[i].index = i;
        }
    }

    public Light[] returnRow()
    {
        return row;
    }

    public int length()
    {
        return row.length;
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

    public void toggleNeighbors(int index)
    {
        row[index].toggle();
        System.out.println("Toggling neighbors of " + index);
        if (index-1 >= 0)
            row[index-1].toggle();
        if (index+1 < row.length)
            row[index+1].toggle();
            
        for(int i = 0; i < row.length; i++) {
            System.out.println("Status of light " + i + ": " + row[i].returnIsOn());
        }
    }
    
    public boolean checkIfCleared()
    {
        int lightsOn = 0;
        for (int i = 0; i< row.length; i++) {
            if (row[i].returnIsOn())
                lightsOn++;
        }
        return lightsOn == 0;
    }
}
