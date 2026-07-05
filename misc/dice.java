package randomitem;
import java.util.Random;
import java.util.Scanner;

public class dice {
    public static void main(String[] args){
        double balance = 400; // starting money
        boolean replay = true;
        int betMoney;
        int diceNumber;
        System.out.println("DICE BETTING");
        System.out.println("Current balance: $" + balance);
        Scanner scanner = new Scanner(System.in);
        // bet amount
        do {

            System.out.print("Enter bet amount: ");
            betMoney = scanner.nextInt();
            scanner.nextLine();
            while (betMoney > balance || balance == 0) {
                System.out.println("Not enough money!");
                betMoney = scanner.nextInt();
                scanner.nextLine();
            }

            System.out.println("Rolling a dice please wait.");

            // Rolling
            Random dice = new Random();
            diceNumber = dice.nextInt(1, 7);
            System.out.println(diceNumber);
            if (diceNumber < 4) {
                System.out.printf("You lost $%d \n", betMoney);
                balance -= betMoney;
                System.out.println("Current balance: $" + balance);
            } else if (diceNumber >= 4) {
                if (diceNumber != 6) {
                    System.out.printf("You won $%d \n", betMoney);
                    balance += betMoney;
                    System.out.println("Current balance: $" + balance);
                } else if (diceNumber == 6) {
                    System.out.printf("JACKPOT! You won $%d \n", (betMoney * 2));
                    balance += (betMoney * 2);
                    System.out.println("Current balance: $" + balance);
                }
            }

            System.out.print("Do you want to play again? (Y/N): ");
            String replayInput = scanner.nextLine();

            if (replayInput.equals("Y")) {
                replay = true;
            }
            if (replayInput.equals("N")) {
                replay = false;
            }
        } while(replay);
        scanner.close();
    }
}
