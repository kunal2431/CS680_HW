package umbcs680.comparator;

import java.util.ArrayList;

public class Car{

    private String model, make;
    private int mileage, year, DominationCount = 0;
    private float price;

    public Car(String model, String make, int mileage, int year, float price){
        this.model = model;
        this.make = make;
        this.mileage = mileage;
        this.year = year;
        this.price = price;
    }

    public String getModel(){
        return this.model;
    }

    public String getMake(){
        return this.make;
    }

    public int getMileage(){
        return this.mileage;
    }

    public int getYear(){
        return this.year;
    }

    public float getPrice(){
        return this.price;
    }

    public void setDominationCount(ArrayList<Car> cars){
        int count=0;
        for (Car c: cars){
            if(this != c){
                if(this.getMileage()<=c.getMileage() && this.getYear()>=c.getYear() && this.price<=c.price){
                    if (this.getMileage()<c.getMileage() || this.getYear()>c.getYear() || this.price<c.price){
                        count++;
                    }
                }
            }
        }
        this.DominationCount=count;
    }

    public int getDominationCount(){
        return DominationCount;
    }

}