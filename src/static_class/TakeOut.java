package static_class;
public class TakeOut extends OrderInfo
{

    // creating variables
    private String typeID;
    int boxAmount;
    int phoneNumber;


    // default constructor
    public TakeOut()
    {
        typeID = "T";
        boxAmount =0;
        phoneNumber =0;
    }

    //getter and setter
    @Override
    public String getTypeID() {
        String id = typeID +getID();
        return id;
    }
    public int getBoxAmount(){
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


} // end TakeOut class