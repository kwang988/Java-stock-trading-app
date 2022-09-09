package com.kenzie.app;

public class StockHolding {
    // Create private instance properties
    private String name;
    private String ticker;
    private double price;
    private int numShares;
    // Create constructor

    public StockHolding(String name, String ticker, double price) {
        this.name = name;
        this.ticker = ticker;
        this.price = price;
        this.numShares = 0;
    }

    // create getters

    public String getName() {
        return name;
    }

    public String getTicker() {
        return ticker;
    }

    public double getPrice() {
        return price;
    }

    public int getNumShares() {
        return numShares;
    }


    // create buy, sell, and getBalance methods
    public void buy(int shares){
        numShares += shares;
    }
    public double sell(int shares){
        double amtSold = 0.0;
        if (shares <= numShares){
            numShares -= shares;
            amtSold = price*shares;
        }
        return amtSold;
    }
    public double getBalance(){
        return price * numShares;
    }
}
