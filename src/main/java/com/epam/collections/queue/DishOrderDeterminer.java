package com.epam.collections.queue;

import java.util.LinkedList;
import java.util.List;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        LinkedList<Integer> dishes = new LinkedList<>();
        for (int i = 1; i <= numberOfDishes; i++) {
            dishes.add(i);
        }
        LinkedList<Integer> result = new LinkedList<>();
        int i = 0;
        int step = everyDishNumberToEat - 1;
        while (!dishes.isEmpty()) {
            i = (i + step) % dishes.size();
            result.add(dishes.remove(i));
        }
        return result;
    }
}
