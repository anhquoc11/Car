package com.example.studentapp.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable {

    private ArrayList<Item> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public int getCount() {
        return items.size();
    }

    public void addItem(Item item) {
        for (Item currentItem : items) {
            boolean matchCode = item.getProductCode() != null && !item.getProductCode().isEmpty()
                    && item.getProductCode().equalsIgnoreCase(currentItem.getProductCode());
            boolean matchDesc = item.getDescription() != null
                    && item.getDescription().equalsIgnoreCase(currentItem.getDescription());

            if (matchCode || matchDesc) {
                currentItem.setQuantity(currentItem.getQuantity() + item.getQuantity());
                return;
            }
        }
        items.add(item);
    }

    public void updateQuantity(String description, int quantity) {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (item.getDescription() != null && item.getDescription().equalsIgnoreCase(description)) {
                if (quantity > 0) {
                    item.setQuantity(quantity);
                } else {
                    items.remove(i);
                }
                return;
            }
        }
    }

    public void removeItem(String description) {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (item.getDescription() != null && item.getDescription().equalsIgnoreCase(description)) {
                items.remove(i);
                return;
            }
        }
    }

    public void removeItem(Item item) {
        removeItem(item.getDescription());
    }


    public double getTotal() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getTotal();
        }
        return total;
    }
}
