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
    protected List<Integer> addonCodes;
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
        System.out.println("====================================\n"+
                           "    EXTRA ADD-ONS  M E N U \n"+
                           "====================================\n"+
                           "Add-on Code  Extra Add-on Item\n"+
                           "---------------------------------");
        for (int i = 0; i < addonsList.length; i++)
            System.out.println((i +1)+ " ---------- " + addonsList[i]);

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
    private List<Integer> getAddonCodes() {
        List<Integer> indexList = new ArrayList<>();
        int intIndex = 1;
        while (intIndex <= addonsList.length) {
            indexList.add(intIndex);
            intIndex++;
        }
        System.out.println(indexList.toString());
        return indexList;
    }


    //This method adds addons to the buyers burger
    private void setAdditions(int limit) {
        int counter = 1;
        while (counter <= limit) {
            String input = scanner.nextLine();
            try{
                if (input.equals("q"))
                    break;
                int itemCode = Integer.parseInt(input);
                String item = addonsList[itemCode - 1];

                if (additions.contains(item))
                    System.out.println("You have already added " + item + ".");
                this.additions.add(item);
                System.out.println(item + " has been added to your " + getName() + ".");
                counter++;
            }catch (Exception e){
                System.out.println("That was an invalid item code.");
            }
        }
        this.setPrice();
    }


    //This method displays a summary of the buyer's burger and prompts for confirmation
    private void getConfirmation() {
        System.out.println("===========================\n"+
                           " O R D E R  S U M M A R Y  \n"+
                           "===========================\n"+
                           "Bread: " + getBread()+"\n"+
                           "Meat: " + this.meat +"\n"+
                           "Extra add-ons: " + getAddons()+"\n"+
                           "===========================\n"+
                           "Does everything look good? y/n");
        String input = scanner.nextLine();
        //TO DO: add additional actions
        if (input.toLowerCase().equals("y"))
            deliverBurger();
         else
            System.out.println("What would you like to change?");
    }


    //This method displays the order's total for the burger
    private void deliverBurger() {
        System.out.println("Your total is $" + new DecimalFormat("##.##").format(getPrice()));
        System.out.println("Thanks for your business!\n");
    }
}
