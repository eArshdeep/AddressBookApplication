package tests;

import address.data.AddressEntry;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressEntryTest
{
    @Test
    public void testEmptyConstructor()
    {
        AddressEntry ae = new AddressEntry();
        assertNull(ae.getFirstName());
        assertNull(ae.getLastName());
        assertNull(ae.getStreet());
        assertNull(ae.getCity());
        assertNull(ae.getState());
        assertEquals(0, ae.getZip());
        assertNull(ae.getPhone());
        assertNull(ae.getEmail());
    }

    @Test
    public void testParamConstructor()
    {
        AddressEntry ae = new AddressEntry(
                "Bob",
                "Marius",
                "123 Main St",
                "Hayward",
                "CA",
                94500,
                "bmar@gmail.com",
                "1234441222"
        );
        assertEquals("Bob", ae.getFirstName());
        assertEquals("Marius", ae.getLastName());
        assertEquals("123 Main St", ae.getStreet());
        assertEquals("Hayward", ae.getCity());
        assertEquals("CA", ae.getState());
        assertEquals(94500, ae.getZip());
        assertEquals("bmar@gmail.com", ae.getEmail());
        assertEquals("1234441222", ae.getPhone());
    }

    @org.junit.jupiter.api.Test
    void getCopy()
    {
        AddressEntry org = new AddressEntry(
                "Bob",
                "Marius",
                "123 Main St",
                "Hayward",
                "CA",
                94500,
                "bmar@gmail.com",
                "1234441222"
        );
        AddressEntry ae = org.getCopy();
        assertEquals("Bob", ae.getFirstName());
        assertEquals("Marius", ae.getLastName());
        assertEquals("123 Main St", ae.getStreet());
        assertEquals("Hayward", ae.getCity());
        assertEquals("CA", ae.getState());
        assertEquals(94500, ae.getZip());
        assertEquals("bmar@gmail.com", ae.getEmail());
        assertEquals("1234441222", ae.getPhone());
        assertNotSame(ae, org);
    }

    @org.junit.jupiter.api.Test
    void testToString()
    {
        AddressEntry ae = new AddressEntry(
                "Bob",
                "Marius",
                "123 Main St",
                "Hayward",
                "CA",
                94500,
                "bmar@gmail.com",
                "1234441222"
        );
        assertEquals(
                "Bob Marius\n123 Main St\nHayward, CA 94500\nbmar@gmail.com\n1234441222",
                ae.toString()
        );
    }

    @org.junit.jupiter.api.Test
    void getFirstName()
    {
        AddressEntry ae = new AddressEntry(
                "Bob",
                "Marius",
                "123 Main St",
                "Hayward",
                "CA",
                94500,
                "bmar@gmail.com",
                "1234441222"
        );
        assertEquals("Bob", ae.getFirstName());
    }

    @org.junit.jupiter.api.Test
    void setFirstName()
    {
        AddressEntry ae = new AddressEntry(
                "Bob",
                "Marius",
                "123 Main St",
                "Hayward",
                "CA",
                94500,
                "bmar@gmail.com",
                "1234441222"
        );
        ae.setFirstName("Jackson");
        assertEquals("Jackson", ae.getFirstName());
    }

    @org.junit.jupiter.api.Test
    void getLastName()
    {
        AddressEntry ae = new AddressEntry(
                "Bob",
                "Marius",
                "123 Main St",
                "Hayward",
                "CA",
                94500,
                "bmar@gmail.com",
                "1234441222"
        );
        assertEquals("Marius", ae.getLastName());
    }

    @org.junit.jupiter.api.Test
    void setLastName()
    {
        AddressEntry ae = new AddressEntry(
                "Bob",
                "Marius",
                "123 Main St",
                "Hayward",
                "CA",
                94500,
                "bmar@gmail.com",
                "1234441222"
        );
        ae.setLastName("Amper");
        assertEquals("Amper", ae.getLastName());
    }

    @org.junit.jupiter.api.Test
    void getStreet()
    {
        AddressEntry ae = new AddressEntry(
                "Bob",
                "Marius",
                "123 Main St",
                "Hayward",
                "CA",
                94500,
                "bmar@gmail.com",
                "1234441222"
        );
        assertEquals("123 Main St", ae.getStreet());
    }

    @org.junit.jupiter.api.Test
    void setStreet()
    {
        AddressEntry ae = new AddressEntry(
                "Bob",
                "Marius",
                "123 Main St",
                "Hayward",
                "CA",
                94500,
                "bmar@gmail.com",
                "1234441222"
        );
        ae.setStreet("0 Technology Way");
        assertEquals("0 Technology Way", ae.getStreet());
    }

    @org.junit.jupiter.api.Test
    void getCity()
    {
        AddressEntry ae = new AddressEntry(
                "Bob",
                "Marius",
                "123 Main St",
                "Hayward",
                "CA",
                94500,
                "bmar@gmail.com",
                "1234441222"
        );
        assertEquals("Hayward", ae.getCity());
    }

    @org.junit.jupiter.api.Test
    void setCity()
    {
        AddressEntry ae = new AddressEntry(
                "Bob",
                "Marius",
                "123 Main St",
                "Hayward",
                "CA",
                94500,
                "bmar@gmail.com",
                "1234441222"
        );
        ae.setCity("San Jose");
        assertEquals("San Jose", ae.getCity());
    }

    @org.junit.jupiter.api.Test
    void getState()
    {
        AddressEntry ae = new AddressEntry(
                "Bob",
                "Marius",
                "123 Main St",
                "Hayward",
                "CA",
                94500,
                "bmar@gmail.com",
                "1234441222"
        );
        assertEquals("CA", ae.getState());
    }

    @org.junit.jupiter.api.Test
    void setState()
    {
        AddressEntry ae = new AddressEntry(
                "Bob",
                "Marius",
                "123 Main St",
                "Hayward",
                "CA",
                94500,
                "bmar@gmail.com",
                "1234441222"
        );
        ae.setState("TX");
        assertEquals("TX", ae.getState());
    }

    @org.junit.jupiter.api.Test
    void getZip()
    {
        AddressEntry ae = new AddressEntry(
                "Bob",
                "Marius",
                "123 Main St",
                "Hayward",
                "CA",
                94500,
                "bmar@gmail.com",
                "1234441222"
        );
        assertEquals(94500, ae.getZip());
    }

    @org.junit.jupiter.api.Test
    void setZip()
    {
        AddressEntry ae = new AddressEntry(
                "Bob",
                "Marius",
                "123 Main St",
                "Hayward",
                "CA",
                94500,
                "bmar@gmail.com",
                "1234441222"
        );
        ae.setZip(12311);
        assertEquals(12311, ae.getZip());
    }

    @org.junit.jupiter.api.Test
    void getPhone()
    {
        AddressEntry ae = new AddressEntry(
                "Bob",
                "Marius",
                "123 Main St",
                "Hayward",
                "CA",
                94500,
                "bmar@gmail.com",
                "1234441222"
        );
        assertEquals("1234441222", ae.getPhone());
    }

    @org.junit.jupiter.api.Test
    void setPhone()
    {
        AddressEntry ae = new AddressEntry(
                "Bob",
                "Marius",
                "123 Main St",
                "Hayward",
                "CA",
                94500,
                "bmar@gmail.com",
                "1234441222"
        );
        ae.setPhone("(511) 121-9912");
        assertEquals("(511) 121-9912", ae.getPhone());
    }

    @org.junit.jupiter.api.Test
    void getEmail()
    {
        AddressEntry ae = new AddressEntry(
                "Bob",
                "Marius",
                "123 Main St",
                "Hayward",
                "CA",
                94500,
                "bmar@gmail.com",
                "1234441222"
        );
        assertEquals("bmar@gmail.com", ae.getEmail());
    }

    @org.junit.jupiter.api.Test
    void setEmail()
    {
        AddressEntry ae = new AddressEntry(
                "Bob",
                "Marius",
                "123 Main St",
                "Hayward",
                "CA",
                94500,
                "bmar@gmail.com",
                "1234441222"
        );
        ae.setEmail("bobmarius@icloud.com");
        assertEquals("bobmarius@icloud.com", ae.getEmail());
    }
}
