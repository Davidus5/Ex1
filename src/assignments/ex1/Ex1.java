package assignments.ex1;

/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     *
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num) {
        int ans = 0;// Initialize the result variable
        // add your code here

        String[] parts = num.split("b");
        String numberPart = parts[0];// The number part of the input
        String base = parts[1];// The base part of the input
        String valid = "0123456789ABCDEF";// A valid character set for bases up to 16
        int true_base = valid.indexOf(base.toCharArray()[0]);// Determines the numerical value of the base
        int len = numberPart.length();// The length of the number part
        for(int i = 0; i<len; i++)// Iterates over each digit in the number part
        {
            int k = valid.indexOf(numberPart.toCharArray()[i]);// Converts each character to its decimal equivalent
            ans += (int) (k*Math.pow(true_base, (len - i - 1)));// Calculates the decimal value of the digit
        }

        ////////////////////
        return ans;// Returns the calculated decimal value.
    }


    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     *
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        boolean ans = true;// Initialize the result variable to true
        // add your code here.

        String valid = "23456789ABCDEFG";// Valid base characters excluding base 1
        int index = a.indexOf('b');// Finds the position of 'b' in the input string
        String base, num;// Variables to store the base and number parts


        // Checks for basic validity: 'b' is present, occurs only once, and is at the correct position
        if (index != -1 && index == a.lastIndexOf('b') && a.lastIndexOf('b') == a.length() - 2
                && index != 0) {
            base = a.split("b")[1];// Extracts the base part

            if (!valid.contains(base)) {// Redefines valid characters based on the base
                return false;
            }
            valid = "0123456789ABCDEFG";// Reset valid characters for the number part
            num = a.split("b")[0];// Extracts the number part
            valid = valid.split(base)[0];// Redefines valid characters based on the base
            for (int i = 0; i < num.length(); i++) {// Iterates over each character in the number part
                char b = num.charAt(i);// Extracts the current character
                if (valid.indexOf(b) == -1) {// Checks if the character is valid
                    return false;
                }
            }
        } else {
            return false;// Returns false if the format is invalid
        }

        ////////////////////
        return ans;// Returns true if all checks pass
    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     *
     * @param num  the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        //String ans = "";
        // add your code here
        String valid = "0123456789ABCDEFG";// Valid character set for bases up to 16

        if (num < 0 || base < 2 || base > 16) {// Validates input parameters
            return ""; // Return an empty string for invalid input
        }
        StringBuilder ans = new StringBuilder();
        // Initializes a StringBuilder to construct the result

        while (num > 0) {// Loops until all digits are processed
            int remainder = num % base;// Find the remainder when num is divided by base
            // Determine the character for the current digit:
            // - '0' to '9' for values 0–9
            // - 'A' to 'F' for values 10–1
            char digit = (char) (remainder < 10 ? '0' + remainder : 'A' + (remainder - 10));
            ans.append(digit); // Appends the digit to the result
            num /= base;// Reduces num by dividing it by the base
        }
        // Reverse the result since the digits are generated in reverse order
        return ans.reverse().toString() + 'b' + valid.charAt(base);
        ////////////////////
        //return ans;
    }




        /**
         * Checks if the two numbers have the same value.
         * @param n1 first number
         * @param n2 second number
         * @return true iff the two numbers have the same values.
         */
        public static boolean equals(String n1, String n2)
        {
            return number2Int(n1) == number2Int(n2);
            // Compares the decimal representations of the numbers
        }


    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     *
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     */
    public static int maxIndex(String[] arr) {
        int ans = 0;// Initializes the result variable to the first index
        int value2, maxValue;// Variables to store the current value and maximum value
        // add your code here

        maxValue = number2Int(arr[0]);// Sets the maximum value to the first number
        for(int i = 0; i < arr.length - 1; i++) {// Iterates through the array
            value2 = number2Int(arr[i+1]);// Gets the value of the next number
            if(maxValue < value2)// Compares the current max with the next number
            {
                ans = i+1;// Updates the index of the largest number
                maxValue = value2;// Updates the maximum value
            }
        }
        ////////////////////
        return ans;// Return the index of the largest number
    }

}