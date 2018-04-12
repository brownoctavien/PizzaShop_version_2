package static_class;

import java.util.Random;

public class OrderInfo
{
    // creating variables
   static private int  ID =0 ;
   private static String typeID = null;


    public OrderInfo(){

    }

    public OrderInfo(int orderID, String typeID)
    {
        this.ID= orderID;
        this.typeID = typeID;
    }

    // method for random orderID numbers
    public  static void makeID()
    {
        Random rand = new Random();
        int id = rand.nextInt(1001)+ 1; //random number 1-1000;
        setOrderID(id);
    }


    // getter and setter methods
    public static void setOrderID(int orderID) {
        OrderInfo.ID = orderID;
    }
    public static void setTypeID(String typeID) {
        OrderInfo.typeID = typeID;
    }
    public static int getID()
    {
        return ID;
    }
    public String getTypeID() {
        return typeID;
    }


} // end of OrderInfo class