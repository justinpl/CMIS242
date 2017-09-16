import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * File Name   : ATMGUI.java
 * Author      : Justin Luce
 * Created on  : 16-09-2017
 * Description : This class creates a GUI and checks input 
 **/
public class ATMGUI extends JFrame 
{
    // create field and button objects
    private JTextField inputField = new JTextField(20);
    private JButton withdrawButton = new JButton("Withdraw");
    private JButton depositButton = new JButton("Deposit");
    private JButton transferToButton = new JButton("Transfer To");
    private JButton balanceButton = new JButton("Balance");
    private JRadioButton checkingRButton = new JRadioButton("Checking");
    private JRadioButton savingsRButton = new JRadioButton("Savings");
    // declare variables 
    private static final double BILL = 20;
    private static double amount;
    // create Account objects
    private Account checkingAccount = new Account(100);
    private Account savingsAccount = new Account(100);
    // construct GUI object
    public ATMGUI()
    {
        super("ATM");
        setSize(300, 175);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,2,10,10));
        buttonPanel.add(withdrawButton);
        buttonPanel.add(depositButton);
        buttonPanel.add(transferToButton);
        buttonPanel.add(balanceButton);
        add(buttonPanel);
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(1, 2, 10, 10));
        radioPanel.add(checkingRButton);
        radioPanel.add(savingsRButton);
        add(radioPanel);
        checkingRButton.setSelected(true);
        ButtonGroup bG = new ButtonGroup();
        bG.add(checkingRButton);
        bG.add(savingsRButton);
        add(inputField);
        withdrawButton.addActionListener
            (event -> withdraw());   
        depositButton.addActionListener
            (event -> deposit());
        transferToButton.addActionListener
            (event -> transferTo());
        balanceButton.addActionListener
            (event -> balance());
    } 
    //check to verify that the number is a double. 
    public void numberCheck()
    {
        try
        {
            amount = Double.parseDouble(inputField.getText());
        }
        catch (NumberFormatException exception)
        {
            JOptionPane.showConfirmDialog(null, "Error, not a number. Please try again.");
        }
    }
    //check to verify that the amount is a multiple of 20
    public boolean denominationCheck()
    {
        if (amount%BILL != 0)
        {
            JOptionPane.showConfirmDialog(null, "Error, must be a muliple of 20. Please try again.");
            return false;
        }
        return true;        
    }
    // check to determine which button is currently selected to reduce duplication
    public Account buttonCheck()
    {
        if (checkingRButton.isSelected())
        {
            return checkingAccount;
        }
        else
        {
            return savingsAccount;
        }
    }
    //method to performs checks and withdraw amount from selected account 
    public void withdraw()
    {
        numberCheck();
        if (denominationCheck() == true)
        {
            try
            {
                buttonCheck().withdraw(amount);
                JOptionPane.showMessageDialog(null, "Succesfully withdrew: $" + amount);
            }
            catch (InsufficientFunds exception)
            {
                JOptionPane.showMessageDialog(null, exception.getMessage() + " more needed");
            }
        }
    }
    // method to perform check and deposit amount
    public void deposit()
    {
        numberCheck();
        buttonCheck().deposit(amount);
        JOptionPane.showMessageDialog(null, "Succesfully deposited: $" + amount);
    }   
    // method to perform check and transfer from one account to the other
    public void transferTo()
    {
        numberCheck();
        try
        {
            if (buttonCheck() == checkingAccount)
            {
                checkingAccount.transferTo(savingsAccount, amount);
            }
            else
            {
                savingsAccount.transferTo(checkingAccount, amount);
            }
            JOptionPane.showMessageDialog(null, "Succesfully tranfered: $" + amount);
        }
        catch (InsufficientFunds exception)
        {
            JOptionPane.showMessageDialog(null, exception.getMessage() + " more needed");
        }   
    }
    // method to get balance
    public void balance()
    {
        double balance = buttonCheck().balance();
        JOptionPane.showConfirmDialog(null, "Your balance is: $"+balance);
    }
    public static void main(String[] args)
    {
        ATMGUI frame = new ATMGUI();
        frame.setVisible(true);
    }
}
