import java.util.Scanner;

/**
 * File Name   : Recursive.java
 * Author      : Justin Luce
 * Created on  : 30-09-2017
 * Description : 
 **/
public class Recursive
{
    public static void main(String[] args)
    {
        Scanner stdin = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = stdin.nextInt();
        int sequence_1 = iterativeSequence(n);
        System.out.println("Iterative Sequence = " + sequence_1);
        int sequence_2 = recursiveSequence(n);
        System.out.println("Recursive Sequence = " + sequence_2);
    }
    private static int iterativeSequence(int n)
    {
        int count = 0;
        int current = 0;
        for (int i = 1; i <= n; i++)
        {
            if (i%2!=0)
            {
                count++;
            }
            current = current + count;
        }
        return current;
    }
    private static int recursiveSequence(int n)
    {
        if (n <= 1)
            return n;
        return recursiveSequence(n - 2) + (n);
    }
}
