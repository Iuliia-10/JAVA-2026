package hw_1;

import java.util.ArrayList;
import java.util.Scanner;

public class ScannerProvider {
    private Scanner scanner;

    public ScannerProvider() {
        this.scanner = new Scanner(System.in);
    }

    public String readPassword() {
        System.out.print("Enter password here: ");
        return scanner.nextLine();
    }

    public void printResult(ArrayList<String> errors) {
        if (errors.isEmpty()) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid.");
            System.out.println("Validation errors are present:");
            System.out.println("Validation errors here:");
            for (String error : errors) {
                System.out.println(error);
            }
        }
    }
}