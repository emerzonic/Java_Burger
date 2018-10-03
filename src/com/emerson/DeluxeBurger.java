package com.emerson;

import java.util.ArrayList;

public class DeluxeBurger extends BasicBurger {


    public DeluxeBurger(String meat) {
        super(meat);
        this.addonsList = new String[]{"chip", "drink"};

    }

}
