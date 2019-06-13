package com.acquisio.basic.java.question04;


import java.util.ArrayList;
import java.util.List;

class Inventory<T extends Item> {

    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public T getFirst() {
        if (items.size() > 0) {
            return items.get(0);
        }
        return null;
    }

    public T getLast() {
        int size = items.size();
        if (size > 0) {
            return items.get(size - 1);
        }
        return null;
    }


    public boolean remove(T item) {
        return items.remove(item);
    }

    public T findFirst(String name) {
        for (T item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }
}
