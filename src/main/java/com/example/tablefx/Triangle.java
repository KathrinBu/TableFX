package com.example.tablefx;

import javafx.beans.property.SimpleStringProperty;

public class Triangle {
    SimpleStringProperty x,y,z;

    public Triangle(String x, String y, String z) {
        this.x = new SimpleStringProperty(x);
        this.y = new SimpleStringProperty(y);
        this.z = new SimpleStringProperty(z);
    }

    public String getX() {
        return x.get();
    }

    public void setX(String value) {
        x.set(value);
    }

    public String getY() {
        return y.get();
    }
    public void setY(String value) {
        y.set(value);
    }
    public String getZ() {
        return z.get();
    }
    public void setC(String value) {
        z.set(value);
    }
}
