package static_class;


public class Delivery extends OrderInfo
{


    // creating variables
    private String typeID;

    private int boxAmount;
    private int  phoneNumber;



    // default constructor
    public Delivery()
    {
        typeID = "D";
    }


    // getter and setter methods
    public void setBoxAmount(int boxAmount)
    {
        this.boxAmount = boxAmount;
    }

    public int getBoxAmount()
    {
        return boxAmount;
    }

    public void setPhoneNumber(int phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public int getPhoneNumber()

    {
        return phoneNumber;
    }

    @Override
    public String getTypeID() {
        String id = typeID +getOrderID();
        return id;
    }


    public void makeTypeID() {
        super.makeID();
    }

} // end of Delivery class
