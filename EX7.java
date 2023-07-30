import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EX7 {

    static ArrayList<Integer> user_array = new ArrayList<>();
    static  Scanner scanner = new Scanner(System.in);
    static int arr_size;

    public static void main(String[] args) {
        System.out.println("\n\n Q7 output: ");


        System.out.println("before start the menu .. enter the size of array you want: ");
        arr_size = userInput();
        startMenue(arr_size);

    }

    public static int userInput () {
        int size = 0;
        try{
            size = scanner.nextInt();
        }catch (InputMismatchException e) {
            System.out.println("please you should enter number only :)");
        }

        return size;
    }

    public static void startMenue(int size) {
        do {
            System.out.println("\nPlease select one option: "
                    + "\n 1.Accept elements of an array."
                    + "\n 2.Display elements of an array. "
                    + "\n 3.Search the element within array. "
                    + "\n 4.Sort the array. "
                    + "\n 5.Stop."
                    + "\n\n select now...");

            int option = userInput();



            if (option == 1) {
                System.out.println("please enter " +arr_size+ " number of the array: ");
                for (int i = 0; i < arr_size; i++) {
                    user_array.add(userInput());
                }
            } else if (option == 2) {
                if (user_array.isEmpty()) {
                    System.out.println("please enter " +arr_size+ " number of the array: ");
                    for (int i = 0; i < arr_size; i++) {
                        user_array.add(userInput());
                    }
                }
                System.out.println("elements of array are: " + user_array);
            } else if (option == 3) {
                if (user_array.isEmpty()) {
                    System.out.println("please enter " +arr_size+ " number of the array: ");
                    for (int i = 0; i < arr_size; i++) {
                        user_array.add(userInput());
                    }
                }
                System.out.println("please enter a number to search it in array: ");
                int search_element = userInput();
                for ( int e : user_array ){
                    if (e == search_element)
                        System.out.println("the element is in index " + user_array.indexOf(e));
                }
            } else if (option == 4) {
                if (user_array.isEmpty()) {
                    System.out.println("please enter " +arr_size+ " number of the array: ");
                    for (int i = 0; i < arr_size; i++) {
                        user_array.add(userInput());
                    }
                }
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