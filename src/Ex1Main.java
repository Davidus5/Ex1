import java.util.Scanner;
import assignments.ex1.Ex1;

import static assignments.ex1.Ex1.number2Int;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2="", quit = "quit";
        String output_base;
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();

            // add your code here
            if(Ex1.isNumber(num1)) {
                System.out.println("Num1 is valid ");
                System.out.println("Num1 is worth " + number2Int(num1));

                System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                num2 = sc.next();
                if (Ex1.isNumber(num2)){
                    System.out.println("Num2 is valid ");
                    System.out.println("Num2 is worth " + number2Int(num2));
                    System.out.println("Enter a base for output: (a number [2,16]");
                    output_base = sc.next();
                    System.out.println(num1 + " + " + num2 + " = " + Ex1.int2Number(number2Int(num1) + number2Int(num2), Integer.parseInt(output_base)));
                    System.out.println(num1 + " * " + num2 + " = " + Ex1.int2Number(number2Int(num1) * number2Int(num2), Integer.parseInt(output_base)));


                }
                else {
                    System.out.println("Num2 is invalid ");
                }
            }
            else {
                System.out.println("Num1 is invalid ");
            }
                /////////////////////




        }
        System.out.println("quiting now...");
    }
}
