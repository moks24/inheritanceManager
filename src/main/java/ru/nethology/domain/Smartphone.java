package ru.nethology.domain;

public class Smartphone extends  Product{
    private String manufacturer;

    public Smartphone(){super();}

    public Smartphone(int id, int name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
