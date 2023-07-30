import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EX7 {

    static ArrayList<Integer> user_array = new ArrayList<>();
    static int arr_size;

    public static void main(String[] args) {

        System.out.println("before start the menu .. enter the size of array you want: ");
        arr_size = userInput();
        startMenu();

    }


//    user input,,,  reusable method
    public static int userInput () {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        try{
            input = scanner.nextInt();
        }catch (InputMismatchException e) {
            System.out.println("*** please you should enter number only :) ***");
        }

        return input;
    }


//    check if array empty,,,  reusable code
    public static void checkArray() throws Exception {
        if (user_array.isEmpty()) {
            throw new Exception("there is no array,, continue to enter an array");
        }
    }


//    user fill out the array,,,  reusable code
    public static void fillArray(int size) {
        System.out.println("please enter " +size+ " number of the array: ");
        for (int i = 0; i < size; i++) {
            user_array.add(userInput());
        }
    }

    //    try-catch for empty array,,, reusable code
    public static void testArray() {
        try {
            checkArray();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fillArray(arr_size);
        }
    }

    public static void startMenu() {
        int option;
        do {
            System.out.println("\nPlease select one option: "
                    + "\n 1.Accept elements of an array."
                    + "\n 2.Display elements of an array. "
                    + "\n 3.Search the element within array. "
                    + "\n 4.Sort the array. "
                    + "\n 5.Stop."
                    + "\n\n select now...");

            option = userInput();



            if (option == 1) {
                testArray();
            } else if (option == 2) {
                testArray();
                System.out.println("elements of array are: " + user_array);
            } else if (option == 3) {
                testArray();
                System.out.println("please enter a number to search it in array: ");
                int search_element = userInput();
                for ( int e : user_array ){
                    if (e == search_element)
                        System.out.println("the element is in index " + user_array.indexOf(e));
                }
            } else if (option == 4) {
                testArray();
                System.out.println("the origin array: " + user_array);
                user_array.sort(Comparator.naturalOrder());
                System.out.println("the sorted array: " + user_array);
            } else if (option == 5) {
                System.out.println("you exit the menu...");
                break;
            } else System.out.println("invalid entry...");
        }while (true);
    }

}