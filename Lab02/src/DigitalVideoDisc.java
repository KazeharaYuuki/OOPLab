public class DigitalVideoDisc {
    // Part 6
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // Part 7
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    // Part 8
    public DigitalVideoDisc(String title) {
        this.title = title;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    public class TestPassingParameter {
        public static void main(String[] args) {
            DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
            DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

            swap(jungleDVD, cinderellaDVD);
            System.out.println("jungle dvd title: " + jungleDVD.getTitle());
            System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

            changeTitle(jungleDVD, cinderellaDVD.getTitle());
            System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        }

        public static void swap(Object o1, Object o2) {
            Object tmp = o1;
            o1 = o2;
            o2 = tmp;
        }

        public static void changeTitle(DigitalVideoDisc dvd, String title) {
            String oldTitle = dvd.getTitle();
            dvd.setTitle(title);
            dvd = new DigitalVideoDisc(oldTitle);
        }
    }
}
