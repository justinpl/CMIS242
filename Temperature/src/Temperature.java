import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * File Name   : Temperature.java
 * Author      : Justin Luce
 * Created on  : 15-09-2017
 * Description : 
 **/
class Temperature extends JFrame implements ActionListener
{
    private JTextField input = new JTextField(20);
    private JTextField output = new JTextField(20);
    private JButton convert = new JButton("Convert");
    private JRadioButton cToF = new JRadioButton("C to F");
    private JRadioButton fToC = new JRadioButton("F to C");
    private ButtonGroup bG = new ButtonGroup();
    private double temp;
        
    public Temperature()
    {
        super("Temperature Conversion");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0,1));
        add(input);
        add(cToF);
        cToF.setSelected(true);
        add(fToC);
        bG.add(cToF);
        bG.add(fToC);
        add(output);
        output.setEditable(false);
        add(convert);
        convert.addActionListener(this);
    }   
    @Override
    public void actionPerformed(ActionEvent event)
    {
        if (event.getSource() == convert)
        {
            if (cToF.isSelected())
            {
                temp = Double.parseDouble(input.getText());
                temp = (temp*1.8+32);
                output.setText(Double.toString(temp));
            }
            else
            {
                temp = Double.parseDouble(input.getText());
                temp = ((temp-32)/1.8);
                output.setText(Double.toString(temp));
            }
        }
    }
    public static void main(String[] args)
    {
        Temperature frame = new Temperature();
        frame.setVisible(true);
    }
}