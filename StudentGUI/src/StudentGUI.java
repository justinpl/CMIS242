import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * File Name   : StudentGUI.java
 * Author      : Justin Luce
 * Created on  : 14-10-2017
 * Description : 
 **/
public class StudentGUI extends JFrame
{
    Map <String, Student> studentDatabase = new TreeMap();
    // creating GUI elements
    private JLabel idL = new JLabel("ID:");
    private JLabel nameL = new JLabel("Name:");
    private JLabel majorL = new JLabel("Major:");
    private JLabel choiceL = new JLabel("Choose Selection");
    private JTextField idInput = new JTextField(20);
    private JTextField nameInput = new JTextField(20);
    private JTextField majorInput = new JTextField(20);
    private JComboBox selectionC = new JComboBox(new Object[] {"Insert","Delete","Find","Update"});
    private JButton processB = new JButton("Process Request");
        
    // GUI constructor
    public StudentGUI()
    {
        super("Project 4");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5,2,10,10));
        add(idL);
        add(idInput);
        add(nameL);
        add(nameInput);
        add(majorL);
        add(majorInput);
        add(choiceL);
        add(selectionC);
        add(processB);
        processB.addActionListener
            (event -> process());
    }
    // method to interact with database
    public void process()
    {
        try
        {
            // check if the ID enter is a number
            checkNum();
            switch(selectionC.getSelectedIndex())
            {
                // if insert was selected, insert student at ID location
                case 0:
                {
                    if (studentDatabase.containsKey(idInput.getText()) == false)
                    {
                        studentDatabase.put(idInput.getText(), new Student(nameInput.getText(),majorInput.getText()));
                        JOptionPane.showMessageDialog(null, "You have successfully inserted " + nameInput.getText());
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "The ID you have entered is already in use. ID " + nextKey() + " is available");
                    }
                    break;
                }
                // if remove was selected, remove student from ID location
                case 1:
                {
                    if (studentDatabase.containsKey(idInput.getText()) == true)
                    {
                        studentDatabase.remove(idInput.getText());
                        JOptionPane.showMessageDialog(null, "You have successfully removed Student ID: " + idInput.getText());
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "The ID you have entered is not in use.");
                    }
                    break;
                }
                // if find was selected, shows the students Name, major and GPA
                case 2:
                {
                    if (studentDatabase.containsKey(idInput.getText()) == true)
                    {
                        JOptionPane.showMessageDialog(null, studentDatabase.get(idInput.getText().toString()));
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "The ID you have entered is not in use.");
                    }
                    break;
                }
                // if update was selected, update the students GPA
                case 3:
                {
                    if (studentDatabase.containsKey(idInput.getText()) == true)
                    {
                        int creditHour = 0;
                        Student updateStudent = studentDatabase.get(idInput.getText());
                        String[] gradelist = {"A", "B", "C", "D", "F"};
                        JComboBox grade = new JComboBox(gradelist);
                        grade.setEditable(true);
                        JOptionPane.showMessageDialog( null, grade, "Choose grade", JOptionPane.QUESTION_MESSAGE);
                        if (grade.getSelectedItem() == "A")
                        {
                            creditHour = 4;
                        }
                        else if (grade.getSelectedItem() == "B")
                        {
                            creditHour = 3;
                        }
                        else if (grade.getSelectedItem() == "C")
                        {
                            creditHour = 2;
                        }
                        else if (grade.getSelectedItem() == "D")
                        {
                            creditHour = 1;
                        }
                        else if (grade.getSelectedItem() == "F")
                        {
                            creditHour = 0;
                        }
                                                                
                        String[] creditlist = {"3", "6"};
                        JComboBox credit = new JComboBox(creditlist);
                        credit.setEditable(true);
                        JOptionPane.showMessageDialog( null, credit, "Choose credits", JOptionPane.QUESTION_MESSAGE);     
                        if (credit.getSelectedItem() == "3")
                        {
                            updateStudent.courseCompleted(3,creditHour);
                        }
                        else if (grade.getSelectedItem() == "6")
                        {
                            updateStudent.courseCompleted(6,creditHour);
                        }
                        studentDatabase.put(idInput.getText(),updateStudent);
                        JOptionPane.showMessageDialog(null, "You have successfully updated Student ID: " + idInput.getText());
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "The ID you have entered is not in use.");
                    }
                    break;
                }    
            }
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Please enter a numeric ID. " + nextKey() + " is available");
        }            
    }
    // determine the lowest empty key
    public String nextKey()
    {
        int i = 0;
        while (true)
        {            
            if (studentDatabase.containsKey(Integer.toString(i)) == true) 
            {
                i++;
            }
            else
            {
                return Integer.toString(i);
            }
        }
    }
    //check if the ID is numeric and throw unhandled exception
    public void checkNum() throws NumberFormatException
    {
        Integer.parseInt(idInput.getText());
    }
    public static void main(String[] args)
    {
        StudentGUI window = new StudentGUI();
        window.setVisible(true);
    }
}
