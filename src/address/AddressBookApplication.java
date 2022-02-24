package address;

import address.data.*;

/**
 * Address Book Application
 *
 * Sets up loop for program. User is prompted for via Menu,
 * and Menu user choice handlers are fired.
 *
 * @author Arshdeep Padda
**/
public class AddressBookApplication
{
    /**
     * Start program loop and prompt user for input via Menu.
     */
    public static void main(String[] args)
    {
        AddressBook ab = AddressBook.getInstance();
        ab.init("AddressInputDataFile.txt"); // TODO: remove

        String input = Menu.displayMenu();
        while (!input.equals("f"))
        {
            switch (input.charAt(0))
            {
                case 97: // a, load
                    Menu.load();
                    break;
                case 98: // b, add
                    Menu.add();
                    break;
                case 99: // c, remove
                    Menu.remove();
                    break;
                case 100: // d, find
                    Menu.find();
                    break;
                case 101: // e list
                    Menu.list();
                    break;
            }
            input = Menu.displayMenu();
        }
        Menu.exit();
    }
}
