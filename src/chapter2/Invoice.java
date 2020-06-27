package chapter2;

import java.util.ArrayList;

public class Invoice {
    private static class Item {
        String description;
    }

    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(String description) {
        Item newItem = new Item();
        newItem.description = description;
        items.add(newItem);
    }

    public static void main(String[] args) {
        Invoice inv = new Invoice();
        inv.addItem("Lastik");
    }
}
