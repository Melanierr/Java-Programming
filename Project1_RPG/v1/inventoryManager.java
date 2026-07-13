package randomitem;
import java.util.Arrays;
import java.util.Scanner;

public class inventoryManager {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] inventoryItem = new String[]{"sword", "shield", "Potion", "bow", "steak"};
        int[] inventoryAmount = {2, 1, 5, 1, 10};
        boolean isExit = false;
        do{
            System.out.println("1.View inventory\n2.Use item\n3.Add item\n4.Search item\n5.Exit");
            String option = scanner.nextLine();
            switch(option) {
                case "1" -> {
                    for (int i = 0; i < inventoryItem.length; i++) {
                        System.out.println(inventoryItem[i] + ": " + inventoryAmount[i] + "x");
                    }
                }
                case "2" -> {
                    for (int i = 0; i < inventoryItem.length; i++) {
                        System.out.println(inventoryItem[i] + ": " + inventoryAmount[i] + "x");
                    }
                    System.out.print("Select an item: "); String useItem = scanner.nextLine().toLowerCase();
                    if(useItem.equals("Potion") || useItem.equals("steak")){
                        System.out.print("How many: ");
                        int useAmount = scanner.nextInt();
                        for(int i = 0; i < inventoryItem.length; i++) {
                            boolean isFound = false;
                            if (useItem.equals(inventoryItem[i])) {
                                isFound = true;
                                inventoryAmount[i] -= useAmount;
                                System.out.println(inventoryItem[i] + ": " + inventoryAmount[i]);
                            }
                            if(!isFound){
                                System.out.println("Item not found");
                            }

                        }
                    }
                }
                case "3" ->{
                    for(int i = 0; i < inventoryItem.length; i++) {
                        boolean isFound = false;
                        System.out.print("Item name: ");
                        String searchName = scanner.nextLine();
                        for (i = 0; i < inventoryItem.length; i++) {
                            if (searchName.equalsIgnoreCase(inventoryItem[i])) {
                                isFound = true;
                                System.out.print("How many to add: ");
                                int addAmount = scanner.nextInt();
                                scanner.nextLine();
                                inventoryAmount[i] += addAmount;
                                System.out.println("Updated!");
                                System.out.println(inventoryItem[i] + ": " + inventoryAmount[i]);
                                break;
                            }
                        }
                        if (!isFound) {
                            inventoryItem = Arrays.copyOf(inventoryItem, inventoryItem.length + 1);
                            inventoryAmount = Arrays.copyOf(inventoryAmount, inventoryAmount.length + 1);
                            inventoryItem[inventoryItem.length - 1] = searchName;
                            System.out.print("How many to add: ");
                            int addAmount = scanner.nextInt();
                            scanner.nextLine();
                            inventoryAmount[inventoryAmount.length - 1] = addAmount;
                            System.out.println("New item added!");
                        }
                    }
                }
                case "4" ->{
                    System.out.print("Item name: "); String searchName = scanner.nextLine();
                    for(int i = 0; i < inventoryItem.length; i++) {
                        boolean isFound = false;
                        if (searchName.equals(inventoryItem[i])) {
                            isFound = true;
                            System.out.println(inventoryItem[i] + ": " + inventoryAmount[i]);
                            break;
                        }
                        System.out.println("Item not found");
                    }
                }
                case "5" -> {isExit = true;}
                default -> {continue;}
            }
        }while(!isExit);
    }
}
