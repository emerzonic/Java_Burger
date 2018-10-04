package com.emerson;

import java.util.ArrayList;
import java.util.Scanner;

public class HealthyBurger extends BasicBurger {
    private String bread;
    private String name;


    public HealthyBurger(String meat) {
        super(meat);
        this.bread = "Wheat Bread";
        this.name = "Healthy Burger";
    }

    @Override
    public String getBread() {
        return this.bread;
    }

    @Override
    public String getName() {
        return this.name;
    }
}

