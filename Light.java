public class Light
{
    private boolean isOn;
    
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
    
    public void toggle()
    {
        isOn = !isOn;
    }
    
    public void set(boolean status)
    {
        isOn = status;
    }
}