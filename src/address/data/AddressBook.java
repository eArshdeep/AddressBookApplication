package address.data;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * AddressBook represents book of address entries.
 *
 * @author Arshdeep Padda
 * @since v0.1
 */
public class AddressBook
{
    /* Fields */

    /**
     * addressEntryList: address store.
     */
    ArrayList<AddressEntry> addressEntryList = new ArrayList<AddressEntry>();

    /* Methods */

    /**
     * List all entries of internal address store.
     *
     * Uses AddressEntry.toString
     *
     * @author Arshdeep Padda
     * @since v0.1
     */
    public void list()
    {
        Iterator<AddressEntry> it = addressEntryList.iterator();
        while (it.hasNext())
        {
            System.out.println(it.next());
        }
    }

    /**
     * Add entry to address book.
     * @param address AddressEntry to add.
     *
     * @author Arshdeep Padda
     * @since v0.1
     */
    public void add(AddressEntry address)
    {
        addressEntryList.add(address);
    }
}
