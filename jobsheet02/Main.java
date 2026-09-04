package jobsheet02;

public class Main {
    public static void main(String[] args) {        
        Reactangle [] shapes = new Reactangle[3];
        shapes[0] = new Reactangle(6, 4);
        shapes[1] = new Reactangle(3, 3);
        shapes[2] = new Reactangle(8, 2);
        
        for (Reactangle r : shapes) {
            System.out.println("Area: " +r.area() + ", Perimeter: " +r.perimeter());
        }

        Student s = new Student("Nadia", "S001", 3.8);
        System.out.println(s.describe());

        Circle radius = new Circle(5);
        System.out.println("Area: " + radius.area() + ", Circumference: " + radius.circumference());
    }
}