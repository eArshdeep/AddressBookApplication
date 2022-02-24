package address;

import address.data.AddressBook;
import address.data.AddressEntry;

import java.util.Scanner;

/**
 * Menu class prompts user for input for various Contact field parameters,
 * e.g. name, address, etc.
 *
 * @author Arshdeep Padda
 * @since v0
**/
public class Menu
{
    /** Scanner for IO. */
    private static final Scanner scanner = new Scanner(System.in);

    /** AddressBook Singleton */
    private static AddressBook ab = AddressBook.getInstance();

    /**
     * @author Arshdeep Padda
     * @since v0
    */
    Menu()
    {

    }

    /**
     * Prompt user a query via stdio and return response.
     *
     * Note: query is printed without implicit newline.
     *
     * @param query - Query to prompt user.
     * @return String - User response.
     *
     * @author Arshdeep Padda
     * @since v0
    */
    static public String prompt(String query)
    {
        System.out.print(query);
        String in;
        while ((in = scanner.nextLine()).equals(""))
            System.out.print(query);
        return in;
    }

    /**
     * Prompt user for a integer given some prompt query.
     *
     * If input is not an integer, user is notifed as such
     * and asked repetitively for valid input.
     *
     * @param query Prompt to print.
     * @return Integer provided by user.
     */
    static public Integer promptInteger(String query)
    {
        boolean goodInput = false;
        Integer integer = null;
        while (!goodInput)
        {
            String in = prompt(query);
            try {
                integer = Integer.parseInt(in);
                goodInput = true;
            } catch (NumberFormatException nfe)
            {
                System.out.println("Input must be an integer");
            }
        }
        return integer;
    }

    /**
     * Prompt user for first name.
     * @return String - User input.
     *
     * @author Arshdeep Padda
     * @since v0
    */
    public static String prompt_FirstName()
    {
        return prompt("First Name: ");
    }

    /**
     * Prompt user for last name.
     * @return String - User input.
     *
     * @author Arshdeep Padda
     * @since v0
    */
    public static String prompt_LastName()
    {
        return prompt("Last Name: ");
    }

    /**
     * Prompt user for street.
     * @return String - User input.
     *
     * @author Arshdeep Padda
     * @since v0
    */
    public static String prompt_Street()
    {
        return prompt("Street: ");
    }

    /**
     * Prompt user for city.
     * @return String - User input.
     *
     * @author Arshdeep Padda
     * @since v0
    */
    public static String prompt_City()
    {
        return prompt("City: ");
    }

    /**
     * Prompt user for state.
     * @return String - User input.
     *
     * @author Arshdeep Padda
     * @since v0
    */
    public static String prompt_State()
    {
        return prompt("State: ");
    }

    /**
     * Prompt user for ZIP.
     * @return Integer - User input.
     *
     * @author Arshdeep Padda
     * @since v0.4
    */
    public static Integer prompt_Zip()
    {
        return promptInteger("ZIP: ");
    }

    /**
     * Prompt user for telephone.
     * @return String - User input.
     *
     * @author Arshdeep Padda
     * @since v0
    */
    public static String prompt_Phone()
    {
        return prompt("Phone: ");
    }

    /**
     * Prompt user for email.
     * @return String - User input.
     *
     * @author Arshdeep Padda
     * @since v0
    */
    public static String prompt_Email()
    {
        return prompt("Email: ");
    }

    /**
     * printMenuChoices - Print menu choices.
     *
     * This is a purely print-only function.
     *
     * @author Arshdeep Padda
     * @since v0.5
     */
    private static void printMenuChoices()
    {
        System.out.println("a) Load");
        System.out.println("b) Add");
        System.out.println("c) Remove");
        System.out.println("d) Find");
        System.out.println("e) List");
        System.out.println("f) Quit");
    }

    /**
     * Display Menu and return user choice.
     *
     * User choice is validated between [a,f].
     *
     * @return User choice.
     *
     * @author Arshdeep Padda
     * @since v0.5
     */
    public static String displayMenu()
    {
        System.out.println("\nAddress Book Application");
        printMenuChoices();

        String choice = prompt("\nEnter: ");
        while (choice.length() != 1 || choice.charAt(0) < 97 || choice.charAt(0) > 102)
        {
            System.out.println("\nPlease enter valid choice");
            printMenuChoices();
            choice = prompt("\nEnter: ");
        }
        return choice;
    }

    /**
     * Prompt user for filename and call init on ab.
     *
     * @author Arshdeep Padda
     * @since v0.6
     */
    public static void load()
    {
        ab.init(Menu.prompt("Filename: "));
    }

    /**
     * Prompt user for contact addition and call add on ab.
     * All fields of contact are requested from user.
     *
     * @author Arshdeep Padda
     * @since v0.6
     */
    public static void add()
    {
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
    }

    /**
     * Prompt user for search of user to remove, show contact results of
     * search, and perform deletion based on user contact selection.
     *
     * @author Arshdeep Padda
     * @since v0.6
     */
    public static void remove()
    {
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
            return;
        }
        ab.remove(contacts[choice-1]);
    }

    /**
     * Prompt user for search query of last name to search contact store,
     * then display all contacts with last names starting with query as prefix.
     *
     * @author Arshdeep Padda
     * @since v0.6
     */
    public static void find()
    {
        String qname = Menu.prompt("Last name to search for: ");
        AddressEntry[] results = ab.find(qname);
        for (int i=0; i<results.length; i++)
        {
            System.out.print(i+1);
            System.out.print(") ");
            System.out.println(results[i]);
        }
    }

    /**
     * List all contacts.
     *
     * @author Arshdeep Padda
     * @since v0.6
     */
    public static void list()
    {
        System.out.println("\nListing all contacts:");
        ab.list();
    }

    /**
     * Report exit and exit with code zero.
     *
     * Peaceful exit processes, e.g. saving, can be implemented here.
     *
     * @author Arshdeep Padda
     * @since v0.6
     */
    public static void exit()
    {
        System.out.println("Exiting application...");
        System.exit(0);
    }

}
