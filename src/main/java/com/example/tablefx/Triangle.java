package com.example.tablefx;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Triangle {
    SimpleDoubleProperty x,y,z;
    private SimpleDoubleProperty perimeter = new SimpleDoubleProperty();
    private SimpleDoubleProperty area = new SimpleDoubleProperty();

    public Triangle(double x, double y, double z) {
        this.x = new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
        this.z = new SimpleDoubleProperty(z);

        {
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
        }

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

 /*   public Triangle(String x, String y, String z) {
        this.x.set(Double.parseDouble(x));
        this.y.set(Double.parseDouble(y));
        this.z.set(Double.parseDouble(z));
    }
*/
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
