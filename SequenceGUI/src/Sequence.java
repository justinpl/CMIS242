/**
 * File Name   : Sequence.java
 * Author      : Justin Luce
 * Created on  : 07-10-2017
 * Description : 
 **/

public class Sequence 
{
    //declare efficiency counter
    private static int efficiency = 0;
    // method to calculate value iteratively
    public static int iterative(int n)
    {
    int previous = 0, current = 1, next;
    for (int i = 1; i <= n; i++)
    {
            next = previous + (current*2);
            previous = current;
            current = next;
            addEfficiency();
    }
    return previous;
    }
    // method to calculate value recursively
    public static int recursive(int n)
    {
        addEfficiency();
        if (n <= 1)
            return n;
        return (recursive(n - 1)*2) + recursive(n - 2);
    }
    // method to set efficiency to zero
    public static void setEfficiency()
    {
        efficiency = 0;
    }
    // method to increment efficiency counter, useful as a recursive helper method 
    public static void addEfficiency()
    {
        efficiency += 1;
    }    
    // gets the vale of the efficiency couter
    public static String getEfficiency()
    {
        return Integer.toString(efficiency);
    }
}    
    
