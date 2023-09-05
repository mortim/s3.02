package com.cosmopolis.batiments;

public abstract class Batiment {
    private float price;
    private int min_residents;
    private int max_residents;
    private int landing;

    /**
     * @param price Prix du bâtiment
     * @param min_residents Nombre minimum d'habitants
     * @param max_residents Nombre maximum d'habitants
     * @param landing Palier en nombre d'habitants
     */
    public Batiment(int price, int min_residents, int max_residents, int landing) {
        this.price = price;
        this.min_residents = min_residents;
        this.max_residents = max_residents;
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

    public int getMinResidents() {
        return min_residents;
    }

    public int getMaxResidents() {
        return max_residents;
    }

    public void setResidents(int min, int max) {
        this.min_residents = min;
        this.max_residents = max;
    }

    public int getLanding() {
        return landing;
    }

    public void setMinMaxResidents(int min_residents, int max_residents) {
        this.min_residents = min_residents;
        this.max_residents = max_residents;
    }    
    public String toString() {
        return this.getClass().getSimpleName() + "(prix=" + this.price + ", min_residents=" + this.min_residents + ", max_residents=" + this.max_residents + ", palier=" + this.landing + ")";
    }
}