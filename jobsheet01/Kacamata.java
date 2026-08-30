package jobsheet01;

public class Kacamata {
    private String brand, color;
    private int size;

    void setBrand(String brandName) {
        brand = brandName;
    }

    void setSize(int sizeKacamata) {
        size = sizeKacamata;
    }

    void setColor(String colorKacamata) {
        color = colorKacamata;
    }

    void printInfo() {
        System.out.println("Brand : " + brand);
        System.out.println("Size : " + size);
        System.out.println("Color : " + color);
    }    
}