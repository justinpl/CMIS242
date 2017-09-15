import java.io.File;
import java.util.Scanner;

/**
 * File Name   : ExceptionHandle.java
 * Author      : Justin Luce
 * Created on  : 08-09-2017
 * Description : 
 **/
public class ExceptionHandle
{
    public static void main(String[] args)
    {
        try
        {
            exceptionMethod2();
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }
    public static void exceptionMethod1() throws Exception
    {
        Scanner input = new Scanner(System.in);
        File file = new File("file.txt");
        input = new Scanner(file);
    }
    public static void exceptionMethod2() throws Exception
    {
        exceptionMethod1();
    }  
}
