package com.test;

import java.io.Serializable;

public class Data implements Serializable {
    private String text;
    private String label;
    private double price;

    public Data(String text, String label, double price) {
        this.text = text;
        this.label = label;
        this.price = price;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
