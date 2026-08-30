package jobsheet01;

public class Demo {
    public static void main(String[] args) {
        Hp hp1 = new Hp();
        Kacamata kacamata1 = new Kacamata();
        Laptop laptop1 = new Laptop();
        LaptopGaming laptopGaming1 = new LaptopGaming();
        Shoes shoes1 = new Shoes();
        SepatuRoda sepatuRoda1 = new SepatuRoda();

        hp1.setBrand("Xiaomi Redmi Note 13");
        hp1.setStorage(128);
        hp1.setRam(8);
        hp1.setProcessor("Snapdragon 685 Octa-core Max 2.8 GHz");
        hp1.printInfo();

        kacamata1.setBrand("Jisoo 023");
        kacamata1.setColor("Black");
        kacamata1.setSize(50);
        kacamata1.printInfo();

        laptop1.setBrand("Acer Nitro v15");
        laptop1.setStorage(512);
        laptop1.setRam(16);
        laptop1.setCpu("Intel Core i5-13420H");
        laptop1.printInfo();

        laptopGaming1.setBrand("ROG Zephyrus G14");
        laptopGaming1.setStorage(2048);
        laptopGaming1.setRam(32);
        laptopGaming1.setCpu("Intel Core Ultra 9 386H");
        laptopGaming1.setGpu("NVIDIA GeForce RTX 5080 Ti");
        laptopGaming1.printInfo();

        shoes1.setBrand("Nike");
        shoes1.setSize(39);
        shoes1.setColor("Black");
        shoes1.printInfo();

        sepatuRoda1.setBrand("Rollerblade");
        sepatuRoda1.setSize(40);
        sepatuRoda1.setColor("White");
        sepatuRoda1.setTotalTire(8);
        sepatuRoda1.printInfo();
    }
}