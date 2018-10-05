package com.emerson;

public class DeluxeBurger extends BasicBurger {
    private String name;

    public DeluxeBurger(String meat) {
        super(meat);
        this.name = "Deluxe Burger";
        this.addonsList = new String[]{"chip", "drink"};

    }


    @Override
    public String getName() {
        return name;

    }
}
