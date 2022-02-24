package address.data;

import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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
        for (Map.Entry<String, AddressEntry> entry : this.addressEntryList.entrySet())
        {
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
     *
     *
     * @param address_entry
     *
     * @author Arshdeep Padda
     * @since v0.4
     */
    public void remove(AddressEntry address_entry)
    {
        addressEntryList.remove(address_entry.getLastName());
    }

    /**
     *
     * @param lastname Last name (whole or prefix) to search for.
     * @return
     */
    public AddressEntry[] find(String lastname)
    {
        String toKey = Character.toString(lastname.charAt(0)+1);
        NavigableMap<String, AddressEntry> range = addressEntryList.subMap(
                lastname, true, toKey, false
        );

        System.out.println("Find:\n");
        for (Map.Entry<String, AddressEntry> entry : range.entrySet())
        {
            System.out.println(entry.getValue());
            System.out.println();
        }

        return range.values().toArray(new AddressEntry[0]);
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
