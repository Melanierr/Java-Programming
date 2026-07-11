package Managers;
import entity.*;
import entity.Character;
import item.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CharacterManager {
    private final ArrayList < Item > inventory = new ArrayList <> ();
    private Character character;
    private final Scanner scanner;

    public CharacterManager(Scanner scanner) {
        this.scanner = scanner;
    }
    public void run() {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("========================");
            System.out.println("Character Customization");
            System.out.println("1.Create a character\n2.View character stats\n3.Inventory\n4.Exit");
            String selectedMode = scanner.nextLine();
            switch (selectedMode) {
                case "1" -> {
                    System.out.println("========================");
                    System.out.print("Enter character name: ");
                    String characterName = scanner.nextLine();
                    System.out.println("Select a class\n1.Knight\n2.Archer\n3.Mage");
                    String characterClass = scanner.nextLine();
                    createChar(characterName, characterClass);
                }
                case "2" -> {
                    if (character != null) {
                        System.out.println(character);
                    } else {
                        System.out.println("No character found");
                    }
                }
                case "3" -> {
                    InventoryManager inv = new InventoryManager(scanner, inventory, character);
                    inv.run(false);
                }
                case "4" -> isExit = true;
                default -> {
                    System.out.println("Invalid option");
                }
            }
        }
    }
    void createChar(String characterName, String characterClass) {
        switch (characterClass) {
            case "1" -> this.character = new Knight(characterName);
            case "2" -> this.character = new Archer(characterName);
            case "3" -> this.character = new Mage(characterName);
            default -> System.out.println("Invalid character class");
        }
    }
    public entity.Character getCharacter() {
        return character;
    }
    public void runBattle(){
        BattleManager BattleConsole = new BattleManager(character, inventory, scanner);
        BattleConsole.run();
    }
}
