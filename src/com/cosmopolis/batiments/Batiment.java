package com.cosmopolis.batiments;

public abstract class Batiment {
    private float price;
    private int minhab;
    private int maxhab;
    private int landing;

    /**
     * @param price Prix du bâtiment
     * @param minhab Nombre minimum d'habitants
     * @param maxhab Nombre maximum d'habitants
     * @param landing Palier en nombre d'habitants
     */
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getMinhab() {
        return minhab;
    }

    public int getMaxhab() {
        return maxhab;
    }

    public void setHab(int min, int max) {
        this.minhab = min;
        this.maxhab = max;
    }

    public int getLanding() {
        return landing;
    }

    public void setMinMaxHab(int minhab, int maxhab) {
        this.minhab = minhab;
        this.maxhab = maxhab;
    }    
    public String toString() {
        return this.getClass().getSimpleName() + "(prix=" + this.price + ", minhab=" + this.minhab + ", maxhab=" + this.maxhab + ", palier=" + this.landing + ")";
    }
}