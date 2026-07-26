package hw_1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ScannerProvider scannerProvider = new ScannerProvider();
        Validations validations = new Validations();

        String password = scannerProvider.readPassword();

        ArrayList<String> errors = validations.validate(password);

        scannerProvider.printResult(errors);
    }
}
