package static_class;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.Random;

public class OrderInfo
{
    // creating variables
   static protected String ID;
   static protected String typeID;
   static protected String paymentType;

    OrderInfo(String ID, String typeID, String paymentType){
        OrderInfo.ID = ID;
        OrderInfo.typeID = typeID;
        OrderInfo.paymentType= paymentType;
    }
    public OrderInfo(){
        ID = null;
        typeID = null;
        paymentType = null;
    }


    // method for random orderID numbers
    public static void makeID()
    {
        Random rand = new Random();
        int id = rand.nextInt(1001)+ 1; //random number 1-1000;
        setID(String.valueOf(id));
    }


    // getter and setter methods
    private  static void setID(String ID) {
        OrderInfo.ID = ID;
    }
    private static void setTypeID(String typeID) {
        OrderInfo.typeID = typeID;
    }
    public static String getID()
    {
        return ID;
    }

    private static String getTypeID() {
        return typeID;
    }

    public static void setPaymentType(String paymentType){
        OrderInfo.paymentType = paymentType;
    }
    public static String getPaymentType(){
        return paymentType;
    }


} // end of OrderInfo class