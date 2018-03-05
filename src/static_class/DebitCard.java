package static_class;

public class DebitCard {

    // create variables
    String name;
    int cardNumber;
    int cardExpirationDate;
    int pinNumber;


    // default constructor
    public DebitCard(String name, int cardNumber, int cardExpirationDate, int pinNumber)
    {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cardExpirationDate = cardExpirationDate;
        this.pinNumber = pinNumber;
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

    public void setPinNumber(int pinNumber)
    {
        this.pinNumber = pinNumber;
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

    public int getPinNumber()
    {
        return pinNumber;
    }
} // end of DebitCard
