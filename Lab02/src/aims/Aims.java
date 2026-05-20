package aims;

import aims.cart.Cart;
import aims.media.DigitalVideoDisc;
import aims.store.Store;
import java.util.Scanner;
import aims.media.*;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initSampleData();

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewStoreOptions();
                    break;
                case 2:
                    updateStoreOptions();
                    break;
                case 3:
                    viewCartOptions();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (choice != 0);
    }

    private static void initSampleData() {
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        Book book = new Book("Java Core", "Education", 45.0f);
        book.addAuthor("Cay S. Horstmann");
        CompactDisc cd = new CompactDisc("ABBA Gold", "Pop", "ABBA", 25.0f);
        cd.addTrack(new Track("Mamma Mia", 3));

        store.addMedia(dvd);
        store.addMedia(book);
        store.addMedia(cd);
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    private static void viewStoreOptions() {
        int choice;
        do {
            store.printStore();
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media's details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3-4: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMediaInStore();
                    break;
                case 4:
                    viewCartOptions();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static void seeMediaDetails() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);

        if (media != null) {
            System.out.println(media.toString());
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            if (media instanceof Playable) {
                System.out.println("2. Play");
            }
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2: ");
            int subChoice = scanner.nextInt();
            scanner.nextLine();

            if (subChoice == 1) {
                cart.addMedia(media);
            } else if (subChoice == 2 && media instanceof Playable) {
                ((Playable) media).play();
            }
        } else {
            System.out.println("Media not found!");
        }
    }

    private static void addMediaToCart() {
        System.out.print("Enter the title of the media to add to cart: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            cart.addMedia(media);
        } else {
            System.out.println("Media not found!");
        }
    }

    private static void playMediaInStore() {
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played or was not found!");
        }
    }

    private static void updateStoreOptions() {
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.print("Choose option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
    }

    private static void viewCartOptions() {
        int choice;
        do {
            cart.print();
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3-4-5: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    break;
                case 2:
                    System.out.println("1. Sort by Title\t2. Sort by Cost");
                    int sortChoice = scanner.nextInt();
                    if (sortChoice == 1) cart.sortByTitle();
                    else cart.sortByCost();
                    break;
                case 3:
                    System.out.print("Enter title to remove: ");
                    String title = scanner.nextLine();
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("An order has been created successfully!");
                    cart = new Cart();
                    break;
                case 0:
                    break;
            }
        } while (choice != 0);
    }
}