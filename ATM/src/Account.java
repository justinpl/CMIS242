/**
 * File Name   : Account.java
 * Author      : Justin Luce
 * Created on  : 16-09-2017
 * Description : This class creates objects to interact with bank accounts
 **/
public class Account
{
    //declare variables
    private double accountBalance;
    private static int WITHDRAWALS = 0;
    private static final double ATM_FEE = 1.5;
    // object constructor
    public Account(double accountBalance)
    {
        this.accountBalance = accountBalance;
    }
    //method to withdraw amount from selected account
    public void withdraw(double amount) throws InsufficientFunds
    {
        if (WITHDRAWALS >= 4)
        {
            amount += 1.5;
        }
        if (accountBalance < amount)
        {
            throw new InsufficientFunds("Insufficient Funds: $" + (amount - accountBalance));
        }
        else
        {
            accountBalance -= amount;
        }
        WITHDRAWALS++;
    }
    //method to deposit amount into slected account
    public void deposit(double amount)
    {
        accountBalance += amount;
    }
    // method to transfer from one account to another
    public void transferTo(Account transferAccount, double amount)  throws InsufficientFunds
    {
        if (transferAccount.accountBalance < amount)
        {
            throw new InsufficientFunds("Insufficient Funds: $" + (amount - transferAccount.accountBalance));
        }        
        transferAccount.accountBalance -= amount;
        accountBalance += amount;        
    }
    public double balance()
    {
        return accountBalance;
    }
}
