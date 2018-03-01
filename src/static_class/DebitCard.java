package static_class;

public class DebitCard extends Customer
{

    // create variables
    String nameOnDebitCard;
    int debitCardNumber;
    int debitCardExpirationDate;
    int pinNumber;


    // default constructor
    public void DebitCard()
    {

    }

    // Verification method
    public void verify()
    {
        // created later
    }

    // setters and getters
    public void setNameOnCard(String nameOnDebitCard)
    {
        this.nameOnDebitCard = nameOnDebitCard;
    }

    public void setDebitCardNumber(int debitCardNumber)
    {
        this.debitCardNumber = debitCardNumber;
    }

    public void setDebitCardExpirationDate(int debitCardExpirationDate)
    {
        this.debitCardExpirationDate = debitCardExpirationDate;
    }

    public void setPinNumber(int pinNumber)
    {
        this.pinNumber = pinNumber;
    }

    public String getNameOnDebitCard()
    {
        return nameOnDebitCard;
    }

    public int getDebitCardNumber()
    {
        return debitCardNumber;
    }

    public int getDebitCardExpirationDate()
    {
        return debitCardExpirationDate;
    }

    public int getPinNumber()
    {
        return pinNumber;
    }
} // end of DebitCard
