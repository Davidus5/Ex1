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
        int ans = 0;
        // add your code here
        String[] parts = num.split("b");
        String numberPart = parts[0];
        String base = parts[1];
        String valid = "0123456789ABCDEF";
        int true_base = valid.indexOf(base.toCharArray()[0]);
        int len = numberPart.length();
        for(int i = 0; i<len; i++)
        {
            int k = valid.indexOf(numberPart.toCharArray()[i]);
            ans += (int) (k*Math.pow(true_base, (len - i - 1)));
        }

        ////////////////////
        return ans;
    }


    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     *
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        boolean ans = true;
        // add your code here.
        String valid = "23456789ABCDEFG";
        int index = a.indexOf('b');
        String base, num;


        if (index != -1 && index == a.lastIndexOf('b') && a.lastIndexOf('b') == a.length() - 2
                && index != 0) {
            base = a.split("b")[1];

            if (!valid.contains(base)) {
                return false;
            }
            valid = "0123456789ABCDEFG";
            num = a.split("b")[0];
            valid = valid.split(base)[0];
            for (int i = 0; i < num.length(); i++) {
                char b = num.charAt(i);
                if (valid.indexOf(b) == -1) {
                    return false;
                }
            }
        } else {
            return false;
        }

        ////////////////////
        return ans;
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
        String valid = "0123456789ABCDEFG";

        if (num < 0 || base < 2 || base > 16) {
            return ""; // Return an empty string for invalid input
        }
        StringBuilder ans = new StringBuilder();
        while (num > 0) {
            int remainder = num % base;// Find the remainder when num is divided by base
            // Determine the character for the current digit:
            // - '0' to '9' for values 0–9
            // - 'A' to 'F' for values 10–1
            char digit = (char) (remainder < 10 ? '0' + remainder : 'A' + (remainder - 10));
            ans.append(digit);
            num /= base;
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
        int ans = 0;
        int value2, maxValue;
        // add your code here
        maxValue = number2Int(arr[0]);
        for(int i = 0; i < arr.length - 1; i++) {
            value2 = number2Int(arr[i+1]);
            if(maxValue < value2)
            {
                ans = i+1;
                maxValue = value2;
            }
        }
        ////////////////////
        return ans;// Return the index of the largest number
    }

}