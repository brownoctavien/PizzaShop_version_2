package static_class;

import java.util.Random;

public class Customer
{

    static private String name ;
    static private String address;
   static private int ID ;
   static private int phone;

   public Customer(){
       name= null;
       address= null;
       ID = 0;
       phone= 0;
   }

    // method for making random customerID

    public static void makeID()
    {
        Random rand = new Random();
        int id = rand.nextInt(1001)+ 1; //random number 1-1000;
        setID(id);    }

    // setter methods
    public static void setName(String name)
    {
        Customer.name = name;
    }

    public static void setAddress(String address)
    {
        Customer.address = address;
    }


    public static void setID(int ID)
    {
        Customer.ID = ID;
    }

    public  static void setPhone(int phone)
    {
        Customer.phone = phone;
    }

    public static String getName()
    {
        return name;
    }

    public static String getAddress()
    {
        return address;
    }

    public static int getID()
    {
        return ID;
    }

    public static int getPhone()
    {
        return phone;
    }

}

