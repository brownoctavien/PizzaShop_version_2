package static_class;

public class InHouse extends OrderInfo
{

    static String ID;


    // default constructor
    public InHouse()
    {
        typeID = "H";
    }

    public static String getID()
    {
        return InHouse.ID;
    }
    public static void makeID()
    {
        typeID = "H";

        InHouse.ID = InHouse.typeID + OrderInfo.ID;
    }

} // end of InHouse class
