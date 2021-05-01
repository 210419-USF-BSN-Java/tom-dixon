package com.shop.presentation.components;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import com.shop.data.models.Item;

public class Ui {

    public void textBlock(File txt) {
        try (Scanner scanOut = new Scanner(txt)) {
            ;
            while (scanOut.hasNextLine()) {
                System.out.println(scanOut.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error calling MenuHeader.printText(): ");
            e.printStackTrace();
        }
    }

    public void itemList(List<Item> list) {
        for (Item item : list) {
            System.out.println("-------------------------------------");
            System.out.println("Id: " + item.getId() + " Name: " + item.getName() + " Price: $" + item.getPrice());
        }

    }

    public void margin(int rows) {
        for (int i = 1; i < rows; i++) {
            System.out.println("");
        }

    }

}
