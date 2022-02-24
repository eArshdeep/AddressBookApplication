package address;

import address.data.AddressBook;
import address.data.AddressEntry;

import java.io.*;

/**
 * @author Arshdeep Padda
**/
public class AddressBookApplication
{
    /**
     * Test out features of AddressBook.
     */
    public static void main(String[] args)
    {
        AddressBook ab = new AddressBook();
        ab.init("AddressInputDataFile.txt");

        String input = Menu.displayMenu();

        while (!input.equals("f"))
        {
            switch (input.charAt(0))
            {
                case 97:
                    ab.init(Menu.prompt("Filename: "));
                    break;
                case 98:
                    ab.add(
                            new AddressEntry(
                                    Menu.prompt_FirstName(),
                                    Menu.prompt_LastName(),
                                    Menu.prompt_Street(),
                                    Menu.prompt_City(),
                                    Menu.prompt_State(),
                                    Menu.prompt_Zip(),
                                    Menu.prompt_Email(),
                                    Menu.prompt_Phone()
                            )
                    );
                    break;
                case 99:
                    String name = Menu.prompt("Last Name to Remove: ");
                    AddressEntry[] contacts = ab.find(name);
                    for (int i=0; i<contacts.length; i++)
                    {
                        System.out.print(i+1);
                        System.out.print(") ");
                        System.out.println(contacts[i]);
                    }
                    Integer choice = Menu.promptInteger("Remove: ");
                    if (choice < 1 || choice > contacts.length)
                    {
                        System.out.println("Invalid deletion choice.");
                        break;
                    }
                    ab.remove(contacts[choice-1]);
                    break;
                case 100:
                    String qname = Menu.prompt("Last name to search for: ");
                    AddressEntry[] results = ab.find(qname);
                    for (int i=0; i<results.length; i++)
                    {
                        System.out.print(i+1);
                        System.out.print(") ");
                        System.out.println(results[i]);
                    }
                    break;
                case 101:
                    System.out.println("\nListing all contacts.");
                    ab.list();
                    break;
            }

            input = Menu.displayMenu();
        }
    }
}
