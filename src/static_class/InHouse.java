package static_class;

public class InHouse extends OrderInfo
{

    // typeID
    private  String typeID;


    // default constructor
    public InHouse()
    {
        typeID = "H";
    }

    @Override
    public String getTypeID() {
        String id = typeID +getID();
        return id;
    }

} // end of InHouse class
