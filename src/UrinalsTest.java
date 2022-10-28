import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;


public class UrinalsTest {


    @Test
    public void testpassfail(){
      //Check for Passing and failing of testcases
      System.out.println(" ====== Krutik Pandya ==== TEST ONE EXECUTED =======");
      assertEquals(69,69);
  }

    @Test
    public void testInputStringValidity(){
        //Check for Passing and failing of testcases
        System.out.println(" ====== Krutik Pandya ==== TEST TWO EXECUTED =======");
        assertEquals(false, Urinals.goodString("1101"));
        assertEquals(true, Urinals.goodString("1001"));
        assertEquals(true, Urinals.goodString("00000"));
        assertEquals(true, Urinals.goodString("01000"));
        assertEquals(true, Urinals.goodString("00010"));
        assertEquals(true, Urinals.goodString("10000"));
        assertEquals(false, Urinals.goodString("011010"));
        assertEquals(false, Urinals.goodString("000110"));
        assertEquals(false, Urinals.goodString("0111010"));
        assertEquals(false, Urinals.goodString("0111011110"));
        assertEquals(false, Urinals.goodString("01111"));

    }

}