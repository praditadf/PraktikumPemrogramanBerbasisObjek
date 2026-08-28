package jobsheet01;

public class RoadBike extends Bike{
    private int tireWidth;

    void setTireWidth(int width) {
        tireWidth = width;
    }

    @Override
    void printInfo() {
        super.printInfo();
        System.out.println("Tire Width : " + tireWidth + " mm");
        System.out.println("Bike Type : Road Bike ");
    }

}
