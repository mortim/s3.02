package com.cosmopolis.batiments;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class Batiment implements Serializable {
    private float price;
    private int min_residents;
    private int max_residents;
    private int landing;
    private int barhab;

    /**
     * @param price Prix du bâtiment
     * @param min_residents Nombre minimum d'habitants
     * @param max_residents Nombre maximum d'habitants
     * @param landing Palier en nombre d'habitants
     */
    public Batiment(int price, int min_residents, int max_residents, int landing, int barhab) {
        this.price = price;
        this.min_residents = min_residents;
        this.max_residents = max_residents;
        this.landing = landing;
        this.barhab=barhab;
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

    public int getBarHab(){return this.barhab;}


    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(this.price);
        out.writeObject(this.min_residents);
        out.writeObject(this.max_residents);
        out.writeObject(this.landing);   
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.price = (float)in.readObject();
        this.min_residents = (int)in.readObject();
        this.max_residents = (int)in.readObject();
        this.landing = (int)in.readObject();
    }
}