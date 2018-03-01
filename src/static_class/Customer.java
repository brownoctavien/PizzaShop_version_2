package static_class;

public class Customer
{
    public static void main (String args[])
    {
        // creating customer object
        Customer customer = new Customer();
        customer.makeID();
        System.out.println(customer.getID());

        // creating order object
        OrderInfo order = new OrderInfo();
        order.makeOrderID();
        order.setTypeID(324324);
        System.out.println(order.getTypeID());
        System.out.println(order.getOrderID());

        // setting customer name
        customer.setName("Matt Harrington");
        System.out.println(customer.getName());

        // testing cash payment method
        Cash cash = new Cash();
        cash.cashPayment(25.00);
        System.out.println(cash.getAmount());

    } // end of main method for testing

    // variables
    String name = "";
    String address = "";
    int ID = 1000000;
    int orderID = 0;
    int phone = 0;

    // default constructor
    public Customer()
    {

    }

    // creates Customer Object
    public Customer(int ID, String name, String address, int phone)
    {

        this.ID = ID;
        this.name = name;
        this.address = address;
        this.phone = phone;

    }


    // method for making random customerID
    public void makeID() // works on 1/25/18
    {
        int id = ID;
        id = (int) ((int) this.getID() * 1.314234);
        id =  (int) (Math.random() * id);
        setID(id);
    }


    // setter methods
    public void setName(String name)
    {
        this.name = name;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setID(int ID)
    {
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

