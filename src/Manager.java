import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;

public class Manager {
    private static File transFile= new File("TransLog.txt");

    public static void addNewWord(HashMap<String, String> hm) {
        System.out.print("Enter English: ");
        String english = Validation.checkInputString();
        if (!checkKeywordExist(hm, english)) {
            if (!Validation.getYNAnswer()) {
                return;
            }
        }
        System.out.print("Enter Vietnamese: ");
        String vietnam = Validation.checkInputString();
        //lowercase word english
        english.toLowerCase();
        //check key word english exist or not
        hm.put(english, vietnam);
        System.err.println("Add successful.");
    }
    public static void removeWord(HashMap<String, String> hm) {
        System.out.print("Enter English: ");
        String english = Validation.checkInputString();
        english.toLowerCase();
        if (!checkKeywordExist(hm, english)) {
            System.err.println("English word is not exist.");
            return;
        }
        hm.remove(english);
        System.err.println("Remove successful.");
    }
    public static void editWord(HashMap<String, String> hm) {
        System.out.print("Enter English: ");
        String english = Validation.checkInputString();
        english.toLowerCase();
        if (!checkKeywordExist(hm, english)) {
            System.err.println("English word is not exist.");
            return;
        }
        System.out.print("Enter Vietnamese: ");
        String vietnam = Validation.checkInputString();
        hm.put(english, vietnam);
        System.err.println("Edit successful.");
    }
    private static boolean checkKeywordExist(HashMap<String, String> hm, String english) {
        english.toLowerCase();
        if (hm.containsKey(english)) {
            System.err.println("English word is exist.");
            return true;
        }
        return false;
    }
    public static void translate(HashMap<String, String> hm) {
        System.out.print("Enter English: ");
        String english = Validation.checkInputString();
        english.toLowerCase();
        if (!checkKeywordExist(hm, english)) {
            System.err.println("English word is not exist.");
            return;
        }
        System.out.println("Vietnamese: " + hm.get(english));
    }
    public static void printAllWords(HashMap<String, String> hm) {
        System.out.println("English\tVietnamese");
        for (String key : hm.keySet()) {
            System.out.println(key + "\t" + hm.get(key));
        }
    }
    public static void searchWord(HashMap<String, String> hm) {
        System.out.print("Enter English: ");
        String english = Validation.checkInputString();
        english.toLowerCase();
        if (!checkKeywordExist(hm, english)) {
            System.err.println("English word is not exist.");
            return;
        }
        System.out.println("Vietnamese: " + hm.get(english));
    }
    public static void save(HashMap<String, String> hm) {
        if (transFile.exists()) {
            System.err.println("File is exist.");
            return;
        }
        try {
            transFile.createNewFile();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return;
        }
        try {
            FileWriter fw = new FileWriter(transFile);
            for (String key : hm.keySet()) {
                fw.write(key + "\t" + hm.get(key) + "\n");
            }
            fw.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());}
    }
}
