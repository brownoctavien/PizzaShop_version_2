package static_class;

import java.util.Random;

public class OrderInfo extends Customer
{
    // creating variables
   private int  orderID ;
   private String typeID;

    // default constructor
    public OrderInfo()
    {
        orderID = 0;
        typeID = null;
    }

    // constructor for creating Order object
    public OrderInfo(int orderID, String typeID)
    {
        this.orderID = orderID;
        this.typeID = typeID;
    }

    // method for random orderID numbers
    public  void makeOrderID()
    {
        Random rand = new Random();
        int id = rand.nextInt(1001)+ 1; //random number 1-1000;
        setOrderID(id);
    }


    // getter and setter methods
    public  void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }
    public  int getOrderID() {
        return orderID;
    }
    public String getTypeID() {
        return typeID;
    }


} // end of OrderInfo class