import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class MiRomanNumeralTest
{
	private String word;   // Test fixture
	private RomanNumeral number;

   @Before      // Set up - Called before every test method.
   public void setUp()
   {
	  number = new RomanNumeral();
      word = new String();
   }

   @After      // Tear down - Called after every test method.
   public void tearDown()
   {
	  number = null;
      word = null;  // redundant in this example!
   }

	@Test
   public void testForNull()
   {
      word = null;
      //try {
         assertTrue("Invalid repeated letters", -1 == number.convierte (word));
      //} catch (NullPointerException e) {
        // return;
      //}
      //fail ("NullPointerException expected");
   }
   
  /* @Test (expected = IllegalArgumentException.class)
   public void testEmptyList()
   {
      RomanNumeral.convierte(word);
   }*/
   
   @Test //(expected = ClassCastException.class)
   @SuppressWarnings ("unchecked")
   public void testMutuallyIncomparable()
   {
   	word = "II1";
      assertTrue("Invalid repeated letters", -1 == number.convierte (word));
   }
   
   @Test //(expected = ClassCastException.class)
   @SuppressWarnings ("unchecked")
   public void testcuatroI()
   {
   	word = "IIII";
      assertTrue("Invalid repeated letters", -1 == number.convierte (word));
   }
   
   @Test //(expected = ClassCastException.class)
   @SuppressWarnings ("unchecked")
   public void testcuatroC()
   {
   	word = "CCCC";
      assertTrue("Invalid repeated letters", -1 == number.convierte (word));
   }
   
   @Test //(expected = ClassCastException.class)
   @SuppressWarnings ("unchecked")
   public void testcuatroX()
   {
   	word = "XXXX";
      assertTrue("Invalid repeated letters", -1 == number.convierte (word));
   }
   
   @Test //(expected = ClassCastException.class)
   @SuppressWarnings ("unchecked")
   public void testdosL()
   {
   	word = "LL";
      assertTrue("Invalid repeated letters", -1 == number.convierte (word));
   }
   
   @Test //(expected = ClassCastException.class)
   @SuppressWarnings ("unchecked")
   public void testdosV()
   {
   	word = "VV";
      assertTrue("Invalid repeated letters", -1 == number.convierte (word));
   }
   
   @Test //(expected = ClassCastException.class)
   @SuppressWarnings ("unchecked")
   public void testdosD()
   {
   	word = "DD";
      assertTrue("Invalid repeated letters", -1 == number.convierte (word));
   }
   
}
