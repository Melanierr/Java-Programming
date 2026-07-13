package randomitem;
import java.util.Scanner;
import java.util.Random;
public class rpggame {
    public static void main(String[] args){
        String name;
        String characterClass;
        int age;
        int health = 0;
        int atk = 0;
        boolean startFirst;

        Scanner pickcharacter = new Scanner(System.in);
        System.out.print("Name : ");
        name = pickcharacter.nextLine();

        System.out.print("Age : ");
        age = pickcharacter.nextInt();
        pickcharacter.nextLine();

        System.out.print("Character class (Warrior/Mage/Archer) : ");
        characterClass = pickcharacter.nextLine().toLowerCase();
        if(characterClass.isEmpty()) {
            System.out.println("You haven't select a class");
        }
        if(characterClass.equals("warrior")) {
            health = 100;
            atk = 20;
        }
        else if(characterClass.equals("mage")) {
            health = 60;
            atk = 35;
        }
        else if(characterClass.equals("archer")){
            health = 80;
            atk = 25;
        }
        /*
        // generate enemy stats
        int enemyHP = 0;
        int enemyAtk = 0;
        Random random = new Random();
        enemyHP = random.nextInt(50, 120);
        enemyAtk = random.nextInt(10, 30);

        startFirst = random.nextBoolean();


        // === BATTLE ===
        // battle, stats print
        System.out.println("===== BATTLE =====");
        System.out.println(name + " class: " + characterClass);
        System.out.printf("HP: %d ATK: %d \n", health, atk);


        // idk
        System.out.println("Enemy appears!");
        System.out.println("Angry Wolf 🐺");
        System.out.printf("HP: %d ATK: %d \n", enemyHP, enemyAtk);

        // attackain
        if(startFirst) {
            System.out.println("You attack!");
            System.out.printf("Angry Wolf \nHP: %d \n", (enemyHP - atk));
            System.out.println("Wolf attacks! 🐺");
            System.out.printf("Musc \nHP: %d \n", (health - enemyAtk));
        }
        else{
            System.out.println("Wolf attacks! 🐺");
            System.out.printf("Musc \nHP: %d \n", (health - enemyAtk));
            System.out.println("You attack!");
            System.out.printf("Angry Wolf \nHP: %d \n", (enemyHP - atk));
        }

         */
    }
}
