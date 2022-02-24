package address.data;

/**
 * AddressEntry represents singular address / contact entry.
 *
 * It includes fields such as: First name, last name,
 * street, city, state, and ZIP, email, and phone.
 *
 * @author Arshdeep Padda
 * @since v0.1
 */
public class AddressEntry
{
    /* Fields */

    /** First name. */
    private String firstName;
    /** Last name. */
    private String lastName;
    /** Street address. */
    private String street;
    /** City. */
    private String city;
    /** State. */
    private String state;
    /** ZIP. */
    private Integer zip;
    /** Phone. */
    private String phone;
    /** Email. */
    private String email;

    /* Constructors */

    /**
     * Constructs AddressEntry with empty strings.
     *
     * @author Arshdeep Padda
     * @since v0.1
     */
    public AddressEntry()
    {
        this.firstName = null;
        this.lastName = null;
        this.street = null;
        this.city = null;
        this.state = null;
        this.zip = 0;
        this.email = null;
        this.phone = null;
    }

    /**
     * Construct AddressEntry using all 8 contact fields.
     *
     * @param firstName First name
     * @param lastName Last name
     * @param street Street
     * @param city City
     * @param state State
     * @param zip ZIP
     * @param phone Phone
     * @param email Email
     */
    public AddressEntry
    (
        String firstName, String lastName,
        String street, String city, String state, Integer zip,
        String phone, String email
    )
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    /* Methods */

    /**
     * Copy present instance and return new object with same properties.
     * @return New AddressEntry object that is copied of this instance.
     * @author Arshdeep Padda
     * @since v0.6
     */
    public AddressEntry getCopy()
    {
        return new AddressEntry(
          this.firstName,
          this.lastName,
          this.street,
          this.city,
          this.state,
          this.zip,
          this.phone,
          this.email
        );
    }

    /**
     * Returns string representation of contact.
     *
     * All 8 fields of contact over 5 lines.
     *      First Last
     *      Street
     *      City, State, ZIP
     *      Email
     *      Phone
     *
     * @return String representation of present AddressEntry.
     *
     * @author Arshdeep Padda
     * @since 0.01
     */
    public String toString()
    {
        return firstName + " " + lastName + "\n" +
                street + "\n" +
                city + ", " + state + " " + zip + "\n" +
                email + "\n" + phone;
    }

    /* Getters and Setters */

    /**
     * Get first name.
     * @return First name.
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Set first name.
     * @param firstName First name.
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Get last name.
     * @return Last name.
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Set last name.
     * @param lastName Last name.
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Get street.
     * @return Street.
     */
    public String getStreet()
    {
        return street;
    }

    /**
     * Set street.
     * @param street Street.
     */
    public void setStreet(String street)
    {
        this.street = street;
    }

    /**
     * Get city.
     * @return City.
     */
    public String getCity()
    {
        return city;
    }

    /**
     * Set City.
     * @param city City.
     */
    public void setCity(String city)
    {
        this.city = city;
    }

    /**
     * Get state.
     * @return State.
     */
    public String getState()
    {
        return state;
    }

    /**
     * Set state.
     * @param state State.
     */
    public void setState(String state)
    {
        this.state = state;
    }

    /**
     * Get ZIP.
     * @return ZIP.
     */
    public Integer getZip()
    {
        return zip;
    }

    /**
     * Set ZIP.
     * @param zip ZIP.
     */
    public void setZip(Integer zip)
    {
        this.zip = zip;
    }

    /**
     * Get Phone.
     * @return Phone
     */
    public String getPhone()
    {
        return phone;
    }

    /**
     * Set Phone.
     * @param phone Phone
     */
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    /**
     * Get Email.
     * @return Email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Set Email.
     * @param email Email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
}
