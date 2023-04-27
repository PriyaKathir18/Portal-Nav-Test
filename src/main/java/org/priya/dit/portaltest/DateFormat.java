package org.priya.dit.portaltest;

import java.util.Date;

public class DateFormat {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.toString().replace(" ","_").replace(":","_"));

    }
}
