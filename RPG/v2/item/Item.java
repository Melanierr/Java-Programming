package item;
import entity.Character;
public abstract class Item {
    String name;
    String description;
    int amount;
    public Item(String name, String description, int amount) {
        this.name = name;
        this.description = description;
        this.amount = amount;
    }
    @Override
    public String toString() {
        return (name+"\n"+description+"\n"+"Amount: " +amount);
    }
    public String getName() {
        return name;
    }
    public abstract void useItem(Character player);
}
