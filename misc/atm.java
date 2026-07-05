package randomitem;
import java.util.Scanner;
public class atm {
    public static void main(String[] args){
        /*
        Scanner scanner = new Scanner(System.in);
            double initialMoney;
            double rate;
            int years;
            int timesCompounded;
            double amount;

            System.out.print("Enter the deposit money: ");
            initialMoney = scanner.nextDouble();

            System.out.print("Interest rate %: ");
            rate = scanner.nextDouble() / 100;

            System.out.print("Times compounded/year: ");
            timesCompounded = scanner.nextInt();
            System.out.print("How long ( years ): ");
            years = scanner.nextInt();

            amount = initialMoney * Math.pow(1+ rate / timesCompounded, timesCompounded*years );
            System.out.printf("Total money after %d years is $ %.01f \n", years, amount);
        scanner.close();

         */
        double balance = 1000;
        String mode;
        System.out.println("==== CHAT-GPT BANK ====");
        Scanner scanner = new Scanner(System.in);
        System.out.println("MENU");
        System.out.println("1. Deposit \n2.Withdraw \n3.Check Balance \n");
        mode = scanner.nextLine().toLowerCase();
        if(mode.equals("deposit") || mode.equals("1")){
            double depositMoney;
            System.out.printf("Your current balance is: $ %.2f \n", balance);
            System.out.println("How much do you want to deposit?");
            depositMoney = scanner.nextDouble();
            balance += depositMoney;
            System.out.printf("Succesful! Your current balance is: $ %.2f", balance);

        }
        else if(mode.equals("withdraw") || mode.equals("2")){
            double withdrawMoney;
            System.out.printf("Your current balance is: $ %.2f \n", balance);
            System.out.println("How much do you want to withdraw?");
            withdrawMoney = scanner.nextDouble();
            if(withdrawMoney>balance){
                System.out.println("Insufficient funds!!!");
                return;
            }
            balance -= withdrawMoney;
            System.out.printf("Succesful! Your current balance is: $ %.2f", balance);
        }
        else if(mode.equals("check balance") || mode.equals("3")){
            System.out.printf("Your current balance is : $ %.2f", balance);

        }
        scanner.close();
    }
}
