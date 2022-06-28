package com.bakery;

import com.bakery.entities.*;
import com.bakery.factory.CandyFactory;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("SELECT AN STORE\n" +
                "1 - Lollipop\n" +
                "2 - Bubblegum\n" +
                "r: ");
        Candy candy;
        switch (sc.nextInt()) {
            case 1:
                candy = new LollipopStore().createCandy();
                System.out.println(candy.getType());
                break;
            case 2:
                candy = new BubblegumStore().createCandy();
                System.out.println(candy.getType());
                break;
        }
    }
}
