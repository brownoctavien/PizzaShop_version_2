package static_class;

public class Cash extends Customer
{

   // creating variables
    double amount;


    // default constructor
    public Cash()
    {

    }


    // cashPayment method
    public double cashPayment(double amountPayment)
    {
        setAmount(amountPayment);
        return getAmount();
    }

    // setters and getters
    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public double getAmount()
    {
        return amount;
    }
} // end of class Cash
