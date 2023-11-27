public class Shoe {
    private String name;
    private float price;
    private int minSize;
    private int maxSize;
    private int wight;
    private float score;

    private double quality;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) { this.price = price; }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public void setWight(int wight) {
        this.wight = wight;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public void setQuality() {
        this.quality = ((this.score * 0.7 + 0.3 * (this.maxSize - this.minSize)) / (this.price + this.wight /1000.0)) * 300;
    }

    public double getQuality() {
        return quality;
    }
}
