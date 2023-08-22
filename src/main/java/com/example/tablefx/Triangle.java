package com.example.tablefx;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Triangle {
    SimpleDoubleProperty x,y,z;
    private SimpleDoubleProperty perimeter = new SimpleDoubleProperty();
    private SimpleDoubleProperty area = new SimpleDoubleProperty();

    public double getPerimeter() {
        return perimeter.get();
    }

    public SimpleDoubleProperty perimeterProperty() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter.set(perimeter);
    }

    public double getArea() {
        return area.get();
    }

    public SimpleDoubleProperty areaProperty() {
        return area;
    }

    public void setArea(double area) {
        this.area.set(area);
    }

    public Triangle(double x, double y, double z) {
        this.x = new SimpleDoubleProperty();
        this.y = new SimpleDoubleProperty();
        this.z = new SimpleDoubleProperty();

            this.x.addListener((s1, o,n)->{
                this.perimeter.set(perimeter());
                this.area.set(area());
            });
            this.y.addListener((s1, o,n)->{
                this.perimeter.set(perimeter());
                this.area.set(area());
            });
            this.z.addListener((s1, o,n)->{
                this.perimeter.set(perimeter());
                this.area.set(area());
            });
        this.z.set(z);
        this.y.set(y);
        this.x.set(x);


    }

    public void setZ(double z) {
        this.z.set(z);
    }

    public SimpleDoubleProperty xProperty() {
        return x;
    }

    public SimpleDoubleProperty yProperty() {
        return y;
    }

    public SimpleDoubleProperty zProperty() {
        return z;
    }

    public double getX() {
        return x.get();
    }

    public void setX(double value) {
        x.set(value);
    }

    public double getY() {
        return y.get();
    }
    public void setY(double value) {
        y.set(value);
    }
    public double getZ() {
        return z.get();
    }
    public void setC(double value) {
        z.set(value);
    }

    double perimeter()
    {
        return x.get()+y.get()+z.get();
    }
    double area()
    {
        double p = perimeter.get()/2;
        return Math.sqrt(p*(p-x.get())*(p-y.get())*(p-z.get()));
    }
}
