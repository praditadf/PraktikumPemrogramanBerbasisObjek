package jobsheet01;

public class Shoes {
    private String brand, color;
    private int size;

    void setBrand(String brandName) {
        brand = brandName;
    }

    void setSize(int sizeShoes) {
        size = sizeShoes;
    }

    void setColor(String colorShoes) {
        color = colorShoes;
    }

    void printInfo() {
        System.out.println("Brand : " + brand);
        System.out.println("Size : " + size);
        System.out.println("Color : " + color);
    }
}