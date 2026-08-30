package jobsheet01;

public class Hp {
    private String brand;
    private int storage;
    private int ram;
    private String processor;

    void setBrand(String brandName) {
        brand = brandName;
    }

    void setStorage(int totalStorage) {
        storage = totalStorage;
    }

    void setRam(int totalRam) {
        ram = totalRam;
    }

    void setProcessor(String processorName) {
        processor = processorName;
    }

    void printInfo() {
        System.out.println("Brand : " + brand);
        System.out.println("Storage : " + storage + " GB");
        System.out.println("Ram : " + ram + " GB");
        System.out.println("Processor : " + processor);
    }
}