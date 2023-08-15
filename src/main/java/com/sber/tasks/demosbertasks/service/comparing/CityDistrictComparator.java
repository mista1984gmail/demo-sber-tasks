package com.sber.tasks.demosbertasks.service.comparing;

import com.sber.tasks.demosbertasks.model.City;

import java.util.Comparator;

public class CityDistrictComparator implements Comparator<City> {

    public int compare(City a, City b){

        return a.getDistrict().compareTo(b.getDistrict());
    }
}
