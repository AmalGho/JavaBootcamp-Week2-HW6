import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Project1 {

    static String[][] ticTacToe;
    static String turn;

    public static void main(String[] args) {


        ticTacToe = new String[3][3];
        turn = "X";
        String winner = null;

        System.out.println("\n Tic Tac Toe Game :) \n");
        numberSlots();
        printBoard();


        int slot;
        do {

            if (turn == "X"){

                slot = playerInput();

                try {
                    checkValidity(slot);
                    checkAvailability(slot);
                    turn = "O";
                    printBoard();
                    winner = checkWinner();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }


            if (turn == "O") {
                slot = computer();
                if (isEmpty(slot))
                    computer();
                else {
                    System.out.println("\n\n Player " + turn + " turns .. computer choose " + slot +" \n");
                    turn = "X";
                    printBoard();
                    winner = checkWinner();
                }
            }


        }while(winner == null);


        try {
            System.out.println("\n\n\n " + printWinner(winner) );
        }catch (NullPointerException e){
            System.out.println("** game over ,, no one wins **");
        }

    }



    public static int playerInput() {
        Scanner gamer = new Scanner(System.in);
        int slot = 0;
        try {
            System.out.println("\n\n Player " + turn + " turns .. choose place from 1-9 \n");
            slot = gamer.nextInt();
        }catch (InputMismatchException e) {
            System.out.println("** invalid entry, you should enter a number between 1-9 **");
        }
        return slot;
    }


    public static void checkValidity(int input) throws Exception {
        if (!(input > 0 && input <= 9)) {
            throw new Exception("Invalid entry, choose between 1-9");
        }
    }

    public static void checkAvailability(int input) throws Exception{
        if (isEmpty(input)) {
            throw new Exception("slot is not Available, choose another slot");
        }
    }

    //    method to print board
    public static void printBoard() {
        for (int i = 0; i < ticTacToe.length; i++) {
            for (int j = 0; j < ticTacToe[0].length; j++) {
                System.out.print( ticTacToe[i][j]);
                if (j != 2)
                    System.out.print("   |  ");
            }
            if (i != 2)
                System.out.println("\n----+------+----");
        }
    }


    //    method to number slots in the board
    public static void numberSlots() {
        int slot = 0;
        for (int i = 0; i < ticTacToe.length; i++) {
            for (int j = 0; j < ticTacToe[0].length; j++) {
                slot++;
                ticTacToe[i][j] = String.valueOf(slot);
            }
        }
    }


    //    method check whether the slot empty
    public static boolean isEmpty(int slot) {
        for (int i = 0; i < ticTacToe.length; i++) {
            for (int j = 0; j < ticTacToe[0].length; j++) {
                if (ticTacToe[i][j].equals(String.valueOf(slot))){
                    ticTacToe[i][j] = turn;
                    return false;
                }
            }
        }
        return true;
    }


    //    method to generate a random number
    public static int randomNumber() {
        Random random = new Random();
        int number = random.nextInt(9) + 1;
        return number;
    }


    //    method to manage computer choices
    public static int computer() {
        int slot = randomNumber();
        for (int i = 0; i < ticTacToe.length; i++) {
            for (int j = 0; j < ticTacToe[0].length; j++) {
                if (ticTacToe[i][j] == "X" || ticTacToe[i][j] == "O") {
                    slot = randomNumber();
                    break;
                }else break;
            }
        }
        return slot;
    }


    //    method to check the winner
    public static String checkWinner() {

        for (int i = 0; i < 8; i++) {
            String tie = null;
            switch (i) {
                case 0:
                    tie = ticTacToe[0][0] + ticTacToe[0][1] + ticTacToe[0][2];
                    break;
                case 1:
                    tie = ticTacToe[1][0] + ticTacToe[1][1] + ticTacToe[1][2];
                    break;
                case 2:
                    tie = ticTacToe[2][0] + ticTacToe[2][1] + ticTacToe[2][2];
                    break;
                case 3:
                    tie = ticTacToe[0][0] + ticTacToe[1][1] + ticTacToe[2][2];
                    break;
                case 4:
                    tie = ticTacToe[0][2] + ticTacToe[1][1] + ticTacToe[2][0];
                    break;
                case 5:
                    tie = ticTacToe[0][0] + ticTacToe[1][0] + ticTacToe[2][0];
                    break;
                case 6:
                    tie = ticTacToe[0][1] + ticTacToe[1][1] + ticTacToe[2][1];
                    break;
                case 7:
                    tie = ticTacToe[0][2] + ticTacToe[1][2] + ticTacToe[2][2];
                    break;
            }

            if (tie.equals("XXX")) {
                return "X";
            }else if (tie.equals("OOO")) {
                return "O";
            }

        }

//        check draw
        int counter = 0;
        for (int i = 0; i < ticTacToe.length; i++) {
            for (int j = 0; j < ticTacToe[0].length; j++) {
                if (ticTacToe[i][j] == "X" || ticTacToe[i][j] == "O") {
                    counter++;
                }else break;
            }
        }

        if(counter == 9) {
            return "draw";
        }

        return null;
    }


    //    method to print the winner
    static public String printWinner(String winner) {
        if (winner.equalsIgnoreCase("draw")) {
            return "x_x   it is draw :(   x_x";
        }else return "\\o/ \\o/ \\o/   " + winner + " is the winner :)   \\o/ \\o/ \\o/";
    }


}