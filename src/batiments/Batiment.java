package batiments;
public abstract class Batiment {
    private int price;
    private int minhab;
    private int maxhab;
    private int landing;

    public Batiment(int price, int minhab, int maxhab, int landing) {
        this.price = price;
        this.minhab = minhab;
        this.maxhab = maxhab;
        this.landing = landing;
    }

    public Batiment(int price, int landing){
        this.price = price;
        this.landing = landing;
    }

    public int getPrice() {
        return price;
    }

    public int getMinhab() {
        return minhab;
    }

    public int getMaxhab() {
        return maxhab;
    }

    public int getLanding() {
        return landing;
    }

    public void setMinMaxHab(int minhab, int maxhab) {
        this.minhab = minhab;
        this.maxhab = maxhab;
    }    
}