/**
 * File Name   : Student.java
 * Author      : Justin Luce
 * Created on  : 14-10-2017
 * Description : 
 **/
public class Student
{ 
    // declare variables
    private String name;
    private String major;
    private int creditHours = 0;
    private int qualityPoints = 0;
    // construct student class
    public Student(String name, String major)
    {
        this.name = name;
        this.major = major;
        this.creditHours = 0;
        this.qualityPoints = 0;
    }
    // update GPA related variables
    public void courseCompleted(int creditHours, int grade)
    {
        this.creditHours += creditHours;
        qualityPoints += creditHours * grade;
    }
    // compute GPA
    public double computeGPA()
    {
        if (this.creditHours == 0)
            return 4.0;
        return (double) qualityPoints / creditHours;
    }
    @Override
    public String toString()
    {
        return "Name: " + name + "\nMajor: " + major + "\nGPA: " + computeGPA();
    }
}
