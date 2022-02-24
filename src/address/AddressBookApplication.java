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
        ae1.setZip(Integer.parseInt("94533"));
        ae1.setEmail("adaler@gmail.com");
        ae1.setPhone("(514) 231-1233");

        ae2.setFirstName("Jackson");
        ae2.setLastName("Oz");
        ae2.setStreet("123 Main St");
        ae2.setCity("San Francisco");
        ae2.setState("CA");
        ae2.setZip(Integer.parseInt("94413"));
        ae2.setEmail("joz@gmail.com");
        ae2.setPhone("(112) 231-4111");

        ab.add(ae1);
        ab.add(ae2);
    }
}
