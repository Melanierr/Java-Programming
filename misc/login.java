package  randomitem;
import java.util.Scanner;

public class login {
    public static void main(String[] args) {
        // Initialize Scanner at the very top so it's available for all sections
        Scanner scanner = new Scanner(System.in);

        // =========================================================================
        // 1. Email Parser
        // =========================================================================
        String email;
        boolean emailValid = false;

        do {
            System.out.print("Enter your email: ");
            email = scanner.nextLine().trim(); // .trim() removes accidental leading/trailing spaces

            int atSymbol = email.indexOf("@");
            // Basic validation: must contain '@', shouldn't be the first or last character
            if (atSymbol > 0 && atSymbol < email.length() - 1) {
                emailValid = true;
                String emailUsername = email.substring(0, atSymbol);
                String emailDomain = email.substring(atSymbol + 1);

                System.out.println("Username: " + emailUsername);
                System.out.println("Domain: " + emailDomain);
            } else {
                System.out.println("Invalid email, please try again.");
            }
        } while (!emailValid);

        System.out.println(); // Visual separator

        // =========================================================================
        // 2. Username Validator
        // =========================================================================
        String username;
        boolean isValid = false;

        do {
            System.out.print("Enter your username: ");
            username = scanner.nextLine().trim();
            int len = username.length();

            // Combined nested ifs into a single, clean condition
            if (len >= 4 && len <= 12 && !username.contains(" ") && !username.contains("@")) {
                isValid = true;
                System.out.println("Successfully created username.");
            } else {
                System.out.println("Invalid username, please try again!");
            }
        } while (!isValid);

        System.out.println(); // Visual separator

        // =========================================================================
        // 3. Password Strength Checker
        // =========================================================================
        String password;
        boolean passwordValid = false;

        do {
            System.out.print("Enter your password: ");
            password = scanner.nextLine();

            if (password.length() >= 8) {
                // Variables must be reset inside the loop for subsequent attempts
                boolean hasUppercase = false;
                boolean hasLowercase = false;
                boolean hasDigit = false;

                // Loop through and break early if all conditions are met
                for (int scan = 0; scan < password.length(); scan++) {
                    char scanChar = password.charAt(scan);
                    if (Character.isUpperCase(scanChar)) hasUppercase = true;
                    if (Character.isLowerCase(scanChar)) hasLowercase = true;
                    if (Character.isDigit(scanChar)) hasDigit = true;

                    // Optimization: stop scanning if we already found everything we need
                    if (hasUppercase && hasLowercase && hasDigit) {
                        break;
                    }
                }

                if (hasUppercase && hasLowercase && hasDigit) {
                    passwordValid = true;
                    System.out.println("Password is valid and secure!");
                } else {
                    System.out.println("Invalid password. Must contain uppercase, lowercase, and a digit.");
                }
            } else {
                System.out.println("Invalid password. Must be at least 8 characters long.");
            }
        } while (!passwordValid);

        scanner.close();
    }
}