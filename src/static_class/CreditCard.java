package static_class;

public class CreditCard
{

    // create variables
    String name;
    int cardNumber;
    int cardExpirationDate;
    String cardType;


    // default constructor
    public  CreditCard(String name, int cardNumber, int cardExpirationDate, String cardType)
    {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cardExpirationDate = cardExpirationDate;
        this.cardType = cardType;
    }

    // Verification method
    public void verify()
    {
        // created later
    }

    // setters and getters
    public void setNameOnCard(String nameOnDebitCard)
    {
        this.name= nameOnDebitCard;
    }

    public void setDebitCardNumber(int debitCardNumber)
    {
        this.cardNumber = debitCardNumber;
    }

    public void setDebitCardExpirationDate(int debitCardExpirationDate)
    {
        this.cardExpirationDate = debitCardExpirationDate;
    }

    public void setPinNumber(String cardType)
    {
        this.cardType = cardType;
    }

    public String getNameOnDebitCard()
    {
        return name;
    }

    public int getDebitCardNumber()
    {
        return cardNumber;
    }

    public int getDebitCardExpirationDate()
    {
        return cardExpirationDate;
    }

    public String getcardType()
    {
        return cardType;
    }
} // end of DebitCard
