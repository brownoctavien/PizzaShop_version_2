package static_class;

import java.util.Random;

public class Customer extends OrderInfo
{

    static String name = null;
    static String address = null;
   static int ID = 0 ;
   static int phone = 0;


    // method for making random customerID
    public static void makeCustomerID()
    {
        Random rand = new Random();
        int id = rand.nextInt(1001)+ 1; //random number 1-1000;
        setCustomerID(id);
    }

    // setter methods
    public static void setName(String name){
        Customer.name = name;
    }

    public static void setAddress(String address) {
        Customer.address = address;
    }

    public static void setCustomerID(int ID) {
        Customer.ID = ID;
    }

    public static void setPhone(int phone)
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

    public static int getCustomerID() {
        return ID;
    }

    public static int getPhone()
    {
        return phone;
    }

}

