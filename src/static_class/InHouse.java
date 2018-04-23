package static_class;

public class InHouse extends OrderInfo
{

    static String ID;


    // default constructor
    public InHouse()
    {
        typeID = "H";
    }

    public static String getID(){
        return InHouse.ID;
    }
    public static void makeID() {
        /*Random rand = new Random();
        int id = rand.nextInt(1001)+ 1; //random number 1-1000;*/
        typeID = "H";

        InHouse.ID = InHouse.typeID + OrderInfo.ID;
    }

} // end of InHouse class
