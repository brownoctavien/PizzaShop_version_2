package static_class;
public class TakeOut extends OrderInfo
{

    // creating variables
    static int boxAmount;
    static int phoneNumber;
    static String ID;


    // default constructor
    public TakeOut()
    {
        typeID = "T";
        boxAmount =0;
        phoneNumber =0;
    }

    //getter and setter

    public static int getBoxAmount(){
        return boxAmount;
    }
    public int getPhoneNumber(){
        return phoneNumber;
    }
    public void setBoxAmount(int amount){
        this.boxAmount = amount;
    }
    public  void setPhoneNumber(int phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public static String getID(){
        return TakeOut.ID;
    }
    public static void makeID() {
        /*Random rand = new Random();
        int id = rand.nextInt(1001)+ 1; //random number 1-1000;*/
        typeID = "T";

        TakeOut.ID = TakeOut.typeID + OrderInfo.ID;
    }


} // end TakeOut class