/**
 * File Name   : InsufficentFunds.java
 * Author      : Justin Luce
 * Created on  : 16-09-2017
 * Description : this class is an exception to handle insufficient funds
 **/
class InsufficientFunds extends Exception
{
    public InsufficientFunds(String message)
    {
        super(message);
    }
}

