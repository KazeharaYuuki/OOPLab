package aims.store;

import aims.disc.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc itemsInStore[];
    private int qtyInStore = 0;

    public Store(int capacity) {
        itemsInStore = new DigitalVideoDisc[capacity];
    }

    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < itemsInStore.length) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("The DVD " + dvd.getTitle() + " has been added to the store.");
        } else {
            System.out.println("The store is almost full!");
        }
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i].equals(dvd)) {
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                found = true;
                System.out.println("The DVD " + dvd.getTitle() + " has been removed from the store.");
                break;
            }
        }
        if (!found) {
            System.out.println("The DVD was not found in the store.");
        }
    }
}