package com.bakery.entities;

import com.bakery.factory.CandyFactory;

public class BubblegumStore extends CandyFactory {

    @Override
    public Candy createCandy() {
        return new Bubblegum();
    }
}
