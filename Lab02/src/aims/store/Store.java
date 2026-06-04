package aims.store;

import aims.media.DigitalVideoDisc;
import aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public Store() {
    }

    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("The media " + media.getTitle() + " has been added to the store.");
        } else {
            System.out.println("The media " + media.getTitle() + " already exists in the store.");
        }
    }

    public void removeMedia(Media media) {

    }

    public void printStore() {
        System.out.println("***********************STORE***********************");
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is currently empty.");
        } else {
            for (int i = 0; i < itemsInStore.size(); i++) {
                System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
            }
        }
        System.out.println("***************************************************");
    }

    public void addDVD(DigitalVideoDisc dvd2) {
    }

    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media instanceof DigitalVideoDisc) {
                if (((DigitalVideoDisc) media).isMatch(title)) {
                    return media;
                }
            } else if (media.getTitle() != null && media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}