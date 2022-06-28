package com.bakery.entities;

import com.bakery.factory.CandyFactory;

public class LollipopStore extends CandyFactory {
    @Override
    public Candy createCandy() {
        return new Lollipop();
    }
}
