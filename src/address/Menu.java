package address;

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
    /** Private Scanner instance. */
    private final Scanner scanner;

    /**
     * Set up Menu by setting up scanner.
     * @author Arshdeep Padda
     * @since v0
    */
    Menu()
    {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Prompt user a query via stdio and return response.
     *
     * Note: query is printed without implict newline.
     *
     * @param query - Query to prompt user.
     * @return String - User response.
     *
     * @author Arshdeep Padda
     * @since v0
    */
    public String prompt(String query)
    {
        System.out.print(query);
        return this.scanner.nextLine();
    }

    /**
     * Prompt user for first name.
     * @return String - User input.
     *
     * @author Arshdeep Padda
     * @since v0
    */
    public String prompt_FirstName()
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
    public String prompt_LastName()
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
    public String prompt_Street()
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
    public String prompt_City()
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
    public String prompt_State()
    {
        return prompt("State: ");
    }

    /**
     * Prompt user for zip.
     * @return String - User input.
     *
     * @author Arshdeep Padda
     * @since v0
    */
    public String prompt_Zip()
    {
        return prompt("ZIP: ");
    }

    /**
     * Prompt user for telephone.
     * @return String - User input.
     *
     * @author Arshdeep Padda
     * @since v0
    */
    public String prompt_Telephone()
    {
        return prompt("Telephone: ");
    }

    /**
     * Prompt user for email.
     * @return String - User input.
     *
     * @author Arshdeep Padda
     * @since v0
    */
    public String prompt_Email()
    {
        return prompt("Email: ");
    }
}
