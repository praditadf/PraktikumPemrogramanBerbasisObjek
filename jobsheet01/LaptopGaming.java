package jobsheet01;

public class LaptopGaming extends Laptop {
    private String gpu;

    void setGpu(String gpuName) {
        gpu = gpuName;
    }

    @Override
    void printInfo() {
        super.printInfo();
        System.out.println("GPU : " + gpu);
    }
    
}