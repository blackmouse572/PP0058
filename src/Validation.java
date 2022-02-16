import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Validation {
    private final static Scanner in = new Scanner(System.in);

    public static int checkInputIntLimit(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");

                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().toLowerCase().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            }
            else {
                return result;
            }
        }
    }

    public static String checkInputWord(){
        while (true) {
            try {
                String result = in.nextLine().trim().toLowerCase();
                if (result.isEmpty()) {
                    throw new Exception();

                }
                //Use regex to check if input is a word
                if (!result.matches("[a-zA-Z]+")){
                   throw new Exception();
                }
                return result;
            } catch (Exception e) {
                System.out.println("Invalid input!");
                System.out.println("Enter again: ");
            }
        }
    }

    public static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
                System.out.println("Enter again age: ");
            }
        }
    }
    //Get Y/N answer
    public static boolean getYNAnswer() {
        while (true) {
            try {
                String result = in.nextLine().trim().toUpperCase();
                if (result.equals("Y")) {
                    return true;
                } else if (result.equals("N")) {
                    return false;
                }
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Invalid input!");
                System.out.println("Enter again: ");
            }
        }
    }


}
