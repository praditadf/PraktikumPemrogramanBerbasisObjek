package jobsheet02;

public class Reactangle {
    int width;
    int height;

    Reactangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    int area() {
        return width * height;
    }

    int perimeter() {
        return 2 * (width + height);
    }
}