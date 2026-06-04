package aims.media;

import aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
    // Part 6
    private String director;
    private int length;
    private static int nbDigitalVideoDiscs = 0;
    // Part 7
    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }
    // Part 8
    public DigitalVideoDisc(String title) {
        this.setTitle(title);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this(title, category, cost);
        this.director = director;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this(title);
        this.setCategory(category);
        this.setCost(cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this(title,  category, director, cost);
        this.length = length;
    }

    @Override
    public String toString() {
        return "DVD - " + this.getTitle() + " - " +
                (this.getCategory() != null ? this.getCategory() : "N/A") + " - " +
                (this.getDirector() != null ? this.getDirector() : "N/A") + " - " +
                this.getLength() + ": " + this.getCost() + " $";
    }

    public boolean isMatch(String title) {
        return this.getTitle() != null && this.getTitle().equalsIgnoreCase(title);
    }

    @Override

    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
        } else {
            System.err.println("ERROR: DVD length is non-positive!");
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }
}
