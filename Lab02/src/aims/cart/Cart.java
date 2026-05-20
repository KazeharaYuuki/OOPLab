package aims.cart;

import aims.media.DigitalVideoDisc;
import aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;

// Part 9
public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public Cart() {
    }

    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("The media " + media.getTitle() + " has been added to your cart.");
        } else {
            System.out.println("The media " + media.getTitle() + " is already in the cart.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media " + media.getTitle() + " has been removed from your cart.");
        } else {
            System.out.println("The media " + media.getTitle() + " does not exist in your cart.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1) {
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc dvd2) {
    }

    public void sortByTitle() {
        Collections.sort(this.itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Cart has been sorted by title.");
    }

    public void sortByCost() {
        Collections.sort(this.itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Cart has been sorted by cost.");
    }
}


