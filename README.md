This project is a solution to Ex1, which involves designing a number formatting converter and calculator.
 The program works with numbers represented as strings in various bases (binary to hexadecimal).
 The primary goal is to validate and manipulate these string representations.
 
Features:

Convert Numbers to Decimal

Functionality to convert a number from a specified base (2–16) into its decimal (base-10) representation.
Validate Number Formats

Checks if a string is in a valid number format for the given base.
Convert Decimal to Base Representation

Converts a decimal number into its string representation in a specified base.
Compare Numbers Across Bases

Determines if two numbers (in different bases) are equivalent.
Find the Largest Number in an Array

Identifies the index of the largest number (in decimal value) from an array of numbers represented as strings.

How It Works:

Number Format
Numbers are represented as strings in the format:
<number><b><base>

Example:
135bA (base-10 default)
100111b2 (binary)
12345b6 (base-6)
Invalid Formats
Examples of invalid inputs:

b2
0b1
123b
1234b11

Acknowledgments

Inspired by the assignment description provided in this document.
https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/edit
Built for educational purposes to explore string manipulation and base conversions in Java.
