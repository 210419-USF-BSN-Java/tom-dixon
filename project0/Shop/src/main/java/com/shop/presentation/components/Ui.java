package com.shop.presentation.components;

import java.io.File;
import java.util.Scanner;

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
}
