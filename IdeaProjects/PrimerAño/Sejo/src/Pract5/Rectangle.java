package Pract5;

public class Rectangle extends Figuras{

    private double base;
    private double height;

public Rectangle(double base, double height){
    this.base = base;
    this.height = height;
}

    @Override
    double area() {
        return base * height;
    }

    @Override
    double perimeter() {
        return base * 2 + height * 2;
    }
}


