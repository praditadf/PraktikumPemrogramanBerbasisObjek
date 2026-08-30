package jobsheet01;

public class Laptop {
    private String brand;
    private int storage;
    private int ram;
    private String cpu;

    void setBrand(String brandName) {
        brand = brandName;
    }

    void setStorage(int totalStorage) {
        storage = totalStorage;
    }

    void setRam(int totalRam) {
        ram = totalRam;
    }

    void setCpu(String cpuName) {
        cpu = cpuName;
    }

    void printInfo() {
        System.out.println("Brand : " + brand);
        System.out.println("Storage : " + storage + " GB");
        System.out.println("RAM : " + ram + " GB");
        System.out.println("CPU : " + cpu);
    }
}