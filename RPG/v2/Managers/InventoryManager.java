package Managers;
import entity.*;
import item.*;
import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManager {
    private final Scanner scanner;
    private final ArrayList<Item> inventory;
    private final entity.Character character;
    public InventoryManager(Scanner scanner, ArrayList<Item> inventory, entity.Character character) {
        this.scanner = scanner;
        this.inventory = inventory;
        this.character = character;
    }
    public void run(){
        boolean inInventory = true;
        while (inInventory) {
            System.out.println("========================");
            System.out.println("INVENTORY MENU");
            System.out.println("""
                    1.View inventory
                    2.Add item
                    3.Remove item
                    4.Use item
                    5.Exit inventory""");
            String selectedMode = scanner.nextLine();
            switch (selectedMode) {
                case "1"-> {
                    System.out.println("========================");
                    System.out.println("INVENTORY");
                    if(inventory.isEmpty()) {
                        System.out.println("Inventory is empty.");
                    }
                    else {
                        for (Item items : inventory) {
                            System.out.println(items);
                        }
                    }
                }
                case "2"-> {
                    System.out.print("Choose item type (Potion, Armor, Weapon): ");
                    String itemType = scanner.nextLine();
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter item amount: ");
                    int itemAmount = scanner.nextInt(); scanner.nextLine();
                    switch (itemType.toLowerCase()) {
                        case "potion"-> {
                            inventory.add(new Potion(itemName, "", itemAmount, 50));
                        }
                        case "armor"-> {
                            inventory.add(new Armor(itemName, "", itemAmount, 20));
                        }
                        case "weapon"-> {
                            inventory.add(new Weapon(itemName, "", itemAmount, 1.3));
                        }
                    }
                }
                case "3" -> {
                    for(Item items : inventory) {System.out.println(items);}
                    System.out.print("Select an item: ");
                    String name = scanner.nextLine();
                    for(int i=0; i< inventory.size(); i++) {
                        if(name.equals(inventory.get(i).toString())) {
                            inventory.remove(i);
                            System.out.println("Sucessfully removed " + name);
                            break;
                        }
                        else{
                            System.out.println("No item found");
                        }
                    }
                }
                case "4"-> {
                    for(Item items : inventory) {System.out.println(items);}
                    System.out.print("Select an item: ");
                    String name = scanner.nextLine();
                    if(inventory.isEmpty()) {
                        System.out.println("Inventory is empty.");
                    }
                    else {
                        for (Item item : inventory) {
                            if (name.equals(item.getName())) {
                                item.useItem(character);
                                break;
                            }
                        }
                    }
                }
                case "5"-> inInventory = false;
            }
        }
    }
}
