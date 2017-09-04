import java.io.File;
import java.util.Scanner;

/**
 * File Name   : Project1.java
 * Author      : Justin Luce
 * Created on  : 04-09-2017
 * Description : computes the salaries for a collection of employees of different types.
 **/
public class Project1
{
    //constants to track 2014 employees and their salary
    static Object[] ARRAY14 = new Object[10];
    static int COUNT14 = 0;
    static int TOTALSALARY14 = 0;
    //constants to track 2015 employees and their salary
    static Object[] ARRAY15 = new Object[10];
    static int COUNT15 = 0;
    static int TOTALSALARY15 = 0;
    
    public static void main(String[] args)
    {
        try 
        {
            Scanner input = new Scanner(System.in);
            File file = new File("C:\\Users\\jluce\\Documents\\file.txt");
            input = new Scanner(file);
            //loop through file line by line
            while (input.hasNextLine()) 
            {
                String line = input.nextLine();
                //split line into array using " " as delimiter
                String[] arrayLine = line.split(" ");
                //if the line is an employee, create employee object and store in appropriate array
                if (arrayLine[1].equals("Employee"))
                {
                    Employee employee = new Employee(arrayLine[2],Integer.parseInt(arrayLine[3]));
                    appendArray(employee,arrayLine);
                }
                //if the line is a salesman, create salesman object and store in appropriate array
                else if (arrayLine[1].equals("Salesman"))
                {
                    Salesman employee = new Salesman(arrayLine[2],Integer.parseInt(arrayLine[3]),Integer.parseInt(arrayLine[4]));
                    appendArray(employee,arrayLine);
                }
                //if the line is an executive, create executive object and store in appropriate array
                else if (arrayLine[1].equals("Executive"))
                {
                    Executive employee = new Executive(arrayLine[2],Integer.parseInt(arrayLine[3]),Integer.parseInt(arrayLine[4]));
                    appendArray(employee,arrayLine);
                }                
            }
            input.close();
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
        // loop through 2014 employee array and display employees
        for (int i=0; i < COUNT14; i++)
        {
            System.out.println(ARRAY14[i]);
        }
        // print average salary for 2014
        System.out.println("Average Salary 2014: " + TOTALSALARY14/COUNT14 + "\n");
        // loop through 2015 employee array and display employees
        for (int i=0; i < COUNT15; i++)
        {
            System.out.println(ARRAY15[i]);
        }
        // print average salary for 2015
        System.out.println("Average Salary 2015: " + TOTALSALARY15/COUNT15 + "\n");
    }
    //add employee to appropriate array and calculate salary
    private static void appendArray(Employee employee,String[] arrayLine)
    {
        if (arrayLine[0].equals("2014"))
        {
            ARRAY14[COUNT14] = employee;
            TOTALSALARY14 += employee.annualSalary();
            COUNT14++;
        }
        else if (arrayLine[0].equals("2015"))
        {
            ARRAY15[COUNT15] = employee;
            TOTALSALARY15 += employee.annualSalary();
            COUNT15++;
        }
    }
}
class Employee
{
    private String name;
    private int monthSalary;
    
    public Employee() {}
    
    public Employee(String x, int y)
    {
        name = x;
        monthSalary = y;
    }
    public int annualSalary()
    {
        int annualSalary = monthSalary*12;
        return annualSalary;
    }
    public String toString()
    {
        String output = "Name: " + name + "\nMonthly Salary: " + monthSalary + "\nAnnual Salary: " + this.annualSalary() + "\n";
        return output;
    }
}
class Salesman extends Employee
{
    private int annualSales;
    
    public Salesman() {}
    
    public Salesman(String x, int y, int z)
    {
        super(x,y);
        annualSales = z;
    }
    @Override
    public int annualSalary()
    {
        int commision = annualSales/50;
        if (commision > 20000)
        {
            commision = 20000;
        }
        int annualSalary = super.annualSalary()+commision;
        return annualSalary;
    }
    @Override
    public String toString()
    {
        String output = super.toString() + "Annual Sales: " + annualSales + "\n";
        return output;
    }
}
class Executive extends Employee
{
    private int stockPrice;
    
    public Executive() {}
    
    public Executive(String x, int y, int z)
    {
        super(x,y);
        stockPrice = z;
    }
    @Override
    public int annualSalary()
    {
        int bonus = 0;
        if (stockPrice > 50)
        {
            bonus = 30000;
        }
        int annualSalary = super.annualSalary()+bonus;
        return annualSalary;
    }
    @Override
    public String toString()
    {
        String output = super.toString() + "Stock Price: " + stockPrice + "\n";
        return output;
    }
}