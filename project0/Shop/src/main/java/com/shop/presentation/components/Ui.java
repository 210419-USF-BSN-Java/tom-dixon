package com.shop.presentation.components;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import javax.sql.rowset.spi.SyncResolver;

import com.shop.data.models.Item;
import com.shop.data.models.Offer;

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
            hr();
            System.out.println("Id: " + item.getId() + " Name: " + item.getName() + " Price: $" + item.getPrice());
        }

    }

    public void stringList(List<String> list) {
        for (String s : list) {
            hr();
            System.out.println(s);
        }
    }

    public void offerList(List<Offer> offers) {
        for (Offer o : offers) {
            System.out.println(
                    "--------------------------------------------------------------------------------------------------------------");
            ;
            System.out.println("Offer Id: " + o.getId() + " Item Id: " + o.getItemId() + " Deposit: $"
                    + o.getDownPayment() + " Number of payments: " + o.getWeeks() + " Weekly payment amount: "
                    + o.getPaymentPerWeek() + " Gross: " + o.getGross());
        }
    }

    public void hr() {
        System.out.println("---------------------------------------------");
    }

    public void hrBold() {
        System.out.println("=====================================================================================");
    }

    public void margin(int rows) {
        for (int i = 1; i < rows; i++) {
            System.out.println("");
        }

    }

}
