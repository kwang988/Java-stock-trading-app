package com.kenzie.app;

import java.util.Scanner;

public class Main {
    public static void displayMenu() {
        System.out.println("Enter a selection (1-4)");
        System.out.println("1. Check your Balance");
        System.out.println("2. Buy");
        System.out.println("3. Sell");
        System.out.println("4. Exit");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Kenzie Stock Exchange");
        Scanner in = new Scanner(System.in);
        System.out.println("What is the Stock's name?");
        String name = in.nextLine();
        System.out.println("What is the Stock's ticker symbol?");
        String ticker = in.nextLine();
        System.out.println("What is the Stock's current price?");
        double price = Double.parseDouble(in.nextLine());

        // Create your StockHolding using the values above
        StockHolding stockHolding = new StockHolding(name, ticker, price);
        // Create your Execution Loop
        boolean exitFlag = false;
        while (!exitFlag) {
            // print the menu
            displayMenu();
            // collect which option they chose from Scanner
             try {
            int userInputOption = Integer.parseInt(in.nextLine());
            // perform the operation: Check your balance, buy, sell, or exit
            // repeat!
            if (userInputOption != 4) {
                switch (userInputOption) {
                    case 1:
                        System.out.println("You own " + stockHolding.getNumShares() +
                                " shares of " + stockHolding.getName() +
                                " (" + stockHolding.getTicker() + ")");
                        System.out.println("Your balance is: $" + stockHolding.getBalance());
                        break;
                    case 2:
                        System.out.printf("How many shares would you like to buy?" + "\n");
                        int inputNumSharesToBuy = Integer.parseInt(in.nextLine());
                        stockHolding.buy(inputNumSharesToBuy);
                        System.out.println("You bought " + inputNumSharesToBuy +
                                " shares for $" + price * inputNumSharesToBuy);
                        break;
                    case 3:
                        System.out.println("How many shares would you like to sell?");
                        int inputNumSharesToSell = Integer.parseInt(in.nextLine());
                        if (inputNumSharesToSell <= stockHolding.getNumShares()) {
                            double amtSold = stockHolding.sell(inputNumSharesToSell);
                            System.out.println("You sold " + inputNumSharesToSell +
                                    " shares for $" + amtSold);
                        } else {
                            System.out.println("You do not have enough shares!");
                        }
                        break;
                    default:
                        System.out.println("The selection is unrecognized");
                }
            } else {
                exitFlag = true;
            }
             }
                 catch(NumberFormatException e) {
                     System.out.println("The selection is unrecognized");
                 }
        }
        System.out.println("Goodbye!");
    }
}
