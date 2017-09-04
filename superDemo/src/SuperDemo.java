/**
 * File Name   : SuperDemo.java
 * Author      : Justin Luce
 * Created on  : 02-09-2017
 * Description : 
 **/
public class SuperDemo
{
    public static void main(String[] args)
    {
        Boat boat1 = new Boat("fred", "red");
        SailBoat boat2 = new SailBoat();
        System.out.println(boat1.toString());
        System.out.println(boat2.toString());
    }
}

class Boat
{
    private String name = "boaty mcboatface";
    private String color = "white";
    
    public Boat() {}
    
    public Boat(String x, String y)
    {
        name = x;
        color = y;
    }
    public String toString() 
    {
        return "Name: " + name + "\nColor: " + color + "\n";
    }
}

class SailBoat extends Boat
{
    private int numSails = 2; 
    
    public SailBoat() {}
    
    public SailBoat(String x, String y, int z)
    {
        super(x,y);
        numSails = z;
    }
    public String toString() 
    {
        return super.toString() + "Sails: " + numSails ;
    }
}
