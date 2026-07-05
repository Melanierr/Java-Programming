package randomitem;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;


public class rpgmanager {
    // my ass literally tried to create method to create a whole character and return a table of values but lowk im nooob not that level yet lmfao
    public static void main(String[] args){
        boolean isExit = false;
        String username ="";
        int hp = 0;
        int maxHp = 0;
        int level = 0;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("=== CHARACTER MENU ===");
            System.out.println("1.Create character\n2.View character\n3.Heal character\n4.Take damage\n5.Level up\n6.Inventory\n7.Exit ");
            String selectedMode = scanner.nextLine();

            switch (selectedMode) {
                case "1" -> {
                    System.out.print("Enter your name: ");
                    username = scanner.nextLine();
                    System.out.print("Enter Max HP: ");
                    maxHp = scanner.nextInt();
                    hp = maxHp;
                    level = 1;
                }
                case "2" -> {
                    System.out.println("Name: " + username);
                    System.out.printf("HP: %d" + "/" + "%d\n", hp, maxHp);
                    System.out.println("Level: " + level);
                }
                case "3" -> {
                    System.out.print("Heal how many or randomised: "); // could have put a random but that so random also
                    int amount = scanner.nextInt();
                    System.out.println("You healed " + amount + " HP");
                    hp = healChar(hp, maxHp, amount);
                }
                case "4" -> {

                    System.out.println("Take damage huh lets gamble");
                    int damage = random.nextInt(1, 31);
                    System.out.println("You took " + damage + " DMG");
                    if(hp-damage <= 0){System.out.println("You died nga");}
                    hp = takeDamage(hp, damage);

                }
                case "5" -> {
                    System.out.println("You wanna level up huh");
                    int levelUp = random.nextInt(1, 5);
                    level += levelUp;
                    maxHp += 10*levelUp;
                    System.out.println("You are now level " + level);
                }
                case "6" -> {
                    System.out.println("INVENTORY");
                }
                case "7" -> isExit = true;
            }
        }while(!isExit);
        scanner.close();
    }
    static int healChar(int health, int maxHealth, int amount){
        health += amount;
        if(health > maxHealth){ health = maxHealth; }
        return health;
    }
    static int takeDamage(int health, int damage){
        return health -= damage;
    }

}
