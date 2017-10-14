import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/**
 * File Name   : SequenceGUI.java
 * Author      : Justin Luce
 * Created on  : 07-10-2017
 * Description : 
 **/
public class SequenceGUI extends JFrame
{
    // creating GUI elements
    private JRadioButton iterativeR = new JRadioButton("Iterative");
    private JRadioButton recursiveR = new JRadioButton("Recursive");
    private JLabel enterL = new JLabel("Enter n:");
    private JTextField enterInput = new JTextField(20);
    private JLabel emptyL = new JLabel();
    private JButton computeB = new JButton("Compute");
    private JLabel resultL = new JLabel("Result:");
    private JTextField resultOutput = new JTextField(20);
    private JLabel efficiencyL = new JLabel("Efficiency:");
    private JTextField efficiencyOutput = new JTextField(20);
        
    // GUI constructor
    public SequenceGUI()
    {
        super("Project 3");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5,2,10,10));
        add(iterativeR);
        iterativeR.setSelected(true);
        add(recursiveR);
        ButtonGroup bg = new ButtonGroup();
        bg.add(iterativeR);
        bg.add(recursiveR);
        add(enterL);
        add(enterInput);
        add(emptyL);
        add(computeB);
        add(resultL);
        add(resultOutput);
        resultOutput.setEditable(false);
        add(efficiencyL);
        add(efficiencyOutput);
        efficiencyOutput.setEditable(false);
        computeB.addActionListener
            (event -> compute());
        addWindowListener(new WindowCloser());
    }
    public void compute()
    { 
        try
        {
            // reset efficiency to 0
            Sequence.setEfficiency();
            // iterative is chosen, use Sequence.iterative and display results
            if (iterativeR.isSelected() == true)
            {
                resultOutput.setText(Integer.toString(Sequence.iterative(Integer.parseInt(enterInput.getText()))));
                efficiencyOutput.setText(Sequence.getEfficiency());
            }
            // else, use Sequence.recursive and display results
            else
            {
                resultOutput.setText(Integer.toString(Sequence.recursive(Integer.parseInt(enterInput.getText()))));
                efficiencyOutput.setText(Sequence.getEfficiency());
            }
        }
        // if non-numbers are entered, show error dialog 
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    // when window is closed create csv file
    private class WindowCloser extends WindowAdapter
    {
        @Override
        public void windowClosing(WindowEvent windowEvent)
        {
            //create csv file file containing the number entered, the result, and efficiencies for iterative and recursive
            try
            {
                PrintWriter pw = new PrintWriter(new File("DataSummary.csv"));
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i <= 10; i++)
                {
                    Sequence.setEfficiency();
                    sb.append(i+",");
                    sb.append(Sequence.iterative(i)+",");
                    sb.append(Sequence.getEfficiency()+",");
                    Sequence.setEfficiency();
                    Sequence.recursive(i);
                    sb.append(Sequence.getEfficiency()+"\n");
                }
                pw.write(sb.toString());
                pw.close();
                System.exit(0);
            }
            // if issues prevent creation of the file, display error dialog 
            catch (FileNotFoundException e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    public static void main(String[] args)
    {
        SequenceGUI window = new SequenceGUI();
        window.setVisible(true);
    }
}