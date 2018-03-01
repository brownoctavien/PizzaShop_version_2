package static_class;


import java.util.Random;

public class OrderInfo extends Customer
{

    // creating variables
   private int  orderID ;
    private int typeID;

    // default constructor
    public OrderInfo()
    {

        orderID = 0;
        typeID = 0;
    }

    // constructor for creating Order object
    public OrderInfo(int orderID, int typeID)
    {
        this.orderID = getOrderID();
        this.typeID = getTypeID();
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
    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public  int getOrderID() {
        return orderID;
    }

    public int getTypeID() {
        return typeID;
    }







} // end of OrderInfo class