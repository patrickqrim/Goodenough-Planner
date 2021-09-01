
public class Task
{
    private Time startTime;
    private Time endTime;
    private String name;
    
    public Task(String n, Time s, Time e)
    {
        name = n;
        startTime = s;
        endTime = e;
    }

    public String getName()
    {
        return name;
    }
    public Time getStartTime()
    {
        return startTime;
    }
    public Time getEndTime()
    {
        return endTime;
    }
    public void setName(String n)
    {
        name = n;
    }
    public void setStartTime(Time x)
    {
        startTime = x;
    }
    public void setEndTime(Time x)
    {
        endTime = x;
    }
}
