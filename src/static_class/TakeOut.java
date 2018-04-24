package static_class;
public class TakeOut extends OrderInfo
{

    // creating variables
    static int boxAmount;
    static int phoneNumber;
    static String ID;


    // default constructor
    public TakeOut()
    {
        typeID = "T";
        boxAmount =0;
        phoneNumber =0;
    }

    //getter and setter

    public static int getBoxAmount()
    {
        return boxAmount;
    }
    public int getPhoneNumber()
    {
        return phoneNumber;
    }
    public void setBoxAmount(int amount)
    {
        this.boxAmount = amount;
    }
    public  void setPhoneNumber(int phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    public static String getID()
    {
        return TakeOut.ID;
    }
    public static void makeID()
    {
        typeID = "T";

        TakeOut.ID = TakeOut.typeID + OrderInfo.ID;
    }
    
} // end TakeOut class