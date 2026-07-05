package randomitem;

import java.util.Scanner;
public class username {
    public static void main(String[] args){
        // username validator
        String username;
        boolean isValid = false;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter your username: ");
            username = scanner.nextLine();
            if(!username.isEmpty()) {
                if (username.length() <= 12 && username.length() >= 4) {
                    if (!username.contains(" ") && !username.contains("@")) {
                        isValid = true;
                        System.out.println("Successfully created username.");
                    } else {System.out.println("Invalid username, please try again!");}
                } else {System.out.println("Invalid username, please try again!");}
            } else {System.out.println("Invalid username, please try again!");}
        } while (!isValid);

        // email parser
        String email;
        boolean emailValid = false;
        do {
            System.out.print("Enter your email: ");
            email = scanner.nextLine();
            if(email.contains("@")){
                emailValid = true;
                int atSymbol = email.indexOf("@");
                String emailUsername = email.substring(0, atSymbol);
                String emailDomain = email.substring(atSymbol+1);
                System.out.println("Username: " + emailUsername);
                System.out.println("Domain: " + emailDomain);
            }
            else{
                System.out.println("Invalid email, please try again.");
            }
        }while(!emailValid);

        // password strength checker
        String password;
        boolean passwordValid = false;
        do {
            System.out.print("Enter your password: ");
            password = scanner.nextLine();
            if(password.length() >= 8){
                boolean hasUppercase = false;
                boolean hasDigit = false;
                boolean hasLowercase = false;
                for(int scan = 0; scan < password.length(); scan++){
                    char scanChar = password.charAt(scan);
                    if(Character.isUpperCase(scanChar)) hasUppercase = true;
                    if(Character.isLowerCase(scanChar)) hasLowercase = true;
                    if(Character.isDigit(scanChar)) hasDigit = true;
                }
                if(hasUppercase && hasLowercase && hasDigit)
                {
                    passwordValid = true;
                    break;
                }
                if(!hasUppercase || !hasLowercase || !hasDigit){
                    System.out.println("Invalid password.");
                }
            }
            else{
                System.out.println("Invalid password.");
            }
        }while(!passwordValid);
        scanner.close();
    }
}
