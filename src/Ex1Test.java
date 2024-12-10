import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import assignments.ex1.Ex1;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
        @Test
        void computeNumberTest() {
            String s2 = "1011b2";
            int v = Ex1.number2Int(s2);
            assertEquals(v,11);
            String s10 = "1011bA";
            v = Ex1.number2Int(s10);
            s2 = Ex1.int2Number(v,2);
            int v2 = Ex1.number2Int(s2);
            assertEquals(v,v2);
            assertTrue(Ex1.equals(s10,s2));
        }

        @Test
        void isBasisNumberTest() {
            String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
            for(int i=0;i<good.length;i=i+1) {
                boolean ok = Ex1.isNumber(good[i]);
                assertTrue(ok);
            }
            String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
            for(int i=0;i<not_good.length;i=i+1) {
                boolean not_ok = Ex1.isNumber(not_good[i]);
                assertFalse(not_ok);
            }
        }
        @Test
        void int2NumberTest() {
           // implement this test
            assertEquals("101b2", Ex1.int2Number(5, 2), "5 in base 2 should be '101b2'");
            assertEquals("15b10", Ex1.int2Number(15, 10), "15 in base 10 should be '15b10'");
            assertEquals("FAb16", Ex1.int2Number(250, 16), "250 in base 16 should be 'FAb16'");
            assertEquals("100b4", Ex1.int2Number(16, 4), "16 in base 4 should be '100b4'");
            assertEquals("0b2", Ex1.int2Number(0, 2), "0 in base 2 should be '0b2'");
            // Test invalid inputs
            assertEquals("", Ex1.int2Number(-1, 10), "Negative numbers should return an empty string");
            assertEquals("", Ex1.int2Number(10, 1), "Base less than 2 should return an empty string");
            assertEquals("", Ex1.int2Number(10, 17), "Base greater than 16 should return an empty string");

            // Test edge cases
            assertEquals("1b2", Ex1.int2Number(1, 2), "1 in base 2 should be '1b2'");
            assertEquals("A00b16", Ex1.int2Number(2560, 16), "2560 in base 16 should be 'A00b16'");
            assertEquals("1111b2", Ex1.int2Number(15, 2), "15 in base 2 should be '1111b2'");




        }
        @Test
        void maxIndexTest() {
            // implement this
            // Test with valid arrays
            String[] arr1 = {"101b2", "111b2", "10b2"}; // Values: 5, 7, 2 in decimal
            assertEquals(1, Ex1.maxIndex(arr1), "The maximum value is at index 1 (111b2)");

            String[] arr2 = {"A0b16", "9b10", "5b8"}; // Values: 160, 9, 5 in decimal
            assertEquals(0, Ex1.maxIndex(arr2), "The maximum value is at index 0 (A0b16)");

            String[] arr3 = {"10b2", "10b2", "10b2"}; // All values are equal (2 in decimal)
            assertEquals(0, Ex1.maxIndex(arr3), "When all values are equal, the first index should be returned");

            String[] arr4 = {"1b2", "1b3", "1b16"}; // Values: 1, 1, 1 in decimal
            assertEquals(0, Ex1.maxIndex(arr4), "All values are equal, return the first index");

            // Test with a single-element array
            String[] arr5 = {"101b2"}; // Value: 5 in decimal
            assertEquals(0, Ex1.maxIndex(arr5), "With a single element, the index should be 0");

            String[] arr6 = {};
            try {
                Ex1.maxIndex(arr6);
                fail("An exception should be thrown for an empty array");
            } catch (ArrayIndexOutOfBoundsException e) {
                // Test passes, as this behavior is expected
            }
            // Add additional test functions - test as much as you can.

        }