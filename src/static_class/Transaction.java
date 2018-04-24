package static_class;

public class Transaction extends Customer
{

    // creating variables
   static private double customerPaymentAmount = 0;
   static private String customerPaymentType = null;

    // default constructor
    public Transaction()
    {

    }

    // printing results method
    public void printReceipt()
    {
        // finished later
    }

    // setters and getters
    public static void setCustomerPaymentAmount(double customerPaymentAmount)
    {
        Transaction.customerPaymentAmount = customerPaymentAmount;
    }

    public static void setCustomerPaymentType(String customerPaymentType)
    {
        Transaction.customerPaymentType = customerPaymentType;
    }

    public static double getCustomerPaymentAmount()
    {
        return customerPaymentAmount;
    }

    public String getCustomerPaymentType()
    {
        return customerPaymentType;
    }
} // end of Transaction class
