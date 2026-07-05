package  randomitem;
import java.util.Scanner;

public class login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String email;
        boolean emailValid = false;
        do {
            System.out.print("Enter your email: ");
            email = scanner.nextLine().trim();

            int atSymbol = email.indexOf("@");
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
        System.out.println();
        String username;
        boolean isValid = false;
        do {
            System.out.print("Enter your username: ");
            username = scanner.nextLine().trim();
            int len = username.length();
            if (len >= 4 && len <= 12 && !username.contains(" ") && !username.contains("@")) {
                isValid = true;
                System.out.println("Successfully created username.");
            } else {
                System.out.println("Invalid username, please try again!");
            }
        } while (!isValid);

        System.out.println();

        String password;
        boolean passwordValid = false;
        do {
            System.out.print("Enter your password: ");
            password = scanner.nextLine();
            if (password.length() >= 8) {
                boolean hasUppercase = false;
                boolean hasLowercase = false;
                boolean hasDigit = false;
                for (int scan = 0; scan < password.length(); scan++) {
                    char scanChar = password.charAt(scan);
                    if (Character.isUpperCase(scanChar)) hasUppercase = true;
                    if (Character.isLowerCase(scanChar)) hasLowercase = true;
                    if (Character.isDigit(scanChar)) hasDigit = true;
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
