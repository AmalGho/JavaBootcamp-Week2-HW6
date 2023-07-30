import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    static ArrayList<Integer> results = new ArrayList<>();


    public static void main(String[] args) {

        int option;

        do {

            System.out.println("\n\nEnter 1 to addition the numbers" +
                    "\nEnter 2 to subtraction the numbers"
                    + "\nEnter 3 to multiplication the numbers"
                    + "\nEnter 4 to division the numbers"
                    + "\nEnter 5 to modulus the numbers"
                    + "\nEnter 6 to find minimum number"
                    + "\nEnter 7 to find maximum number"
                    + "\nEnter 8 to find the average of numbers"
                    + "\nEnter 9 to print the last result in calculator"
                    + "\nEnter 10 to print the list of all results in calculator"
                    + "\n ....waiting to enter an option.");

            option = userInput();

            if (option == 1) {
                System.out.println("enter 2 numbers to do the addition: ");
                add(userInput(), userInput(), results);
            } else if (option == 2) {
                System.out.println("enter 2 numbers to do the subtraction: ");
                sub(userInput(), userInput(), results);
            } else if (option == 3) {
                System.out.println("enter 2 numbers to do the multiplication: ");
                multip(userInput(), userInput(), results);
            } else if (option == 4) {
                System.out.println("enter 2 numbers to do the division: ");
                div(userInput(), userInput(), results);
            } else if (option == 5) {
                System.out.println("enter 2 numbers to do the modulus: ");
                mod(userInput(), userInput(), results);
            } else if (option == 6) {
                System.out.println("enter 2 numbers to find the minimum number: ");
                min(userInput(), userInput(), results);
            } else if (option == 7) {
                System.out.println("enter 2 numbers to find the maximum number: ");
                max(userInput(), userInput(), results);
            } else if (option == 8) {
                System.out.println("enter 2 numbers to find the average: ");
                avg(userInput(), userInput(), results);
            } else if (option == 9) {
                checkIndex();
                break;
            } else if (option == 10) {
                System.out.println("th results list: " + results);
                break;
            } else {
                System.out.println("sorry, invalid entry... out of menu");
            }
        }while (true);

    }


//    manage user inputs
    public static int userInput() {
        Scanner data = new Scanner(System.in);
        int option = 0;
        try{
            option = data.nextInt();
        }catch (InputMismatchException e) {
            System.out.println("** please you should enter number only :)");
        }
        return option;
    }


    public static void checkIndex() {
        try{
            results.get(results.size()-1);
            System.out.println("the last result: " + results.get(results.size()-1));
        }catch (IndexOutOfBoundsException e1){
            System.out.println("** you did no operations");
        }catch (NullPointerException e2){
            System.out.println("** the list is empty");
        }
    }

    public static void add(int num1 , int num2, ArrayList results) {
        int result = num1 + num2;
        results.add(result);
        System.out.println("\nthe result of " + num1 + " + " + num2 + " is " + result);
    }

    public static void sub(int num1, int num2, ArrayList results) {
        int result = num1 - num2;
        results.add(result);
        System.out.println("\nthe result of " + num1 + " - " + num2 + " is " + result);
    }

    public static void multip(int num1, int num2, ArrayList results) {
        int result = num1 * num2;
        results.add(result);
        System.out.println("\nthe result of " + num1 + " * " + num2 + " is " + result);
    }

    public static void div(int num1, int num2, ArrayList results) {
        try {
            int result = num1 / num2;
            results.add(result);
            System.out.println("\nthe result of " + num1 + " / " + num2 + " is " + result);
        }catch (ArithmeticException e) {
            System.out.println("** you cannot divide by 0");
        }
    }

    public static void mod(int num1, int num2, ArrayList results) {
        try{
            int result = num1 % num2;
            results.add(result);
            System.out.println("\nthe result of " + num1 + " % " + num2 + " is " + result);
        }catch (ArithmeticException e){
            System.out.println("** you cannot divide by 0");
        }
    }

    public static void min(int num1, int num2, ArrayList results) {
        int min = 0;
        if (num1 <= num2){
            min = num1;
        }else min = num2;
        results.add(min);
        System.out.println("\nthe min of " + num1 + " and " + num2 + " is " + min);
    }

    public static void max(int num1, int num2, ArrayList results) {
        int max = 0;
        if (num1 >= num2){
            max = num1;
        }else max = num2;
        results.add(max);
        System.out.println("\nthe max of " + num1 + " and " + num2 + " is " + max);
    }

    public static void avg(int num1, int num2, ArrayList results) {
        int result = (num1 + num2 ) / 2;
        results.add(result);
        System.out.println("\nthe average of " + num1 + " and " + num2 + " is " + result);
    }
}
