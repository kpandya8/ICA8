import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;


public class UrinalsTest {


    @Test
    public void testpassfail(){
      //Check for Passing and failing of testcases
      System.out.println(" ====== Krutik Pandya ==== TEST ZERO EXECUTED =======");
      assertEquals(69,69);
  }

    @Test
    public void testInputStringValidity(){
        //Check for Input String Validity
        System.out.println(" ====== Krutik Pandya ==== TEST ONE EXECUTED =======");
        //Test cases that gives true value and follows the unwritten rule
        assertEquals(true, Urinals.goodString("10101"));
        assertEquals(true, Urinals.goodString("1001"));
        assertEquals(true, Urinals.goodString("00000"));
        assertEquals(true, Urinals.goodString("01000"));
        assertEquals(true, Urinals.goodString("00010"));
        assertEquals(true, Urinals.goodString("10000"));
        //String has charachters other than 0's and 1's
        assertEquals(false, Urinals.goodString("(35678)"));
        assertEquals(false, Urinals.goodString("000!s1abc10"));
        assertEquals(false, Urinals.goodString("0111-[]010"));
        assertEquals(false, Urinals.goodString("011!@#1011110"));
        assertEquals(false, Urinals.goodString("011asc1fw231"));
    }

    @Test
    public void testStringLength(){
        //Check for String Length
        System.out.println(" ====== Krutik Pandya ==== TEST TWO EXECUTED =======");
        //String is null
        assertEquals(false, Urinals.goodString(""));
        //String length is greater than 20
        assertEquals(false, Urinals.goodString("000000000000000000000000000000000000000000000"));
        //String length is in valid range
        assertEquals(true, Urinals.goodString("10101"));
        //String length is 1
        assertEquals(true, Urinals.goodString("1"));
        assertEquals(true, Urinals.goodString("0"));
    }
    @Test
    public void testStringFor11s(){
        //Check for String for 11's
        System.out.println(" ====== Krutik Pandya ==== TEST THREE EXECUTED =======");
        //String has consecutive 11's
        assertEquals(false, Urinals.goodString("11"));
        //String has consecutive 11's, 01's, 00's, 10's
        assertEquals(false, Urinals.goodString("11010001101000110"));
        //String has no 11's
        assertEquals(true, Urinals.goodString("10101"));
        assertEquals(true, Urinals.goodString("01"));
        assertEquals(true, Urinals.goodString("000"));
    }

    @Test
    public void testStringForValidOutput(){
        //Check for Valid Output
        System.out.println(" ====== Krutik Pandya ==== TEST FOUR EXECUTED =======");
        //String output based on the example
        assertEquals(1, Urinals.urinalsAvailable("10001"));
        assertEquals(0, Urinals.urinalsAvailable("1001"));
        assertEquals(3, Urinals.urinalsAvailable("00000"));
        assertEquals(2, Urinals.urinalsAvailable("0000"));
        assertEquals(1, Urinals.urinalsAvailable("01000"));
        assertEquals(-1, Urinals.urinalsAvailable("011"));
    }


}