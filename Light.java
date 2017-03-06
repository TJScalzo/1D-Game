public class Light
{
    private boolean isOn;
    public int index;
    
    //Constructors
    public Light()
    {
        isOn = false;
    }
    
    public Light(boolean isOn)
    {
        this.isOn = isOn;
    }
    
    //Methods
    public boolean returnIsOn()
    {
        return isOn;
    }
    
    public String getStatus()
    {
        if (isOn)
            return "*";
        else
            return "•";
    }
    
    public void toggle()
    {
        isOn = !isOn;
    }
    
    public void set(boolean status)
    {
        isOn = status;
    }
}