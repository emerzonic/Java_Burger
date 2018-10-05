package com.emerson;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which type of burger would you like? ");
        System.out.println("Enter the burger code\n 1 for Basic Burger\n 2 for Healthy Burger\n 3 for Deluxe Burger\n");
        String userInput = scanner.nextLine();

        switch (userInput) {
            case "1":
                System.out.println("What meat would you like? ");
                String meat = scanner.nextLine();
                BasicBurger basicBurger = new BasicBurger(meat);
                basicBurger.takeOrder(4);
                break;
            case "2":
                System.out.println("What meat would you like? ");
                meat = scanner.nextLine();
                HealthyBurger healthyBurger = new HealthyBurger(meat);
                healthyBurger.takeOrder(6);
                break;
            case "3":
                System.out.println("What meat would you like? ");
                meat = scanner.nextLine();
                DeluxeBurger deluxeBurger = new DeluxeBurger(meat);
                deluxeBurger.takeOrder(2);
                break;
            default:
                System.out.println("You entered an invalid code.");
                break;
        }
    }
}
