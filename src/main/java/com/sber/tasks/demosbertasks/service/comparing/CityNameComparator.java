package com.sber.tasks.demosbertasks.service.comparing;

import com.sber.tasks.demosbertasks.model.City;

import java.util.Comparator;

public class CityNameComparator implements Comparator<City> {

    public int compare(City a, City b){

        return a.getName().toLowerCase().compareTo(b.getName().toLowerCase());
    }
}
