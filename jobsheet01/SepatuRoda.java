package jobsheet01;

public class SepatuRoda extends Shoes {
    private int totalTire;

    void setTotalTire(int tire){
        totalTire = tire;
    }

    @Override
    void printInfo() {
        super.printInfo();
        System.out.println("Shoes Type : Sepatu Roda");
        System.out.println("Total Tire : " + totalTire);
    }
}