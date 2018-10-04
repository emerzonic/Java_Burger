package com.emerson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BasicBurger {
    private Double price;
    private String meat;
    private ArrayList<Object> additions;
    private Scanner scanner = new Scanner(System.in);
    public String[] addonsList;
    private String bread;
    private String name;

    BasicBurger(String meat) {
        this.name = "Basic Burger";
        this.bread = "White Bread";
        this.price = 5.00;
        this.meat = meat;
        this.additions = new ArrayList<>();
        this.addonsList = new String[]{"tomato", "carrot", "mushroom", "lettuce", "bacon", "onion", "egg", "pickle"};

    }

    private Double getPrice() {
        return price;
    }


    private String getBread() {
        return bread;
    }

    private void setPrice() {
        int extraCost = this.additions.size() * 2;
        this.price += extraCost;
    }


    //This method takes the buyer's order
    void takeOrder(int limit) {
        System.out.println("Which type of add on would you like? Enter q anytime to stop");
        for (int i = 0; i < this.addonsList.length; i++) {
            System.out.println(i + 1 + " for " + this.addonsList[i]);
        }
        this.setAdditions(limit);
        this.getConfirmation();
    }


    //This method returns a string representation of the addons.
    private String getAddons() {
        StringBuilder addOnList = new StringBuilder();
        for (Object addOn : this.additions) {
            String item = addOn + ", ";
            addOnList.append(item);
        }
        return addOnList.toString();
    }


    //This method returns a string of the addonsList indexes to be used for validation
    private String getAddonsIndexes() {
        StringBuilder index = new StringBuilder();
        int counter = 1;
        while (counter <= this.addonsList.length) {
            String stringIndex = Integer.toString(counter);
            String item = "" + stringIndex;
            index.append(item);
            counter++;
        }
        return index.toString();
    }


    //This method adds addons to the buyers burger
    private void setAdditions(int limit) {
        int counter = 1;
        while (counter <= limit) {
            String itemCode = scanner.nextLine();
            if (itemCode.equals("q")) {
                break;

            } else if (itemCode.equals("") || !this.getAddonsIndexes().contains(itemCode)) {
                System.out.println("That was an invalid item code");

            } else {
                int index = Integer.parseInt(itemCode) - 1;
                this.additions.add(this.addonsList[index]);
                System.out.println(this.addonsList[index] + " has been added");
                counter++;
            }
        }
        this.setPrice();
    }


    //This method displays a summary of the buyer's burger and prompts for confirmation
    private void getConfirmation() {
        System.out.println("===========================");
        System.out.println(" O R D E R  S U M M A R Y");
        System.out.println("===========================");
        System.out.println("Bread: " + this.getBread());
        System.out.println("Meat: " + this.meat);
        System.out.println("Extra add on: " + this.getAddons());
        System.out.println("===========================");
        System.out.println("Does everything look good? y/n");
        String input = scanner.nextLine();
        //TO DO: add additional actions
        if (input.toLowerCase().equals("y")) {
            this.deliverBurger();
        } else {
            System.out.println("What would you like to change?");
        }
    }


    //This method displays the order's total for the burger
    private void deliverBurger() {
        System.out.println("Your total is " + this.getPrice());
        System.out.println("Thanks for your business!");
    }
}
