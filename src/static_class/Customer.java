package static_class;

import java.util.Random;

public class Customer
{

    // variables
    String name;
    String address;
    int ID;
    int orderID;
    int phone;

    // default constructor
    public Customer()
    {
        name = null;
        address = null;
        ID = 0;
        orderID = 0;
        phone = 0;
    }

    // creates Customer Object
    public Customer(int ID, String name, String address, int phone) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }


    // method for making random customerID
    public  void makeID()
    {
        Random rand = new Random();
        int id = rand.nextInt(1001)+ 1; //random number 1-1000;
        setID(id);
    }

    // setter methods
    public void setName(String name){
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

   /* public void setOrder(int orderID)
    {
        this.orderID = orderID;
    }*/

    public void setPhone(int phone)
    {
        this.phone = phone;
    }

    // getter methods
    public String getName()
    {
        return name;
    }

    public String getAddress()
    {
        return address;
    }

    public int getID()
    {
        return ID;
    }

    /*public int getOrder()
    {
        return order;
    }*/

    public int getPhone()
    {
        return phone;
    }

} // end of customer class

