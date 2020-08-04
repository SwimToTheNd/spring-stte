package com.stte.spring.ioc;

/**
 * create by BloodFly at 2020/6/7
 */
public class Car {
    private String name;
    private String company;
    private Double price;
    private int speed;

    public Car() {
    }

    public Car(String name, String company, Double price) {
        this.name = name;
        this.company = company;
        this.price = price;
    }

    public Car(String name, String company, int speed) {
        this.name = name;
        this.company = company;
        this.speed = speed;
    }

    public Car(String name, String company, Double price, int speed) {
        this.name = name;
        this.company = company;
        this.price = price;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", price=" + price +
                ", speed=" + speed +
                '}';
    }
}
