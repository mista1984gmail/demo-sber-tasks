package com.sber.tasks.demosbertasks.service.comparing;

import com.sber.tasks.demosbertasks.model.City;

import java.util.Comparator;

public class CityNameComparatorWithOrder implements Comparator<City> {

    public int compare(City a, City b){

        return a.getName().compareTo(b.getName());
    }
}
