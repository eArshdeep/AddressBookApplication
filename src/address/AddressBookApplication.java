package address;

import address.data.AddressBook;
import address.data.AddressEntry;

import java.io.*;

/**
 * main AddressBookApplication: invoke some methods of the Menu class.
**/
public class AddressBookApplication
{
    /**
     * Test out features of AddressBook.
     */
    public static void main(String[] args)
    {
        AddressBook ab = new AddressBook();
        AddressEntry ae1 = new AddressEntry();
        AddressEntry ae2 = new AddressEntry();

        ae1.setFirstName("Augustus");
        ae1.setLastName("Daler");
        ae1.setStreet("123 Paseo St");
        ae1.setCity("Hayward");
        ae1.setState("CA");
        ae1.setZip("94533");
        ae1.setEmail("adaler@gmail.com");
        ae1.setPhone("(514) 231-1233");

        ae2.setFirstName("Jackson");
        ae2.setLastName("Oz");
        ae2.setStreet("123 Main St");
        ae2.setCity("San Francisco");
        ae2.setState("CA");
        ae2.setZip("94413");
        ae2.setEmail("joz@gmail.com");
        ae2.setPhone("(112) 231-4111");

        ab.add(ae1);
        ab.add(ae2);

        init("AddressInputDataFile.txt", ab);
        ab.list();
    }

    /**
     * Initialize address book from file source.
     *
     * Assumes: variable number of complete contact entries.
     *
     * @param filename Filename of file on disk.
     * @param ab AddressBook instance to add parsed entries to.
     *
     * @author Arshdeep Padda
     * @since v0.3
     */
    static void init (String filename, AddressBook ab)
    {
        try {
            BufferedReader file = new BufferedReader(
                    new FileReader(filename)
            );
            String line;
            while ((line = file.readLine()) != null)
            {
                if (line.equals("")) continue;
                ab.add(
                        new AddressEntry(
                                line,
                                file.readLine(),
                                file.readLine(),
                                file.readLine(),
                                file.readLine(),
                                file.readLine(),
                                file.readLine(),
                                file.readLine()
                        )
                );
            }
        } catch (IOException e)
        {
            System.out.print("Unable to open specified file: ");
            System.out.println(filename);
            System.exit(99);
        }
    }
}
