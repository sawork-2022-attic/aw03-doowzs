package com.example.webpos.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class Cart {

    private List<Item> items = new ArrayList<>();

    public boolean addItem(Item item) {
        int amount = items.stream()
                .filter(i -> Objects.equals(i.getProduct(), item.getProduct()))
                .mapToInt(Item::getQuantity)
                .sum();
        items.removeIf(i -> Objects.equals(i.getProduct(), item.getProduct()));
        if (amount + item.getQuantity() > 0) {
            items.add(new Item(item.getProduct(), amount + item.getQuantity()));
        }
        return true;
    }

    public boolean removeItem(Item item) {
        return items.removeIf(i -> Objects.equals(i.getProduct(), item.getProduct()));
    }

    @Override
    public String toString() {
        if (items.size() == 0) {
            return "Empty Cart";
        }
        double total = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cart -----------------\n");

        for (int i = 0; i < items.size(); i++) {
            stringBuilder.append(items.get(i).toString()).append("\n");
            total += items.get(i).getQuantity() * items.get(i).getProduct().getPrice();
        }
        stringBuilder.append("----------------------\n");

        stringBuilder.append("Total...\t\t\t" + total);

        return stringBuilder.toString();
    }
}
