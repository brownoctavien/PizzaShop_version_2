package static_class;


import java.util.Random;

public class Delivery extends OrderInfo
{


    // creating variables
    private static int boxAmount;
    private static int  phoneNumber;
    private static String ID;




    // default constructor
    public Delivery()
    {
        // make orderType to delivery type
        typeID = "D";
        ID= null;
    }


    // getter and setter methods
    public static void setBoxAmount(int boxAmount)
    {
        Delivery.boxAmount = boxAmount;
    }

    public static int getBoxAmount()
    {
        return boxAmount;
    }

    public static void setPhoneNumber(int phoneNumber)
    {
        Delivery.phoneNumber = phoneNumber;
    }

    public static int getPhoneNumber()

    {
        return phoneNumber;
    }



    public static void makeID() {
        /*Random rand = new Random();
        int id = rand.nextInt(1001)+ 1; //random number 1-1000;*/
        typeID = "D";

       Delivery.ID = Delivery.typeID + OrderInfo.ID;
    }
    public static void setID(){}


    public static String getID(){
        return Delivery.ID;
    }

} // end of Delivery class
