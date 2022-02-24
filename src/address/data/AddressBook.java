package address.data;

import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * AddressBook represents book of address entries.
 *
 * This class is implemented as a singleton since `v0.6`.
 *
 * @author Arshdeep Padda
 * @since v0.1
 */
public final class AddressBook
{
    /* Singleton */

    /** Singular AddressBook Instance */
    private static AddressBook INSTANCE;

    /** Private Constructor */
    private AddressBook ()
    {

    }

    /**
     * Return singular instance of AddressBook.
     *
     * One is created if not already instantiated.
     *
     * @return Singleton AddressBook instance
     */
    public static AddressBook getInstance()
    {
        if (INSTANCE == null) INSTANCE = new AddressBook();
        return INSTANCE;
    }

    /* Fields */

    /**
     * addressEntryList: address store.
     */
    TreeMap<String, AddressEntry> addressEntryList = new TreeMap<String, AddressEntry>();

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
        int n = 1;
        for (Map.Entry<String, AddressEntry> entry : this.addressEntryList.entrySet())
        {
            System.out.print(n++); System.out.print(") ");
            System.out.println(entry.getValue());
            System.out.println();
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
        addressEntryList.put(address.getLastName(), address);
    }

    /**
     * Remove AddressEntry from AddressEntry store.
     *
     * @param address_entry AddressEntry to remove from store.
     *
     * @author Arshdeep Padda
     * @since v0.4
     */
    public void remove(AddressEntry address_entry)
    {
        addressEntryList.remove(address_entry.getLastName());
    }

    /**
     * Find contacts whose last name is or begins with specified prefix.
     * @param lastname Last name (whole or prefix) to search for.
     * @return Array of AddressEntry's matching query.
     */
    public AddressEntry[] find(String lastname)
    {
        if (lastname.length() < 1)
            return new AddressEntry[] {};
        String toKey = Character.toString(lastname.charAt(0)+1);
        NavigableMap<String, AddressEntry> range = addressEntryList.subMap(
                lastname, true, toKey, false
        );
        ArrayList<AddressEntry> contacts = new ArrayList<>();
        for (Map.Entry<String, AddressEntry> entry : range.entrySet())
        {
            if (entry.getValue().getLastName().startsWith(lastname))
                contacts.add( entry.getValue().getCopy() );
        }
        return contacts.toArray(new AddressEntry[0]);
    }

    /**
     * Initialize address book from file source.
     *
     * Assumes: variable number of complete contact entries.
     *
     * If filename is inaccessible, a message is printed to console
     * and function exits.
     *
     * @param filename Filename of file on disk.
     *
     * @author Arshdeep Padda
     * @since v0.4
     */
    public void init (String filename)
    {
        try {
            BufferedReader file = new BufferedReader(
                    new FileReader(filename)
            );
            String line;
            while ((line = file.readLine()) != null)
            {
                if (line.equals("")) continue;
                String lname = file.readLine();
                this.addressEntryList.put(
                        lname,
                        new AddressEntry(
                                line,
                                lname,
                                file.readLine(),
                                file.readLine(),
                                file.readLine(),
                                Integer.parseInt(file.readLine()),
                                file.readLine(),
                                file.readLine()
                        )
                );
            }
        } catch (IOException e)
        {
            System.out.print("Unable to open specified file: ");
            System.out.println(filename);
        }
    }
}
