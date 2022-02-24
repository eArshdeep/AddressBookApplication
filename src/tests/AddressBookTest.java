package tests;

import address.data.AddressBook;
import address.data.AddressEntry;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest
{

    @Test
    void getInstance()
    {
        AddressBook in1 = AddressBook.getInstance();
        AddressBook in2 = AddressBook.getInstance();
        assertSame(in1, in2);
    }

    @Test
    @Order(4)
    void list()
    {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        AddressBook ab = AddressBook.getInstance();
        ab.list();

        ab.add(new AddressEntry(
                "Bob",
                "Marius",
                "123 Main St",
                "Hayward",
                "CA",
                94500,
                "bmar@gmail.com",
                "1234441222"
        ));

        ab.add(new AddressEntry(
                "Bob",
                "Pius",
                "123 Main St",
                "Hayward",
                "CA",
                94500,
                "bmar@gmail.com",
                "1234441222"
        ));

        ab.list();

        final String outString = out.toString();

        String expected = "1) Marcus Gaius\n" +
                "12 Frank Ave\n" +
                "Union City, CA 94112\n" +
                "gm@gmail.com\n" +
                "301-313-2211\n" +
                "\n" +
                "2) Bob Janner\n" +
                "993 Bicker Ave\n" +
                "San Leandro, CA 94513\n" +
                "bjanner@hotmail.com\n" +
                "300-312-4999\n" +
                "\n" +
                "3) Gaius Julius\n" +
                "1 Round Way\n" +
                "Sausalito, CA 94199\n" +
                "gjul@icloud.com\n" +
                "133-311-4812\n" +
                "\n" +
                "4) Jackson Oz\n" +
                "3112 Janners Ave\n" +
                "Fremont, CA 94536\n" +
                "joz@gmail.com\n" +
                "514-331-1499\n" +
                "\n" +
                "5) Bob Pius\n" +
                "123 Main St\n" +
                "Hayward, CA 94500\n" +
                "bmar@gmail.com\n" +
                "1234441222\n" +
                "\n" +
                "6) Jay S\n" +
                "912 Om Way\n" +
                "Fremont, CA 94531\n" +
                "jays@gmail.com\n" +
                "123-333-1222\n" +
                "\n" +
                "7) Akash Sing\n" +
                "11231 Fremont Way\n" +
                "Fremont, CA 94513\n" +
                "asing@school.edu\n" +
                "513-312-0931\n" +
                "\n" +
                "8) John Singh\n" +
                "741 My Way\n" +
                "Fremont, CA 93122\n" +
                "jsingh@icloud.com\n" +
                "3123312233\n" +
                "\n" +
                "1) Marcus Gaius\n" +
                "12 Frank Ave\n" +
                "Union City, CA 94112\n" +
                "gm@gmail.com\n" +
                "301-313-2211\n" +
                "\n" +
                "2) Bob Janner\n" +
                "993 Bicker Ave\n" +
                "San Leandro, CA 94513\n" +
                "bjanner@hotmail.com\n" +
                "300-312-4999\n" +
                "\n" +
                "3) Gaius Julius\n" +
                "1 Round Way\n" +
                "Sausalito, CA 94199\n" +
                "gjul@icloud.com\n" +
                "133-311-4812\n" +
                "\n" +
                "4) Bob Marius\n" +
                "123 Main St\n" +
                "Hayward, CA 94500\n" +
                "bmar@gmail.com\n" +
                "1234441222\n" +
                "\n" +
                "5) Jackson Oz\n" +
                "3112 Janners Ave\n" +
                "Fremont, CA 94536\n" +
                "joz@gmail.com\n" +
                "514-331-1499\n" +
                "\n" +
                "6) Bob Pius\n" +
                "123 Main St\n" +
                "Hayward, CA 94500\n" +
                "bmar@gmail.com\n" +
                "1234441222\n" +
                "\n" +
                "7) Jay S\n" +
                "912 Om Way\n" +
                "Fremont, CA 94531\n" +
                "jays@gmail.com\n" +
                "123-333-1222\n" +
                "\n" +
                "8) Akash Sing\n" +
                "11231 Fremont Way\n" +
                "Fremont, CA 94513\n" +
                "asing@school.edu\n" +
                "513-312-0931\n" +
                "\n" +
                "9) John Singh\n" +
                "741 My Way\n" +
                "Fremont, CA 93122\n" +
                "jsingh@icloud.com\n" +
                "3123312233\n\n";

        assertEquals(
                expected,
                outString);
    }

    @Test
    @Order(1)
    void add()
    {
        AddressBook ab = AddressBook.getInstance();
        ab.add(new AddressEntry(
                "Bob",
                "Pius",
                "123 Main St",
                "Hayward",
                "CA",
                94500,
                "bmar@gmail.com",
                "1234441222"
        ));
        assertEquals(1, ab.find("Pius").length);
    }

    @Test
    @Order(3)
    void remove()
    {
        AddressBook ab = AddressBook.getInstance();
        ab.add(new AddressEntry(
                "Bob",
                "Pius",
                "123 Main St",
                "Hayward",
                "CA",
                94500,
                "bmar@gmail.com",
                "1234441222"
        ));
        AddressEntry ae;
        AddressEntry[] addresses = ab.find("Pius");
        int count = addresses.length;

        assertTrue(addresses.length > 0);

        ae = addresses[0];
        ab.remove(ae);

        addresses = ab.find("Pius");
        assertTrue(addresses.length == count-1);
    }

    @Test
    @Order(2)
    void find()
    {
        AddressBook ab = AddressBook.getInstance();

        ab.add(new AddressEntry(
                "Bob",
                "Pius",
                "123 Main St",
                "Hayward",
                "CA",
                94500,
                "bmar@gmail.com",
                "1234441222"
        ));

        assertTrue(ab.find("P").length == 1);
        assertTrue(ab.find("Pius").length == 1);
        assertTrue(ab.find("Piuss").length == 0);
    }

    @Test
    @Order(5)
    void init()
    {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        AddressBook ab = AddressBook.getInstance();
        // Note: Adjust working directory to make path properly resolvable.
        ab.init("./AddressInputDataFile.txt");

        String expected = "1) Marcus Gaius\n" +
                "12 Frank Ave\n" +
                "Union City, CA 94112\n" +
                "gm@gmail.com\n" +
                "301-313-2211\n" +
                "\n" +
                "2) Bob Janner\n" +
                "993 Bicker Ave\n" +
                "San Leandro, CA 94513\n" +
                "bjanner@hotmail.com\n" +
                "300-312-4999\n" +
                "\n" +
                "3) Gaius Julius\n" +
                "1 Round Way\n" +
                "Sausalito, CA 94199\n" +
                "gjul@icloud.com\n" +
                "133-311-4812\n" +
                "\n" +
                "4) Jackson Oz\n" +
                "3112 Janners Ave\n" +
                "Fremont, CA 94536\n" +
                "joz@gmail.com\n" +
                "514-331-1499\n" +
                "\n" +
                "5) Bob Pius\n" +
                "123 Main St\n" +
                "Hayward, CA 94500\n" +
                "bmar@gmail.com\n" +
                "1234441222\n\n" +
                "6) Jay S\n" +
                "912 Om Way\n" +
                "Fremont, CA 94531\n" +
                "jays@gmail.com\n" +
                "123-333-1222\n" +
                "\n" +
                "7) Akash Sing\n" +
                "11231 Fremont Way\n" +
                "Fremont, CA 94513\n" +
                "asing@school.edu\n" +
                "513-312-0931\n" +
                "\n" +
                "8) John Singh\n" +
                "741 My Way\n" +
                "Fremont, CA 93122\n" +
                "jsingh@icloud.com\n" +
                "3123312233\n" + "\n";

        ab.list();
        final String outString = out.toString();
        assertEquals(expected, outString);
    }
}
