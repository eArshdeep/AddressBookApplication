package address.data;

import java.util.ArrayList;
import java.util.Iterator;

public class AddressBook
{
    /* Fields */

    ArrayList<AddressEntry> addressEntryList = new ArrayList<AddressEntry>();

    /* Methods */

    public void list()
    {
        Iterator<AddressEntry> it = addressEntryList.iterator();
        while (it.hasNext())
        {
            System.out.println(it.next());
        }
    }

    public void add(AddressEntry address)
    {
        addressEntryList.add(address);
    }
}
