import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * File Name   : ATM.java
 * Author      : Justin Luce
 * Created on  : 15-09-2017
 * Description : 
 **/
class ATM extends JFrame implements ActionListener
{
    private JTextField OUTPUT = new JTextField(20);
    private JButton WITHDRAW = new JButton("Withdraw");
    private JButton DEPOSIT = new JButton("Deposit");
    private JButton TRANSFER_TO = new JButton("Transfer To");
    private JButton BALANCE = new JButton("Balance");
    private JRadioButton CHECKING = new JRadioButton("Checking");
    private JRadioButton SAVINGS = new JRadioButton("Savings");
    
    public ATM()
    {
        super("ATM");
        setSize(300, 175);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,2,10,10));
        buttonPanel.add(WITHDRAW);
        buttonPanel.add(DEPOSIT);
        buttonPanel.add(TRANSFER_TO);
        buttonPanel.add(BALANCE);
        add(buttonPanel);
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(1, 2, 10, 10));
        radioPanel.add(CHECKING);
        radioPanel.add(SAVINGS);
        add(radioPanel);
        CHECKING.setSelected(true);
        ButtonGroup bG = new ButtonGroup();
        bG.add(CHECKING);
        bG.add(SAVINGS);
        add(OUTPUT);
        OUTPUT.setEditable(false);
        WITHDRAW.addActionListener(this);
        DEPOSIT.addActionListener(this);
        TRANSFER_TO.addActionListener(this);
        BALANCE.addActionListener(this);        
    }   
    @Override
    public void actionPerformed(ActionEvent event)
    {
        
    }
    public static void main(String[] args)
    {
        ATM frame = new ATM();
        frame.setVisible(true);
    }
}