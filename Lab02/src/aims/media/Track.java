package aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() { return title; }
    public int getLength() { return length; }

    @Override
    public void play() {
        if (this.getLength() > 0) { // Kiểm tra độ dài
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        } else {
            System.out.println("ERROR: Track " + this.getTitle() + " cannot be played because its length is 0 or less.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || !(obj instanceof Track)) {
            return false;
        }

        Track other = (Track) obj;

        if (this.title == null) {
            if (other.getTitle() != null) return false;
        } else if (!this.title.equalsIgnoreCase(other.getTitle())) {
            return false;
        }

        return this.length == other.getLength();
    }
}
