package com.emerson;

import java.util.ArrayList;
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

    void takeOrder(int limit) {
        System.out.println("Which type of add on would you like? Enter q anytime to stop");
        for (int i = 0; i < this.addonsList.length; i++) {
            System.out.println(i + 1 + " for " + this.addonsList[i]);
        }

        this.setAdditions(limit);
    }


    private String getBread() {
        return bread;
    }


    private String getAddons() {
        StringBuilder addOnList = new StringBuilder();
        for (Object addOn : this.additions){
            String item =  addOn +", ";
            addOnList.append(item);
        }
        return addOnList.toString();
    }


    private Double getPrice() {
        return price;
    }

    private void setPrice() {
        int extraCost = this.additions.size() * 2;
        this.price += extraCost;
        this.getConfirmation();
    }


    private void setAdditions(int limit) {
        int counter = 1;
        while (counter <= limit) {
            String itemCode = scanner.nextLine();
            if (itemCode.equals("q")) {
                this.setPrice();
                break;

            } else if (Integer.parseInt(itemCode) <= this.addonsList.length + 1 && Integer.parseInt(itemCode) >= 1) {
                int index = Integer.parseInt(itemCode);
                this.additions.add(this.addonsList[index - 1]);
                System.out.println(this.addonsList[index - 1] + " has been added");
                counter++;

            } else {
                //TO DO: add more validations
                System.out.println("That was an invalid item code");
            }
        }
        this.setPrice();
    }


    private void getConfirmation() {
        System.out.println("Does everything look good? y/n");
        System.out.println("===========================");
        System.out.println(" O R D E R  S U M M A R Y");
        System.out.println("===========================");
        System.out.println("Bread: " + this.getBread());
        System.out.println("Meat: " + this.meat);
        System.out.println("Extra add on: " + this.getAddons());
        System.out.println("===========================");
        String input = scanner.nextLine();
        if (input.toLowerCase().equals("y")) {
            this.deliverBurger();
        } else {
            System.out.println("What would you like to change?");
            //TO DO: add additional actions
        }
    }


    private void deliverBurger() {
        System.out.println("Your total is " + this.getPrice());
        System.out.println("Thanks for your business!");
    }
}
