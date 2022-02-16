public class Menu {
    public static int menu(){
    System.out.println("======== Dictionary program ========");
    System.out.println("1. Add word");
    System.out.println("2. Delete word");
    System.out.println("3. Translate");
    System.out.println("4. Exit");
    System.out.print("Enter your choice: ");
    return Validation.checkInputIntLimit(1,4);
}}
