package static_class;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

public class PizzaMenu
{

    // creating variables
   static String topping;
    static String size;
    static String count= null;
    static String MenuID= null;


    // default constructor
    public PizzaMenu()
    {

    }

    // setters and getters
    public static void setTopping(String topping)
    {
        PizzaMenu.topping = topping;
    }

    public static String getTopping()
    {
        return topping;
    }
    public static String getMenuID()
    {
        return MenuID;
    }
    public static void setMenuID(String menuID)
    {
        PizzaMenu.MenuID = menuID;
    }
    public static void setCount(String count)
    {
        PizzaMenu.count = count;
    }
    public static String getCount()
    {
        return count;
    }

    public static void setSize(String size)
    {
        PizzaMenu.size = size;
    }

    public static String getSize()
    {
       return size;
    }
} // end of PizzaMenu class
