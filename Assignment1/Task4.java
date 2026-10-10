 
package Assignment1;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        System.out.println("\n--- String Operations ---");

        System.out.println("String: " + str);
        System.out.println("Length: " + str.length());
        System.out.println("Is Empty: " + str.isEmpty());

        if (!str.isEmpty()) {
            System.out.println("Character at index 0: " + str.charAt(0));
        } else {
            System.out.println("Character at index 0: Not available");
        }

        System.out.println("To String: " + str.toString());
        System.out.println("Equals 'Hello': " + str.equals("Hello"));
        System.out.println("Compare To 'Hello': " + str.compareTo("Hello"));
        System.out.println("Contains 'Hello': " + str.contains("Hello"));
        System.out.println("Index of 'l': " + str.indexOf('l'));
        System.out.println("Last Index of 'l': " + str.lastIndexOf('l'));
        System.out.println("Starts With 'H': " + str.startsWith("H"));
        System.out.println("Ends With 'o': " + str.endsWith("o"));
        System.out.println("Matches '.*o.*': " + str.matches(".*o.*"));

        if (str.length() >= 5) {
            System.out.println("Substring (0, 5): " + str.substring(0, 5));
        } else {
            System.out.println("Substring (0, 5): String length is less than 5");
        }

        System.out.println("To Lower Case: " + str.toLowerCase());
        System.out.println("Trim: " + str.trim());
        System.out.println("Replace 'l' with 'L': " + str.replace('l', 'L'));

        String trimmed = str.trim();

        if (!trimmed.isEmpty()) {
            String[] words = trimmed.split("\\s+");

            System.out.println("Split into words:");
            for (String word : words) {
                System.out.println(word);
            }

            System.out.println("Join with '-': " + String.join("-", words));
        } else {
            System.out.println("Split into words: No words available");
            System.out.println("Join with '-': ");
        }

        int number = 100;
        System.out.println("Value Of (100): " + String.valueOf(number));

        // Difference between String, StringBuffer and StringBuilder
        System.out.println("\n--- String, StringBuffer and StringBuilder ---");

        // String is immutable
        String s = "Hello";
        s.concat(" World");
        System.out.println("String after concat: " + s);

        // StringBuffer is mutable and synchronized
        StringBuffer sbf = new StringBuffer("Hello");
        sbf.append(" World");
        System.out.println("StringBuffer after append: " + sbf);

        // StringBuilder is mutable and not synchronized
        StringBuilder sbd = new StringBuilder("Hello");
        sbd.append(" World");
        System.out.println("StringBuilder after append: " + sbd);

        sc.close();
    }
}
 