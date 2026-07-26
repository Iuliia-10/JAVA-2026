package hw_1;

import java.util.ArrayList;

public class Validations {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()_+-=";
    private static final String[] FORBIDDEN_SEQUENCES = {"1234", "abcd", "qwerty", "password", "admin"};

    public ArrayList<String> validate(String password) {
        ArrayList<String> errors = new ArrayList<>();

        if (password.length() < 8 || password.length() > 32) {
            errors.add("Password length must be between 8 and 32 characters.");
        }

        boolean hasUppercase = false;
        for (int i = 0; i < password.length(); i++) {
            if (ALPHABET.contains(String.valueOf(password.charAt(i)))) {
                hasUppercase = true;
                break;
            }
        }
        if (!hasUppercase) {
            errors.add("Password must contain at least one uppercase letter.");
        }

        boolean hasLowercase = false;
        String lowerAlphabet = ALPHABET.toLowerCase();
        for (int i = 0; i < password.length(); i++) {
            if (lowerAlphabet.contains(String.valueOf(password.charAt(i)))) {
                hasLowercase = true;
                break;
            }
        }
        if (!hasLowercase) {
            errors.add("Password must contain at least one lowercase letter.");
        }

        boolean hasDigit = false;
        for (int i = 0; i < password.length(); i++) {
            if (DIGITS.contains(String.valueOf(password.charAt(i)))) {
                hasDigit = true;
                break;
            }
        }
        if (!hasDigit) {
            errors.add("Password must contain at least one digit.");
        }

        boolean hasSpecial = false;
        for (int i = 0; i < password.length(); i++) {
            char letter = password.charAt(i);
            String letterStr = String.valueOf(letter);
            if (SPECIAL_CHARS.contains(letterStr)) {
                hasSpecial = true;
                break;
            }
        }
        if (!hasSpecial) {
            errors.add("Password must contain at least one special character.");
        }

        String lowerPassword = password.toLowerCase();
        boolean hasForbidden = false;
        for (int i = 0; i < FORBIDDEN_SEQUENCES.length; i++) {
            String seq = FORBIDDEN_SEQUENCES[i];

            if (lowerPassword.contains(seq)) {
                hasForbidden = true;
                break;
            }
        }

        if (hasForbidden) {
            errors.add("Password contains forbidden sequence.");
        }

        return errors;
    }
}