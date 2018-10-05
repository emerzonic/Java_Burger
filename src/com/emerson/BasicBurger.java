package com.emerson;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BasicBurger {
    private Double basePrice;
    private String meat;
    private List<Object> additions;
    private Scanner scanner = new Scanner(System.in);
    protected String[] addonsList;
    protected String addonCodes;
    private String bread;
    private String name;


    BasicBurger(String meat) {
        this.name = "Basic Burger";
        this.bread = "White Bread";
        this.basePrice = 5D;
        this.meat = meat;
        this.additions = new ArrayList<>();
        this.addonsList = new String[]{"tomato", "carrot", "mushroom", "lettuce", "bacon", "onion", "egg", "pickle", "avocado"};
        this.addonCodes = this.getAddonCodes();
    }

    private Double getPrice() {
        return basePrice;
    }


    protected String getBread() {
        return bread;
    }

    protected String getName() {
        return name;
    }


    //this method gets and sets the total price of the burger.
    private void setPrice() {
        Double extraCost = additions.size() * 1.99D;
        basePrice += extraCost;
    }


    //This method takes the buyer's order
    protected void takeOrder(int limit) {
        System.out.println("====================================");
        System.out.println("    EXTRA ADD-ONS  M E N U ");
        System.out.println("====================================");
        System.out.println("Add-on Code  Extra Add-on Item");
        System.out.println("---------------------------------");
        for (int i = 0; i < addonsList.length; i++) {
            System.out.println(addonCodes.charAt(i) + " ---------- " + addonsList[i]);
        }
        System.out.println("Which type of add on would you like? \nEnter item code to add to burger. \nhit \"q\" when you are done.");
        setAdditions(limit);
        getConfirmation();
    }


    //This method returns a string representation of the addons.
    private String getAddons() {
        StringBuilder addOnList = new StringBuilder();
        for (Object addOn : additions) {
            String item = addOn + ", ";
            addOnList.append(item);
        }
        return addOnList.toString();
    }


    //This method returns a string of the addonsList indexes
    private String getAddonCodes() {
        StringBuilder indexList = new StringBuilder();
        int intIndex = 1;
        while (intIndex <= addonsList.length) {
            String stringIndex = Integer.toString(intIndex);
            String element = "" + stringIndex;
            indexList.append(element);
            intIndex++;
        }
        return indexList.toString();
    }


    //This method adds addons to the buyers burger
    private void setAdditions(int limit) {
        int counter = 1;
        while (counter <= limit) {
            String itemCode = scanner.nextLine();
            if (itemCode.equals("q")) {
                break;

            } else if (itemCode.equals("") || !addonCodes.contains(itemCode)) {
                System.out.println("That was an invalid item code.");

            } else if (additions.contains(addonsList[Integer.parseInt(itemCode) - 1])) {
                System.out.println("You have already added " + addonsList[Integer.parseInt(itemCode) - 1] + ".");

            } else {
                int index = Integer.parseInt(itemCode) - 1;
                this.additions.add(addonsList[index]);
                System.out.println(addonsList[index] + " has been added to your " + getName() + ".");
                counter++;
            }
        }
        this.setPrice();
    }


    //This method displays a summary of the buyer's burger and prompts for confirmation
    private void getConfirmation() {
        System.out.println("===========================");
        System.out.println(" O R D E R  S U M M A R Y  ");
        System.out.println("===========================");
        System.out.println("Bread: " + getBread());
        System.out.println("Meat: " + this.meat);
        System.out.println("Extra add-ons: " + getAddons());
        System.out.println("===========================");
        System.out.println("Does everything look good? y/n");
        String input = scanner.nextLine();
        //TO DO: add additional actions
        if (input.toLowerCase().equals("y")) {
            deliverBurger();
        } else {
            System.out.println("What would you like to change?");
        }
    }


    //This method displays the order's total for the burger
    private void deliverBurger() {
        System.out.println("Your total is $" + new DecimalFormat("##.##").format(getPrice()));
        System.out.println("Thanks for your business!");
    }
}
